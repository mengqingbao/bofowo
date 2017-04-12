package com.bofowo.site.query;

import com.common.page.QueryBase;
import java.io.Serializable;

public class ProductQuery extends QueryBase implements Serializable {
	private String type;
	private String tablie;
	private Integer shopId=0;
	private Integer cateId=0;
	private Integer shopCategoryId;
	private String keyWord;
	private Integer level=0;
	private String taglib;
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

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getShopCategoryId() {
		return shopCategoryId;
	}

	public void setShopCategoryId(Integer shopCategoryId) {
		this.shopCategoryId = shopCategoryId;
	}

	public String getTaglib() {
		return taglib;
	}

	public void setTaglib(String taglib) {
		this.taglib = taglib;
	}
}
