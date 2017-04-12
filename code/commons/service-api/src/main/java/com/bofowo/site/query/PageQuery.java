package com.bofowo.site.query;

import com.common.page.QueryBase;
import java.io.Serializable;

public class PageQuery extends QueryBase implements Serializable {
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
