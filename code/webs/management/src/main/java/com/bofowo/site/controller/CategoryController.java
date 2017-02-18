package com.bofowo.site.controller;
import com.bofowo.site.service.CategoryService;
import common.web.BaseController;
import org.springframework.ui.ModelMap;
import com.bofowo.site.query.CategoryQuery;
import com.bofowo.site.model.CategoryModel;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class CategoryController extends BaseController{

	@Autowired
	private CategoryService categoryService;

	@RequestMapping("/category-add")
	public String addcategory(ModelMap model){
		return "category/add";
	}
	
	@RequestMapping("/category-edit")
	public String editcategory(ModelMap model,long id){
		CategoryModel category = categoryService.getById(id);
		model.put("category",category);
		return "category/edit";
	}
	
	@RequestMapping("category-insert")
	public String insert_category(CategoryModel category,ModelMap model){
		categoryService.insert(category);
		return "redirect:/category-page.htm";
	}
	
	@RequestMapping("category-page")
	public String page_category(CategoryQuery query,ModelMap model){
		query.setPageSize(10);
		query.setTotalItem(categoryService.fetchPageCount(query));
		List<CategoryModel> items=categoryService.fetchPage(query);
		
		model.put("pageInfo", query);
		model.put("items",items);
		return "category/page";
	}
	
	@RequestMapping("/category-detail")
	public String detail_category(ModelMap model,long id){
		CategoryModel category = categoryService.getById(id);
		model.put("category",category);
		return "category/detail";
	}
	
	@RequestMapping("category-del")
	public String del_category(ModelMap model,long id){
		categoryService.del(id);
		return "redirect:/category-page.htm";
	}
	
	@RequestMapping("category-update")
	public String update_category(CategoryModel category,ModelMap model){
		categoryService.update(category);
		return "redirect:/category-detail.htm";
	}
}