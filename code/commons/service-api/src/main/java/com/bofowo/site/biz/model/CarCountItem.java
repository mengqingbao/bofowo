/**
 * Project Name:bfwmall-service-api
 * File Name:CarCountItem.java
 * Package Name:com.bofowo.site.biz.model
 * Date:2016年11月26日上午1:11:33
 * Copyright (c) 2016, BOFOWO Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.site.biz.model;

import java.util.ArrayList;
import java.util.List;

import com.bofowo.site.model.CarModel;

/**
 * ClassName:CarCountItem <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年11月26日 上午1:11:33 <br/>
 * @author   mqb
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class CarCountItem {
	
	private float totalPrice;
	private String shopName;
	private String shopUrl;
	private String sellerId;
	private List<CarModel> items=new ArrayList<CarModel>();
	
	public void addCarModel(CarModel carModel){
		items.add(carModel);
		totalPrice +=carModel.getNum()*carModel.getPrice();
		sellerId=carModel.getSellerId();
	}

	public float getTotalPrice() {
		return totalPrice;
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

	public List<CarModel> getItems() {
		return items;
	}

	public void setItems(List<CarModel> items) {
		this.items = items;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
}

