/**
 * Project Name:lymall-management
 * File Name:TradeController.java
 * Package Name:com.bofowo.site.controller
 * Date:2016年2月25日下午8:14:04
 * Copyright (c) 2016,Shanghai bofowo Technology co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.site.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bofowo.core.handler.HandlerChain;
import com.bofowo.core.trade.support.factory.TradeHandlerFactory;
import com.bofowo.site.model.OrderModel;
import com.bofowo.site.model.TradeModel;
import com.bofowo.site.query.TradeQuery;
import com.bofowo.site.service.CategoryService;
import com.bofowo.site.service.CommentService;
import com.bofowo.site.service.CustomerServiceService;
import com.bofowo.site.service.OrderService;
import com.bofowo.site.service.ProducimageService;
import com.bofowo.site.service.ProductrademarkService;
import com.bofowo.site.service.TradeService;

import common.security.login.CurrentUserUtil;
import common.util.LayoutType;
import common.util.StringUtil;
import common.web.BaseController;

/**
 * ClassName:TradeController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年2月25日 下午8:14:04 <br/>
 * @author   mqb
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */

@Controller
public class TradeController extends BaseController {
	@Resource
	private CategoryService categoryService;
	
	@Resource
	private ProducimageService producimageService;
	@Resource
	private ProductrademarkService productrademarkService;
	
	@Resource
	private TradeService traderService;
	@Resource
	private OrderService orderService;
	@Resource
	private CommentService commentService;
	@Resource
	private CustomerServiceService customerServiceService;
	
	@Resource
	private TradeHandlerFactory tradeHandlerFactory;
	/**
	 * 
	 * searchTradeList:订单查询. <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author mqb
	 * @return
	 * @since JDK 1.7
	 */
	@RequestMapping(value="manage-search-trades",method=RequestMethod.GET)
	public String searchTradeList(TradeQuery query,ModelMap model){
		query.setPageSize(10);
		query.setTotalItem(traderService.fetchPageCount(query));
		List<TradeModel> trades=traderService.fetchPage(query);
		Map<String,Object> map=new HashMap<String,Object>();
		for(TradeModel trade :trades){
			long tid=trade.getId();
			List<OrderModel> orders=orderService.getOrderByTid(trade.getId());
			trade.setOrders(orders);
		}
		model.put("pageInfo", query);
		model.put("items", trades);
		if(StringUtil.isEmpty(query.getStatus())){
			query.setStatus("0");
		}
		model.put("status", query.getStatus());
		return "biz/trade/trades";
	}
	
	@RequestMapping(value="doTradeAction",method=RequestMethod.GET)
	public String tradeProcess(ModelMap model,Integer tradeId,Integer orderId,String status,String actionUserType){
		Map data=new HashMap();
		data.put("tradeId", tradeId);
		data.put("status", status);
		data.put("orderId", orderId);
		data.put("actionUserType", actionUserType);
		data.put("currentUserId", CurrentUserUtil.getCurrentUserName());
		HandlerChain chains=tradeHandlerFactory.getHandlerChain("");
		chains.doExecute(data, chains);
		data.get("");
		model.put("json", "{}");
		return "common/json";
	}
	
	@RequestMapping("trade-back-request")
	public String backProduct(){
		
		return "biz/trade/tradesBack";
	}
	@RequestMapping("trade-change-request")
	public String changeProduct(){
		
		return "biz/trade/tradesChange";
	}
	
	@RequestMapping("trade-comment-search")
	public String commentSearch(){
		
		return "biz/trade/tradesComment";
	}
	
	public String commentsReport(){
		return "biz/trade/tradeReports";
	}
}

