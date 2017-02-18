package com.bofowo.site.query;

import com.common.page.QueryBase;
import java.io.Serializable;

public class BuyerCollectionQuery extends QueryBase implements Serializable {
	private String sellerId;
	private String buyerId;
	private String type;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
