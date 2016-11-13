package com.bofowo.site.query;

import com.common.page.QueryBase;
import java.io.Serializable;

public class ProductrademarkQuery extends QueryBase implements Serializable {

	private String sellerId;

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	
}
