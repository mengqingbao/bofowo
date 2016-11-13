package com.bofowo.site.controller;
import com.bofowo.site.model.TradeConsoleModel;
import com.bofowo.site.query.TradeConsoleQuery;
import com.bofowo.site.service.TradeConsoleService;

import common.web.BaseController;

import org.springframework.ui.ModelMap;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class TradeConsoleController extends BaseController{

	@Autowired
	private TradeConsoleService tradeconsoleService;

	@RequestMapping("/tradeconsole-add")
	public String addtradeconsole(ModelMap model){
		return "tradeconsole/add";
	}
	
	@RequestMapping("/tradeconsole-edit")
	public String edittradeconsole(ModelMap model,long id){
		TradeConsoleModel tradeconsole = tradeconsoleService.getById(id);
		model.put("tradeconsole",tradeconsole);
		return "tradeconsole/edit";
	}
	
	@RequestMapping("tradeconsole-insert")
	public String insert_tradeconsole(TradeConsoleModel tradeconsole,ModelMap model){
		tradeconsoleService.insert(tradeconsole);
		return "redirect:/tradeconsole-page.htm";
	}
	
	@RequestMapping("tradeconsole-page")
	public String page_tradeconsole(TradeConsoleQuery query,ModelMap model){
		query.setPageSize(10);
		query.setTotalItem(tradeconsoleService.fetchPageCount(query));
		List<TradeConsoleModel> items=tradeconsoleService.fetchPage(query);
		
		model.put("pageInfo", query);
		model.put("items",items);
		return "tradeconsole/page";
	}
	
	@RequestMapping("/tradeconsole-detail")
	public String detail_tradeconsole(ModelMap model,long id){
		TradeConsoleModel tradeconsole = tradeconsoleService.getById(id);
		model.put("tradeconsole",tradeconsole);
		return "tradeconsole/detail";
	}
	
	@RequestMapping("tradeconsole-del")
	public String del_tradeconsole(ModelMap model,long id){
		tradeconsoleService.del(id);
		return "redirect:/tradeconsole-page.htm";
	}
	
	@RequestMapping("tradeconsole-update")
	public String update_tradeconsole(TradeConsoleModel tradeconsole,ModelMap model){
		tradeconsoleService.update(tradeconsole);
		return "redirect:/tradeconsole-detail.htm";
	}
}