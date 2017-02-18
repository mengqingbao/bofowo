/**
 * Project Name:bfwmall-web-common
 * File Name:TradeCountModel.java
 * Package Name:com.bofowo.biz.util
 * Date:2016年12月4日上午12:07:18
 * Copyright (c) 2016, BOFOWO Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.biz.util;
/**
 * ClassName:TradeCountModel <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年12月4日 上午12:07:18 <br/>
 * @author   mqb
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class TradeCountModel {
	private String title;
	private float total;
	private float realPay;
	public TradeCountModel(float total, String title) {
		this.title=title;
		this.total=total;
		this.realPay=total;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public float getRealPay() {
		return realPay;
	}
	public void setRealPay(float realPay) {
		this.realPay = realPay;
	}
	
	
}

