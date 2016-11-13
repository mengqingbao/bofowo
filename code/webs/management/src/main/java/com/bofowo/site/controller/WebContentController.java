package com.bofowo.site.controller;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bofowo.site.model.WebContentModel;
import com.bofowo.site.query.CategoryQuery;
import com.bofowo.site.query.TaglibQuery;
import com.bofowo.site.query.WebContentQuery;
import com.bofowo.site.service.CategoryService;
import com.bofowo.site.service.TaglibService;
import com.bofowo.site.service.WebContentService;

import common.constant.WebConstant;
import common.util.BeanUtils;
import common.web.BaseController;


@Controller
public class WebContentController extends BaseController{

	@Autowired
	private WebContentService webcontentService;
	
	@Resource
	private CategoryService categoryService;
	
	@Resource
	private TaglibService taglibService;

	@RequestMapping("/webcontent-add")
	public String addwebcontent(ModelMap model){
		return "webcontent/add";
	}
	
	@RequestMapping("/webcontent-edit")
	public String editwebcontent(CategoryQuery query,TaglibQuery tquery,ModelMap model,long id){
		
		query.setPageSize(50);
		query.setTotalItem(50);
		query.setType(WebConstant.WEB_CONTENT);
		List categories=categoryService.fetchPage(query);
		tquery.setType(WebConstant.WEB_CONTENT);
		tquery.setPageSize(50);
		tquery.setTotalItem(50);
		tquery.setStatus("1");
		List tags=taglibService.fetchPage(tquery);
		model.put("categories", categories);
		model.put("tags", tags);
		
		WebContentModel webcontent = webcontentService.getById(id);
		model.put("content",webcontent);
		return "biz/content/modify";
	}
	
	@RequestMapping("webcontent-insert")
	public String insert_webcontent(WebContentModel webcontent,ModelMap model){
		webcontent.setCreateDate(new Date());
		webcontent.setModifyDate(new Date());
		webcontentService.insert(webcontent);
		return "redirect:/content-search.htm";
	}
	
	@RequestMapping("webcontent-page")
	public String page_webcontent(WebContentQuery query,ModelMap model){
		query.setPageSize(10);
		query.setTotalItem(webcontentService.fetchPageCount(query));
		List<WebContentModel> items=webcontentService.fetchPage(query);
		
		model.put("pageInfo", query);
		model.put("items",items);
		return "webcontent/page";
	}
	
	@RequestMapping("/webcontent-detail")
	public String detail_webcontent(ModelMap model,long id){
		WebContentModel webcontent = webcontentService.getById(id);
		model.put("webcontent",webcontent);
		return "webcontent/detail";
	}
	
	@RequestMapping("webcontent-del")
	public String del_webcontent(ModelMap model,long id){
		webcontentService.del(id);
		return "redirect:/content-search.htm";
	}
	
	@RequestMapping("webcontent-update")
	public String update_webcontent(WebContentModel webcontent,ModelMap model){
		
		WebContentModel webcontentold = webcontentService.getById(webcontent.getId());
		
		BeanUtils.copyProperties(webcontent, webcontentold);
		webcontentold.setModifyDate(new Date());
		webcontentService.update(webcontentold);
		return "redirect:/content-search.htm";
	}
}