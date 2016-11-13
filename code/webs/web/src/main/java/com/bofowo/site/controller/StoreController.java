/**
 * Project Name:lymall-web
 * File Name:StoreController.java
 * Package Name:com.bofowo.site.controller
 * Date:2016年3月12日下午3:05:36
 * Copyright (c) 2016,Shanghai bofowo Technology co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.site.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bofowo.site.model.PostemplateModel;
import com.bofowo.site.model.ProductModel;
import com.bofowo.site.model.ShopCategoryModel;
import com.bofowo.site.model.ShopCategoryPropModel;
import com.bofowo.site.model.ShopModel;
import com.bofowo.site.query.PostemplateQuery;
import com.bofowo.site.query.ProducpropertiesQuery;
import com.bofowo.site.query.ProductQuery;
import com.bofowo.site.query.ShopCategoryPropQuery;
import com.bofowo.site.query.ShopCategoryQuery;
import com.bofowo.site.service.PostemplateService;
import com.bofowo.site.service.ProducpropertiesService;
import com.bofowo.site.service.ProductService;
import com.bofowo.site.service.ProductrademarkService;
import com.bofowo.site.service.ShopCategoryPropService;
import com.bofowo.site.service.ShopCategoryService;
import com.bofowo.site.service.ShopService;

import common.security.login.CurrentUserUtil;
import common.util.BeanUtils;
import common.util.LayoutType;
import common.util.StringUtil;
import common.web.BaseController;

/**
 * ClassName:StoreController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年3月12日 下午3:05:36 <br/>
 * @author   mqb
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
@Controller
public class StoreController extends BaseController {
	
	@Resource
	private PostemplateService postemplateService;
	
	@Resource
	private ProductrademarkService productrademarkService;
	@Resource
	private ShopCategoryService shopCategoryService;
	@Resource
	private ProducpropertiesService producpropertiesService;
	@Resource
	private ShopCategoryPropService shopCategoryPropService;
	@Resource
	private ProductService productService;
	@Resource
	private ShopService shopService;
	

	@RequestMapping("/shop-detail")
	public String shopDetail(ModelMap model,boolean error,Integer id,ProductQuery query){
		//店铺基础信息
		ShopModel shop=shopService.getById(id);
		model.put("shop", shop);
		if(shop==null){
			return "error";
		}
		//店铺分类信息
		List<ShopCategoryModel> cates=shopCategoryService.getListByShopId(shop.getId());
		model.put("cates", cates);
		
		//查询热卖列表
				query.setCurrentUserName(CurrentUserUtil.getCurrentUserName());
				query.setTotalItem(6);
				query.setPageSize(6);
				query.setTablie("hot");
				List<ProductModel> hots=productService.getHotTop(query);
				model.put("hots",hots);
				//查询新上架产品
				query.setTablie("new");
				List<ProductModel> news=productService.getNewsTop(query);
				model.put("news",news);
				
		return "shopDetail";
	}
	
	@RequestMapping("/shop-item-list-{shopId}-{cateId}")
	public String shopItemSearch(ModelMap model,boolean error,@PathVariable("cateId") Integer cateId,@PathVariable("shopId") Integer shopId,ProductQuery query){
		//店铺基础信息
		ShopModel shop=shopService.getById(shopId);
		model.put("shop", shop);
		if(shop==null){
			return "error";
		}
		
		//店铺分类信息
		List<ShopCategoryModel> cates=shopCategoryService.getListByShopId(shop.getId());
		model.put("cates", cates);
		query.setCateId(cateId);
		query.setShopId(shopId);
		query.setPageSize(12);
		query.setTotalItem(productService.fetchPageCount(query));
		List<ProductModel> items=productService.fetchPage(query);
		model.put("items", items);
		model.put("pageInfo", query);
		return "shopItemList";
	}
	
	@RequestMapping("store-trades-goods")
	public String storeTradesGoods(){
		this.setLayout(LayoutType.SELLER);
		return "store/store_trades_goods";
	}
	
	@RequestMapping("transport-tool")
	public String transportTool(ModelMap model,PostemplateQuery query){
		this.setLayout(LayoutType.SELLER);
		query.setPageSize(5);
		query.setTotalItem(5);
		query.setCurrentUserName(CurrentUserUtil.getCurrentUserName());
		List<PostemplateModel> post=postemplateService.fetchPage(query);
		model.put("pageInfo", query);
		model.put("items", post);
		return "store/transport_tool";
	}
	
	
	@RequestMapping("transport-tool-add")
	public String addTransportTool(){
		this.setLayout(LayoutType.SELLER);
		
		return "store/transport_tool_add";
	}
	
	@RequestMapping("transport-tool-insert")
	public String insert_postemplate(PostemplateModel postemplate,ModelMap model){
		postemplate.setSellerId(CurrentUserUtil.getCurrentUserName());
		postemplateService.insert(postemplate);
		return "redirect:/transport-tool.htm";
	}
	
	@RequestMapping("transport-tool-edit")
	public String addTransportToolEdit(Integer id,ModelMap model){
		this.setLayout(LayoutType.SELLER);
		PostemplateModel pm=postemplateService.getById(id);
		if(pm!=null){
			model.put("item", pm);
		}else{
			return "redirect:/transport-tool.htm";
		}
		return "store/transport_tool_edit";
	}
	@RequestMapping("transport-tool-update")
	public String updatePostemplate(Integer id,PostemplateModel postemplate,ModelMap model){
		PostemplateModel pm=postemplateService.getById(id);
		BeanUtils.copyProperties(postemplate, pm);
		postemplateService.update(pm);
		return "redirect:/transport-tool.htm";
	}
	@RequestMapping("transport-tool-del")
	public String addTransportToolDel(Integer id,ModelMap model){
		postemplateService.del(id);
		return "redirect:/transport-tool.htm";
	}
	
	@RequestMapping("store-bill-setting")
	public String storeBillSetting(){
		this.setLayout(LayoutType.SELLER);
		return "store/store_bill_setting";
	}
	
	/**
	 * 分类列表
	 * storeCategory:(这里用一句话描述这个方法的作用). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author mqb
	 * @param query
	 * @param model
	 * @return
	 * @since JDK 1.7
	 */
	@RequestMapping("provider-store-category")
	public String storeCategory(ShopCategoryQuery query,ModelMap model){
		this.setLayout(LayoutType.SELLER);
		query.setPageSize(10);
		query.setTotalItem(shopCategoryService.fetchPageCount(query));
		List<ShopCategoryModel> items=shopCategoryService.fetchPage(query);
		model.put("pageInfo", query);
		model.put("list",items);
		return "seller/item/store_category";
	}
	
	@RequestMapping("provider-store-category-add")
	public String addStoreBrand(){
		this.setLayout(LayoutType.SELLER);
		
		return "seller/item/store_category_add";
	}
	
	@RequestMapping("provider-store-category-insert")
	public String insertStoreBrand(ShopCategoryModel shopcategory){
		this.setLayout(LayoutType.SELLER);
		shopCategoryService.insert(shopcategory);
		return "redirect:/provider-store-category.htm";
	}
	
	@RequestMapping("provider-store-category-edit")
	public String editStoreBrand(Integer id,ModelMap model){
		this.setLayout(LayoutType.SELLER);
		ShopCategoryModel scm=shopCategoryService.getById(id);
		model.put("item", scm);
		return "seller/item/store_category_edit";
	}
	
	@RequestMapping("provider-store-category-update")
	public String updateStoreBrand(ShopCategoryModel shopCategoryModel,Integer id){
		ShopCategoryModel scm=shopCategoryService.getById(id);
		BeanUtils.copyProperties(shopCategoryModel, scm);
		shopCategoryService.update(shopCategoryModel);
		return "redirect:/provider-store-category.htm";
	}
	
	@RequestMapping("provider-store-category-del")
	public String delStoreBrand(Integer id){
		
		shopCategoryService.del(id);
		return "redirect:/provider-store-category.htm";
	}
	
	@RequestMapping("shop-setting")
	public String shopSetting(ModelMap model){
		this.setLayout(LayoutType.SELLER);
		ShopModel shop=shopService.getByUsername(CurrentUserUtil.getCurrentUserName());
		model.put("item", shop);
		return "shop/shop_setting";
	}
	@RequestMapping("shop-update")
	public String shopUpdate(ModelMap model,ShopModel shop){
		this.setLayout(LayoutType.SELLER);
		ShopModel shopModel=shopService.getByUsername(CurrentUserUtil.getCurrentUserName());
		BeanUtils.copyProperties(shop, shopModel);
		shopService.update(shopModel);
		
		return "redirect:/shop-setting.htm";
	}
	
	@RequestMapping("shop-theme-setting")
	public String shopThemeSetting(){
		this.setLayout(LayoutType.SELLER);
		return "shop/theme_setting";
	}
	
	@RequestMapping("store-prop-{type}")
	public String storePropSpec(@PathVariable("type") String type,ShopCategoryPropQuery query,ModelMap model){
		this.setLayout(LayoutType.SELLER);
		query.setPageSize(15);
		query.setType(type);
		query.setTotalItem(shopCategoryPropService.fetchPageCount(query));
		List<ShopCategoryPropModel> scpms=shopCategoryPropService.fetchPage(query);
		model.put("type", type);
		model.put("items", scpms);
		model.put("pageInfo", query);
		return "shop/store_prop_spec";
	}
	
	@RequestMapping("store-prop-add")
	public String storePropSpecAdd(String type,ProducpropertiesQuery query,ModelMap model){
		this.setLayout(LayoutType.SELLER);
		model.put("type", type);
		List<ShopCategoryModel> scms=shopCategoryService.getCatesBySellerId(CurrentUserUtil.getCurrentUserName());
		model.put("scms",scms);
		return "shop/store_prop_spec_add";
	}
	
	@RequestMapping("store-prop-edit")
	public String storePropSpecEdit(Integer id,String type,ProducpropertiesQuery query,ModelMap model){
		this.setLayout(LayoutType.SELLER);
		model.put("type", type);
		List<ShopCategoryModel> scms=shopCategoryService.getCatesBySellerId(CurrentUserUtil.getCurrentUserName());
		ShopCategoryPropModel scpm=shopCategoryPropService.getById(id);
		model.put("scms",scms);
		model.put("item", scpm);
		String val=scpm.getInputOption();
		if(!StringUtil.isEmpty(val)){
			String[] vals=val.split(";");
			model.put("inputOpetion", vals);
		}
		return "shop/store_prop_spec_edit";
	}
	
	@RequestMapping("store-prop-insert")
	public String storePropSpecInsert(String type,ShopCategoryPropModel spm,ModelMap model){
		spm.setSellerId(CurrentUserUtil.getCurrentUserName());
		spm.setStatus("1");
		shopCategoryPropService.insert(spm);
		return "redirect:/store-prop-"+type+".htm";
	}
	
	@RequestMapping("store-prop-del")
	public String storePropSpecDel(Integer id){
		shopCategoryPropService.del(id);
		return this.redirectRefer(request);
	}
	
	@RequestMapping("store-prop-update")
	public String storePropSpecUpdate(String type,ShopCategoryPropModel spm,ModelMap model){
		ShopCategoryPropModel oscpm=shopCategoryPropService.getById(spm.getId());
		BeanUtils.copyProperties(spm, oscpm);
		shopCategoryPropService.update(oscpm);
		return "redirect:/store-prop-"+type+".htm";
	}
	
}

