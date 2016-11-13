/**
 * Project Name:lymall-web
 * File Name:CouponController.java
 * Package Name:com.bofowo.site.controller
 * Date:2016年3月12日下午5:33:26
 * Copyright (c) 2016,Shanghai bofowo Technology co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.site.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bofowo.site.model.CouponModel;
import com.bofowo.site.query.CouponQuery;
import com.bofowo.site.service.CouponService;

import common.security.login.CurrentUserUtil;
import common.util.BeanUtils;
import common.util.LayoutType;
import common.web.BaseController;

/**
 * ClassName:CouponController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年3月12日 下午5:33:26 <br/>
 * @author   mqb
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
@Controller
public class CouponController extends BaseController {

	@Resource
	private CouponService couponService;
	
	@RequestMapping("store-manjian")
	public String manjian(ModelMap model,CouponQuery query){
		query.setPageSize(20);
		query.setType("1");
		query.setSellerId(CurrentUserUtil.getCurrentUserName());
		query.setTotalItem(couponService.fetchPageCount(query));
		List<CouponModel> items=couponService.fetchPage(query);
		this.setLayout(LayoutType.SELLER);
		model.put("items", items);
		model.put("pageInfo", query);
		return "coupon/man_jian";
		
	}
	
	@RequestMapping("store-manjian-add")
	public String manjianAdd(ModelMap model,CouponQuery query){
		this.setLayout(LayoutType.SELLER);
		return "coupon/man_jian_add";
		
	}
	
	@RequestMapping("store-coupon-del")
	public String manjianDel(Integer id,String type){
		this.setLayout(LayoutType.SELLER);
		couponService.del(id);
		if("1".equals(type)){
			return "redirect:/store-manjian.htm";
		}else{
			return "redirect:/store-free-shipment.htm";
		}
		
	}
	
	@RequestMapping("store-coupon-insert")
	public String manjianInsert(ModelMap model,CouponModel coupon,String type){
		this.setLayout(LayoutType.SELLER);
		coupon.setSellerId(CurrentUserUtil.getCurrentUserName());
		
		couponService.insert(coupon);
		if("1".equals(type)){
			return "redirect:/store-manjian.htm";
		}else{
			return "redirect:/store-free-shipment.htm";
		}
	}
	
	@RequestMapping("store-coupon-edit")
	public String couponEdit(ModelMap model,CouponModel coupon,String type,Integer id){
		this.setLayout(LayoutType.SELLER);
		coupon.setSellerId(CurrentUserUtil.getCurrentUserName());
		CouponModel cm=couponService.getById(id);
		model.put("item",cm);
		if("1".equals(type)){
			return "coupon/man_jian_edit";
		}else{
			return "coupon/mian_you_edit";
		}
	}
	
	@RequestMapping("store-coupon-update")
	public String manjianUpdate(Integer id,CouponModel coupon,String type){
		this.setLayout(LayoutType.SELLER);
		CouponModel cm=couponService.getById(id);
		BeanUtils.copyProperties(coupon, cm);
		couponService.update(cm);
		if("1".equals(type)){
			return "redirect:/store-manjian.htm";
		}else{
			return "redirect:/store-free-shipment.htm";
		}
		
	}
	
	@RequestMapping("store-free-shipment")
	public String mianyou(ModelMap model,CouponQuery query){
		this.setLayout(LayoutType.SELLER);
		query.setPageSize(20);
		query.setType("2");
		query.setSellerId(CurrentUserUtil.getCurrentUserName());
		query.setTotalItem(couponService.fetchPageCount(query));
		List<CouponModel> items=couponService.fetchPage(query);
		this.setLayout(LayoutType.SELLER);
		model.put("items", items);
		model.put("pageInfo", query);
		return "coupon/mian_you";
		
	}
	
	@RequestMapping("store-free-shipment-add")
	public String mianyouAdd(ModelMap model,CouponQuery query){
		this.setLayout(LayoutType.SELLER);
		return "coupon/mian_you_add";
		
	}
	
	@RequestMapping("youhuiqian")
	public String youhuiquan(){
		this.setLayout(LayoutType.SELLER);
		return "coupon/you_hui_quan";
		
	}
}

