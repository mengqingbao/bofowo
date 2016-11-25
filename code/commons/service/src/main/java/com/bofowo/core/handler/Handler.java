/**
 * Project Name:bfwmall-service
 * File Name:Handler.java
 * Package Name:com.bofowo.core.trade.handler
 * Date:2016年11月17日下午5:18:16
 * Copyright (c) 2016, BOFOWO Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.core.handler;

import java.util.Map;

/**
 * ClassName:Handler <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年11月17日 下午5:18:16 <br/>
 * @author   mqb
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public interface Handler {
	/**
	 * 
	 * 流程处理
	 *
	 * @author mqb
	 * @since JDK 1.7
	 */
	public void execute(Map data,HandlerChain chain);

}

