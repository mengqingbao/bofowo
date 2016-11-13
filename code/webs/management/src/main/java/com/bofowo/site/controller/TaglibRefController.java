package com.bofowo.site.controller;
import com.bofowo.site.model.TaglibRefModel;
import com.bofowo.site.query.TaglibRefQuery;
import com.bofowo.site.service.TaglibRefService;

import common.web.BaseController;

import org.springframework.ui.ModelMap;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class TaglibRefController extends BaseController{

	@Autowired
	private TaglibRefService taglibrefService;

	@RequestMapping("/taglibref-add")
	public String addtaglibref(ModelMap model){
		return "taglibref/add";
	}
	
	@RequestMapping("/taglibref-edit")
	public String edittaglibref(ModelMap model,long id){
		TaglibRefModel taglibref = taglibrefService.getById(id);
		model.put("taglibref",taglibref);
		return "taglibref/edit";
	}
	
	@RequestMapping("taglibref-insert")
	public String insert_taglibref(TaglibRefModel taglibref,ModelMap model){
		taglibrefService.insert(taglibref);
		return "redirect:/taglibref-page.htm";
	}
	
	@RequestMapping("taglibref-page")
	public String page_taglibref(TaglibRefQuery query,ModelMap model){
		query.setPageSize(10);
		query.setTotalItem(taglibrefService.fetchPageCount(query));
		List<TaglibRefModel> items=taglibrefService.fetchPage(query);
		
		model.put("pageInfo", query);
		model.put("items",items);
		return "taglibref/page";
	}
	
	@RequestMapping("/taglibref-detail")
	public String detail_taglibref(ModelMap model,long id){
		TaglibRefModel taglibref = taglibrefService.getById(id);
		model.put("taglibref",taglibref);
		return "taglibref/detail";
	}
	
	@RequestMapping("taglibref-del")
	public String del_taglibref(ModelMap model,long id){
		taglibrefService.del(id);
		return "redirect:/taglibref-page.htm";
	}
	
	@RequestMapping("taglibref-update")
	public String update_taglibref(TaglibRefModel taglibref,ModelMap model){
		taglibrefService.update(taglibref);
		return "redirect:/taglibref-detail.htm";
	}
}