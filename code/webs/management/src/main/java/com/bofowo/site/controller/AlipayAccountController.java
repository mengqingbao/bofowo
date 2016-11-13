package com.bofowo.site.controller;
import com.bofowo.site.model.AlipayAccountModel;
import com.bofowo.site.query.AlipayAccountQuery;
import com.bofowo.site.service.AlipayAccountService;

import common.web.BaseController;

import org.springframework.ui.ModelMap;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class AlipayAccountController extends BaseController{

	@Autowired
	private AlipayAccountService alipayaccountService;

	@RequestMapping("/alipayaccount-add")
	public String addalipayaccount(ModelMap model){
		return "alipayaccount/add";
	}
	
	@RequestMapping("/alipayaccount-edit")
	public String editalipayaccount(ModelMap model,long id){
		AlipayAccountModel alipayaccount = alipayaccountService.getById(id);
		model.put("alipayaccount",alipayaccount);
		return "alipayaccount/edit";
	}
	
	@RequestMapping("alipayaccount-insert")
	public String insert_alipayaccount(AlipayAccountModel alipayaccount,ModelMap model){
		alipayaccountService.insert(alipayaccount);
		return "redirect:/alipayaccount-page.htm";
	}
	
	@RequestMapping("alipayaccount-page")
	public String page_alipayaccount(AlipayAccountQuery query,ModelMap model){
		query.setPageSize(10);
		query.setTotalItem(alipayaccountService.fetchPageCount(query));
		List<AlipayAccountModel> items=alipayaccountService.fetchPage(query);
		
		model.put("pageInfo", query);
		model.put("items",items);
		return "alipayaccount/page";
	}
	
	@RequestMapping("/alipayaccount-detail")
	public String detail_alipayaccount(ModelMap model,long id){
		AlipayAccountModel alipayaccount = alipayaccountService.getById(id);
		model.put("alipayaccount",alipayaccount);
		return "alipayaccount/detail";
	}
	
	@RequestMapping("alipayaccount-del")
	public String del_alipayaccount(ModelMap model,long id){
		alipayaccountService.del(id);
		return "redirect:/alipayaccount-page.htm";
	}
	
	@RequestMapping("alipayaccount-update")
	public String update_alipayaccount(AlipayAccountModel alipayaccount,ModelMap model){
		alipayaccountService.update(alipayaccount);
		return "redirect:/alipayaccount-detail.htm";
	}
}