package com.bofowo.site.model;

import java.io.Serializable;

public class ManageRoleResouceModel implements Serializable{

		/**
	 * 
	 */
	private static final long serialVersionUID = 1238613290293316822L;
		private int roleId;
		private int resourceId;
		
		public int getRoleId(){
		return roleId;
	}
		public int getResourceId(){
		return resourceId;
	}
		
		public void setRoleId(int roleId){
		this.roleId = roleId;
	}
		public void setResourceId(int resourceId){
		this.resourceId = resourceId;
	}
		
}