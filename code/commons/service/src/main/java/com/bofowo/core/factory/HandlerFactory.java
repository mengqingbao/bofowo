/**
 * Project Name:bfwmall-service
 * File Name:HandlerFactory.java
 * Package Name:com.bofowo.core.factory
 * Date:2016年11月17日下午10:21:22
 * Copyright (c) 2016, BOFOWO Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.core.factory;

import com.bofowo.core.handler.Handler;
import com.bofowo.core.handler.HandlerChain;

/**
 * ClassName:HandlerFactory <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年11月17日 下午10:21:22 <br/>
 * @author   mqb
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public interface HandlerFactory {

	public HandlerChain getHandlerChain(String fileNames);
}

