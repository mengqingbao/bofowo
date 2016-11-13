package com.bofowo.site.query;

import com.common.page.QueryBase;
import java.io.Serializable;

public class CarQuery extends QueryBase implements Serializable {
	private String BuyerId;

	public String getBuyerId() {
		return BuyerId;
	}

	public void setBuyerId(String buyerId) {
		BuyerId = buyerId;
	}
	
	
	
}
