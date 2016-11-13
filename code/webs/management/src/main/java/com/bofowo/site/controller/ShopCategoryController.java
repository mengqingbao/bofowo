package com.bofowo.site.controller;
import com.bofowo.site.model.ShopCategoryModel;
import com.bofowo.site.query.ShopCategoryQuery;
import com.bofowo.site.service.ShopCategoryService;

import common.web.BaseController;

import org.springframework.ui.ModelMap;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class ShopCategoryController extends BaseController{

	@Autowired
	private ShopCategoryService shopcategoryService;

	@RequestMapping("/shopcategory-add")
	public String addshopcategory(ModelMap model){
		return "shopcategory/add";
	}
	
	@RequestMapping("/shopcategory-edit")
	public String editshopcategory(ModelMap model,long id){
		ShopCategoryModel shopcategory = shopcategoryService.getById(id);
		model.put("shopcategory",shopcategory);
		return "shopcategory/edit";
	}
	
	@RequestMapping("shopcategory-insert")
	public String insert_shopcategory(ShopCategoryModel shopcategory,ModelMap model){
		shopcategoryService.insert(shopcategory);
		return "redirect:/shopcategory-page.htm";
	}
	
	@RequestMapping("shopcategory-page")
	public String page_shopcategory(ShopCategoryQuery query,ModelMap model){
		query.setPageSize(10);
		query.setTotalItem(shopcategoryService.fetchPageCount(query));
		List<ShopCategoryModel> items=shopcategoryService.fetchPage(query);
		
		model.put("pageInfo", query);
		model.put("items",items);
		return "shopcategory/page";
	}
	
	@RequestMapping("/shopcategory-detail")
	public String detail_shopcategory(ModelMap model,long id){
		ShopCategoryModel shopcategory = shopcategoryService.getById(id);
		model.put("shopcategory",shopcategory);
		return "shopcategory/detail";
	}
	
	@RequestMapping("shopcategory-del")
	public String del_shopcategory(ModelMap model,long id){
		shopcategoryService.del(id);
		return "redirect:/shopcategory-page.htm";
	}
	
	@RequestMapping("shopcategory-update")
	public String update_shopcategory(ShopCategoryModel shopcategory,ModelMap model){
		shopcategoryService.update(shopcategory);
		return "redirect:/shopcategory-detail.htm";
	}
}