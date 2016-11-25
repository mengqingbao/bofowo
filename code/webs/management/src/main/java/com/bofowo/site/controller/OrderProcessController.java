package com.bofowo.site.controller;
import com.bofowo.site.service.OrderProcessService;
import common.web.BaseController;
import org.springframework.ui.ModelMap;
import com.bofowo.site.query.OrderProcessQuery;
import com.bofowo.site.model.OrderProcessModel;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class OrderProcessController extends BaseController{

	@Autowired
	private OrderProcessService orderprocessService;

	@RequestMapping("/orderprocess-add")
	public String addorderprocess(ModelMap model){
		return "orderprocess/add";
	}
	
	@RequestMapping("/orderprocess-edit")
	public String editorderprocess(ModelMap model,long id){
		OrderProcessModel orderprocess = orderprocessService.getById(id);
		model.put("orderprocess",orderprocess);
		return "orderprocess/edit";
	}
	
	@RequestMapping("orderprocess-insert")
	public String insert_orderprocess(OrderProcessModel orderprocess,ModelMap model){
		orderprocessService.insert(orderprocess);
		return "redirect:/orderprocess-page.htm";
	}
	
	@RequestMapping("orderprocess-page")
	public String page_orderprocess(OrderProcessQuery query,ModelMap model){
		query.setPageSize(10);
		query.setTotalItem(orderprocessService.fetchPageCount(query));
		List<OrderProcessModel> items=orderprocessService.fetchPage(query);
		
		model.put("pageInfo", query);
		model.put("items",items);
		return "orderprocess/page";
	}
	
	@RequestMapping("/orderprocess-detail")
	public String detail_orderprocess(ModelMap model,long id){
		OrderProcessModel orderprocess = orderprocessService.getById(id);
		model.put("orderprocess",orderprocess);
		return "orderprocess/detail";
	}
	
	@RequestMapping("orderprocess-del")
	public String del_orderprocess(ModelMap model,long id){
		orderprocessService.del(id);
		return "redirect:/orderprocess-page.htm";
	}
	
	@RequestMapping("orderprocess-update")
	public String update_orderprocess(OrderProcessModel orderprocess,ModelMap model){
		orderprocessService.update(orderprocess);
		return "redirect:/orderprocess-detail.htm";
	}
}