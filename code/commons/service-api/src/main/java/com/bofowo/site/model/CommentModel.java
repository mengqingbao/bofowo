package com.bofowo.site.model;

import java.io.Serializable;
import java.util.Date;

public class CommentModel implements Serializable{

		private int id;
		private String buyerId;
		private String orderId;
		private int serviceRate;
		private int itemRate;
		private int postRate;
		private String comment;
		private Date createdTime;
		private String tOrderComment;
		private Date modifiedTime;
		private String status;
		private String shopId;
		private String sellerId;
		private String exComment;
		private int exServiceRate;
		private int exItemRate;
		private int exPost;
		private int tradeId;
		private int itemId;
		
		public int getId(){
		return id;
	}
		public String getBuyerId(){
		return buyerId;
	}
		public String getOrderId(){
		return orderId;
	}
		public int getServiceRate(){
		return serviceRate;
	}
		public int getItemRate(){
		return itemRate;
	}
		public int getPostRate(){
		return postRate;
	}
		public String getComment(){
		return comment;
	}
		public Date getCreatedTime(){
		return createdTime;
	}
		public String getTOrderComment(){
		return tOrderComment;
	}
		public Date getModifiedTime(){
		return modifiedTime;
	}
		public String getStatus(){
		return status;
	}
		public String getShopId(){
		return shopId;
	}
		public String getSellerId(){
		return sellerId;
	}
		public String getExComment(){
		return exComment;
	}
		public int getExServiceRate(){
		return exServiceRate;
	}
		public int getExItemRate(){
		return exItemRate;
	}
		public int getExPost(){
		return exPost;
	}
		public int getTradeId(){
		return tradeId;
	}
		
		public void setId(int id){
		this.id = id;
	}
		public void setBuyerId(String buyerId){
		this.buyerId = buyerId;
	}
		public void setOrderId(String orderId){
		this.orderId = orderId;
	}
		public void setServiceRate(int serviceRate){
		this.serviceRate = serviceRate;
	}
		public void setItemRate(int itemRate){
		this.itemRate = itemRate;
	}
		public void setPostRate(int postRate){
		this.postRate = postRate;
	}
		public void setComment(String comment){
		this.comment = comment;
	}
		public void setCreatedTime(Date createdTime){
		this.createdTime = createdTime;
	}
		public void setTOrderComment(String tOrderComment){
		this.tOrderComment = tOrderComment;
	}
		public void setModifiedTime(Date modifiedTime){
		this.modifiedTime = modifiedTime;
	}
		public void setStatus(String status){
		this.status = status;
	}
		public void setShopId(String shopId){
		this.shopId = shopId;
	}
		public void setSellerId(String sellerId){
		this.sellerId = sellerId;
	}
		public void setExComment(String exComment){
		this.exComment = exComment;
	}
		public void setExServiceRate(int exServiceRate){
		this.exServiceRate = exServiceRate;
	}
		public void setExItemRate(int exItemRate){
		this.exItemRate = exItemRate;
	}
		public void setExPost(int exPost){
		this.exPost = exPost;
	}
		public void setTradeId(int tradeId){
		this.tradeId = tradeId;
	}
		public String gettOrderComment() {
			return tOrderComment;
		}
		public void settOrderComment(String tOrderComment) {
			this.tOrderComment = tOrderComment;
		}
		public int getItemId() {
			return itemId;
		}
		public void setItemId(int itemId) {
			this.itemId = itemId;
		}
		
}