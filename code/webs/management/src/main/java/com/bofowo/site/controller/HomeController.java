package com.bofowo.site.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import common.util.LayoutType;
import common.web.BaseController;


@Controller
public class HomeController extends BaseController{

	
	@RequestMapping("/index")
	public String index(ModelMap model){
		return "index";
	}
	
	@RequestMapping("/member-admin-add")
	public String addadmin(ModelMap model){
		return "admin/add";
	}
	
	@RequestMapping("/login")
	public String login(ModelMap model,boolean error){
		this.setLayout(LayoutType.EMPTY);
		model.put("error", error);
		return "login";
	}
	
	@RequestMapping("/test")
	public String test(ModelMap model){
		this.setLayout(LayoutType.EMPTY);
		return "program";
	}
	
}