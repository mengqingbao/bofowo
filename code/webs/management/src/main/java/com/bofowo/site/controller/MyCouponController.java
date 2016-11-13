package com.bofowo.site.controller;
import com.bofowo.site.model.MyCouponModel;
import com.bofowo.site.query.MyCouponQuery;
import com.bofowo.site.service.MyCouponService;

import common.web.BaseController;

import org.springframework.ui.ModelMap;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class MyCouponController extends BaseController{

	@Autowired
	private MyCouponService mycouponService;

	@RequestMapping("/mycoupon-add")
	public String addmycoupon(ModelMap model){
		return "mycoupon/add";
	}
	
	@RequestMapping("/mycoupon-edit")
	public String editmycoupon(ModelMap model,long id){
		MyCouponModel mycoupon = mycouponService.getById(id);
		model.put("mycoupon",mycoupon);
		return "mycoupon/edit";
	}
	
	@RequestMapping("mycoupon-insert")
	public String insert_mycoupon(MyCouponModel mycoupon,ModelMap model){
		mycouponService.insert(mycoupon);
		return "redirect:/mycoupon-page.htm";
	}
	
	@RequestMapping("mycoupon-page")
	public String page_mycoupon(MyCouponQuery query,ModelMap model){
		query.setPageSize(10);
		query.setTotalItem(mycouponService.fetchPageCount(query));
		List<MyCouponModel> items=mycouponService.fetchPage(query);
		
		model.put("pageInfo", query);
		model.put("items",items);
		return "mycoupon/page";
	}
	
	@RequestMapping("/mycoupon-detail")
	public String detail_mycoupon(ModelMap model,long id){
		MyCouponModel mycoupon = mycouponService.getById(id);
		model.put("mycoupon",mycoupon);
		return "mycoupon/detail";
	}
	
	@RequestMapping("mycoupon-del")
	public String del_mycoupon(ModelMap model,long id){
		mycouponService.del(id);
		return "redirect:/mycoupon-page.htm";
	}
	
	@RequestMapping("mycoupon-update")
	public String update_mycoupon(MyCouponModel mycoupon,ModelMap model){
		mycouponService.update(mycoupon);
		return "redirect:/mycoupon-detail.htm";
	}
}