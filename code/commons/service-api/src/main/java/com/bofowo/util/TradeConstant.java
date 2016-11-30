/**
 * Project Name:bfwmall-web
 * File Name:TradeConstant.java
 * Package Name:com.bofowo.util
 * Date:2016年11月15日下午9:10:18
 * Copyright (c) 2016, BOFOWO Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.util;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName:TradeConstant <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年11月15日 下午9:10:18 <br/>
 * @author   mqb
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class TradeConstant {
	//等待付款
	public static String WAITING_PAY="0"; 
	//已付款 
	public static String CANCEL_ORDER_STATUS="1";
	//卖家已发货
	public static String WAITING_SELLER_SEND="2";
	//已签收
	public static String WAITING_BUYER_SIGN="3";
	//完成
	public static String ORDER_SUCCESS="4";
	//退款不退货
	public static String BACK_MONEY_WITHOUT_PRODUCT_REQUEST="5";
	//退款不退货 卖家同意
	public static String BACK_MONEY_WITHOUT_PRODUCT_REQUEST_CONFORM="51";
	//退款不退货 卖家同意 等待买家发货
	public static String BACK_MONEY_WITHOUT_PRODUCT_BUYER_SENDING="52";
	//退款不退货 卖家同意 买家已经发货
	public static String BACK_MONEY_WITHOUT_PRODUCT_BUYER_SENDED="53";
	//退款不退货 卖家同意 卖家已经收货
	public static String BACK_MONEY_WITHOUT_PRODUCT_SELLER_CONFORM="53";
	//退款不退货 卖家同意 卖家确认收货
	public static String BACK_MENONY_WITHOUT_PRODUCT_FINISHED="54";
	//退款不退货 卖家同意 发起争议
	public static String BACK_MENONY_WITHOUT_PRODUCT_DISPUTE="55";
	//退款不退货 卖家同意 争议结束
	public static String BACK_MENONY_WITHOUT_PRODUCT_DISPUTE_FINISHED="56";
	//退款退货
	public static String BACK_MONEY_WITH_PRODUCT_REQUEST="6";
	//退款退货 卖家同意 等待发挥快递
	public static String BACK_MONEY_WITH_PRODUCT_BUYER_WAITING_REQUEST="61";
	//退款退货 买家已发货 等待卖家确认
	public static String BACK_MONEY_WITH_PRODUCT_SELLER_POST_CONFORM="62";
	//退款退货 卖家同意
	public static String BACK_MONEY_WITH_PRODUCT_FINSHIED="63";
	//退款退货 争议
	public static String BACK_MONEY_WITH_PRODUCT_DISPUTE="64";
	//退款退货 争议结束
	public static String BACK_MONEY_WITH_PRODUCT_DISPUTE_FINISHED="65";
	//交易正常完成
	public static String SUCCESS_FINSHIED="100";
	//售后服务申请
	public static String SERVICE_REQUEST="120";
	//售后服务，卖家同意，等待买家发货。
	public static String SERVICE_CONFORM="121";
	//售后服务，卖家同意，卖家已经收到货物，正在维修。
	public static String SERVICE_SELLER_POST_CONFORM="121";
	
	//售后服务，卖家同意，卖家已经收到货物，正在维修。
	public static String SERVICE_SELLER_FIXING="122";
	
	//售后服务，卖家同意，维修完成，已经发货。
	public static String SERVICE_SELLER_SEND="123";
	
	//售后服务，卖家同意，买家收货 完成。
	public static String SERVICE_SELLER_FIXING_FINISHED="124";
	
	public final static Map map = new HashMap();  
	static {  
		map.put("0", "等待付款");
	    map.put("1", "已付款");  
	    map.put("2", "已发货");
	    map.put("3", "已签收");
	    map.put("4", "交易完成");
	    map.put("5", "");
	    map.put("51", "");
	    map.put("52", "");
	    map.put("53", "");
	    map.put("54", "");
	    map.put("55", "");
	    map.put("56", "");
	    map.put("6", "");
	    map.put("61", "");
	    map.put("62", "");
	    map.put("63", "");
	    map.put("64", "");
	    map.put("65", "");
	    map.put("100", "交易成功");
	    map.put("120", "");
	    map.put("121", "");
	    map.put("122", "");
	    map.put("123", "");
	    map.put("124", "");
	    
	}  

	
}

