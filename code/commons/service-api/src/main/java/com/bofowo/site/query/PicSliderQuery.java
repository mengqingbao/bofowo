package com.bofowo.site.query;

import com.common.page.QueryBase;
import java.io.Serializable;

public class PicSliderQuery extends QueryBase implements Serializable {

	private String sellerId;
	private String status;
	private String shopId;
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getShopId() {
		return shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	
	
	
}
