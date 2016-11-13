package com.bofowo.site.controller;
import com.bofowo.site.model.PageModel;
import com.bofowo.site.query.PageQuery;
import com.bofowo.site.service.PageService;

import common.web.BaseController;

import org.springframework.ui.ModelMap;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class PageController extends BaseController{

	@Autowired
	private PageService pageService;

	@RequestMapping("/page-add")
	public String addpage(ModelMap model){
		return "page/add";
	}
	
	@RequestMapping("/page-edit")
	public String editpage(ModelMap model,long id){
		PageModel page = pageService.getById(id);
		model.put("page",page);
		return "page/edit";
	}
	
	@RequestMapping("page-insert")
	public String insert_page(PageModel page,ModelMap model){
		pageService.insert(page);
		return "redirect:/page-page.htm";
	}
	
	@RequestMapping("page-page")
	public String page_page(PageQuery query,ModelMap model){
		query.setPageSize(10);
		query.setTotalItem(pageService.fetchPageCount(query));
		List<PageModel> items=pageService.fetchPage(query);
		
		model.put("pageInfo", query);
		model.put("items",items);
		return "page/page";
	}
	
	@RequestMapping("/page-detail")
	public String detail_page(ModelMap model,long id){
		PageModel page = pageService.getById(id);
		model.put("page",page);
		return "page/detail";
	}
	
	@RequestMapping("page-del")
	public String del_page(ModelMap model,long id){
		pageService.del(id);
		return "redirect:/page-page.htm";
	}
	
	@RequestMapping("page-update")
	public String update_page(PageModel page,ModelMap model){
		pageService.update(page);
		return "redirect:/page-detail.htm";
	}
}