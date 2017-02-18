package com.bofowo.site.query;

import com.common.page.QueryBase;
import java.io.Serializable;

public class ProducpropertiesQuery extends QueryBase implements Serializable {
	private String type;
	private Integer cateId;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getCateId() {
		return cateId;
	}

	public void setCateId(Integer cateId) {
		this.cateId = cateId;
	}
	

	
}
