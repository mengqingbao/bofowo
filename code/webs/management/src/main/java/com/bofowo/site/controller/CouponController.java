package com.bofowo.site.controller;
import com.bofowo.site.model.CouponModel;
import com.bofowo.site.query.CouponQuery;
import com.bofowo.site.service.CouponService;

import common.web.BaseController;

import org.springframework.ui.ModelMap;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class CouponController extends BaseController{

	@Autowired
	private CouponService couponService;

	@RequestMapping("/coupon-add")
	public String addcoupon(ModelMap model){
		return "coupon/add";
	}
	
	@RequestMapping("/coupon-edit")
	public String editcoupon(ModelMap model,long id){
		CouponModel coupon = couponService.getById(id);
		model.put("coupon",coupon);
		return "coupon/edit";
	}
	
	@RequestMapping("coupon-insert")
	public String insert_coupon(CouponModel coupon,ModelMap model){
		couponService.insert(coupon);
		return "redirect:/coupon-page.htm";
	}
	
	@RequestMapping("coupon-page")
	public String page_coupon(CouponQuery query,ModelMap model){
		query.setPageSize(10);
		query.setTotalItem(couponService.fetchPageCount(query));
		List<CouponModel> items=couponService.fetchPage(query);
		
		model.put("pageInfo", query);
		model.put("items",items);
		return "coupon/page";
	}
	
	@RequestMapping("/coupon-detail")
	public String detail_coupon(ModelMap model,long id){
		CouponModel coupon = couponService.getById(id);
		model.put("coupon",coupon);
		return "coupon/detail";
	}
	
	@RequestMapping("coupon-del")
	public String del_coupon(ModelMap model,long id){
		couponService.del(id);
		return "redirect:/coupon-page.htm";
	}
	
	@RequestMapping("coupon-update")
	public String update_coupon(CouponModel coupon,ModelMap model){
		couponService.update(coupon);
		return "redirect:/coupon-detail.htm";
	}
}