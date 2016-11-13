package com.bofowo.site.model;

import java.io.Serializable;

public class PostemplateModel implements Serializable{

		private int id;
		private String sellerId;
		private String tittle;
		private float fee;
		private float firstFee;
		private int exWeight;
		private float exWeightFee;
		private String freeArea;
		private String status;
		
		public int getId(){
		return id;
	}
		public String getSellerId(){
		return sellerId;
	}
		public String getTittle(){
		return tittle;
	}
		public float getFee(){
		return fee;
	}
		public float getFirstFee(){
		return firstFee;
	}
		public int getExWeight(){
		return exWeight;
	}
		public float getExWeightFee(){
		return exWeightFee;
	}
		public String getFreeArea(){
		return freeArea;
	}
		public String getStatus(){
		return status;
	}
		
		public void setId(int id){
		this.id = id;
	}
		public void setSellerId(String sellerId){
		this.sellerId = sellerId;
	}
		public void setTittle(String tittle){
		this.tittle = tittle;
	}
		public void setFee(float fee){
		this.fee = fee;
	}
		public void setFirstFee(float firstFee){
		this.firstFee = firstFee;
	}
		public void setExWeight(int exWeight){
		this.exWeight = exWeight;
	}
		public void setExWeightFee(float exWeightFee){
		this.exWeightFee = exWeightFee;
	}
		public void setFreeArea(String freeArea){
		this.freeArea = freeArea;
	}
		public void setStatus(String status){
		this.status = status;
	}
		
}