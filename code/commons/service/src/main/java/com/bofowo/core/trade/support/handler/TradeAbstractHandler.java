/**
 * Project Name:bfwmall-service
 * File Name:TradeAbstractHandler.java
 * Package Name:com.bofowo.core.handler
 * Date:2016年11月17日下午6:50:47
 * Copyright (c) 2016, BOFOWO Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.core.trade.support.handler;

import java.util.Map;

import com.bofowo.core.handler.Handler;
import com.bofowo.core.handler.HandlerChain;
import com.bofowo.core.handler.TradeHandler;
import com.bofowo.site.service.AccountService;
import com.bofowo.site.service.OrderService;
import com.bofowo.site.service.TradeService;

/**
 * ClassName:TradeAbstractHandler <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年11月17日 下午6:50:47 <br/>
 * @author   mqb
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public abstract class TradeAbstractHandler implements TradeHandler{

	private TradeService tradeService;
	private OrderService orderService;
	private AccountService accountService;
	private String buyerId,SellerId;
	private int tradeId;
	@Override
	public void execute(Map data, HandlerChain chain) {
		data.put("buyerId", buyerId);
		data.put("sellerId", SellerId);
		data.put("tradeId",tradeId);
		doProcess(data);
		chain.doExecute(data, chain);
	}
	protected void doProcess(Map data){
		
	}
	
	public void setTradeService(TradeService tradeService) {
		this.tradeService = tradeService;
	}
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}
	public void setSellerId(String sellerId) {
		SellerId = sellerId;
	}
	public void setTradeId(int tradeId) {
		this.tradeId = tradeId;
	}
	
}

