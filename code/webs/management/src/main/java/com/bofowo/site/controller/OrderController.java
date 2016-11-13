package com.bofowo.site.controller;
import com.bofowo.site.model.OrderModel;
import com.bofowo.site.query.OrderQuery;
import com.bofowo.site.service.OrderService;

import common.web.BaseController;

import org.springframework.ui.ModelMap;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class OrderController extends BaseController{

	@Autowired
	private OrderService orderService;

	@RequestMapping("/order-add")
	public String addorder(ModelMap model){
		return "order/add";
	}
	
	@RequestMapping("/order-edit")
	public String editorder(ModelMap model,long id){
		OrderModel order = orderService.getById(id);
		model.put("order",order);
		return "order/edit";
	}
	
	@RequestMapping("order-insert")
	public String insert_order(OrderModel order,ModelMap model){
		orderService.insert(order);
		return "redirect:/order-page.htm";
	}
	
	@RequestMapping("order-page")
	public String page_order(OrderQuery query,ModelMap model){
		query.setPageSize(10);
		query.setTotalItem(orderService.fetchPageCount(query));
		List<OrderModel> items=orderService.fetchPage(query);
		
		model.put("pageInfo", query);
		model.put("items",items);
		return "order/page";
	}
	
	@RequestMapping("/order-detail")
	public String detail_order(ModelMap model,long id){
		OrderModel order = orderService.getById(id);
		model.put("order",order);
		return "order/detail";
	}
	
	@RequestMapping("order-del")
	public String del_order(ModelMap model,long id){
		orderService.del(id);
		return "redirect:/order-page.htm";
	}
	
	@RequestMapping("order-update")
	public String update_order(OrderModel order,ModelMap model){
		orderService.update(order);
		return "redirect:/order-detail.htm";
	}
}