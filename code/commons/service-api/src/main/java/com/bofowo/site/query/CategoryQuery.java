package com.bofowo.site.query;

import com.common.page.QueryBase;
import java.io.Serializable;

public class CategoryQuery extends QueryBase implements Serializable {
	private int pid;
	private String type;
	private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}
	
	
}
