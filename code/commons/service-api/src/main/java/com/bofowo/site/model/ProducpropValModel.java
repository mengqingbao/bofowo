package com.bofowo.site.model;

import java.io.Serializable;

public class ProducpropValModel implements Serializable{

		private int id;
		private int productId;
		private String propName;
		private String propVal;
		private int propId;
		private String propKey;
		
		public int getId(){
		return id;
	}
		public int getProductId(){
		return productId;
	}
		public String getPropName(){
		return propName;
	}
		public String getPropVal(){
		return propVal;
	}
		public int getPropId(){
		return propId;
	}
		public String getPropKey(){
		return propKey;
	}
		
		public void setId(int id){
		this.id = id;
	}
		public void setProductId(int productId){
		this.productId = productId;
	}
		public void setPropName(String propName){
		this.propName = propName;
	}
		public void setPropVal(String propVal){
		this.propVal = propVal;
	}
		public void setPropId(int propId){
		this.propId = propId;
	}
		public void setPropKey(String propKey){
		this.propKey = propKey;
	}
		
}