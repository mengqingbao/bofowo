package com.bofowo.site.model;

import java.io.Serializable;
import java.util.Date;

public class CommodityAuctionModel implements Serializable{
	
	 
	 	 	private int id;
	 	 	private int productNumber;
	 	 	private float startingPrice;
	 	 	private float bidIncrement;
	 	 	private int currentBids;
	 	 	private float currentPrice;
	 	 	private float reservePrice;
	 	 	private float bail;
	 	 	private int status;
	 	 	private Date shootingTime;
	 	 	private Date endTime;
	 	 	private int publishStatus;
	 	 	private float lowEstimate;
	 	 	private float highEstimate;
	 	 	
			public float getLowEstimate() {
				return lowEstimate;
			}
			public void setLowEstimate(float lowEstimate) {
				this.lowEstimate = lowEstimate;
			}
			public float getHighEstimate() {
				return highEstimate;
			}
			public void setHighEstimate(float highEstimate) {
				this.highEstimate = highEstimate;
			}
			public int getId() {
				return id;
			}
			public void setId(int id) {
				this.id = id;
			}
			public int getProductNumber() {
				return productNumber;
			}
			public void setProductNumber(int productNumber) {
				this.productNumber = productNumber;
			}
			public float getStartingPrice() {
				return startingPrice;
			}
			public void setStartingPrice(float startingPrice) {
				this.startingPrice = startingPrice;
			}
			public float getBidIncrement() {
				return bidIncrement;
			}
			public void setBidIncrement(float bidIncrement) {
				this.bidIncrement = bidIncrement;
			}
			public int getCurrentBids() {
				return currentBids;
			}
			public void setCurrentBids(int currentBids) {
				this.currentBids = currentBids;
			}
			public float getCurrentPrice() {
				return currentPrice;
			}
			public void setCurrentPrice(float currentPrice) {
				this.currentPrice = currentPrice;
			}
			public float getReservePrice() {
				return reservePrice;
			}
			public void setReservePrice(float reservePrice) {
				this.reservePrice = reservePrice;
			}
			public float getBail() {
				return bail;
			}
			public void setBail(float bail) {
				this.bail = bail;
			}
			public int getStatus() {
				return status;
			}
			public void setStatus(int status) {
				this.status = status;
			}
			public Date getShootingTime() {
				return shootingTime;
			}
			public void setShootingTime(Date shootingTime) {
				this.shootingTime = shootingTime;
			}
			public Date getEndTime() {
				return endTime;
			}
			public void setEndTime(Date endTime) {
				this.endTime = endTime;
			}
			public int getPublishStatus() {
				return publishStatus;
			}
			public void setPublishStatus(int publishStatus) {
				this.publishStatus = publishStatus;
			}
	 
	 	 	
	 	 	
	 	 	
	
	

		
	
	
		
}