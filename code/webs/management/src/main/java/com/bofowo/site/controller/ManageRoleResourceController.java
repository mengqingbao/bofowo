package com.bofowo.site.controller;
import com.bofowo.site.model.ManageRoleResourceModel;
import com.bofowo.site.query.ManageRoleResourceQuery;
import com.bofowo.site.service.ManageRoleResourceService;

import common.web.BaseController;

import org.springframework.ui.ModelMap;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class ManageRoleResourceController extends BaseController{

	@Autowired
	private ManageRoleResourceService manageroleresourceService;

	@RequestMapping("/manageroleresource-add")
	public String addmanageroleresource(ModelMap model){
		return "manageroleresource/add";
	}
	
	@RequestMapping("/manageroleresource-edit")
	public String editmanageroleresource(ModelMap model,long id){
		ManageRoleResourceModel manageroleresource = manageroleresourceService.getById(id);
		model.put("manageroleresource",manageroleresource);
		return "manageroleresource/edit";
	}
	
	@RequestMapping("manageroleresource-insert")
	public String insert_manageroleresource(ManageRoleResourceModel manageroleresource,ModelMap model){
		manageroleresourceService.insert(manageroleresource);
		return "redirect:/manageroleresource-page.htm";
	}
	
	@RequestMapping("manageroleresource-page")
	public String page_manageroleresource(ManageRoleResourceQuery query,ModelMap model){
		query.setPageSize(10);
		query.setTotalItem(manageroleresourceService.fetchPageCount(query));
		List<ManageRoleResourceModel> items=manageroleresourceService.fetchPage(query);
		
		model.put("pageInfo", query);
		model.put("items",items);
		return "manageroleresource/page";
	}
	
	@RequestMapping("/manageroleresource-detail")
	public String detail_manageroleresource(ModelMap model,long id){
		ManageRoleResourceModel manageroleresource = manageroleresourceService.getById(id);
		model.put("manageroleresource",manageroleresource);
		return "manageroleresource/detail";
	}
	
	@RequestMapping("manageroleresource-del")
	public String del_manageroleresource(ModelMap model,long id){
		manageroleresourceService.del(id);
		return "redirect:/manageroleresource-page.htm";
	}
	
	@RequestMapping("manageroleresource-update")
	public String update_manageroleresource(ManageRoleResourceModel manageroleresource,ModelMap model){
		manageroleresourceService.update(manageroleresource);
		return "redirect:/manageroleresource-detail.htm";
	}
}