package com.bofowo.site.model;

import java.io.Serializable;
import java.util.Date;

public class AuctionMarginModel implements Serializable{
	
	 
	 	 	private int id;
	 	 	private int auctionId;
	 	 	private String username;
	 	 	private double margin;
	 	 	private int status;
	 	 	private Date crossTime;
	 	 	private Date offTime;
	 
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
	
	
			public void setUsername(String username){
			this.username=username;
		}
	
	
	    public String getUsername(){
          return username;
	    }
	
	
			public void setCrossTime(Date crossTime){
			this.crossTime=crossTime;
		}
	
	
	    public Date getCrossTime(){
          return crossTime;
	    }
	
	
			public void setOffTime(Date offTime){
			this.offTime=offTime;
		}
	
	
	    public Date getOffTime(){
          return offTime;
	    }


		public double getMargin() {
			return margin;
		}


		public void setMargin(double margin) {
			this.margin = margin;
		}


		public int getStatus() {
			return status;
		}


		public void setStatus(int status) {
			this.status = status;
		}
	
	    
	
		
}