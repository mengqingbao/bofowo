/**
 * Project Name:bfwmall-service
 * File Name:TipSellerHandler.java
 * Package Name:com.bofowo.core.trade.support.handler
 * Date:2016年11月17日下午11:21:25
 * Copyright (c) 2016, BOFOWO Technology Co., Ltd. All Rights Reserved.
 *
 */

package com.bofowo.core.trade.support.handler;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.bofowo.core.handler.Handler;
import com.bofowo.core.handler.HandlerChain;

/**
 * ClassName:TipSellerHandler <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年11月17日 下午11:21:25 <br/>
 * 
 * @author mqb
 * @version
 * @since JDK 1.7
 * @see
 */
@Component("tipSellerHandler")
public class TipSellerHandler implements Handler {

	@Override
	public void execute(Map data, HandlerChain chain) {
		String actionType = (String) data.get("actionType");
		if ("tipAction".equals(actionType)) {
			Integer tradeId = (Integer) data.get("tradeId");
			Integer orderId = (Integer) data.get("orderId");
			System.out.println("tipseller");
			data.put("message", "已经提送");
		}
		chain.doExecute(data, chain);
	}

}
