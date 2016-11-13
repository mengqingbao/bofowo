package com.bofowo.site.model;

import java.io.Serializable;
import java.util.Date;

public class AuctionTypeModel implements Serializable{
	
	 
	 	 	private int id;
	 	 	private String className;
	 	 	private int quantityLimitation;
	 	 	private String auctionTypeId;
	 
			public void setId(int id){
			this.id=id;
		}
	
	
	    public int getId(){
          return id;
	    }
	
	
			public void setClassName(String className){
			this.className=className;
		}
	
	
	    public String getClassName(){
          return className;
	    }
	
	
			public void setQuantityLimitation(int quantityLimitation){
			this.quantityLimitation=quantityLimitation;
		}
	
	
	    public int getQuantityLimitation(){
          return quantityLimitation;
	    }


		public String getAuctionTypeId() {
			return auctionTypeId;
		}


		public void setAuctionTypeId(String auctionTypeId) {
			this.auctionTypeId = auctionTypeId;
		}
		
}