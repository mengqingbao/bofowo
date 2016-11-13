package com.bofowo.site.model;

import java.io.Serializable;
import java.util.Date;

public class ThemeModel implements Serializable{

		private int id;
		private String name;
		private String content;
		private String status;
		private int level;
		private int price;
		private String sellerId;
		private String avatar;
		private String draw;
		private Date createTime;
		private Date modifyTime;
		
		public int getId(){
		return id;
	}
		public String getName(){
		return name;
	}
		public String getContent(){
		return content;
	}
		public String getStatus(){
		return status;
	}
		public int getLevel(){
		return level;
	}
		public int getPrice(){
		return price;
	}
		public String getSellerId(){
		return sellerId;
	}
		public String getAvatar(){
		return avatar;
	}
		public String getDraw(){
		return draw;
	}
		public Date getCreateTime(){
		return createTime;
	}
		public Date getModifyTime(){
		return modifyTime;
	}
		
		public void setId(int id){
		this.id = id;
	}
		public void setName(String name){
		this.name = name;
	}
		public void setContent(String content){
		this.content = content;
	}
		public void setStatus(String status){
		this.status = status;
	}
		public void setLevel(int level){
		this.level = level;
	}
		public void setPrice(int price){
		this.price = price;
	}
		public void setSellerId(String sellerId){
		this.sellerId = sellerId;
	}
		public void setAvatar(String avatar){
		this.avatar = avatar;
	}
		public void setDraw(String draw){
		this.draw = draw;
	}
		public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}
		public void setModifyTime(Date modifyTime){
		this.modifyTime = modifyTime;
	}
		
}