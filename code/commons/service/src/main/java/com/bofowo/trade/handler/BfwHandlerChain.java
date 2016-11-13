/**
 * Project Name:lymall-service
 * File Name:BfwHandlerChain.java
 * Package Name:com.bofowo.trade.handler
 * Date:2016年8月17日下午3:06:29
 * Copyright (c) 2016,Shanghai bofowo Technology co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.trade.handler;

import java.util.List;
import java.util.Map;

/**
 * ClassName:BfwHandlerChain <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年8月17日 下午3:06:29 <br/>
 * @author   mqb
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public interface BfwHandlerChain {
	/**
	 * 
	 * doHandler:(这里用一句话描述这个方法的作用). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 * TODO(这里描述这个方法的执行流程 – 可选).<br/>
	 * TODO(这里描述这个方法的使用方法 – 可选).<br/>
	 * TODO(这里描述这个方法的注意事项 – 可选).<br/>
	 *
	 * @author mqb
	 * @param source
	 * @param map
	 * @since JDK 1.7
	 */
	public void doHandler(List<Object> source,Map<String,Object> map);

}

