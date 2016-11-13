package com.bofowo.site.model;

import java.io.Serializable;
import java.util.Date;

public class CategoryModel implements Serializable{

		private int id;
		private int pid;
		private String name;
		private String status;
		private Date createdDate;
		private String creator;
		private String isDelete;
		private String type;
		private String desc;
		
		public int getId(){
		return id;
	}
		public int getPid(){
		return pid;
	}
		public String getName(){
		return name;
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
		public String getIsDelete(){
		return isDelete;
	}
		public String getType(){
		return type;
	}
		public String getDesc(){
		return desc;
	}
		
		public void setId(int id){
		this.id = id;
	}
		public void setPid(int pid){
		this.pid = pid;
	}
		public void setName(String name){
		this.name = name;
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
		public void setIsDelete(String isDelete){
		this.isDelete = isDelete;
	}
		public void setType(String type){
		this.type = type;
	}
		public void setDesc(String desc){
		this.desc = desc;
	}
		
}