package com.bofowo.site.model;

import java.io.Serializable;

public class ProducchannelModel implements Serializable{

		private int id;
		private String channel;
		private int productId;
		private int shopId;
		private String sellerId;
		
		public int getId(){
		return id;
	}
		public String getChannel(){
		return channel;
	}
		public int getProductId(){
		return productId;
	}
		public int getShopId(){
		return shopId;
	}
		public String getSellerId(){
		return sellerId;
	}
		
		public void setId(int id){
		this.id = id;
	}
		public void setChannel(String channel){
		this.channel = channel;
	}
		public void setProductId(int productId){
		this.productId = productId;
	}
		public void setShopId(int shopId){
		this.shopId = shopId;
	}
		public void setSellerId(String sellerId){
		this.sellerId = sellerId;
	}
		
}