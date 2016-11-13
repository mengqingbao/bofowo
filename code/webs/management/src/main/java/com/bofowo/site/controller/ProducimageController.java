package com.bofowo.site.controller;
import com.bofowo.site.model.ProducimageModel;
import com.bofowo.site.query.ProducimageQuery;
import com.bofowo.site.service.ProducimageService;

import common.web.BaseController;

import org.springframework.ui.ModelMap;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class ProducimageController extends BaseController{

	@Autowired
	private ProducimageService producimageService;

	@RequestMapping("/producimage-add")
	public String addproducimage(ModelMap model){
		return "producimage/add";
	}
	
	@RequestMapping("/producimage-edit")
	public String editproducimage(ModelMap model,long id){
		ProducimageModel producimage = producimageService.getById(id);
		model.put("producimage",producimage);
		return "producimage/edit";
	}
	
	@RequestMapping("producimage-insert")
	public String insert_producimage(ProducimageModel producimage,ModelMap model){
		producimageService.insert(producimage);
		return "redirect:/producimage-page.htm";
	}
	
	@RequestMapping("producimage-page")
	public String page_producimage(ProducimageQuery query,ModelMap model){
		query.setPageSize(10);
		query.setTotalItem(producimageService.fetchPageCount(query));
		List<ProducimageModel> items=producimageService.fetchPage(query);
		
		model.put("pageInfo", query);
		model.put("items",items);
		return "producimage/page";
	}
	
	@RequestMapping("/producimage-detail")
	public String detail_producimage(ModelMap model,long id){
		ProducimageModel producimage = producimageService.getById(id);
		model.put("producimage",producimage);
		return "producimage/detail";
	}
	
	@RequestMapping("producimage-del")
	public String del_producimage(ModelMap model,long id){
		producimageService.del(id);
		return "redirect:/producimage-page.htm";
	}
	
	@RequestMapping("producimage-update")
	public String update_producimage(ProducimageModel producimage,ModelMap model){
		producimageService.update(producimage);
		return "redirect:/producimage-detail.htm";
	}
}