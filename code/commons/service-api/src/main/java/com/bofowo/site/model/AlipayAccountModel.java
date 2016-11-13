package com.bofowo.site.model;

import java.io.Serializable;
import java.util.Date;

public class AlipayAccountModel implements Serializable{

		private int id;
		private String sellerId;
		private String aliPayAccount;
		private Date createTime;
		private Date modifyTime;
		private String status;
		
		public int getId(){
		return id;
	}
		public String getSellerId(){
		return sellerId;
	}
		public String getAliPayAccount(){
		return aliPayAccount;
	}
		public Date getCreateTime(){
		return createTime;
	}
		public Date getModifyTime(){
		return modifyTime;
	}
		public String getStatus(){
		return status;
	}
		
		public void setId(int id){
		this.id = id;
	}
		public void setSellerId(String sellerId){
		this.sellerId = sellerId;
	}
		public void setAliPayAccount(String aliPayAccount){
		this.aliPayAccount = aliPayAccount;
	}
		public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}
		public void setModifyTime(Date modifyTime){
		this.modifyTime = modifyTime;
	}
		public void setStatus(String status){
		this.status = status;
	}
		
}