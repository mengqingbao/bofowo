package com.bofowo.site.query;

import com.common.page.QueryBase;
import java.io.Serializable;

public class ShopCategoryQuery extends QueryBase implements Serializable {
private String sellerId;

private String shopId;

public String getSellerId() {
	return sellerId;
}

public void setSellerId(String sellerId) {
	this.sellerId = sellerId;
}

public String getShopId() {
	return shopId;
}

public void setShopId(String shopId) {
	this.shopId = shopId;
}


	
}
