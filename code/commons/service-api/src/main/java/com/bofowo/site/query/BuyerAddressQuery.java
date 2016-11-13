package com.bofowo.site.query;

import com.common.page.QueryBase;
import java.io.Serializable;

public class BuyerAddressQuery extends QueryBase implements Serializable {
	private String buyerId;

	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	
	
	
}
