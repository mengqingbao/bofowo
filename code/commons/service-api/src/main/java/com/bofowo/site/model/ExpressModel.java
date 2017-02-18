package com.bofowo.site.model;

import java.io.Serializable;
import java.util.Date;

public class ExpressModel implements Serializable{

		private int id;
		private String expCompany;
		private String fId;
		private String type;
		private String sellerId;
		private String buyerId;
		private String content;
		private String status;
		private Date modifiedTime;
		
		public int getId(){
		return id;
	}
		public String getExpCompany(){
		return expCompany;
	}
		public String getFId(){
		return fId;
	}
		public String getType(){
		return type;
	}
		public String getSellerId(){
		return sellerId;
	}
		public String getBuyerId(){
		return buyerId;
	}
		public String getContent(){
		return content;
	}
		public String getStatus(){
		return status;
	}
		public Date getModifiedTime(){
		return modifiedTime;
	}
		
		public void setId(int id){
		this.id = id;
	}
		public void setExpCompany(String expCompany){
		this.expCompany = expCompany;
	}
		public void setFId(String fId){
		this.fId = fId;
	}
		public void setType(String type){
		this.type = type;
	}
		public void setSellerId(String sellerId){
		this.sellerId = sellerId;
	}
		public void setBuyerId(String buyerId){
		this.buyerId = buyerId;
	}
		public void setContent(String content){
		this.content = content;
	}
		public void setStatus(String status){
		this.status = status;
	}
		public void setModifiedTime(Date modifiedTime){
		this.modifiedTime = modifiedTime;
	}
		
}