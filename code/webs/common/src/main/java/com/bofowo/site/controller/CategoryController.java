package com.bofowo.site.controller;
import com.bofowo.site.model.CategoryModel;
import com.bofowo.site.query.CategoryQuery;
import com.bofowo.site.service.CategoryService;

import common.util.BeanUtils;
import common.util.LayoutType;
import common.web.BaseController;
import net.sf.json.JSONArray;

import org.springframework.ui.ModelMap;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class CategoryController extends BaseController{

	@Autowired
	private CategoryService categoryService;

	@RequestMapping("/category-add")
	public String addcategory(ModelMap model,String type,CategoryQuery query,Integer pid){
		query.setPageSize(30);
		query.setTotalItem(30);
		query.setType(type);
		query.setPid(pid);
		List list=categoryService.fetchPage(query);
		model.put("list", list);
		model.put("type", type);
		return "biz/category/add";
	}
	
	@RequestMapping("/category-edit")
	public String editcategory(ModelMap model,long id){
		CategoryModel category = categoryService.getById(id);
		model.put("category",category);
		return "biz/category/edit";
	}
	
	@RequestMapping("category-insert")
	public String insert_category(CategoryModel category,ModelMap model){
		category.setCreatedDate(new Date());
		category.setCreator("sys");
		categoryService.insert(category);
		return "redirect:/content-category.htm?type="+category.getType();
	}
	
	@RequestMapping("category-page")
	public String page_category(CategoryQuery query,ModelMap model){
		query.setPageSize(10);
		query.setTotalItem(categoryService.fetchPageCount(query));
		List<CategoryModel> items=categoryService.fetchPage(query);
		
		model.put("pageInfo", query);
		model.put("items",items);
		return "biz/category/page";
	}
	
	@RequestMapping("/category-detail")
	public String detail_category(ModelMap model,long id){
		CategoryModel category = categoryService.getById(id);
		model.put("category",category);
		return "biz/category/detail";
	}
	
	@RequestMapping("category-del")
	public String del_category(ModelMap model,long id,String type){
		categoryService.del(id);
		return "redirect:content-category.htm?type="+type;
	}
	
	@RequestMapping("category-update")
	public String update_category(CategoryModel category,ModelMap model){
		CategoryModel ocategory = categoryService.getById(category.getId());
		BeanUtils.copyProperties(category, ocategory);
		ocategory.setCreatedDate(new Date());
		categoryService.update(ocategory);
		return "redirect:content-category.htm?type="+category.getType();
	}
	
	
	@RequestMapping("get-sub-category")
	public String getSubCategory(CategoryQuery query,ModelMap model,Integer pid){
		this.setLayout(LayoutType.EMPTY);
		query.setPageSize(30);
		query.setTotalItem(30);
		List<CategoryModel> items=categoryService.fetchPage(query);
		model.put("json",JSONArray.fromObject(items).toString());
		return "common/json";
	}
}