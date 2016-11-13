package com.bofowo.site.model;

import java.io.Serializable;
import java.util.Date;

public class CommodityOrderAndDetailModel implements Serializable {
	
	private String orderNumber;
	private String receiver;
	private double orderAmount;
	private int status;
	private Date createTime;
	private int payMethod;
	private int commodityQuantity;
	private String artName;
	private String author;
	
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public double getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getPayMethod() {
		return payMethod;
	}
	public void setPayMethod(int payMethod) {
		this.payMethod = payMethod;
	}
	
	public int getCommodityQuantity() {
		return commodityQuantity;
	}
	public void setCommodityQuantity(int commodityQuantity) {
		this.commodityQuantity = commodityQuantity;
	}
	public String getArtName() {
		return artName;
	}
	public void setArtName(String artName) {
		this.artName = artName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
}