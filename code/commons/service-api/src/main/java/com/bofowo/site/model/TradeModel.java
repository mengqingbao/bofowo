package com.bofowo.site.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class TradeModel implements Serializable{

		private int id;
		private String title;
		private float total;
		private float realPay;
		private String status;
		private String pic;
		private int num;
		private String note;
		private int productId;
		private float shopPrace;
		private String sellerId;
		private String buyerId;
		private String shopName;
		private String payWay;
		private Date createdTime;
		private Date modifyTime;
		
		private List<OrderModel> orders;
		
		public int getId(){
		return id;
	}
		public String getTitle(){
		return title;
	}
		public float getTotal(){
		return total;
	}
		public float getRealPay(){
		return realPay;
	}
		public String getStatus(){
		return status;
	}
		public String getPic(){
		return pic;
	}
		public int getNum(){
		return num;
	}
		public String getNote(){
		return note;
	}
		public int getProductId(){
		return productId;
	}
		public float getShopPrace(){
		return shopPrace;
	}
		public String getSellerId(){
		return sellerId;
	}
		public String getBuyerId(){
		return buyerId;
	}
		public String getShopName(){
		return shopName;
	}
		public String getPayWay(){
		return payWay;
	}
		public Date getCreatedTime(){
		return createdTime;
	}
		public Date getModifyTime(){
		return modifyTime;
	}
		
		public void setId(int id){
		this.id = id;
	}
		public void setTitle(String title){
		this.title = title;
	}
		public void setTotal(float total){
		this.total = total;
	}
		public void setRealPay(float realPay){
		this.realPay = realPay;
	}
		public void setStatus(String status){
		this.status = status;
	}
		public void setPic(String pic){
		this.pic = pic;
	}
		public void setNum(int num){
		this.num = num;
	}
		public void setNote(String note){
		this.note = note;
	}
		public void setProductId(int productId){
		this.productId = productId;
	}
		public void setShopPrace(float shopPrace){
		this.shopPrace = shopPrace;
	}
		public void setSellerId(String sellerId){
		this.sellerId = sellerId;
	}
		public void setBuyerId(String buyerId){
		this.buyerId = buyerId;
	}
		public void setShopName(String shopName){
		this.shopName = shopName;
	}
		public void setPayWay(String payWay){
		this.payWay = payWay;
	}
		public void setCreatedTime(Date createdTime){
		this.createdTime = createdTime;
	}
		public void setModifyTime(Date modifyTime){
		this.modifyTime = modifyTime;
	}
		public List<OrderModel> getOrders() {
			return orders;
		}
		public void setOrders(List<OrderModel> orders) {
			this.orders = orders;
		}
		
		
		
}