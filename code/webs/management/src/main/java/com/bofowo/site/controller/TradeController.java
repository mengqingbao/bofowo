/**
 * Project Name:lymall-management
 * File Name:TradeController.java
 * Package Name:com.bofowo.site.controller
 * Date:2016年2月25日下午8:14:04
 * Copyright (c) 2016,Shanghai bofowo Technology co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.site.controller;

import java.lang.invoke.MethodType;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String searchTradeList(){
		
		return "biz/trade/trades";
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

