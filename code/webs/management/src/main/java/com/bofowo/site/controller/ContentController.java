/**
 * Project Name:lymall-management
 * File Name:ContentController.java
 * Package Name:com.bofowo.site.controller
 * Date:2016年2月25日下午8:51:53
 * Copyright (c) 2016,Shanghai bofowo Technology co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.site.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bofowo.site.model.TaglibModel;
import com.bofowo.site.model.WebContentModel;
import com.bofowo.site.query.CategoryQuery;
import com.bofowo.site.query.TaglibQuery;
import com.bofowo.site.query.WebContentQuery;
import com.bofowo.site.service.CategoryService;
import com.bofowo.site.service.TaglibService;
import com.bofowo.site.service.WebContentService;

import common.constant.WebConstant;
import common.web.BaseController;

/**
 * ClassName:ContentController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年2月25日 下午8:51:53 <br/>
 * @author   mqb
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
@Controller
public class ContentController extends BaseController {
	
	@Resource
	private WebContentService webContentService;
	
	@Resource
	private CategoryService categoryService;
	
	@Resource
	private TaglibService taglibService;
	
	@RequestMapping("content-search")
	public String contentSearch(CategoryQuery tquery,WebContentQuery query,ModelMap model){
		tquery.setStatus("1");
		tquery.setPageSize(50);
		tquery.setTotalItem(50);
		tquery.setType(WebConstant.WEB_CONTENT);
		List categories=categoryService.fetchPage(tquery);
		model.put("categories", categories);
		
		query.setPageSize(15);
		int total=webContentService.fetchPageCount(query);
		query.setTotalItem(total);
		List<WebContentModel> lists=webContentService.fetchPage(query);
		
		model.put("pageInfo", query);
		model.put("list", lists);
		return "biz/content/search";
	}
	
	@RequestMapping("content-category")
	public String contentCategory(CategoryQuery query,ModelMap model){
		query.setPageSize(20);
		query.setTotalItem(categoryService.fetchPageCount(query));
		List list=categoryService.fetchPage(query);
		model.put("list", list);
		model.put("pageInfo", query);
		return "biz/content/category";
	}
	
	@RequestMapping("content-taglib")
	public String contentTaglib(TaglibQuery query,ModelMap model){
		query.setPageSize(20);
		query.setTotalItem(taglibService.fetchPageCount(query));
		List list=taglibService.fetchPage(query);
		model.put("pageInfo", query);
		model.put("list", list);
		return "biz/content/taglib";
	}
	
	@RequestMapping("add-content")
	public String addContent(CategoryQuery query,TaglibQuery tquery,ModelMap model){
		query.setStatus("1");
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
		return "biz/content/add";
	}
	
	
	
}

