/**
 * Project Name:bfwmall-service
 * File Name:BackBizHandler.java
 * Package Name:com.bofowo.core.trade.support.handler
 * Date:2016年11月17日下午11:18:29
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
import com.bofowo.util.TradeConstant;

/**
 * ClassName:BackBizHandler <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年11月17日 下午11:18:29 <br/>
 * 
 * @author mqb
 * @version
 * @since JDK 1.7
 * @see
 */
@Component("backBizHandler")
public class BackBizHandler implements Handler {
	@Resource
	private TradeService tradeService;
	@Resource
	private OrderService orderService;
	@Override
	public void execute(Map data, HandlerChain chain) {

		String actionType = (String) data.get("actionType");
		if ("backAction".equals(actionType)) {
			Integer tradeId = Integer.valueOf(String.valueOf(data.get("tradeId")));
			String username=String.valueOf(data.get("currentUserId"));
			TradeModel trade = tradeService.getById(tradeId);
			trade.setStatus(TradeConstant.TRADE_BACK_STATUS);
			tradeService.update(trade);
			
			//更新order付款状态
			//orderService.updateOrderByTid(trade.getId(),TradeConstant.TRADE_CLOSE,username);
			orderService.updateStatusByids(trade.getOrderIds(),TradeConstant.TRADE_BACK_STATUS,username);
		}
		chain.doExecute(data, chain);
	}

}
