package com.bofowo.site.controller;
import com.bofowo.site.model.CustomerServiceModel;
import com.bofowo.site.query.CustomerServiceQuery;
import com.bofowo.site.service.CustomerServiceService;

import common.web.BaseController;

import org.springframework.ui.ModelMap;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class CustomerServiceController extends BaseController{

	@Autowired
	private CustomerServiceService customerserviceService;

	@RequestMapping("/customerservice-add")
	public String addcustomerservice(ModelMap model){
		return "customerservice/add";
	}
	
	@RequestMapping("/customerservice-edit")
	public String editcustomerservice(ModelMap model,long id){
		CustomerServiceModel customerservice = customerserviceService.getById(id);
		model.put("customerservice",customerservice);
		return "customerservice/edit";
	}
	
	@RequestMapping("customerservice-insert")
	public String insert_customerservice(CustomerServiceModel customerservice,ModelMap model){
		customerserviceService.insert(customerservice);
		return "redirect:/customerservice-page.htm";
	}
	
	@RequestMapping("customerservice-page")
	public String page_customerservice(CustomerServiceQuery query,ModelMap model){
		query.setPageSize(10);
		query.setTotalItem(customerserviceService.fetchPageCount(query));
		List<CustomerServiceModel> items=customerserviceService.fetchPage(query);
		
		model.put("pageInfo", query);
		model.put("items",items);
		return "customerservice/page";
	}
	
	@RequestMapping("/customerservice-detail")
	public String detail_customerservice(ModelMap model,long id){
		CustomerServiceModel customerservice = customerserviceService.getById(id);
		model.put("customerservice",customerservice);
		return "customerservice/detail";
	}
	
	@RequestMapping("customerservice-del")
	public String del_customerservice(ModelMap model,long id){
		customerserviceService.del(id);
		return "redirect:/customerservice-page.htm";
	}
	
	@RequestMapping("customerservice-update")
	public String update_customerservice(CustomerServiceModel customerservice,ModelMap model){
		customerserviceService.update(customerservice);
		return "redirect:/customerservice-detail.htm";
	}
}