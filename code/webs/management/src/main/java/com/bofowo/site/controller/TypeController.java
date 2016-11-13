package com.bofowo.site.controller;
import com.bofowo.site.model.TypeModel;
import com.bofowo.site.query.TypeQuery;
import com.bofowo.site.service.TypeService;

import common.web.BaseController;

import org.springframework.ui.ModelMap;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class TypeController extends BaseController{

	@Autowired
	private TypeService typeService;

	@RequestMapping("/type-add")
	public String addtype(ModelMap model){
		return "type/add";
	}
	
	@RequestMapping("/type-edit")
	public String edittype(ModelMap model,long id){
		TypeModel type = typeService.getById(id);
		model.put("type",type);
		return "type/edit";
	}
	
	@RequestMapping("type-insert")
	public String insert_type(TypeModel type,ModelMap model){
		typeService.insert(type);
		return "redirect:/type-page.htm";
	}
	
	@RequestMapping("type-page")
	public String page_type(TypeQuery query,ModelMap model){
		query.setPageSize(10);
		query.setTotalItem(typeService.fetchPageCount(query));
		List<TypeModel> items=typeService.fetchPage(query);
		
		model.put("pageInfo", query);
		model.put("items",items);
		return "type/page";
	}
	
	@RequestMapping("/type-detail")
	public String detail_type(ModelMap model,long id){
		TypeModel type = typeService.getById(id);
		model.put("type",type);
		return "type/detail";
	}
	
	@RequestMapping("type-del")
	public String del_type(ModelMap model,long id){
		typeService.del(id);
		return "redirect:/type-page.htm";
	}
	
	@RequestMapping("type-update")
	public String update_type(TypeModel type,ModelMap model){
		typeService.update(type);
		return "redirect:/type-detail.htm";
	}
}