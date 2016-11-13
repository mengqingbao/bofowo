package com.bofowo.site.controller;
import com.bofowo.site.model.BuyerAddressModel;
import com.bofowo.site.query.BuyerAddressQuery;
import com.bofowo.site.service.BuyerAddressService;

import common.web.BaseController;

import org.springframework.ui.ModelMap;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class BuyerAddressController extends BaseController{

	@Autowired
	private BuyerAddressService buyeraddressService;

	@RequestMapping("/buyeraddress-add")
	public String addbuyeraddress(ModelMap model){
		return "buyeraddress/add";
	}
	
	@RequestMapping("/buyeraddress-edit")
	public String editbuyeraddress(ModelMap model,long id){
		BuyerAddressModel buyeraddress = buyeraddressService.getById(id);
		model.put("buyeraddress",buyeraddress);
		return "buyeraddress/edit";
	}
	
	@RequestMapping("buyeraddress-insert")
	public String insert_buyeraddress(BuyerAddressModel buyeraddress,ModelMap model){
		buyeraddressService.insert(buyeraddress);
		return "redirect:/buyeraddress-page.htm";
	}
	
	@RequestMapping("buyeraddress-page")
	public String page_buyeraddress(BuyerAddressQuery query,ModelMap model){
		query.setPageSize(10);
		query.setTotalItem(buyeraddressService.fetchPageCount(query));
		List<BuyerAddressModel> items=buyeraddressService.fetchPage(query);
		
		model.put("pageInfo", query);
		model.put("items",items);
		return "buyeraddress/page";
	}
	
	@RequestMapping("/buyeraddress-detail")
	public String detail_buyeraddress(ModelMap model,long id){
		BuyerAddressModel buyeraddress = buyeraddressService.getById(id);
		model.put("buyeraddress",buyeraddress);
		return "buyeraddress/detail";
	}
	
	@RequestMapping("buyeraddress-del")
	public String del_buyeraddress(ModelMap model,long id){
		buyeraddressService.del(id);
		return "redirect:/buyeraddress-page.htm";
	}
	
	@RequestMapping("buyeraddress-update")
	public String update_buyeraddress(BuyerAddressModel buyeraddress,ModelMap model){
		buyeraddressService.update(buyeraddress);
		return "redirect:/buyeraddress-detail.htm";
	}
}