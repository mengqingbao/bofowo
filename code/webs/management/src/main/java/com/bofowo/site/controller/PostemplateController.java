package com.bofowo.site.controller;
import com.bofowo.site.model.PostemplateModel;
import com.bofowo.site.query.PostemplateQuery;
import com.bofowo.site.service.PostemplateService;

import common.web.BaseController;

import org.springframework.ui.ModelMap;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class PostemplateController extends BaseController{

	@Autowired
	private PostemplateService postemplateService;

	@RequestMapping("/postemplate-add")
	public String addpostemplate(ModelMap model){
		return "postemplate/add";
	}
	
	@RequestMapping("/postemplate-edit")
	public String editpostemplate(ModelMap model,long id){
		PostemplateModel postemplate = postemplateService.getById(id);
		model.put("postemplate",postemplate);
		return "postemplate/edit";
	}
	
	@RequestMapping("postemplate-insert")
	public String insert_postemplate(PostemplateModel postemplate,ModelMap model){
		postemplateService.insert(postemplate);
		return "redirect:/postemplate-page.htm";
	}
	
	@RequestMapping("postemplate-page")
	public String page_postemplate(PostemplateQuery query,ModelMap model){
		query.setPageSize(10);
		query.setTotalItem(postemplateService.fetchPageCount(query));
		List<PostemplateModel> items=postemplateService.fetchPage(query);
		
		model.put("pageInfo", query);
		model.put("items",items);
		return "postemplate/page";
	}
	
	@RequestMapping("/postemplate-detail")
	public String detail_postemplate(ModelMap model,long id){
		PostemplateModel postemplate = postemplateService.getById(id);
		model.put("postemplate",postemplate);
		return "postemplate/detail";
	}
	
	@RequestMapping("postemplate-del")
	public String del_postemplate(ModelMap model,long id){
		postemplateService.del(id);
		return "redirect:/postemplate-page.htm";
	}
	
	@RequestMapping("postemplate-update")
	public String update_postemplate(PostemplateModel postemplate,ModelMap model){
		postemplateService.update(postemplate);
		return "redirect:/postemplate-detail.htm";
	}
}