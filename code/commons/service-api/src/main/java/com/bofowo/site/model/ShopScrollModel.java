package com.bofowo.site.model;

import java.io.Serializable;
import java.util.Date;

public class ShopScrollModel implements Serializable{

		private int id;
		private String url;
		private String title;
		private String desc;
		private String pic;
		private String sellerId;
		private String status;
		private int shopId;
		private String pushIndex;
		private Date startDate;
		private Date endDate;
		
		public int getId(){
		return id;
	}
		public String getUrl(){
		return url;
	}
		public String getTitle(){
		return title;
	}
		public String getDesc(){
		return desc;
	}
		public String getPic(){
		return pic;
	}
		public String getSellerId(){
		return sellerId;
	}
		public String getStatus(){
		return status;
	}
		public int getShopId(){
		return shopId;
	}
		
		public void setId(int id){
		this.id = id;
	}
		public void setUrl(String url){
		this.url = url;
	}
		public void setTitle(String title){
		this.title = title;
	}
		public void setDesc(String desc){
		this.desc = desc;
	}
		public void setPic(String pic){
		this.pic = pic;
	}
		public void setSellerId(String sellerId){
		this.sellerId = sellerId;
	}
		public void setStatus(String status){
		this.status = status;
	}
		public void setShopId(int shopId){
		this.shopId = shopId;
	}
		public String getPushIndex() {
			return pushIndex;
		}
		public void setPushIndex(String pushIndex) {
			this.pushIndex = pushIndex;
		}
		public Date getStartDate() {
			return startDate;
		}
		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}
		public Date getEndDate() {
			return endDate;
		}
		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}
		
}