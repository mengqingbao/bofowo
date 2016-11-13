package com.bofowo.site.model;

import java.io.Serializable;
import java.util.Date;

public class CartDetailsModel implements Serializable{
	
	 
	 	 	private int productNumber;	//商品编号
	 	 	private String cartCode;	//购物车编号
	 	 	private int productNum;		//商品数量
	 	 	private int checkStatus;	//商品是否勾选 
			
			public int getProductNumber() {
				return productNumber;
			}
			public void setProductNumber(int productNumber) {
				this.productNumber = productNumber;
			}
			public String getCartCode() {
				return cartCode;
			}
			public void setCartCode(String cartCode) {
				this.cartCode = cartCode;
			}
			public int getProductNum() {
				return productNum;
			}
			public void setProductNum(int productNum) {
				this.productNum = productNum;
			}
			public int getCheckStatus() {
				return checkStatus;
			}
			public void setCheckStatus(int checkStatus) {
				this.checkStatus = checkStatus;
			}

	 
	
	    
	
		
}