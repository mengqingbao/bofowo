package com.bofowo.site.model;

import java.io.Serializable;
import java.util.Date;

public class SellerInfoModel implements Serializable{

		private int id;
		private String name;
		private String idCard;
		private String idCardPic;
		private int deposit;
		private String type;
		private String status;
		private Date createdDate;
		private String creator;
		private String userId;
		private String shoperName;
		private String companyCert;
		private String proxyCert;
		private String fistProxyCert;
		
		public int getId(){
		return id;
	}
		public String getName(){
		return name;
	}
		public String getIdCard(){
		return idCard;
	}
		public String getIdCardPic(){
		return idCardPic;
	}
		public int getDeposit(){
		return deposit;
	}
		public String getType(){
		return type;
	}
		public String getStatus(){
		return status;
	}
		public Date getCreatedDate(){
		return createdDate;
	}
		public String getCreator(){
		return creator;
	}
		public String getUserId(){
		return userId;
	}
		public String getShoperName(){
		return shoperName;
	}
		public String getCompanyCert(){
		return companyCert;
	}
		public String getProxyCert(){
		return proxyCert;
	}
		public String getFistProxyCert(){
		return fistProxyCert;
	}
		
		public void setId(int id){
		this.id = id;
	}
		public void setName(String name){
		this.name = name;
	}
		public void setIdCard(String idCard){
		this.idCard = idCard;
	}
		public void setIdCardPic(String idCardPic){
		this.idCardPic = idCardPic;
	}
		public void setDeposit(int deposit){
		this.deposit = deposit;
	}
		public void setType(String type){
		this.type = type;
	}
		public void setStatus(String status){
		this.status = status;
	}
		public void setCreatedDate(Date createdDate){
		this.createdDate = createdDate;
	}
		public void setCreator(String creator){
		this.creator = creator;
	}
		public void setUserId(String userId){
		this.userId = userId;
	}
		public void setShoperName(String shoperName){
		this.shoperName = shoperName;
	}
		public void setCompanyCert(String companyCert){
		this.companyCert = companyCert;
	}
		public void setProxyCert(String proxyCert){
		this.proxyCert = proxyCert;
	}
		public void setFistProxyCert(String fistProxyCert){
		this.fistProxyCert = fistProxyCert;
	}
		
}