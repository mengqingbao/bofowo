package com.bofowo.site.query;

import com.common.page.QueryBase;
import java.io.Serializable;

public class ProductQuery extends QueryBase implements Serializable {
	private String type;
	private String tablie;
	private Integer shopId;
	private Integer cateId;
	private String keyWord;
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTablie() {
		return tablie;
	}

	public void setTablie(String tablie) {
		this.tablie = tablie;
	}

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public Integer getCateId() {
		return cateId;
	}

	public void setCateId(Integer cateId) {
		this.cateId = cateId;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}


	
	
}
