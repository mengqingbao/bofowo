package com.bofowo.site.model;

import java.io.Serializable;
import java.util.Date;

public class CartModel implements Serializable{
	
	 
	 	 	private String cartCode;
	 	 	private String uaerName;
	 	 	private Date createTime;
			public String getCartCode() {
				return cartCode;
			}
			public void setCartCode(String cartCode) {
				this.cartCode = cartCode;
			}
			public String getUaerName() {
				return uaerName;
			}
			public void setUaerName(String uaerName) {
				this.uaerName = uaerName;
			}
			public Date getCreateTime() {
				return createTime;
			}
			public void setCreateTime(Date createTime) {
				this.createTime = createTime;
			}
		
	 	 	
	 	 	
	 	 	
		
}