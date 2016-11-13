package com.bofowo.site.controller;
import com.bofowo.site.model.ManageRoleModel;
import com.bofowo.site.query.ManageRoleQuery;
import com.bofowo.site.service.ManageRoleService;

import common.web.BaseController;

import org.springframework.ui.ModelMap;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class ManageRoleController extends BaseController{

	@Autowired
	private ManageRoleService manageroleService;

	@RequestMapping("/managerole-add")
	public String addmanagerole(ModelMap model){
		return "managerole/add";
	}
	
	@RequestMapping("/managerole-edit")
	public String editmanagerole(ModelMap model,long id){
		ManageRoleModel managerole = manageroleService.getById(id);
		model.put("managerole",managerole);
		return "managerole/edit";
	}
	
	@RequestMapping("managerole-insert")
	public String insert_managerole(ManageRoleModel managerole,ModelMap model){
		manageroleService.insert(managerole);
		return "redirect:/managerole-page.htm";
	}
	
	@RequestMapping("managerole-page")
	public String page_managerole(ManageRoleQuery query,ModelMap model){
		query.setPageSize(10);
		query.setTotalItem(manageroleService.fetchPageCount(query));
		List<ManageRoleModel> items=manageroleService.fetchPage(query);
		
		model.put("pageInfo", query);
		model.put("items",items);
		return "managerole/page";
	}
	
	@RequestMapping("/managerole-detail")
	public String detail_managerole(ModelMap model,long id){
		ManageRoleModel managerole = manageroleService.getById(id);
		model.put("managerole",managerole);
		return "managerole/detail";
	}
	
	@RequestMapping("managerole-del")
	public String del_managerole(ModelMap model,long id){
		manageroleService.del(id);
		return "redirect:/managerole-page.htm";
	}
	
	@RequestMapping("managerole-update")
	public String update_managerole(ManageRoleModel managerole,ModelMap model){
		manageroleService.update(managerole);
		return "redirect:/managerole-detail.htm";
	}
}