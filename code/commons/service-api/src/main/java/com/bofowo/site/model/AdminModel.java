
package com.bofowo.site.model;

import java.io.Serializable;
import java.util.Date;

/**
 * ClassName: AdminModel <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年3月8日 上午6:13:20 <br/>
 *
 * @author mqb
 * @version 
 * @since JDK 1.7
 */
public class AdminModel implements Serializable{

		/**
		 * id:TODO(用一句话描述这个变量表示什么).
		 * @since JDK 1.7
		 */
		private int id;
		private String adminusername;
		private String adminPasswd;
		private Date creatdate;
		private String adminmobile;
		private String adminemail;
		private String adminnick;
		private String adminrealname;
		private String status;
		private String remark;
		private int pointer;
		
		public int getId(){
		return id;
	}
		public String getAdminusername(){
		return adminusername;
	}
		public String getAdminPasswd(){
		return adminPasswd;
	}
		public Date getCreatdate(){
		return creatdate;
	}
		public String getAdminmobile(){
		return adminmobile;
	}
		public String getAdminemail(){
		return adminemail;
	}
		public String getAdminnick(){
		return adminnick;
	}
		public String getAdminrealname(){
		return adminrealname;
	}
		public String getStatus(){
		return status;
	}
		public String getRemark(){
		return remark;
	}
		
		public void setId(int id){
		this.id = id;
	}
		public void setAdminusername(String adminusername){
		this.adminusername = adminusername;
	}
		public void setAdminPasswd(String adminPasswd){
		this.adminPasswd = adminPasswd;
	}
		public void setCreatdate(Date creatdate){
		this.creatdate = creatdate;
	}
		public void setAdminmobile(String adminmobile){
		this.adminmobile = adminmobile;
	}
		public void setAdminemail(String adminemail){
		this.adminemail = adminemail;
	}
		public void setAdminnick(String adminnick){
		this.adminnick = adminnick;
	}
		public void setAdminrealname(String adminrealname){
		this.adminrealname = adminrealname;
	}
		public void setStatus(String status){
		this.status = status;
	}
		public void setRemark(String remark){
		this.remark = remark;
	}
		public int getPointer() {
			return pointer;
		}
		public void setPointer(int pointer) {
			this.pointer = pointer;
		}
		
	
}