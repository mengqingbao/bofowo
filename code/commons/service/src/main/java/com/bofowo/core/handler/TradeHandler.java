/**
 * Project Name:bfwmall-service
 * File Name:TradeHandler.java
 * Package Name:com.bofowo.core.handler
 * Date:2016年11月17日下午7:42:04
 * Copyright (c) 2016, BOFOWO Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.core.handler;

import java.util.Map;

/**
 * ClassName:TradeHandler <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年11月17日 下午7:42:04 <br/>
 * @author   mqb
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public interface TradeHandler extends Handler {

	@Override
	public void execute(Map data, HandlerChain chain);

}

