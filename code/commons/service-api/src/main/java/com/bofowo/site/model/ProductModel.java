package com.bofowo.site.model;

import java.io.Serializable;
import java.util.Date;

public class ProductModel implements Serializable{

		private int id;
		private String name;
		private int trademarkId;
		private float marketPrice;
		private float shopPrice;
		private String type;
		private String code;
		private String content;
		private int shopCategoryId;
		private String shopStatus;
		private String status;
		private String isRecommend;
		private String seoKey;
		private String seoContent;
		private String seoTitle;
		private String tiglib;
		private String plBenefit;
		private int order;
		private int categoryId;
		private int shopId;
		private String sellerId;
		private Date createdTime;
		private Date modifiedTime;
		private String modifier;
		private int num;
		private String images;
		private String categoryAId;
		private String categoryBId;
		private int soldNum;
		private String pcChannel;
		private String mChannel;
		private int postId;
		public int getId(){
		return id;
	}
		public String getName(){
		return name;
	}
		public int getTrademarkId(){
		return trademarkId;
	}
		public float getMarketPrice(){
		return marketPrice;
	}
		public float getShopPrice(){
		return shopPrice;
	}
		public String getType(){
		return type;
	}
		public String getCode(){
		return code;
	}
		public String getContent(){
		return content;
	}
		public int getShopCategoryId(){
		return shopCategoryId;
	}
		public String getShopStatus(){
		return shopStatus;
	}
		public String getStatus(){
		return status;
	}
		public String getIsRecommend(){
		return isRecommend;
	}
		public String getSeoKey(){
		return seoKey;
	}
		public String getSeoContent(){
		return seoContent;
	}
		public String getSeoTitle(){
		return seoTitle;
	}
		public String getTiglib(){
		return tiglib;
	}
		public String getPlBenefit(){
		return plBenefit;
	}
		public int getOrder(){
		return order;
	}
		public int getCategoryId(){
		return categoryId;
	}
		public int getShopId(){
		return shopId;
	}
		public String getSellerId(){
		return sellerId;
	}
		public Date getCreatedTime(){
		return createdTime;
	}
		public Date getModifiedTime(){
		return modifiedTime;
	}
		public String getModifier(){
		return modifier;
	}
		public int getNum(){
		return num;
	}
		public String getImages(){
		return images;
	}
		
		public void setId(int id){
		this.id = id;
	}
		public void setName(String name){
		this.name = name;
	}
		public void setTrademarkId(int trademarkId){
		this.trademarkId = trademarkId;
	}
		public void setMarketPrice(float marketPrice){
		this.marketPrice = marketPrice;
	}
		public void setShopPrice(float shopPrice){
		this.shopPrice = shopPrice;
	}
		public void setType(String type){
		this.type = type;
	}
		public void setCode(String code){
		this.code = code;
	}
		public void setContent(String content){
		this.content = content;
	}
		public void setShopCategoryId(int shopCategoryId){
		this.shopCategoryId = shopCategoryId;
	}
		public void setShopStatus(String shopStatus){
		this.shopStatus = shopStatus;
	}
		public void setStatus(String status){
		this.status = status;
	}
		public void setIsRecommend(String isRecommend){
		this.isRecommend = isRecommend;
	}
		public void setSeoKey(String seoKey){
		this.seoKey = seoKey;
	}
		public void setSeoContent(String seoContent){
		this.seoContent = seoContent;
	}
		public void setSeoTitle(String seoTitle){
		this.seoTitle = seoTitle;
	}
		public void setTiglib(String tiglib){
		this.tiglib = tiglib;
	}
		public void setPlBenefit(String plBenefit){
		this.plBenefit = plBenefit;
	}
		public void setOrder(int order){
		this.order = order;
	}
		public void setCategoryId(int categoryId){
		this.categoryId = categoryId;
	}
		public void setShopId(int shopId){
		this.shopId = shopId;
	}
		public void setSellerId(String sellerId){
		this.sellerId = sellerId;
	}
		public void setCreatedTime(Date createdTime){
		this.createdTime = createdTime;
	}
		public void setModifiedTime(Date modifiedTime){
		this.modifiedTime = modifiedTime;
	}
		public void setModifier(String modifier){
		this.modifier = modifier;
	}
		public void setNum(int num){
		this.num = num;
	}
		public void setImages(String images){
		this.images = images;
	}
		public String getCategoryAId() {
			return categoryAId;
		}
		public void setCategoryAId(String categoryAId) {
			this.categoryAId = categoryAId;
		}
		public String getCategoryBId() {
			return categoryBId;
		}
		public void setCategoryBId(String categoryBId) {
			this.categoryBId = categoryBId;
		}
		public int getSoldNum() {
			return soldNum;
		}
		public void setSoldNum(int soldNum) {
			this.soldNum = soldNum;
		}
		public String getPcChannel() {
			return pcChannel;
		}
		public void setPcChannel(String pcChannel) {
			this.pcChannel = pcChannel;
		}
		public String getmChannel() {
			return mChannel;
		}
		public void setmChannel(String mChannel) {
			this.mChannel = mChannel;
		}
		public int getPostId() {
			return postId;
		}
		public void setPostId(int postId) {
			this.postId = postId;
		}
		
}