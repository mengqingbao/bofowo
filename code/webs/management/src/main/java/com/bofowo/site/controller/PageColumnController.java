package com.bofowo.site.controller;
import com.bofowo.site.model.PageColumnModel;
import com.bofowo.site.query.PageColumnQuery;
import com.bofowo.site.service.PageColumnService;

import common.web.BaseController;

import org.springframework.ui.ModelMap;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class PageColumnController extends BaseController{

	@Autowired
	private PageColumnService pagecolumnService;

	@RequestMapping("/pagecolumn-add")
	public String addpagecolumn(ModelMap model){
		return "pagecolumn/add";
	}
	
	@RequestMapping("/pagecolumn-edit")
	public String editpagecolumn(ModelMap model,long id){
		PageColumnModel pagecolumn = pagecolumnService.getById(id);
		model.put("pagecolumn",pagecolumn);
		return "pagecolumn/edit";
	}
	
	@RequestMapping("pagecolumn-insert")
	public String insert_pagecolumn(PageColumnModel pagecolumn,ModelMap model){
		pagecolumnService.insert(pagecolumn);
		return "redirect:/pagecolumn-page.htm";
	}
	
	@RequestMapping("manage-index-content")
	public String page_pagecolumn(PageColumnQuery query,ModelMap model){
		query.setPageSize(10);
		query.setTotalItem(pagecolumnService.fetchPageCount(query));
		List<PageColumnModel> items=pagecolumnService.fetchPage(query);
		
		model.put("pageInfo", query);
		model.put("items",items);
		return "biz/pagecolumn/page";
	}
	
	@RequestMapping("/pagecolumn-detail")
	public String detail_pagecolumn(ModelMap model,long id){
		PageColumnModel pagecolumn = pagecolumnService.getById(id);
		model.put("pagecolumn",pagecolumn);
		return "pagecolumn/detail";
	}
	
	@RequestMapping("pagecolumn-del")
	public String del_pagecolumn(ModelMap model,long id){
		pagecolumnService.del(id);
		return "redirect:/pagecolumn-page.htm";
	}
	
	@RequestMapping("pagecolumn-update")
	public String update_pagecolumn(PageColumnModel pagecolumn,ModelMap model){
		pagecolumnService.update(pagecolumn);
		return this.redirectRefer(request);
	}
}