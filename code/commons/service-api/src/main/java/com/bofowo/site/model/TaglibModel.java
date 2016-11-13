package com.bofowo.site.model;

import java.io.Serializable;
import java.util.Date;

public class TaglibModel implements Serializable{

		private int id;
		private String name;
		private String type;
		private String status;
		private String isDelete;
		private Date createdDate;
		private Date modifiedDate;
		private String desc;
		private String sellerId;
		private String shopId;
		
		public int getId(){
		return id;
	}
		public String getName(){
		return name;
	}
		public String getType(){
		return type;
	}
		public String getStatus(){
		return status;
	}
		public String getIsDelete(){
		return isDelete;
	}
		public Date getCreatedDate(){
		return createdDate;
	}
		public Date getModifiedDate(){
		return modifiedDate;
	}
		public String getDesc(){
		return desc;
	}
		public String getSellerId(){
		return sellerId;
	}
		public String getShopId(){
		return shopId;
	}
		
		public void setId(int id){
		this.id = id;
	}
		public void setName(String name){
		this.name = name;
	}
		public void setType(String type){
		this.type = type;
	}
		public void setStatus(String status){
		this.status = status;
	}
		public void setIsDelete(String isDelete){
		this.isDelete = isDelete;
	}
		public void setCreatedDate(Date createdDate){
		this.createdDate = createdDate;
	}
		public void setModifiedDate(Date modifiedDate){
		this.modifiedDate = modifiedDate;
	}
		public void setDesc(String desc){
		this.desc = desc;
	}
		public void setSellerId(String sellerId){
		this.sellerId = sellerId;
	}
		public void setShopId(String shopId){
		this.shopId = shopId;
	}
		
}