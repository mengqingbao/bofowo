package com.bofowo.site.model;

import java.io.Serializable;

public class BuyerAddressModel implements Serializable{

		private int id;
		private String buyerId;
		private String province;
		private String city;
		private String area;
		private String address;
		private String postCode;
		private String realName;
		private String mobile;
		private String tele;
		private String isDefault;
		private String isDelete;
		
		public int getId(){
		return id;
	}
		public String getBuyerId(){
		return buyerId;
	}
		public String getProvince(){
		return province;
	}
		public String getCity(){
		return city;
	}
		public String getArea(){
		return area;
	}
		public String getAddress(){
		return address;
	}
		public String getPostCode(){
		return postCode;
	}
		public String getRealName(){
		return realName;
	}
		public String getMobile(){
		return mobile;
	}
		public String getTele(){
		return tele;
	}
		public String getIsDefault(){
		return isDefault;
	}
		public String getIsDelete(){
		return isDelete;
	}
		
		public void setId(int id){
		this.id = id;
	}
		public void setBuyerId(String buyerId){
		this.buyerId = buyerId;
	}
		public void setProvince(String province){
		this.province = province;
	}
		public void setCity(String city){
		this.city = city;
	}
		public void setArea(String area){
		this.area = area;
	}
		public void setAddress(String address){
		this.address = address;
	}
		public void setPostCode(String postCode){
		this.postCode = postCode;
	}
		public void setRealName(String realName){
		this.realName = realName;
	}
		public void setMobile(String mobile){
		this.mobile = mobile;
	}
		public void setTele(String tele){
		this.tele = tele;
	}
		public void setIsDefault(String isDefault){
		this.isDefault = isDefault;
	}
		public void setIsDelete(String isDelete){
		this.isDelete = isDelete;
	}
		
}