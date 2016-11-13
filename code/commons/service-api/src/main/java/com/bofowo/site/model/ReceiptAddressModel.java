package com.bofowo.site.model;

import java.io.Serializable;
import java.util.Date;

public class ReceiptAddressModel implements Serializable{
	
	 
	 	 	private int id;
	 	 	private String userName;
	 	 	private String province;
	 	 	private String city;
	 	 	private String area;
	 	 	private String address;
	 	 	private String phoneNumber;
	 	 	private String receiver;
	 	 	private int status;
	 	 	private String fixedTel;
	 	 	private String email;
			public int getId() {
				return id;
			}
			public void setId(int id) {
				this.id = id;
			}
			public String getUserName() {
				return userName;
			}
			public void setUserName(String userName) {
				this.userName = userName;
			}
			public String getProvince() {
				return province;
			}
			public void setProvince(String province) {
				this.province = province;
			}
			public String getCity() {
				return city;
			}
			public void setCity(String city) {
				this.city = city;
			}
			public String getArea() {
				return area;
			}
			public void setArea(String area) {
				this.area = area;
			}
			public String getAddress() {
				return address;
			}
			public void setAddress(String address) {
				this.address = address;
			}
			public String getPhoneNumber() {
				return phoneNumber;
			}
			public void setPhoneNumber(String phoneNumber) {
				this.phoneNumber = phoneNumber;
			}
			public String getReceiver() {
				return receiver;
			}
			public void setReceiver(String receiver) {
				this.receiver = receiver;
			}
			public int getStatus() {
				return status;
			}
			public void setStatus(int status) {
				this.status = status;
			}
			public String getFixedTel() {
				return fixedTel;
			}
			public void setFixedTel(String fixedTel) {
				this.fixedTel = fixedTel;
			}
			public String getEmail() {
				return email;
			}
			public void setEmail(String email) {
				this.email = email;
			}
	 	 	
	 

	
	
		
}