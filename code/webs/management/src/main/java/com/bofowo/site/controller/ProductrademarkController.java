package com.bofowo.site.controller;
import com.bofowo.site.model.ProductrademarkModel;
import com.bofowo.site.query.ProductrademarkQuery;
import com.bofowo.site.service.ProductrademarkService;

import common.web.BaseController;

import org.springframework.ui.ModelMap;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class ProductrademarkController extends BaseController{

	@Autowired
	private ProductrademarkService productrademarkService;

	@RequestMapping("/productrademark-add")
	public String addproductrademark(ModelMap model){
		return "productrademark/add";
	}
	
	@RequestMapping("/productrademark-edit")
	public String editproductrademark(ModelMap model,long id){
		ProductrademarkModel productrademark = productrademarkService.getById(id);
		model.put("productrademark",productrademark);
		return "productrademark/edit";
	}
	
	@RequestMapping("productrademark-insert")
	public String insert_productrademark(ProductrademarkModel productrademark,ModelMap model){
		productrademarkService.insert(productrademark);
		return "redirect:/productrademark-page.htm";
	}
	
	@RequestMapping("productrademark-page")
	public String page_productrademark(ProductrademarkQuery query,ModelMap model){
		query.setPageSize(10);
		query.setTotalItem(productrademarkService.fetchPageCount(query));
		List<ProductrademarkModel> items=productrademarkService.fetchPage(query);
		
		model.put("pageInfo", query);
		model.put("items",items);
		return "productrademark/page";
	}
	
	@RequestMapping("/productrademark-detail")
	public String detail_productrademark(ModelMap model,long id){
		ProductrademarkModel productrademark = productrademarkService.getById(id);
		model.put("productrademark",productrademark);
		return "productrademark/detail";
	}
	
	@RequestMapping("productrademark-del")
	public String del_productrademark(ModelMap model,long id){
		productrademarkService.del(id);
		return "redirect:/productrademark-page.htm";
	}
	
	@RequestMapping("productrademark-update")
	public String update_productrademark(ProductrademarkModel productrademark,ModelMap model){
		productrademarkService.update(productrademark);
		return "redirect:/productrademark-detail.htm";
	}
}