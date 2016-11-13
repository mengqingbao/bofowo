package com.bofowo.site.controller;
import com.bofowo.site.model.ManageResourceModel;
import com.bofowo.site.query.ManageResourceQuery;
import com.bofowo.site.service.ManageResourceService;

import common.web.BaseController;

import org.springframework.ui.ModelMap;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class ManageResourceController extends BaseController{

	@Autowired
	private ManageResourceService manageresourceService;

	@RequestMapping("/manageresource-add")
	public String addmanageresource(ModelMap model){
		return "manageresource/add";
	}
	
	@RequestMapping("/manageresource-edit")
	public String editmanageresource(ModelMap model,long id){
		ManageResourceModel manageresource = manageresourceService.getById(id);
		model.put("manageresource",manageresource);
		return "manageresource/edit";
	}
	
	@RequestMapping("manageresource-insert")
	public String insert_manageresource(ManageResourceModel manageresource,ModelMap model){
		manageresourceService.insert(manageresource);
		return "redirect:/manageresource-page.htm";
	}
	
	@RequestMapping("manageresource-page")
	public String page_manageresource(ManageResourceQuery query,ModelMap model){
		query.setPageSize(10);
		query.setTotalItem(manageresourceService.fetchPageCount(query));
		List<ManageResourceModel> items=manageresourceService.fetchPage(query);
		
		model.put("pageInfo", query);
		model.put("items",items);
		return "manageresource/page";
	}
	
	@RequestMapping("/manageresource-detail")
	public String detail_manageresource(ModelMap model,long id){
		ManageResourceModel manageresource = manageresourceService.getById(id);
		model.put("manageresource",manageresource);
		return "manageresource/detail";
	}
	
	@RequestMapping("manageresource-del")
	public String del_manageresource(ModelMap model,long id){
		manageresourceService.del(id);
		return "redirect:/manageresource-page.htm";
	}
	
	@RequestMapping("manageresource-update")
	public String update_manageresource(ManageResourceModel manageresource,ModelMap model){
		manageresourceService.update(manageresource);
		return "redirect:/manageresource-detail.htm";
	}
}