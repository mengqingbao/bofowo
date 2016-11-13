package com.bofowo.site.controller;
import com.bofowo.site.model.BuyerCollectionModel;
import com.bofowo.site.query.BuyerCollectionQuery;
import com.bofowo.site.service.BuyerCollectionService;

import common.web.BaseController;

import org.springframework.ui.ModelMap;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class BuyerCollectionController extends BaseController{

	@Autowired
	private BuyerCollectionService buyercollectionService;

	@RequestMapping("/buyercollection-add")
	public String addbuyercollection(ModelMap model){
		return "buyercollection/add";
	}
	
	@RequestMapping("/buyercollection-edit")
	public String editbuyercollection(ModelMap model,long id){
		BuyerCollectionModel buyercollection = buyercollectionService.getById(id);
		model.put("buyercollection",buyercollection);
		return "buyercollection/edit";
	}
	
	@RequestMapping("buyercollection-insert")
	public String insert_buyercollection(BuyerCollectionModel buyercollection,ModelMap model){
		buyercollectionService.insert(buyercollection);
		return "redirect:/buyercollection-page.htm";
	}
	
	@RequestMapping("buyercollection-page")
	public String page_buyercollection(BuyerCollectionQuery query,ModelMap model){
		query.setPageSize(10);
		query.setTotalItem(buyercollectionService.fetchPageCount(query));
		List<BuyerCollectionModel> items=buyercollectionService.fetchPage(query);
		
		model.put("pageInfo", query);
		model.put("items",items);
		return "buyercollection/page";
	}
	
	@RequestMapping("/buyercollection-detail")
	public String detail_buyercollection(ModelMap model,long id){
		BuyerCollectionModel buyercollection = buyercollectionService.getById(id);
		model.put("buyercollection",buyercollection);
		return "buyercollection/detail";
	}
	
	@RequestMapping("buyercollection-del")
	public String del_buyercollection(ModelMap model,long id){
		buyercollectionService.del(id);
		return "redirect:/buyercollection-page.htm";
	}
	
	@RequestMapping("buyercollection-update")
	public String update_buyercollection(BuyerCollectionModel buyercollection,ModelMap model){
		buyercollectionService.update(buyercollection);
		return "redirect:/buyercollection-detail.htm";
	}
}