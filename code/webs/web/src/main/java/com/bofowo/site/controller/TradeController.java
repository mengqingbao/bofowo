/**
 * Project Name:lymall-management
 * File Name:ProductController.java
 * Package Name:com.bofowo.site.controller
 * Date:2016年2月25日下午8:50:17
 * Copyright (c) 2016,Shanghai bofowo Technology co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.site.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bofowo.site.model.OrderModel;
import com.bofowo.site.model.ProductModel;
import com.bofowo.site.model.TradeModel;
import com.bofowo.site.service.CategoryService;
import com.bofowo.site.service.OrderService;
import com.bofowo.site.service.ProducimageService;
import com.bofowo.site.service.ProductService;
import com.bofowo.site.service.TradeService;

import common.security.login.CurrentUserUtil;
import common.web.BaseController;

/**
 * ClassName:ProductController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年2月25日 下午8:50:17 <br/>
 * @author   mqb
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
@Controller
public class TradeController extends BaseController {
	@Resource
	private ProductService productService;
	@Resource
	private ProducimageService producimageService;
	@Resource
	private CategoryService categoryService;
	@Resource
	private TradeService tradeService;
	@Resource
	private OrderService orderService;
	
	@RequestMapping("trade_add")
	public String add(Integer goodsId,Integer quantity,String title,String spec,ModelMap model){
		if(quantity<1||goodsId<0){
			return this.redirectRefer(request);
		}
		model.put("goodsId", goodsId);
		ProductModel pm=productService.getById(goodsId);
		model.put("pm", pm);
		model.put("num", quantity);
		model.put("total",pm.getShopPrice()*quantity);
		return "trade_add";
	}
	@RequestMapping("trade_add_pay")
	public String tradde_add_pay(Integer goodsId,Integer quantity,ModelMap model){
		if(quantity<1||goodsId<0){
			return this.redirectRefer(request);
		}
		ProductModel pm=productService.getById(goodsId);
		TradeModel trade=new TradeModel();
		OrderModel order=new OrderModel();
		trade.setProductId(goodsId);
		order.setItemId(goodsId);
		//trade.setBuyerId(CurrentUserUtil.getCurrentUserName());
		//order.setBuyerId(CurrentUserUtil.getCurrentUserName());
		trade.setTitle(pm.getName());
		order.setTitle(pm.getName());
		order.setPrice(pm.getShopPrice());
		order.setNum(quantity);
		trade.setNum(quantity);
		trade.setRealPay(pm.getShopPrice()*quantity);
		order.setRealPay(pm.getShopPrice()*quantity);
		order.setPic(pm.getImages());
		trade.setPic(pm.getImages());
		trade.setPayWay("taobao");
		order.setPayWay("taobao");
		trade.setCreatedTime(new Date());
		order.setCreatedTime(new Date());
		tradeService.insert(trade);
		order.setTid(trade.getId());
		orderService.insert(order);
		if("taobao".equals(trade.getPayWay())){
			return "redirect:alipay.htm?tid="+trade.getId();
		}else if("weixin".equals(trade.getPayWay())){
			return "redirect:weixin_pay.htm?tid="+trade.getId();
		}
		return this.redirectRefer(request);
	}
}

