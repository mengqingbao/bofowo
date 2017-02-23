package com.bofowo.site.model;

import java.io.Serializable;


public class ShopCategoryPropModel implements Serializable {

	private int id;
	private int categoryId;
	private String name;
	private String sellerId;
	private int shopId;
	private String type;
	private String inputType;
	private String inputOption;
	private String status;

	public int getId() {
		return id;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public String getName() {
		return name;
	}

	public String getSellerId() {
		return sellerId;
	}

	public int getShopId() {
		return shopId;
	}

	public String getType() {
		return type;
	}

	public String getInputType() {
		return inputType;
	}

	public String getInputOption() {
		return inputOption;
	}

	public String getStatus() {
		return status;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setInputType(String inputType) {
		this.inputType = inputType;
	}

	public void setInputOption(String inputOption) {
		this.inputOption = inputOption;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String[] getOptions() {
		if (inputOption != null && !"".equals(inputOption)) {
			return inputOption.split(";");
		}
		return null;
	}

}