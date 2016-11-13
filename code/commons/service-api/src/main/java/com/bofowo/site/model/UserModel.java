package com.bofowo.site.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class UserModel implements Serializable{

		private int id; //id
		private String userName;  //用户名,使用手机号,同时也作为登陆账号
		private String nickName;  //用户昵称
		private String realName;  //真实姓名
		private String idCardNum;  //身份证号码
		private String password;  //密码，用户的登录密码
		private String email;  //用户邮箱
		private String userImg;  //用户头像
		private String channel;  //注册渠道
		private Date creatDate;  //用户的创建日期
		private String status;	//账户状态
		private String address;
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
		public String getNickName() {
			return nickName;
		}
		public void setNickName(String nickName) {
			this.nickName = nickName;
		}
		public String getRealName() {
			return realName;
		}
		public void setRealName(String realName) {
			this.realName = realName;
		}
		public String getIdCardNum() {
			return idCardNum;
		}
		public void setIdCardNum(String idCardNum) {
			this.idCardNum = idCardNum;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getUserImg() {
			return userImg;
		}
		public void setUserImg(String userImg) {
			this.userImg = userImg;
		}
		public String getChannel() {
			return channel;
		}
		public void setChannel(String channel) {
			this.channel = channel;
		}
		public Date getCreatDate() {
			return creatDate;
		}
		public void setCreatDate(Date creatDate) {
			this.creatDate = creatDate;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		
		
}