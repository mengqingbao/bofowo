package com.bofowo.site.controller;
import com.bofowo.site.service.ExpressService;
import common.web.BaseController;
import org.springframework.ui.ModelMap;
import com.bofowo.site.query.ExpressQuery;
import com.bofowo.site.model.ExpressModel;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class ExpressController extends BaseController{

	@Autowired
	private ExpressService expressService;

	@RequestMapping("/express-add")
	public String addexpress(ModelMap model){
		return "express/add";
	}
	
	@RequestMapping("/express-edit")
	public String editexpress(ModelMap model,long id){
		ExpressModel express = expressService.getById(id);
		model.put("express",express);
		return "express/edit";
	}
	
	@RequestMapping("express-insert")
	public String insert_express(ExpressModel express,ModelMap model){
		expressService.insert(express);
		return "redirect:/express-page.htm";
	}
	
	@RequestMapping("express-page")
	public String page_express(ExpressQuery query,ModelMap model){
		query.setPageSize(10);
		query.setTotalItem(expressService.fetchPageCount(query));
		List<ExpressModel> items=expressService.fetchPage(query);
		
		model.put("pageInfo", query);
		model.put("items",items);
		return "express/page";
	}
	
	@RequestMapping("/express-detail")
	public String detail_express(ModelMap model,long id){
		ExpressModel express = expressService.getById(id);
		model.put("express",express);
		return "express/detail";
	}
	
	@RequestMapping("express-del")
	public String del_express(ModelMap model,long id){
		expressService.del(id);
		return "redirect:/express-page.htm";
	}
	
	@RequestMapping("express-update")
	public String update_express(ExpressModel express,ModelMap model){
		expressService.update(express);
		return "redirect:/express-detail.htm";
	}
}