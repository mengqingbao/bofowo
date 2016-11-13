package com.bofowo.site.model;

import java.io.Serializable;
import java.util.Date;

public class CouponModel implements Serializable{

		private int id;
		private String name;
		private String desc;
		private Date createdTime;
		private Date beginTime;
		private Date endTime;
		private String status;
		private int shopId;
		private String sellerId;
		private String type;
		private String content;
		private String categoryIds;
		private String pic;
		private Date modifyTime;
		private String modifier;
		
		public int getId(){
		return id;
	}
		public String getName(){
		return name;
	}
		public String getDesc(){
		return desc;
	}
		public Date getCreatedTime(){
		return createdTime;
	}
		public Date getBeginTime(){
		return beginTime;
	}
		public Date getEndTime(){
		return endTime;
	}
		public String getStatus(){
		return status;
	}
		public int getShopId(){
		return shopId;
	}
		public String getSellerId(){
		return sellerId;
	}
		public String getType(){
		return type;
	}
		public String getContent(){
		return content;
	}
		public String getCategoryIds(){
		return categoryIds;
	}
		public String getPic(){
		return pic;
	}
		public Date getModifyTime(){
		return modifyTime;
	}
		public String getModifier(){
		return modifier;
	}
		
		public void setId(int id){
		this.id = id;
	}
		public void setName(String name){
		this.name = name;
	}
		public void setDesc(String desc){
		this.desc = desc;
	}
		public void setCreatedTime(Date createdTime){
		this.createdTime = createdTime;
	}
		public void setBeginTime(Date beginTime){
		this.beginTime = beginTime;
	}
		public void setEndTime(Date endTime){
		this.endTime = endTime;
	}
		public void setStatus(String status){
		this.status = status;
	}
		public void setShopId(int shopId){
		this.shopId = shopId;
	}
		public void setSellerId(String sellerId){
		this.sellerId = sellerId;
	}
		public void setType(String type){
		this.type = type;
	}
		public void setContent(String content){
		this.content = content;
	}
		public void setCategoryIds(String categoryIds){
		this.categoryIds = categoryIds;
	}
		public void setPic(String pic){
		this.pic = pic;
	}
		public void setModifyTime(Date modifyTime){
		this.modifyTime = modifyTime;
	}
		public void setModifier(String modifier){
		this.modifier = modifier;
	}
		
}