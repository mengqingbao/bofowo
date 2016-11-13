package com.bofowo.site.model;

import java.io.Serializable;

public class ProducstockModel implements Serializable{

		private int id;
		private int shopId;
		private String sellerId;
		private int itemId;
		private int propId;
		private String propName;
		private String propValue;
		private int stockNum;
		private int leftNum;
		private String image;
		private float price;
		private int specId;
		private String specName;
		private String specValue;
		
		public int getId(){
		return id;
	}
		public int getShopId(){
		return shopId;
	}
		public String getSellerId(){
		return sellerId;
	}
		public int getItemId(){
		return itemId;
	}
		public int getPropId(){
		return propId;
	}
		public String getPropName(){
		return propName;
	}
		public String getPropValue(){
		return propValue;
	}
		public int getStockNum(){
		return stockNum;
	}
		public int getLeftNum(){
		return leftNum;
	}
		public String getImage(){
		return image;
	}
		public float getPrice(){
		return price;
	}
		public int getSpecId(){
		return specId;
	}
		public String getSpecName(){
		return specName;
	}
		public String getSpecValue(){
		return specValue;
	}
		
		public void setId(int id){
		this.id = id;
	}
		public void setShopId(int shopId){
		this.shopId = shopId;
	}
		public void setSellerId(String sellerId){
		this.sellerId = sellerId;
	}
		public void setItemId(int itemId){
		this.itemId = itemId;
	}
		public void setPropId(int propId){
		this.propId = propId;
	}
		public void setPropName(String propName){
		this.propName = propName;
	}
		public void setPropValue(String propValue){
		this.propValue = propValue;
	}
		public void setStockNum(int stockNum){
		this.stockNum = stockNum;
	}
		public void setLeftNum(int leftNum){
		this.leftNum = leftNum;
	}
		public void setImage(String image){
		this.image = image;
	}
		public void setPrice(float price){
		this.price = price;
	}
		public void setSpecId(int specId){
		this.specId = specId;
	}
		public void setSpecName(String specName){
		this.specName = specName;
	}
		public void setSpecValue(String specValue){
		this.specValue = specValue;
	}
		
}