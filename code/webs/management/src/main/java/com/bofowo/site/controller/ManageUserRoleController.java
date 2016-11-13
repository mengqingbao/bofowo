package com.bofowo.site.controller;
import com.bofowo.site.model.ManageUserRoleModel;
import com.bofowo.site.query.ManageUserRoleQuery;
import com.bofowo.site.service.ManageUserRoleService;

import common.web.BaseController;

import org.springframework.ui.ModelMap;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class ManageUserRoleController extends BaseController{

	@Autowired
	private ManageUserRoleService manageuserroleService;

	@RequestMapping("/manageuserrole-add")
	public String addmanageuserrole(ModelMap model){
		return "manageuserrole/add";
	}
	
	@RequestMapping("/manageuserrole-edit")
	public String editmanageuserrole(ModelMap model,long id){
		ManageUserRoleModel manageuserrole = manageuserroleService.getById(id);
		model.put("manageuserrole",manageuserrole);
		return "manageuserrole/edit";
	}
	
	@RequestMapping("manageuserrole-insert")
	public String insert_manageuserrole(ManageUserRoleModel manageuserrole,ModelMap model){
		manageuserroleService.insert(manageuserrole);
		return "redirect:/manageuserrole-page.htm";
	}
	
	@RequestMapping("manageuserrole-page")
	public String page_manageuserrole(ManageUserRoleQuery query,ModelMap model){
		query.setPageSize(10);
		query.setTotalItem(manageuserroleService.fetchPageCount(query));
		List<ManageUserRoleModel> items=manageuserroleService.fetchPage(query);
		
		model.put("pageInfo", query);
		model.put("items",items);
		return "manageuserrole/page";
	}
	
	@RequestMapping("/manageuserrole-detail")
	public String detail_manageuserrole(ModelMap model,long id){
		ManageUserRoleModel manageuserrole = manageuserroleService.getById(id);
		model.put("manageuserrole",manageuserrole);
		return "manageuserrole/detail";
	}
	
	@RequestMapping("manageuserrole-del")
	public String del_manageuserrole(ModelMap model,long id){
		manageuserroleService.del(id);
		return "redirect:/manageuserrole-page.htm";
	}
	
	@RequestMapping("manageuserrole-update")
	public String update_manageuserrole(ManageUserRoleModel manageuserrole,ModelMap model){
		manageuserroleService.update(manageuserrole);
		return "redirect:/manageuserrole-detail.htm";
	}
}