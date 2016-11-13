package com.bofowo.site.model;

import java.io.Serializable;
import java.util.Date;

public class OrderModel implements Serializable{

		private int id;
		private int itemId;
		private String title;
		private String pic;
		private int num;
		private float price;
		private float total;
		private String status;
		private float realPay;
		private String properties;
		private String spec;
		private int tid;
		private String note;
		private String sellerId;
		private String buyerId;
		private String payWay;
		private Date createdTime;
		private Date modifyTime;
		
		public int getId(){
		return id;
	}
		public int getItemId(){
		return itemId;
	}
		public String getTitle(){
		return title;
	}
		public String getPic(){
		return pic;
	}
		public int getNum(){
		return num;
	}
		public float getPrice(){
		return price;
	}
		public float getTotal(){
		return total;
	}
		public String getStatus(){
		return status;
	}
		public float getRealPay(){
		return realPay;
	}
		public String getProperties(){
		return properties;
	}
		public String getSpec(){
		return spec;
	}
		public int getTid(){
		return tid;
	}
		public String getNote(){
		return note;
	}
		public String getSellerId(){
		return sellerId;
	}
		public String getBuyerId(){
		return buyerId;
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
		public void setItemId(int itemId){
		this.itemId = itemId;
	}
		public void setTitle(String title){
		this.title = title;
	}
		public void setPic(String pic){
		this.pic = pic;
	}
		public void setNum(int num){
		this.num = num;
	}
		public void setPrice(float price){
		this.price = price;
	}
		public void setTotal(float total){
		this.total = total;
	}
		public void setStatus(String status){
		this.status = status;
	}
		public void setRealPay(float realPay){
		this.realPay = realPay;
	}
		public void setProperties(String properties){
		this.properties = properties;
	}
		public void setSpec(String spec){
		this.spec = spec;
	}
		public void setTid(int tid){
		this.tid = tid;
	}
		public void setNote(String note){
		this.note = note;
	}
		public void setSellerId(String sellerId){
		this.sellerId = sellerId;
	}
		public void setBuyerId(String buyerId){
		this.buyerId = buyerId;
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
		
}