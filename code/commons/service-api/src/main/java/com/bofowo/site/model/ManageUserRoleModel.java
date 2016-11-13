package com.bofowo.site.model;

import java.io.Serializable;

public class ManageUserRoleModel implements Serializable{

		private String userName;
		private int roleId;
		
		public String getUserName(){
		return userName;
	}
		public int getRoleId(){
		return roleId;
	}
		
		public void setUserName(String userName){
		this.userName = userName;
	}
		public void setRoleId(int roleId){
		this.roleId = roleId;
	}
		
}