package com.bofowo.site.model;

import java.io.Serializable;
import java.util.Date;

public class SendsmsModel implements Serializable{

		private int id;
		private Date sendDate;
		private String sendMobile;
		private String smsContent;
		private String type;
		private String userName;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public Date getSendDate() {
			return sendDate;
		}
		public void setSendDate(Date sendDate) {
			this.sendDate = sendDate;
		}
		public String getSendMobile() {
			return sendMobile;
		}
		public void setSendMobile(String sendMobile) {
			this.sendMobile = sendMobile;
		}
		public String getSmsContent() {
			return smsContent;
		}
		public void setSmsContent(String smsContent) {
			this.smsContent = smsContent;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
}