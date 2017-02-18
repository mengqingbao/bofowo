package com.bofowo.site.model;

import java.io.Serializable;
import java.util.Date;

public class CustomerServiceModel implements Serializable{

		private int id;
		private String buyerId;
		private String sellerId;
		private int tradeId;
		private int orderId;
		private String name;
		private String pic;
		private String price;
		private String question;
		private String replay;
		private String result;
		private String servicer;
		private String type;
		private int itemId;
		private Date createdTime;
		private Date replayTime;
		private Date endTime;
		private int shopId;
		private String shopName;
		private int repalyRate;
		private String status;
		private String expressCode;
		private String expressContent;
		
		public int getId(){
		return id;
	}
		public String getBuyerId(){
		return buyerId;
	}
		public String getSellerId(){
		return sellerId;
	}
		public int getTradeId(){
		return tradeId;
	}
		public int getOrderId(){
		return orderId;
	}
		public String getName(){
		return name;
	}
		public String getPic(){
		return pic;
	}
		public String getPrice(){
		return price;
	}
		public String getQuestion(){
		return question;
	}
		public String getReplay(){
		return replay;
	}
		public String getResult(){
		return result;
	}
		public String getServicer(){
		return servicer;
	}
		public String getType(){
		return type;
	}
		public int getItemId(){
		return itemId;
	}
		public Date getCreatedTime(){
		return createdTime;
	}
		public Date getReplayTime(){
		return replayTime;
	}
		public Date getEndTime(){
		return endTime;
	}
		public int getShopId(){
		return shopId;
	}
		public String getShopName(){
		return shopName;
	}
		public int getRepalyRate(){
		return repalyRate;
	}
		public String getStatus(){
		return status;
	}
		public String getExpressCode(){
		return expressCode;
	}
		public String getExpressContent(){
		return expressContent;
	}
		
		public void setId(int id){
		this.id = id;
	}
		public void setBuyerId(String buyerId){
		this.buyerId = buyerId;
	}
		public void setSellerId(String sellerId){
		this.sellerId = sellerId;
	}
		public void setTradeId(int tradeId){
		this.tradeId = tradeId;
	}
		public void setOrderId(int orderId){
		this.orderId = orderId;
	}
		public void setName(String name){
		this.name = name;
	}
		public void setPic(String pic){
		this.pic = pic;
	}
		public void setPrice(String price){
		this.price = price;
	}
		public void setQuestion(String question){
		this.question = question;
	}
		public void setReplay(String replay){
		this.replay = replay;
	}
		public void setResult(String result){
		this.result = result;
	}
		public void setServicer(String servicer){
		this.servicer = servicer;
	}
		public void setType(String type){
		this.type = type;
	}
		public void setItemId(int itemId){
		this.itemId = itemId;
	}
		public void setCreatedTime(Date createdTime){
		this.createdTime = createdTime;
	}
		public void setReplayTime(Date replayTime){
		this.replayTime = replayTime;
	}
		public void setEndTime(Date endTime){
		this.endTime = endTime;
	}
		public void setShopId(int shopId){
		this.shopId = shopId;
	}
		public void setShopName(String shopName){
		this.shopName = shopName;
	}
		public void setRepalyRate(int repalyRate){
		this.repalyRate = repalyRate;
	}
		public void setStatus(String status){
		this.status = status;
	}
		public void setExpressCode(String expressCode){
		this.expressCode = expressCode;
	}
		public void setExpressContent(String expressContent){
		this.expressContent = expressContent;
	}
		
}