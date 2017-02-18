/**
 * Project Name:bfwmall-service
 * File Name:ExpressHandler.java
 * Package Name:com.bofowo.core.trade.support.handler
 * Date:2016年11月17日下午11:16:26
 * Copyright (c) 2016, BOFOWO Technology Co., Ltd. All Rights Reserved.
 *
 */

package com.bofowo.core.trade.support.handler;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.bofowo.core.handler.Handler;
import com.bofowo.core.handler.HandlerChain;
import com.bofowo.site.model.OrderModel;
import com.bofowo.site.model.TradeModel;
import com.bofowo.site.service.OrderService;
import com.bofowo.site.service.TradeService;
import com.bofowo.util.TradeConstant;
import common.util.StringUtil;

/**
 * ClassName:ExpressHandler <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年11月17日 下午11:16:26 <br/>
 * 
 * @author mqb
 * @version
 * @since JDK 1.7
 * @see
 */
@Component("expressHandler")
public class ExpressHandler implements Handler {
	@Resource
	private TradeService tradeService;
	@Resource
	private OrderService orderService;
	@Override
	public void execute(Map data, HandlerChain chain) {
		String actionType = (String) data.get("actionType");
		if ("expressAction".equals(actionType)) {
			String tradeIds = (String) data.get("tradeIds");
			String status = (String) data.get("status");
			String userName = (String) data.get("currentUserId");
			String[] tradeIdStrs=tradeIds.split(",");
			for(String tradeId:tradeIdStrs){
				if(StringUtil.isEmpty(tradeId)){
					continue;
				}
				Integer id=Integer.valueOf(tradeId);
				TradeModel trade = tradeService.getById(id);
				trade.setStatus(TradeConstant.WAITING_SELLER_SEND);
				tradeService.update(trade);
				
				//更新order付款状态
				orderService.updateOrderByTid(trade.getId(),TradeConstant.TRADE_CLOSE,userName);
				orderService.updateStatusByids(trade.getOrderIds(),TradeConstant.WAITING_SELLER_SEND,userName);
				data.put("message", "success");
				System.out.println("express");
			}
			
		}
		chain.doExecute(data, chain);

	}

}
