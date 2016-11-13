package com.bofowo.site.controller;
import com.bofowo.site.model.ShopCategoryPropModel;
import com.bofowo.site.query.ShopCategoryPropQuery;
import com.bofowo.site.service.ShopCategoryPropService;

import common.web.BaseController;

import org.springframework.ui.ModelMap;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class ShopCategoryPropController extends BaseController{

	@Autowired
	private ShopCategoryPropService shopcategorypropService;

	@RequestMapping("/shopcategoryprop-add")
	public String addshopcategoryprop(ModelMap model){
		return "shopcategoryprop/add";
	}
	
	@RequestMapping("/shopcategoryprop-edit")
	public String editshopcategoryprop(ModelMap model,long id){
		ShopCategoryPropModel shopcategoryprop = shopcategorypropService.getById(id);
		model.put("shopcategoryprop",shopcategoryprop);
		return "shopcategoryprop/edit";
	}
	
	@RequestMapping("shopcategoryprop-insert")
	public String insert_shopcategoryprop(ShopCategoryPropModel shopcategoryprop,ModelMap model){
		shopcategorypropService.insert(shopcategoryprop);
		return "redirect:/shopcategoryprop-page.htm";
	}
	
	@RequestMapping("shopcategoryprop-page")
	public String page_shopcategoryprop(ShopCategoryPropQuery query,ModelMap model){
		query.setPageSize(10);
		query.setTotalItem(shopcategorypropService.fetchPageCount(query));
		List<ShopCategoryPropModel> items=shopcategorypropService.fetchPage(query);
		
		model.put("pageInfo", query);
		model.put("items",items);
		return "shopcategoryprop/page";
	}
	
	@RequestMapping("/shopcategoryprop-detail")
	public String detail_shopcategoryprop(ModelMap model,long id){
		ShopCategoryPropModel shopcategoryprop = shopcategorypropService.getById(id);
		model.put("shopcategoryprop",shopcategoryprop);
		return "shopcategoryprop/detail";
	}
	
	@RequestMapping("shopcategoryprop-del")
	public String del_shopcategoryprop(ModelMap model,long id){
		shopcategorypropService.del(id);
		return "redirect:/shopcategoryprop-page.htm";
	}
	
	@RequestMapping("shopcategoryprop-update")
	public String update_shopcategoryprop(ShopCategoryPropModel shopcategoryprop,ModelMap model){
		shopcategorypropService.update(shopcategoryprop);
		return "redirect:/shopcategoryprop-detail.htm";
	}
}