package com.bofowo.site.model;

import java.io.Serializable;
import java.util.Date;

public class TradeConsoleModel implements Serializable{

		private int id;
		private String askerId;
		private String answerId;
		private String type;
		private String conten;
		private Date createTime;
		private String pid;
		private String status;
		
		public int getId(){
		return id;
	}
		public String getAskerId(){
		return askerId;
	}
		public String getAnswerId(){
		return answerId;
	}
		public String getType(){
		return type;
	}
		public String getConten(){
		return conten;
	}
		public Date getCreateTime(){
		return createTime;
	}
		public String getPid(){
		return pid;
	}
		public String getStatus(){
		return status;
	}
		
		public void setId(int id){
		this.id = id;
	}
		public void setAskerId(String askerId){
		this.askerId = askerId;
	}
		public void setAnswerId(String answerId){
		this.answerId = answerId;
	}
		public void setType(String type){
		this.type = type;
	}
		public void setConten(String conten){
		this.conten = conten;
	}
		public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}
		public void setPid(String pid){
		this.pid = pid;
	}
		public void setStatus(String status){
		this.status = status;
	}
		
}