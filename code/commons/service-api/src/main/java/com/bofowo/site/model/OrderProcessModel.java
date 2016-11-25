package com.bofowo.site.model;

import java.io.Serializable;
import java.util.Date;

public class OrderProcessModel implements Serializable{

		private int id;
		private int tid;
		private int oid;
		private String desc;
		private String status;
		private Date createdTime;
		private String statusId;
		
		public int getId(){
		return id;
	}
		public int getTid(){
		return tid;
	}
		public int getOid(){
		return oid;
	}
		public String getDesc(){
		return desc;
	}
		public String getStatus(){
		return status;
	}
		public Date getCreatedTime(){
		return createdTime;
	}
		public String getStatusId(){
		return statusId;
	}
		
		public void setId(int id){
		this.id = id;
	}
		public void setTid(int tid){
		this.tid = tid;
	}
		public void setOid(int oid){
		this.oid = oid;
	}
		public void setDesc(String desc){
		this.desc = desc;
	}
		public void setStatus(String status){
		this.status = status;
	}
		public void setCreatedTime(Date createdTime){
		this.createdTime = createdTime;
	}
		public void setStatusId(String statusId){
		this.statusId = statusId;
	}
		
}