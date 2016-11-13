package com.bofowo.site.controller;
import com.bofowo.site.model.ProducstockModel;
import com.bofowo.site.query.ProducstockQuery;
import com.bofowo.site.service.ProducstockService;

import common.web.BaseController;

import org.springframework.ui.ModelMap;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class ProducstockController extends BaseController{

	@Autowired
	private ProducstockService producstockService;

	@RequestMapping("/producstock-add")
	public String addproducstock(ModelMap model){
		return "producstock/add";
	}
	
	@RequestMapping("/producstock-edit")
	public String editproducstock(ModelMap model,long id){
		ProducstockModel producstock = producstockService.getById(id);
		model.put("producstock",producstock);
		return "producstock/edit";
	}
	
	@RequestMapping("producstock-insert")
	public String insert_producstock(ProducstockModel producstock,ModelMap model){
		producstockService.insert(producstock);
		return "redirect:/producstock-page.htm";
	}
	
	@RequestMapping("producstock-page")
	public String page_producstock(ProducstockQuery query,ModelMap model){
		query.setPageSize(10);
		query.setTotalItem(producstockService.fetchPageCount(query));
		List<ProducstockModel> items=producstockService.fetchPage(query);
		
		model.put("pageInfo", query);
		model.put("items",items);
		return "producstock/page";
	}
	
	@RequestMapping("/producstock-detail")
	public String detail_producstock(ModelMap model,long id){
		ProducstockModel producstock = producstockService.getById(id);
		model.put("producstock",producstock);
		return "producstock/detail";
	}
	
	@RequestMapping("producstock-del")
	public String del_producstock(ModelMap model,long id){
		producstockService.del(id);
		return "redirect:/producstock-page.htm";
	}
	
	@RequestMapping("producstock-update")
	public String update_producstock(ProducstockModel producstock,ModelMap model){
		producstockService.update(producstock);
		return "redirect:/producstock-detail.htm";
	}
}