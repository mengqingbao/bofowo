package com.bofowo.site.model;

import java.io.Serializable;
import java.util.Date;

public class AuctionManageMentModel implements Serializable{
	
	 
	 	 	private int id;
	 	 	private int auctionId;
	 	 	private String auctionTypeId;
	 	 	private int status;
	 	 	private Date createTime;
	 	 	private int orderId;
	 
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
	
	

	
	
		public void setStatus(int status){
		this.status=status;
		}
	
	
	    public int getStatus(){
          return status;
	    }
	
	
			public void setCreateTime(Date createTime){
			this.createTime=createTime;
		}
	
	
	    public Date getCreateTime(){
          return createTime;
	    }
	
	
			public void setOrderId(int orderId){
			this.orderId=orderId;
		}
	
	
	    public int getOrderId(){
          return orderId;
	    }


		public String getAuctionTypeId() {
			return auctionTypeId;
		}


		public void setAuctionTypeId(String auctionTypeId) {
			this.auctionTypeId = auctionTypeId;
		}
	
	
	
		
}