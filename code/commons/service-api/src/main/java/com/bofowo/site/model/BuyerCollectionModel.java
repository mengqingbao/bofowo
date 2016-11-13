package com.bofowo.site.model;

import java.io.Serializable;
import java.util.Date;

public class BuyerCollectionModel implements Serializable{

		private int id;
		private int itemId;
		private String title;
		private String image;
		private String buyerId;
		private String sellerId;
		private String shopId;
		private String shopName;
		private String type;
		private Date createdTime;
		private String tBuyerCollectioncol;
		private String isDelete;
		
		public int getId(){
		return id;
	}
		public int getItemId(){
		return itemId;
	}
		public String getTitle(){
		return title;
	}
		public String getImage(){
		return image;
	}
		public String getBuyerId(){
		return buyerId;
	}
		public String getSellerId(){
		return sellerId;
	}
		public String getShopId(){
		return shopId;
	}
		public String getShopName(){
		return shopName;
	}
		public String getType(){
		return type;
	}
		public Date getCreatedTime(){
		return createdTime;
	}
		public String getTBuyerCollectioncol(){
		return tBuyerCollectioncol;
	}
		public String getIsDelete(){
		return isDelete;
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
		public void setImage(String image){
		this.image = image;
	}
		public void setBuyerId(String buyerId){
		this.buyerId = buyerId;
	}
		public void setSellerId(String sellerId){
		this.sellerId = sellerId;
	}
		public void setShopId(String shopId){
		this.shopId = shopId;
	}
		public void setShopName(String shopName){
		this.shopName = shopName;
	}
		public void setType(String type){
		this.type = type;
	}
		public void setCreatedTime(Date createdTime){
		this.createdTime = createdTime;
	}
		public void setTBuyerCollectioncol(String tBuyerCollectioncol){
		this.tBuyerCollectioncol = tBuyerCollectioncol;
	}
		public void setIsDelete(String isDelete){
		this.isDelete = isDelete;
	}
		
}