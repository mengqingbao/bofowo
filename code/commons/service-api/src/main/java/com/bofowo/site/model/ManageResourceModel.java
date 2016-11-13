package com.bofowo.site.model;

import java.io.Serializable;
import java.util.Date;

public class ManageResourceModel implements Serializable{

		/**
	 * 
	 */
	private static final long serialVersionUID = -3880328433370054217L;
		private int id;
		private String name;
		private String content;
		private String type;
		private String status;
		private Date createDate;
		private String creator;
		private int parentId;
		
		public int getId(){
		return id;
	}
		public String getName(){
		return name;
	}
		public String getContent(){
		return content;
	}
		public String getType(){
		return type;
	}
		public String getStatus(){
		return status;
	}
		public Date getCreateDate(){
		return createDate;
	}
		public String getCreator(){
		return creator;
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
		public void setType(String type){
		this.type = type;
	}
		public void setStatus(String status){
		this.status = status;
	}
		public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}
		public void setCreator(String creator){
		this.creator = creator;
	}
		public int getParentId() {
			return parentId;
		}
		public void setParentId(int parentId) {
			this.parentId = parentId;
		}
		
}