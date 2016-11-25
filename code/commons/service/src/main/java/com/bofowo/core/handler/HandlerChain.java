/**
 * Project Name:bfwmall-service
 * File Name:HandlerChain.java
 * Package Name:com.bofowo.core.trade.handler
 * Date:2016年11月17日下午5:18:56
 * Copyright (c) 2016, BOFOWO Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.core.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * ClassName:HandlerChain <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年11月17日 下午5:18:56 <br/>
 * @author   mqb
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class HandlerChain {
	
	private Handler handler=null;
	private List<Handler> handlers=new ArrayList<Handler>();
	private int pos=0;
	public void addHandler(Handler handler){
		handlers.add(handler);
	}
	
	public void doExecute(Map data,HandlerChain chain){
		if(pos<this.getSize()){
			this.next().execute(data, chain);
		}
		
	}
	
	public int getSize(){
		return handlers.size();
	}
	
	public void setHandlers(List<Handler> handlers){
		
		this.handlers=handlers;
	}
	
	public Handler next(){
		pos++;
		return handlers.get(pos-1);
	}

	public void setPos(int pos) {
		this.pos = pos;
	}
	
}

