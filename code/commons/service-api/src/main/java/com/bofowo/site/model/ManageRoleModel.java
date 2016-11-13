package com.bofowo.site.model;

import java.io.Serializable;
import java.util.Date;

public class ManageRoleModel implements Serializable{

		/**
	 * 
	 */
	private static final long serialVersionUID = -2889491272873712422L;
		private int id;
		private String name;
		private String status;
		private String desc;
		private Date createDate;
		private String creator;
		
		public int getId(){
		return id;
	}
		public String getName(){
		return name;
	}
		public String getStatus(){
		return status;
	}
		public String getDesc(){
		return desc;
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
		public void setStatus(String status){
		this.status = status;
	}
		public void setDesc(String desc){
		this.desc = desc;
	}
		public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}
		public void setCreator(String creator){
		this.creator = creator;
	}
		
}