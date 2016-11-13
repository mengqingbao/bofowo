package com.bofowo.site.model;

import java.io.Serializable;
import java.util.Date;

public class CommodityManageMentModel implements Serializable{
	
	 
	 	 	private int id;
	 	 	private String commodityNumber;
	 	 	private String pageTypeId;
	 	 	private int status;
	 	 	private Date createTime;
	 	 	private String orderId;
	 
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
	

			public int getStatus() {
			return status;
		}


		public void setStatus(int status) {
			this.status = status;
		}


			public void setCreateTime(Date createTime){
			this.createTime=createTime;
		}
	
	
	    public Date getCreateTime(){
          return createTime;
	    }
	
	
			public void setOrderId(String orderId){
			this.orderId=orderId;
		}
	
	
	    public String getOrderId(){
          return orderId;
	    }


		public String getPageTypeId() {
			return pageTypeId;
		}


		public void setPageTypeId(String pageTypeId) {
			this.pageTypeId = pageTypeId;
		}
	
	
	
		
}