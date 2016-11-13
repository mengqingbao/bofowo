package com.bofowo.site.controller;
import com.bofowo.site.model.ProductModel;
import com.bofowo.site.query.ProductQuery;
import com.bofowo.site.service.ProductService;

import common.web.BaseController;

import org.springframework.ui.ModelMap;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class ProductController extends BaseController{

	@Autowired
	private ProductService productService;

	@RequestMapping("/product-add")
	public String addproduct(ModelMap model){
		return "product/add";
	}
	
	@RequestMapping("/product-edit")
	public String editproduct(ModelMap model,long id){
		ProductModel product = productService.getById(id);
		model.put("product",product);
		return "product/edit";
	}
	
	@RequestMapping("product-insert")
	public String insert_product(ProductModel product,ModelMap model){
		productService.insert(product);
		return "redirect:/product-page.htm";
	}
	
	@RequestMapping("product-page")
	public String page_product(ProductQuery query,ModelMap model){
		query.setPageSize(10);
		query.setTotalItem(productService.fetchPageCount(query));
		List<ProductModel> items=productService.fetchPage(query);
		
		model.put("pageInfo", query);
		model.put("items",items);
		return "product/page";
	}
	
	@RequestMapping("/product-detail")
	public String detail_product(ModelMap model,long id){
		ProductModel product = productService.getById(id);
		model.put("product",product);
		return "product/detail";
	}
	
	@RequestMapping("product-del")
	public String del_product(ModelMap model,long id){
		productService.del(id);
		return "redirect:/product-page.htm";
	}
	
	@RequestMapping("product-update")
	public String update_product(ProductModel product,ModelMap model){
		productService.update(product);
		return "redirect:/product-detail.htm";
	}
}