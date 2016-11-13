package com.bofowo.site.model;

import java.io.Serializable;

public class AccountModel implements Serializable{

		private int id;
		private String username;
		private String password;
		private int point;
		private String isSeller;
		private String status;
		private int level;
		private String avatar;
		private int score;
		private String wxUsername;
		private String alipayUsername;
		private String jdUsername;
		
		public int getId(){
		return id;
	}
		public String getUsername(){
		return username;
	}
		public String getPassword(){
		return password;
	}
		public int getPoint(){
		return point;
	}
		public String getIsSeller(){
		return isSeller;
	}
		public String getStatus(){
		return status;
	}
		public int getLevel(){
		return level;
	}
		public String getAvatar(){
		return avatar;
	}
		public int getScore(){
		return score;
	}
		public String getWxUsername(){
		return wxUsername;
	}
		public String getAlipayUsername(){
		return alipayUsername;
	}
		public String getJdUsername(){
		return jdUsername;
	}
		
		public void setId(int id){
		this.id = id;
	}
		public void setUsername(String username){
		this.username = username;
	}
		public void setPassword(String password){
		this.password = password;
	}
		public void setPoint(int point){
		this.point = point;
	}
		public void setIsSeller(String isSeller){
		this.isSeller = isSeller;
	}
		public void setStatus(String status){
		this.status = status;
	}
		public void setLevel(int level){
		this.level = level;
	}
		public void setAvatar(String avatar){
		this.avatar = avatar;
	}
		public void setScore(int score){
		this.score = score;
	}
		public void setWxUsername(String wxUsername){
		this.wxUsername = wxUsername;
	}
		public void setAlipayUsername(String alipayUsername){
		this.alipayUsername = alipayUsername;
	}
		public void setJdUsername(String jdUsername){
		this.jdUsername = jdUsername;
	}
		
}