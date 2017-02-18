package com.bofowo.site.model;

import java.io.Serializable;
import java.util.Date;

public class ProductaglibModel implements Serializable{

		private int id;
		private int productId;
		private String taglib;
		private Date ableData;
		private int taglibId;
		private String type;
		private int order;
		private String status;
		private String sellerId;
		private int shopId;
		
		public int getId(){
		return id;
	}
		public int getProductId(){
		return productId;
	}
		public String getTaglib(){
		return taglib;
	}
		public Date getAbleData(){
		return ableData;
	}
		public int getTaglibId(){
		return taglibId;
	}
		public String getType(){
		return type;
	}
		public int getOrder(){
		return order;
	}
		public String getStatus(){
		return status;
	}
		public String getSellerId(){
		return sellerId;
	}
		public int getShopId(){
		return shopId;
	}
		
		public void setId(int id){
		this.id = id;
	}
		public void setProductId(int productId){
		this.productId = productId;
	}
		public void setTaglib(String taglib){
		this.taglib = taglib;
	}
		public void setAbleData(Date ableData){
		this.ableData = ableData;
	}
		public void setTaglibId(int taglibId){
		this.taglibId = taglibId;
	}
		public void setType(String type){
		this.type = type;
	}
		public void setOrder(int order){
		this.order = order;
	}
		public void setStatus(String status){
		this.status = status;
	}
		public void setSellerId(String sellerId){
		this.sellerId = sellerId;
	}
		public void setShopId(int shopId){
		this.shopId = shopId;
	}
		
}