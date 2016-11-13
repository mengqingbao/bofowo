package com.bofowo.site.model;

import java.io.Serializable;
import java.util.Date;

public class BidHistoryModel implements Serializable{
	
	 
	 	 	private int id;
	 	 	private int auctionId;
	 	 	private String userName;
	 	 	private float bidAmount;
	 	 	private String realName;
	 	 	private int status;
	 	 	private Date bidTime;
	 
			public void setId(int id){
			this.id=id;
		}
	
	
	    public int getId(){
          return id;
	    }
	
	
			public void setAuctionId(int auctionId){
			this.auctionId=auctionId;
		}
	
	
	    public int getAuctionId(){
          return auctionId;
	    }
	
	
			public void setUserName(String userName){
			this.userName=userName;
		}
	
	
	    public String getUserName(){
          return userName;
	    }
	
	
			public void setRealName(String realName){
			this.realName=realName;
		}
	
	
	    public String getRealName(){
          return realName;
	    }
	
	
			public void setBidTime(Date bidTime){
			this.bidTime=bidTime;
		}
	
	
	    public Date getBidTime(){
          return bidTime;
	    }


		public float getBidAmount() {
			return bidAmount;
		}


		public void setBidAmount(float bidAmount) {
			this.bidAmount = bidAmount;
		}


		public int getStatus() {
			return status;
		}


		public void setStatus(int status) {
			this.status = status;
		}
	
	    
	
		
}