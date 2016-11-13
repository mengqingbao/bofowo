package com.bofowo.site.model;

import java.io.Serializable;
import java.util.Date;

public class MyCouponModel implements Serializable{

		private int id;
		private String name;
		private int couponId;
		private String content;
		private String buyerId;
		private String sellerId;
		private Date createdTime;
		private String type;
		private Date startDate;
		private Date endDate;
		
		public int getId(){
		return id;
	}
		public String getName(){
		return name;
	}
		public int getCouponId(){
		return couponId;
	}
		public String getContent(){
		return content;
	}
		public String getBuyerId(){
		return buyerId;
	}
		public String getSellerId(){
		return sellerId;
	}
		public Date getCreatedTime(){
		return createdTime;
	}
		public String getType(){
		return type;
	}
		public Date getStartDate(){
		return startDate;
	}
		public Date getEndDate(){
		return endDate;
	}
		
		public void setId(int id){
		this.id = id;
	}
		public void setName(String name){
		this.name = name;
	}
		public void setCouponId(int couponId){
		this.couponId = couponId;
	}
		public void setContent(String content){
		this.content = content;
	}
		public void setBuyerId(String buyerId){
		this.buyerId = buyerId;
	}
		public void setSellerId(String sellerId){
		this.sellerId = sellerId;
	}
		public void setCreatedTime(Date createdTime){
		this.createdTime = createdTime;
	}
		public void setType(String type){
		this.type = type;
	}
		public void setStartDate(Date startDate){
		this.startDate = startDate;
	}
		public void setEndDate(Date endDate){
		this.endDate = endDate;
	}
		
}