package com.bofowo.site.model;

import java.io.Serializable;

public class PicSliderModel implements Serializable{

		private int id;
		private String title;
		private String pic;
		private String sellerId;
		private String shopId;
		private String url;
		private String desc;
		private String status;
		
		public int getId(){
		return id;
	}
		public String getTitle(){
		return title;
	}
		public String getPic(){
		return pic;
	}
		public String getSellerId(){
		return sellerId;
	}
		public String getShopId(){
		return shopId;
	}
		public String getUrl(){
		return url;
	}
		public String getDesc(){
		return desc;
	}
		public String getStatus(){
		return status;
	}
		
		public void setId(int id){
		this.id = id;
	}
		public void setTitle(String title){
		this.title = title;
	}
		public void setPic(String pic){
		this.pic = pic;
	}
		public void setSellerId(String sellerId){
		this.sellerId = sellerId;
	}
		public void setShopId(String shopId){
		this.shopId = shopId;
	}
		public void setUrl(String url){
		this.url = url;
	}
		public void setDesc(String desc){
		this.desc = desc;
	}
		public void setStatus(String status){
		this.status = status;
	}
		
}