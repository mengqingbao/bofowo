package com.bofowo.site.controller;
import com.bofowo.site.model.AccountModel;
import com.bofowo.site.query.AccountQuery;
import com.bofowo.site.service.AccountService;

import common.web.BaseController;

import org.springframework.ui.ModelMap;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class AccountController extends BaseController{

	@Autowired
	private AccountService accountService;

	@RequestMapping("/account-add")
	public String addaccount(ModelMap model){
		return "account/add";
	}
	
	@RequestMapping("/account-edit")
	public String editaccount(ModelMap model,long id){
		AccountModel account = accountService.getById(id);
		model.put("account",account);
		return "account/edit";
	}
	
	@RequestMapping("account-insert")
	public String insert_account(AccountModel account,ModelMap model){
		accountService.insert(account);
		return "redirect:/account-page.htm";
	}
	
	@RequestMapping("account-page")
	public String page_account(AccountQuery query,ModelMap model){
		query.setPageSize(10);
		query.setTotalItem(accountService.fetchPageCount(query));
		List<AccountModel> items=accountService.fetchPage(query);
		
		model.put("pageInfo", query);
		model.put("items",items);
		return "account/page";
	}
	
	@RequestMapping("/account-detail")
	public String detail_account(ModelMap model,long id){
		AccountModel account = accountService.getById(id);
		model.put("account",account);
		return "account/detail";
	}
	
	@RequestMapping("account-del")
	public String del_account(ModelMap model,long id){
		accountService.del(id);
		return "redirect:/account-page.htm";
	}
	
	@RequestMapping("account-update")
	public String update_account(AccountModel account,ModelMap model){
		accountService.update(account);
		return "redirect:/account-detail.htm";
	}
}