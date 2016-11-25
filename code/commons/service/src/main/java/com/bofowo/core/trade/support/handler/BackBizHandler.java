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

import org.springframework.stereotype.Component;

import com.bofowo.core.handler.Handler;
import com.bofowo.core.handler.HandlerChain;

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

	@Override
	public void execute(Map data, HandlerChain chain) {

		String actionType = (String) data.get("actionType");
		if ("backAction".equals(actionType)) {
			Integer tradeId = (Integer) data.get("tradeId");
			Integer orderId = (Integer) data.get("orderId");
			System.out.println("backbiz");
		}
		chain.doExecute(data, chain);
	}

}
