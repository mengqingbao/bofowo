/**
 * Project Name:lymall-management
 * File Name:ProductController.java
 * Package Name:com.bofowo.site.controller
 * Date:2016年2月25日下午8:50:17
 * Copyright (c) 2016,Shanghai bofowo Technology co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.site.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.bofowo.content.BofowoContent;

import com.bofowo.site.biz.model.CategoryTree;
import com.bofowo.site.model.CategoryModel;
import com.bofowo.site.model.ProducimageModel;
import com.bofowo.site.model.ProducpropertiesModel;
import com.bofowo.site.model.ProductModel;
import com.bofowo.site.model.ShopCategoryPropModel;
import com.bofowo.site.query.ProducpropertiesQuery;
import com.bofowo.site.query.ProductQuery;
import com.bofowo.site.query.ShopCategoryPropQuery;
import com.bofowo.site.service.CategoryService;
import com.bofowo.site.service.ProducimageService;
import com.bofowo.site.service.ProducpropertiesService;
import com.bofowo.site.service.ProductService;
import com.bofowo.site.service.ShopCategoryPropService;

import common.constant.WebConstant;
import common.security.login.CurrentUserUtil;
import common.util.BeanUtils;
import common.util.LayoutType;
import common.util.StringUtil;
import common.web.BaseController;

/**
 * ClassName:ProductController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年2月25日 下午8:50:17 <br/>
 * @author   mqb
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
@Controller
public class ItemController extends BaseController {
	@Resource
	private ProductService productService;
	@Resource
	private ProducimageService producimageService;
	@Resource
	private CategoryService categoryService;
	@Resource
	private ShopCategoryPropService shopCategoryPropService;
	@Resource
	private ProducpropertiesService producpropertiesService;
	@RequestMapping("product-search")
	public String productSearch(){
		return "product/searchProduct";
	}
	
	@RequestMapping("product-category-search")
	public String categoryMange(){
		
		return "product/categorySearch";
	}
	
	@RequestMapping("product-taglib-manage")
	public String taglibMange(){
		return "product/taglibs";
	}
	
	@RequestMapping("seller-add-product")
	public String createProduct(){
		return "product/addProduct";
	}
	@RequestMapping("add-product-detail")
	public String createProductDetail(){
		return "product/addProductDetail";
	}
	
	@RequestMapping("add-product-detail-insert")
	public String createProductDetailInsert(ProductModel productModel){
		productModel.setCreatedTime(new Date());
		productModel.setSellerId(CurrentUserUtil.getCurrentUserName());
		productModel.setShopId(CurrentUserUtil.getShopId());
		productModel.setModifiedTime(new Date());
		productModel.setStatus("1");
		productService.insert(productModel);
		producimageService.updateStatus(productModel.getImages(),productModel.getId());
		return "redirect:provider-item-add.htm";
	}
	
	/**
	 * 
	 * providerItemSearch:(这里用一句话描述这个方法的作用). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author mqb
	 * @param type
	 * @return
	 * @since JDK 1.7
	 */
	@RequestMapping("provider-item-search-{type}")
	public String providerItemSearch(@PathVariable("type") String type,ProductQuery query,ModelMap model){
		this.setLayout(LayoutType.SELLER);
		query.setPageSize(15);
		query.setType(type);
		query.setCurrentUserName(CurrentUserUtil.getCurrentUserName());
		query.setTotalItem(productService.fetchPageCount(query));
		List<ProductModel> items=productService.fetchPage(query);
		model.put("list", items);
		model.put("pageInfo", query);
		return "seller/searchProduct";
	}
	
	@RequestMapping("item-dele-{id}")
	public String providerItemDel(@PathVariable("id") Integer id,ModelMap model){
		this.setLayout(LayoutType.EMPTY);
		productService.del(Long.valueOf(id));
		return this.redirectRefer(request);
	}
	
	@RequestMapping("item-modify-{id}")
	public String providerItemModify(@PathVariable("id") Integer id,ModelMap model){
		this.setLayout(LayoutType.UAM);
		String seller=CurrentUserUtil.getCurrentUserName();
		
		ProductModel item=productService.getById(id);
		int cate3id=item.getCategoryId();
	
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
		List<ProducimageModel> pims=producimageService.fetchImagesByPid(item.getId());
		model.put("pims", pims);
		model.put("item",item);
		return "product/modify";
	}
	
	@RequestMapping("item-update")
	public String updateProductDetailInsert(ProductModel productModel){
		productModel.setCreatedTime(new Date());
		productModel.setSellerId(CurrentUserUtil.getCurrentUserName());
		productModel.setModifiedTime(new Date());
		productModel.setStatus("1");
		ProductModel oldPM=productService.getById(productModel.getId());
		BeanUtils.copyProperties(productModel, oldPM);
		productService.update(oldPM);
		return this.redirectRefer(request);
	}
	
	@RequestMapping("item-list-cate")
	public String itemSearchList(ProductQuery query,ModelMap model){
		query.setPageSize(16);
		//根据父id查询子分类
		List<CategoryModel> cates=categoryService.getAllByParendid(query.getCateId(), BofowoContent.CATEGORY_ITEM_CATE_TYPE);
		model.put("cates", cates);
		CategoryTree ct=categoryService.getTreeByCateId(query.getCateId());
		model.put("cateTree", ct);
		//查询分类下的产品信息
		query.setTotalItem(productService.fetchPageCount(query));
		List<ProductModel> items=productService.fetchPage(query);
		model.put("pageInfo", query);
		model.put("items",items);
		return "itemListCate";
	}
	
	/**
	 * 获得店铺属性规格的html，根据店铺所选的分类。
	 * generateShopHtml:(这里用一句话描述这个方法的作用). <br/>
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
	@RequestMapping("getShopCateProp")
	public String generateShopHtml(ShopCategoryPropQuery query,ModelMap model){
		this.setLayout(LayoutType.EMPTY);
		query.setTotalItem(10);
		query.setPageSize(10);
		//规格查询
		query.setType("spec");
		List<ShopCategoryPropModel> list=shopCategoryPropService.getByShopCateId(query);
		model.put("items", list);
		//属性
		query.setType("prop");
		List<ShopCategoryPropModel> props=shopCategoryPropService.getByShopCateId(query);
		model.put("props", props);
		if(props.size()<1&&list.size()<1){
			return "common/empty";
		}
		
		return "seller/item/html_shop_prop";
	}
	/**
	 * 获得系统的属性规格html 根据所选的类目id
	 * generateOrgHtml:(这里用一句话描述这个方法的作用). <br/>
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
	@RequestMapping("getCateProp")
	public String generateOrgHtml(ProducpropertiesQuery query,ModelMap model){
		this.setLayout(LayoutType.EMPTY);
		query.setTotalItem(10);
		query.setPageSize(10);
		List<ProducpropertiesModel> list=producpropertiesService.getByCateId(query);
		model.put("items", list);
		return "seller/item/html_prop";
	}
	
}

