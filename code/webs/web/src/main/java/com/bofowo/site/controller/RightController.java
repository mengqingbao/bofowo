/**
 * Project Name:lymall-web
 * File Name:RightController.java
 * Package Name:com.bofowo.site.controller
 * Date:2016年3月10日下午3:28:56
 * Copyright (c) 2016,Shanghai bofowo Technology co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.site.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bofowo.site.model.CommentModel;
import com.bofowo.site.model.CustomerServiceModel;
import com.bofowo.site.model.TradeConsoleModel;
import com.bofowo.site.query.CommentQuery;
import com.bofowo.site.query.CustomerServiceQuery;
import com.bofowo.site.query.TradeConsoleQuery;
import com.bofowo.site.service.CommentService;
import com.bofowo.site.service.CustomerServiceService;
import com.bofowo.site.service.TradeConsoleService;

import common.security.login.CurrentUserUtil;
import common.util.LayoutType;
import common.web.BaseController;

/**
 * ClassName:RightController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年3月10日 下午3:28:56 <br/>
 * @author   mqb
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
@Controller
public class RightController extends BaseController {
	@Resource
	private CommentService commentService;
	@Resource
	private TradeConsoleService tradeConsoleService;
	@Resource
	private CustomerServiceService customerServiceService;

	@RequestMapping("consumer-console-{type}")
	public String myRate(@PathVariable("type") String type,TradeConsoleQuery query,ModelMap model){
		this.setLayout(LayoutType.BUYER);
		model.put("type", type);
		if("question".equals(type)){
			query.setAskerId(CurrentUserUtil.getCurrentUserName());
			query.setPageSize(20);
			query.setTotalItem(tradeConsoleService.fetchPageCount(query));
			List<TradeConsoleModel> items=tradeConsoleService.fetchPage(query);
			model.put("pageInfo", query);
			model.put("items", items);
			return "buyer/console_my_question";
		}else if("answer".equals(type)){
			query.setAnswerId(CurrentUserUtil.getCurrentUserName());
			query.setPageSize(20);
			query.setTotalItem(tradeConsoleService.fetchPageCount(query));
			List<TradeConsoleModel> items=tradeConsoleService.fetchPage(query);
			model.put("pageInfo", query);
			model.put("items", items);
			return "buyer/console_my_answer";
		}else{
			return "redirect:/error.htm";
		}
		
	}
	
	@RequestMapping("consumer-rate")
	public String comment(CommentQuery query,ModelMap model){
		this.setLayout(LayoutType.BUYER);
		query.setBuyerId(CurrentUserUtil.getCurrentUserName());
		query.setPageSize(20);
		query.setTotalItem(commentService.fetchPageCount(query));
		
		List<CommentModel> items = commentService.fetchPage(query);
		model.put("pageInfo",query);
		model.put("items", items);
		
		return "buyer/console_my_rate";
	}
	@RequestMapping("consumer_service_refund")
	public String refundList(CustomerServiceQuery query,ModelMap model){
		this.setLayout(LayoutType.BUYER);
		query.setType("refund");
		query.setBuyerId(CurrentUserUtil.getCurrentUserName());
		query.setPageSize(20);
		query.setTotalItem(customerServiceService.fetchPageCount(query));
		model.put("pageInfo", query);
		List<CustomerServiceModel> items=customerServiceService.fetchPage(query);
		model.put("items", items);
		return "buyer/comsumer_service";
	}
	@RequestMapping("consumer-service-care")
	public String afterCare(CustomerServiceQuery query,ModelMap model){
		this.setLayout(LayoutType.BUYER);
		query.setType("care");
		query.setBuyerId(CurrentUserUtil.getCurrentUserName());
		query.setPageSize(20);
		query.setTotalItem(customerServiceService.fetchPageCount(query));
		model.put("pageInfo", query);
		List<CustomerServiceModel> items=customerServiceService.fetchPage(query);
		model.put("items", items);
		return "buyer/comsumer_service";
	}
	
	@RequestMapping("consumer-service-complaint")
	public String consumerRuleList(CustomerServiceQuery query,ModelMap model){
		this.setLayout(LayoutType.BUYER);
		query.setType("complaint");
		query.setBuyerId(CurrentUserUtil.getCurrentUserName());
		query.setPageSize(20);
		query.setTotalItem(customerServiceService.fetchPageCount(query));
		model.put("pageInfo", query);
		List<CustomerServiceModel> items=customerServiceService.fetchPage(query);
		model.put("items", items);
		return "buyer/comsumer_service";
	}
	@RequestMapping("consumer-service-report")
	public String reportIPostedList(CustomerServiceQuery query,ModelMap model){
		this.setLayout(LayoutType.BUYER);
		query.setType("report");
		query.setBuyerId(CurrentUserUtil.getCurrentUserName());
		query.setPageSize(20);
		query.setTotalItem(customerServiceService.fetchPageCount(query));
		model.put("pageInfo", query);
		List<CustomerServiceModel> items=customerServiceService.fetchPage(query);
		model.put("items", items);
		return "buyer/comsumer_service";
	}
}

