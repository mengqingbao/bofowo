package com.bofowo.site.query;

import com.common.page.QueryBase;
import java.io.Serializable;

public class CustomerServiceQuery extends QueryBase implements Serializable {
	private String type;
	
	private String buyerId;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}
	
	
	
}
