/**
 * Project Name:bfwmall-web-common
 * File Name:TradeProcessorUtil.java
 * Package Name:com.bofowo.biz.util
 * Date:2016年12月3日下午11:17:08
 * Copyright (c) 2016, BOFOWO Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.biz.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bofowo.site.biz.model.TradeCountItem;
import com.bofowo.site.model.OrderModel;

/**
 * ClassName:TradeProcessorUtil <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年12月3日 下午11:17:08 <br/>
 * @author   mqb
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class TradeProcessorUtil {

	public static Map<Integer, List<OrderModel>> divideOrder(List<OrderModel> orders) {
		Map<Integer,List<OrderModel>> result=new HashMap<Integer,List<OrderModel>>();
		for(OrderModel order:orders){
			Integer tid=order.getTid();
			List<OrderModel> orderList=result.get(tid);
			if(orderList==null){
				orderList=new ArrayList<OrderModel>();
			}
			orderList.add(order);
			result.put(tid, orderList);
		}
		return result;
	}

	public static TradeCountModel countTrade(List<OrderModel> orders) {
		String title="";
		float total=0.0f;
		for(OrderModel order:orders){
			total+=order.getPrice()*order.getNum();
			title=order.getTitle();
		}
		TradeCountModel tci=new TradeCountModel(total,title);
		
		return tci;
	}

}

