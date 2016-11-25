/**
 * Project Name:bfwmall-web
 * File Name:TradeStringUtil.java
 * Package Name:com.bofowo.util
 * Date:2016年11月15日下午11:11:09
 * Copyright (c) 2016, BOFOWO Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.util;
/**
 * ClassName:TradeStringUtil <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年11月15日 下午11:11:09 <br/>
 * @author   mqb
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class TradeStringUtil {
	public static String getTradeStatus(String key){
		return (String) TradeConstant.map.get(key);
	}
	
	public static String getButton(String key){
		Integer flage=(Integer) TradeConstant.map.get(key);
		switch (flage) {
		case 1:
			
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		case 4:
			
			break;
		case 5:
			break;
	   
		default:
			break;
		}
		StringBuffer sql=new StringBuffer();
		
		return "";
	}
}

