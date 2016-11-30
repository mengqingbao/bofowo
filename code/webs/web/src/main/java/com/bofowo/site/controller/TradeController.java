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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bofowo.core.handler.HandlerChain;
import com.bofowo.core.trade.support.factory.TradeHandlerFactory;
import com.bofowo.site.biz.model.CarCountItem;
import com.bofowo.site.model.CarModel;
import com.bofowo.site.model.OrderModel;
import com.bofowo.site.model.ProductModel;
import com.bofowo.site.model.TradeModel;
import com.bofowo.site.service.CarService;
import com.bofowo.site.service.CategoryService;
import com.bofowo.site.service.OrderService;
import com.bofowo.site.service.ProducimageService;
import com.bofowo.site.service.ProductService;
import com.bofowo.site.service.TradeService;
import com.bofowo.site.util.CarDivideUtil;
import com.bofowo.util.TradeConstant;

import common.security.login.CurrentUserUtil;
import common.util.LayoutType;
import common.util.StringUtil;
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
	@Resource
	private CarService carService;
	@Resource
	private TradeHandlerFactory tradeHandlerFactory;
	@RequestMapping("order-cancel")
	public String backOrder(ModelMap model,Integer orderId,String status){
		OrderModel order=orderService.getById(orderId);
		order.setStatus(status);
		orderService.update(order);
		model.put("status", true);
		return "common/json";
	}
	@RequestMapping(value="processTradeAction",method=RequestMethod.POST)
	public String processTradeAction(ModelMap model,Integer tradeId,Integer orderId,String status,String actionType){
		Map data=new HashMap();
		data.put("tradeId", tradeId);
		data.put("status", status);
		data.put("orderId", orderId);
		data.put("currentUserId", CurrentUserUtil.getCurrentUserName());
		data.put("actionType",actionType);
		HandlerChain chains=tradeHandlerFactory.getHandlerChain("");
		chains.doExecute(data, chains);
		data.get("");
		model.put("json", JSONObject.fromObject(data).toString());
		return "common/json";
	}
	
	/**
	 * 
	 * 结算购物车，分单处理
	 * @author mqb
	 * @param ids
	 * @param model
	 * @return
	 * @since JDK 1.7
	 */
	@RequestMapping("trade_add_batch")
	public String addBatch(String submitItemIds,ModelMap model){
		submitItemIds=submitItemIds.substring(0, submitItemIds.lastIndexOf(",")).replace(",", "\",\"");
		submitItemIds="\""+submitItemIds+"\"";
		//查询所有提交的购物车内容
		String username=CurrentUserUtil.getCurrentUserName();
		Map<String, CarCountItem> map=tradeService.submitTrade(submitItemIds, username);
		this.setLayout(LayoutType.CAR);
		return "buyer/trade_pay_batch";
	}
	
	/**
	 * 立即购买产品，单独购买。
	 * @author mqb
	 * @param goodsId
	 * @param quantity
	 * @param title
	 * @param spec
	 * @param model
	 * @return
	 * @since JDK 1.7
	 */
	@RequestMapping("trade_add")
	public String add(Integer goodsId,Integer quantity,String title,String spec,ModelMap model){
		if(quantity<1||goodsId<0){
			return this.redirectRefer(request);
		}
		model.put("goodsId", goodsId);
		ProductModel pm=productService.getById(goodsId);
		model.put("pm", pm);
		model.put("num", quantity);
		//model.put("total",pm.getShopPrice()*quantity);
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
		trade.setStatus(TradeConstant.WAITING_PAY);
		trade.setTitle(pm.getName());
		order.setTitle(pm.getName());
		order.setStatus(TradeConstant.WAITING_PAY);
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

