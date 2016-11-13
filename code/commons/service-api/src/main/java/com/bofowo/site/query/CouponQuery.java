package com.bofowo.site.query;

import com.common.page.QueryBase;
import java.io.Serializable;

public class CouponQuery extends QueryBase implements Serializable {
	private String sellerId;
	private String type;
	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
