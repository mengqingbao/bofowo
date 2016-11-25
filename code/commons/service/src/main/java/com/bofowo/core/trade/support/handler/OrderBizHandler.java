/**
 * Project Name:bfwmall-service
 * File Name:OrderBizHandler.java
 * Package Name:com.bofowo.core.trade.support.handler
 * Date:2016年11月17日下午11:15:22
 * Copyright (c) 2016, BOFOWO Technology Co., Ltd. All Rights Reserved.
 *
 */

package com.bofowo.core.trade.support.handler;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.bofowo.core.handler.Handler;
import com.bofowo.core.handler.HandlerChain;

/**
 * ClassName:OrderBizHandler <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年11月17日 下午11:15:22 <br/>
 * 
 * @author mqb
 * @version
 * @since JDK 1.7
 * @see
 */
@Component("orderBizHandler")
public class OrderBizHandler implements Handler {

	@Override
	public void execute(Map data, HandlerChain chain) {
		String actionType = (String) data.get("actionType");
		if ("orderAction".equals(actionType)) {
			Integer tradeId = (Integer) data.get("tradeId");
			Integer orderId = (Integer) data.get("orderId");
			System.out.println("orderbiz");
		}
		chain.doExecute(data, chain);
	}

}
