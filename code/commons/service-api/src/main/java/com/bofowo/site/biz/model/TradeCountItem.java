/**
 * Project Name:bfwmall-service-api
 * File Name:TradeCountItem.java
 * Package Name:com.bofowo.site.biz.model
 * Date:2016年12月2日上午12:15:49
 * Copyright (c) 2016, BOFOWO Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.site.biz.model;

import java.util.ArrayList;
import java.util.List;

import com.bofowo.site.model.OrderModel;
import com.bofowo.site.model.TradeModel;

/**
 * ClassName:TradeCountItem <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年12月2日 上午12:15:49 <br/>
 * @author   mqb
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class TradeCountItem {
	private float totalPrice;
	private String shopName;
	private String shopUrl;
	private String sellerId;
	private TradeModel tradeModel;
	private List<OrderModel> items=new ArrayList<OrderModel>();
	public float getTotalPrice() {
		return totalPrice;
	}
	
	public void addOrder(OrderModel order){
		items.add(order);
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getShopUrl() {
		return shopUrl;
	}
	public void setShopUrl(String shopUrl) {
		this.shopUrl = shopUrl;
	}
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	public TradeModel getTradeModel() {
		return tradeModel;
	}
	public void setTradeModel(TradeModel tradeModel) {
		this.tradeModel = tradeModel;
	}
	public List<OrderModel> getItems() {
		return items;
	}
	public void setItems(List<OrderModel> items) {
		this.items = items;
	}
	
	
}

