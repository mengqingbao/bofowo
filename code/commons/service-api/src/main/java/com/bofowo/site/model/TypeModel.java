package com.bofowo.site.model;

import java.io.Serializable;

public class TypeModel implements Serializable{

		private int id;
		private String name;
		private String order;
		private String desc;
		private String status;
		private String isDelete;
		
		public int getId(){
		return id;
	}
		public String getName(){
		return name;
	}
		public String getOrder(){
		return order;
	}
		public String getDesc(){
		return desc;
	}
		public String getStatus(){
		return status;
	}
		public String getIsDelete(){
		return isDelete;
	}
		
		public void setId(int id){
		this.id = id;
	}
		public void setName(String name){
		this.name = name;
	}
		public void setOrder(String order){
		this.order = order;
	}
		public void setDesc(String desc){
		this.desc = desc;
	}
		public void setStatus(String status){
		this.status = status;
	}
		public void setIsDelete(String isDelete){
		this.isDelete = isDelete;
	}
		
}