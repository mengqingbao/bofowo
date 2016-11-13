package com.bofowo.site.controller;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bofowo.site.model.TaglibModel;
import com.bofowo.site.query.TaglibQuery;
import com.bofowo.site.service.TaglibService;

import common.util.BeanUtils;
import common.web.BaseController;


@Controller
public class TaglibController extends BaseController{

	@Autowired
	private TaglibService taglibService;

	@RequestMapping("/taglib-add")
	public String addtaglib(ModelMap model,String type){
		model.put("type", type);
		return "biz/taglib/add";
	}
	
	@RequestMapping("/taglib-edit")
	public String edittaglib(ModelMap model,long id){
		TaglibModel taglib = taglibService.getById(id);
		model.put("taglib",taglib);
		return "biz/taglib/edit";
	}
	
	@RequestMapping("taglib-insert")
	public String insert_taglib(TaglibModel taglib,ModelMap model){
		taglib.setCreatedDate(new Date());
		taglib.setModifiedDate(new Date());
		taglib.setIsDelete("0");
		taglibService.insert(taglib);
		return "redirect:content-taglib.htm?type="+taglib.getType();
	}
	
	@RequestMapping("taglib-page")
	public String page_taglib(TaglibQuery query,ModelMap model){
		query.setPageSize(10);
		query.setTotalItem(taglibService.fetchPageCount(query));
		List<TaglibModel> items=taglibService.fetchPage(query);
		
		model.put("pageInfo", query);
		model.put("items",items);
		return "taglib/page";
	}
	
	@RequestMapping("/taglib-detail")
	public String detail_taglib(ModelMap model,long id){
		TaglibModel taglib = taglibService.getById(id);
		model.put("taglib",taglib);
		return "taglib/detail";
	}
	
	@RequestMapping("taglib-del")
	public String del_taglib(ModelMap model,long id){
		taglibService.del(id);
		return "redirect:content-taglib.htm";
	}
	
	@RequestMapping("taglib-update")
	public String update_taglib(TaglibModel taglib,ModelMap model){
		TaglibModel otaglib = taglibService.getById(taglib.getId());
		BeanUtils.copyProperties(taglib, otaglib);
		otaglib.setModifiedDate(new Date());
		taglibService.update(otaglib);
		return "redirect:content-taglib.htm?type="+taglib.getType();
	}
}