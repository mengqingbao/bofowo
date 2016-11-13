package com.bofowo.site.controller;
import com.bofowo.site.model.CommentModel;
import com.bofowo.site.query.CommentQuery;
import com.bofowo.site.service.CommentService;

import common.web.BaseController;

import org.springframework.ui.ModelMap;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class CommentController extends BaseController{

	@Autowired
	private CommentService commentService;

	@RequestMapping("/comment-add")
	public String addcomment(ModelMap model){
		return "comment/add";
	}
	
	@RequestMapping("/comment-edit")
	public String editcomment(ModelMap model,long id){
		CommentModel comment = commentService.getById(id);
		model.put("comment",comment);
		return "comment/edit";
	}
	
	@RequestMapping("comment-insert")
	public String insert_comment(CommentModel comment,ModelMap model){
		commentService.insert(comment);
		return "redirect:/comment-page.htm";
	}
	
	@RequestMapping("comment-page")
	public String page_comment(CommentQuery query,ModelMap model){
		query.setPageSize(10);
		query.setTotalItem(commentService.fetchPageCount(query));
		List<CommentModel> items=commentService.fetchPage(query);
		
		model.put("pageInfo", query);
		model.put("items",items);
		return "comment/page";
	}
	
	@RequestMapping("/comment-detail")
	public String detail_comment(ModelMap model,long id){
		CommentModel comment = commentService.getById(id);
		model.put("comment",comment);
		return "comment/detail";
	}
	
	@RequestMapping("comment-del")
	public String del_comment(ModelMap model,long id){
		commentService.del(id);
		return "redirect:/comment-page.htm";
	}
	
	@RequestMapping("comment-update")
	public String update_comment(CommentModel comment,ModelMap model){
		commentService.update(comment);
		return "redirect:/comment-detail.htm";
	}
}