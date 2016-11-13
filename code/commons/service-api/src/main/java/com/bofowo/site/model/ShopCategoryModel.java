package com.bofowo.site.model;

import java.io.Serializable;
import java.util.Date;

public class ShopCategoryModel implements Serializable{

		private int id;
		private String name;
		private String image;
		private String desc;
		private String creator;
		private Date createdTime;
		private String checker;
		private Date checkedTime;
		private String modifier;
		private Date modifiedTime;
		private String status;
		private String type;
		private String content;
		private String sellerId;
		private int shopId;
		
		public int getId(){
		return id;
	}
		public String getName(){
		return name;
	}
		public String getImage(){
		return image;
	}
		public String getDesc(){
		return desc;
	}
		public String getCreator(){
		return creator;
	}
		public Date getCreatedTime(){
		return createdTime;
	}
		public String getChecker(){
		return checker;
	}
		public Date getCheckedTime(){
		return checkedTime;
	}
		public String getModifier(){
		return modifier;
	}
		public Date getModifiedTime(){
		return modifiedTime;
	}
		public String getStatus(){
		return status;
	}
		public String getType(){
		return type;
	}
		public String getContent(){
		return content;
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
		public void setName(String name){
		this.name = name;
	}
		public void setImage(String image){
		this.image = image;
	}
		public void setDesc(String desc){
		this.desc = desc;
	}
		public void setCreator(String creator){
		this.creator = creator;
	}
		public void setCreatedTime(Date createdTime){
		this.createdTime = createdTime;
	}
		public void setChecker(String checker){
		this.checker = checker;
	}
		public void setCheckedTime(Date checkedTime){
		this.checkedTime = checkedTime;
	}
		public void setModifier(String modifier){
		this.modifier = modifier;
	}
		public void setModifiedTime(Date modifiedTime){
		this.modifiedTime = modifiedTime;
	}
		public void setStatus(String status){
		this.status = status;
	}
		public void setType(String type){
		this.type = type;
	}
		public void setContent(String content){
		this.content = content;
	}
		public void setSellerId(String sellerId){
		this.sellerId = sellerId;
	}
		public void setShopId(int shopId){
		this.shopId = shopId;
	}
		
}