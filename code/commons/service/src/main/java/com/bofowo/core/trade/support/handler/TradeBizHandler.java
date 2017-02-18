/**
 * Project Name:bfwmall-service
 * File Name:TradeBizHandler.java
 * Package Name:com.bofowo.core.trade.support.handler
 * Date:2016年11月17日下午7:43:49
 * Copyright (c) 2016, BOFOWO Technology Co., Ltd. All Rights Reserved.
 *
 */

package com.bofowo.core.trade.support.handler;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.bofowo.core.handler.Handler;
import com.bofowo.core.handler.HandlerChain;
import com.bofowo.site.model.TradeModel;
import com.bofowo.site.service.OrderService;
import com.bofowo.site.service.TradeService;

/**
 * ClassName:TradeBizHandler <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年11月17日 下午7:43:49 <br/>
 * 
 * @author mqb
 * @version
 * @since JDK 1.7
 * @see
 */
@Component("tradeBizHandler")
public class TradeBizHandler implements Handler {
	@Resource
	private TradeService tradeService;
	@Resource
	private OrderService orderService;

	@Override
	public void execute(Map data, HandlerChain chain) {
		String payAction = (String) data.get("actionType");
		if ("payAction".equals(payAction)) {
			Integer tradeId = (Integer) data.get("tradeId");
			Integer orderId = (Integer) data.get("orderId");
			String status = (String) data.get("status");
			String userName = (String) data.get("currentUserId");
			TradeModel trade = tradeService.getById(tradeId);
			trade.setStatus(status);
			tradeService.update(trade);
			data.put("message", "success");
			System.out.println("tradebiz");
		}
		chain.doExecute(data, chain);
	}

}
