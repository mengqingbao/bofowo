package com.bofowo.site.controller;
import com.bofowo.site.model.ThemeModel;
import com.bofowo.site.query.ThemeQuery;
import com.bofowo.site.service.ThemeService;

import common.web.BaseController;

import org.springframework.ui.ModelMap;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class ThemeController extends BaseController{

	@Autowired
	private ThemeService themeService;

	@RequestMapping("/theme-add")
	public String addtheme(ModelMap model){
		return "theme/add";
	}
	
	@RequestMapping("/theme-edit")
	public String edittheme(ModelMap model,long id){
		ThemeModel theme = themeService.getById(id);
		model.put("theme",theme);
		return "theme/edit";
	}
	
	@RequestMapping("theme-insert")
	public String insert_theme(ThemeModel theme,ModelMap model){
		themeService.insert(theme);
		return "redirect:/theme-page.htm";
	}
	
	@RequestMapping("theme-page")
	public String page_theme(ThemeQuery query,ModelMap model){
		query.setPageSize(10);
		query.setTotalItem(themeService.fetchPageCount(query));
		List<ThemeModel> items=themeService.fetchPage(query);
		
		model.put("pageInfo", query);
		model.put("items",items);
		return "theme/page";
	}
	
	@RequestMapping("/theme-detail")
	public String detail_theme(ModelMap model,long id){
		ThemeModel theme = themeService.getById(id);
		model.put("theme",theme);
		return "theme/detail";
	}
	
	@RequestMapping("theme-del")
	public String del_theme(ModelMap model,long id){
		themeService.del(id);
		return "redirect:/theme-page.htm";
	}
	
	@RequestMapping("theme-update")
	public String update_theme(ThemeModel theme,ModelMap model){
		themeService.update(theme);
		return "redirect:/theme-detail.htm";
	}
}