package com.bofowo.site.query;

import com.common.page.QueryBase;
import java.io.Serializable;

public class CommentQuery extends QueryBase implements Serializable {

	private String sellerId;
	
	private String buyerId;

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}
	
	
	
}
