/**
 * Project Name:lymall-web
 * File Name:SellerController.java
 * Package Name:com.bofowo.site.controller
 * Date:2016年3月5日下午11:47:46
 * Copyright (c) 2016,Shanghai bofowo Technology co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.site.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bofowo.site.model.CategoryModel;
import com.bofowo.site.model.CommentModel;
import com.bofowo.site.model.OrderModel;
import com.bofowo.site.model.ProducimageModel;
import com.bofowo.site.model.ProductrademarkModel;
import com.bofowo.site.model.TradeModel;
import com.bofowo.site.query.CategoryQuery;
import com.bofowo.site.query.CommentQuery;
import com.bofowo.site.query.ProductrademarkQuery;
import com.bofowo.site.query.TradeQuery;
import com.bofowo.site.service.CategoryService;
import com.bofowo.site.service.CommentService;
import com.bofowo.site.service.OrderService;
import com.bofowo.site.service.ProducimageService;
import com.bofowo.site.service.ProductrademarkService;
import com.bofowo.site.service.TradeService;

import common.constant.WebConstant;
import common.security.login.CurrentUserUtil;
import common.util.BeanUtils;
import common.util.LayoutType;
import common.util.StringUtil;
import common.web.BaseController;

/**
 * ClassName:SellerController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年3月5日 下午11:47:46 <br/>
 * @author   mqb
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
@Controller
public class SellerController extends BaseController{
	
	@Resource
	private CategoryService categoryService;
	
	@Resource
	private ProducimageService producimageService;
	@Resource
	private ProductrademarkService productrademarkService;
	
	@Resource
	private TradeService traderService;
	@Resource
	private OrderService orderService;
	@Resource
	private CommentService commentService;
	
	@RequestMapping("seller-index")
	public String index(){
		this.setLayout(LayoutType.SELLER);
		return "seller/index";
	}
	
	@RequestMapping("provider-item-add")
	public String providerItemAdd(CategoryQuery query,String type,ModelMap model){
		this.setLayout(LayoutType.SELLER);
		query.setPid(0);
		query.setType(WebConstant.CATEGORY);
		query.setTotalItem(30);
		query.setPageSize(30);
		List topList = categoryService.fetchPage(query);
		model.put("cates", topList);
		return "seller/item/add_item";
	}
	
	@RequestMapping("provider-item-add-detail-{categoryId}")
	public String itemAddDetail(@PathVariable("categoryId") String cateId,ModelMap model){
		this.setLayout(LayoutType.UAM);
		String seller=CurrentUserUtil.getCurrentUserName();
		int cate3id=0;
		if(!StringUtil.isEmpty(cateId)){
			cate3id=Integer.valueOf(cateId);
		}
		CategoryModel cate3=categoryService.getById(cate3id);
		if(cate3!=null){
			model.put("cate3", cate3);
			CategoryModel cate2=categoryService.getById(cate3.getPid());
			if(cate2!=null){
				model.put("cate2", cate2);
				CategoryModel cate1=categoryService.getById(cate2.getPid());
				model.put("cate1", cate1);
			}
		}
		List<CategoryModel> topCate=categoryService.getAllByParendid(0,WebConstant.CATEGORY);
		
		model.put("topCates", topCate);
		
		//查询没有没有被关联上传的图片。
		List<ProducimageModel> pims=producimageService.getSellerUnRefImage(seller);
		model.put("pims", pims);
		return "seller/item/add_item_detail";
	}
	
	/**
	 * 分类列表
	 * storeBrand:(这里用一句话描述这个方法的作用). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author mqb
	 * @param type
	 * @param model
	 * @param query
	 * @return
	 * @since JDK 1.7
	 */
	@RequestMapping("provider-store-brand")
	public String storeBrand(String type,ModelMap model,ProductrademarkQuery query){
		this.setLayout(LayoutType.SELLER);
		query.setSellerId(CurrentUserUtil.getCurrentUserName());
		query.setPageSize(20);
		query.setTotalItem(productrademarkService.fetchPageCount(query));
		List<ProductrademarkModel> items=productrademarkService.fetchPage(query);
		model.put("pageInfo", query);
		model.put("items", items);
		return "seller/item/store_brand";
	}
	
	@RequestMapping("provider-store-brand-add")
	public String addStoreBrand(){
		this.setLayout(LayoutType.SELLER);
		
		return "seller/item/store_brand_add";
	}
	
	@RequestMapping("provider-store-brand-insert")
	public String insertStoreBrand(ProductrademarkModel pm){
		this.setLayout(LayoutType.SELLER);
		pm.setSellerId(CurrentUserUtil.getCurrentUserName());
		pm.setCreatedDate(new Date());
		productrademarkService.insert(pm);
		return "redirect:/provider-store-brand.htm";
	}
	
	@RequestMapping("provider-store-brand-edit")
	public String editStoreBrand(Integer id,ModelMap model){
		this.setLayout(LayoutType.SELLER);
		ProductrademarkModel pm=productrademarkService.getById(id);
		model.put("item", pm);
		return "seller/item/store_brand_edit";
	}
	
	@RequestMapping("provider-store-brand-update")
	public String updateStoreBrand(ProductrademarkModel pm,Integer id){
		this.setLayout(LayoutType.SELLER);
		ProductrademarkModel pcm=productrademarkService.getById(id);
		BeanUtils.copyProperties(pm, pcm);
		productrademarkService.update(pcm);
		return "redirect:/provider-store-brand.htm";
	}
	@RequestMapping("provider-store-brand-del")
	public String delStoreBrand(Integer id,ModelMap model){
		this.setLayout(LayoutType.SELLER);
		productrademarkService.del(id);
		return "redirect:/provider-store-brand.htm";
	}
	
	@RequestMapping("provider-item-from-taobao")
	public String itemFromTaobao(String type){
		this.setLayout(LayoutType.SELLER);
		return "seller/item/from_taobao";
	}
	
	@RequestMapping("provider-item-from-jd")
	public String itemFromjd(String type){
		this.setLayout(LayoutType.SELLER);
		return "seller/item/from_jd";
	}
	
	@RequestMapping("my-sale-trades")
	public String mySaleTrades(TradeQuery query,ModelMap model){
		this.setLayout(LayoutType.SELLER);
		query.setSellerId(CurrentUserUtil.getCurrentUserName());
		query.setPageSize(15);
		query.setTotalItem(traderService.fetchPageCount(query));
		List<TradeModel> trades=traderService.fetchPage(query);
		Map<String,Object> map=new HashMap<String,Object>();
		for(TradeModel trade :trades){
			long tid=trade.getId();
			List<OrderModel> orders=orderService.getOrderByTid(trade.getId());
			trade.setOrders(orders);
		}
		model.put("pageInfo", query);
		model.put("items", trades);
		if(StringUtil.isEmpty(query.getStatus())){
			query.setStatus("0");
		}
		model.put("status", query.getStatus());
		return "seller/trade/trades";
	}
	
	@RequestMapping("i-geted-rate")
	public String myGetRate(CommentQuery query,ModelMap model){
		this.setLayout(LayoutType.SELLER);
		query.setPageSize(30);
		query.setSellerId(CurrentUserUtil.getCurrentUserName());
		query.setTotalItem(commentService.fetchPageCount(query));
		List<CommentModel> items=commentService.fetchPage(query);
		model.put("pageInfo", query);
		model.put("items", items);
		return "seller/rate_i_geted_list";
	}
	
	@RequestMapping("transport-shipments")
	public String shipments(String type){
		this.setLayout(LayoutType.SELLER);
		return "seller/transport_shipments";
	}
	
	@RequestMapping("transport-shipments-setting")
	public String shipmentsSetting(String type){
		this.setLayout(LayoutType.SELLER);
		return "seller/transport_shipments_setting";
	}

}
