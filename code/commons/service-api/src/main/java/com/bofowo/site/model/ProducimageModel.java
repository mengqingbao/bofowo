package com.bofowo.site.model;

import java.io.Serializable;
import java.util.Date;

public class ProducimageModel implements Serializable{

		private int id;
		private int itemId;
		private String path;
		private String status;
		private String sellerId;
		private Date createdDate;
		private int shopId;
		
		public int getId(){
		return id;
	}
		public int getItemId(){
		return itemId;
	}
		public String getPath(){
		return path;
	}
		public String getStatus(){
		return status;
	}
		public String getSellerId(){
		return sellerId;
	}
		public Date getCreatedDate(){
		return createdDate;
	}
		public int getShopId(){
		return shopId;
	}
		
		public void setId(int id){
		this.id = id;
	}
		public void setItemId(int itemId){
		this.itemId = itemId;
	}
		public void setPath(String path){
		this.path = path;
	}
		public void setStatus(String status){
		this.status = status;
	}
		public void setSellerId(String sellerId){
		this.sellerId = sellerId;
	}
		public void setCreatedDate(Date createdDate){
		this.createdDate = createdDate;
	}
		public void setShopId(int shopId){
		this.shopId = shopId;
	}
		
}