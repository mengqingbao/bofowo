package com.bofowo.site.query;

import com.common.page.QueryBase;

import java.io.Serializable;

public class TaglibQuery extends QueryBase implements Serializable {

	private String type;
	private String status;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


	
}
