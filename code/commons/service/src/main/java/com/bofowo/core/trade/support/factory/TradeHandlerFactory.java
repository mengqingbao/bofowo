/**
 * Project Name:bfwmall-service
 * File Name:TradeFactory.java
 * Package Name:com.bofowo.core.trade.support.factory
 * Date:2016年11月17日下午7:33:39
 * Copyright (c) 2016, BOFOWO Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.core.trade.support.factory;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.bofowo.core.factory.HandlerFactory;
import com.bofowo.core.handler.Handler;
import com.bofowo.core.handler.HandlerChain;
import com.bofowo.core.trade.support.handler.BackBizHandler;
import com.bofowo.core.trade.support.handler.CommonSmsHandler;
import com.bofowo.core.trade.support.handler.ExpressHandler;
import com.bofowo.core.trade.support.handler.OrderBizHandler;
import com.bofowo.core.trade.support.handler.TipSellerHandler;
import com.bofowo.core.trade.support.handler.TradeBizHandler;

/**
 * ClassName:TradeFactory <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年11月17日 下午7:33:39 <br/>
 * @author   mqb
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
@Component("tradeHandlerFactory")
public class TradeHandlerFactory implements HandlerFactory {
	
	public List<Handler> list;
	
	public String fileNames="";
	@Resource
	private BackBizHandler backBizHandler;
	@Resource
	private CommonSmsHandler commonSmsHandler;
	@Resource
	private ExpressHandler expressHandler;
	@Resource
	private OrderBizHandler orderBizHandler;
	@Resource
	private TipSellerHandler tipSellerHandler;
	@Resource
	private TradeBizHandler tradeBizHandler;
	private HandlerChain chains;
	public TradeHandlerFactory(){
		
	}
	@Override
	public HandlerChain getHandlerChain(String fileNames) {
		if(chains==null){
			chains=new HandlerChain();
			chains.addHandler(backBizHandler);
			chains.addHandler(commonSmsHandler);
			chains.addHandler(expressHandler);
			chains.addHandler(orderBizHandler);
			chains.addHandler(tipSellerHandler);
			chains.addHandler(tradeBizHandler);
		}
		chains.setPos(0);
		return chains;
	}

	public List<Handler> getList() {
		return list;
	}

	public void setList(List<Handler> list) {
		this.list = list;
	}

	
	
	
	
}

