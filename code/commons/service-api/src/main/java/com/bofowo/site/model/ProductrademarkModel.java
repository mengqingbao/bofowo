package com.bofowo.site.model;

import java.io.Serializable;
import java.util.Date;

public class ProductrademarkModel implements Serializable{

		private int id;
		private String name;
		private String desc;
		private String logoImg;
		private Date modifyDate;
		private String creator;
		private int shopId;
		private String sellerId;
		private String tProductTrademar;
		private Date createdDate;
		private String status;
		
		public int getId(){
		return id;
	}
		public String getName(){
		return name;
	}
		public String getDesc(){
		return desc;
	}
		public String getLogoImg(){
		return logoImg;
	}
		public Date getModifyDate(){
		return modifyDate;
	}
		public String getCreator(){
		return creator;
	}
		public int getShopId(){
		return shopId;
	}
		public String getSellerId(){
		return sellerId;
	}
		public String getTProductTrademar(){
		return tProductTrademar;
	}
		public Date getCreatedDate(){
		return createdDate;
	}
		public String getStatus(){
		return status;
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
		public void setLogoImg(String logoImg){
		this.logoImg = logoImg;
	}
		public void setModifyDate(Date modifyDate){
		this.modifyDate = modifyDate;
	}
		public void setCreator(String creator){
		this.creator = creator;
	}
		public void setShopId(int shopId){
		this.shopId = shopId;
	}
		public void setSellerId(String sellerId){
		this.sellerId = sellerId;
	}
		public void setTProductTrademar(String tProductTrademar){
		this.tProductTrademar = tProductTrademar;
	}
		public void setCreatedDate(Date createdDate){
		this.createdDate = createdDate;
	}
		public void setStatus(String status){
		this.status = status;
	}
		
}