package com.bofowo.site.query;

import com.common.page.QueryBase;

import java.io.Serializable;

public class ShopCategoryPropQuery extends QueryBase implements Serializable {
	private String type;
	private String shopCateId;
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getShopCateId() {
		return shopCateId;
	}

	public void setShopCateId(String shopCateId) {
		this.shopCateId = shopCateId;
	}
	
	
	
}
