package com.bofowo.site.model;

import java.io.Serializable;
import java.util.Date;

public class OrderDetailsModel implements Serializable{
	
	 
	 	 	private int id;
	 	 	private String orderNumber;
	 	 	private String commodityNumber;
	 	 	private int commodityQuantity;
	 	 	private Double commodityPrice;
	 	 	private Date createTime;
	 
			public void setId(int id){
			this.id=id;
		}
	
	
	    public int getId(){
          return id;
	    }
	
	
			public void setCommodityNumber(String commodityNumber){
			this.commodityNumber=commodityNumber;
		}
	
	
	    public String getCommodityNumber(){
          return commodityNumber;
	    }
	
	
			public void setCommodityQuantity(int commodityQuantity){
			this.commodityQuantity=commodityQuantity;
		}
	
	
	    public int getCommodityQuantity(){
          return commodityQuantity;
	    }
	
	
			public void setCreateTime(Date createTime){
			this.createTime=createTime;
		}
	
	
	    public Date getCreateTime(){
          return createTime;
	    }


		public Double getCommodityPrice() {
			return commodityPrice;
		}


		public void setCommodityPrice(Double commodityPrice) {
			this.commodityPrice = commodityPrice;
		}


		public String getOrderNumber() {
			return orderNumber;
		}


		public void setOrderNumber(String orderNumber) {
			this.orderNumber = orderNumber;
		}


		
	
		
}