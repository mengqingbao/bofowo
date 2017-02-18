package com.bofowo.site.query;

import com.common.page.QueryBase;
import java.io.Serializable;

public class TradeQuery extends QueryBase implements Serializable {
	private String sellerId;
	
	private String byerId;
	
	private String status;
	
	private String keyword;

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getByerId() {
		return byerId;
	}

	public void setByerId(String byerId) {
		this.byerId = byerId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	
	
}
