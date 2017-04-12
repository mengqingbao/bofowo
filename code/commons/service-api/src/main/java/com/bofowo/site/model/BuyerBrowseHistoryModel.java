package com.bofowo.site.model;

import java.io.Serializable;
import java.util.Date;

public class BuyerBrowseHistoryModel implements Serializable{

		private int pid;
		private Date createdDate;
		private String buyerId;
		private int times;
		private Date lastVisitDate;
		
		public int getPid(){
		return pid;
	}
		public Date getCreatedDate(){
		return createdDate;
	}
		public String getBuyerId(){
		return buyerId;
	}
		public int getTimes(){
		return times;
	}
		public Date getLastVisitDate(){
		return lastVisitDate;
	}
		
		public void setPid(int pid){
		this.pid = pid;
	}
		public void setCreatedDate(Date createdDate){
		this.createdDate = createdDate;
	}
		public void setBuyerId(String buyerId){
		this.buyerId = buyerId;
	}
		public void setTimes(int times){
		this.times = times;
	}
		public void setLastVisitDate(Date lastVisitDate){
		this.lastVisitDate = lastVisitDate;
	}
		
}