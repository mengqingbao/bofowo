package com.bofowo.site.model;


public class CartList{
	 	public int code;    //商品编号
	 	public String artName; //商品名称 
	 	public String author;  //作者
	 	public String introduction; //商品简介
	    public int number;     //数量
	    public double price;   //商品单价
	    public int checkstatus;  //是否选中结算  0代表选中   1代表未选中
	    public double subtotal;	//商品小计
	    public String picture;	//商品图片
	   
	    
	    
		
	    
		
	    
		public int getCode() {
			return code;
		}
		public void setCode(int code) {
			this.code = code;
		}
		public int getNumber() {
			return number;
		}
		public void setNumber(int number) {
			this.number = number;
		}
		public int getCheckstatus() {
			return checkstatus;
		}
		public void setCheckstatus(int checkstatus) {
			this.checkstatus = checkstatus;
		}
		public String getArtName() {
			return artName;
		}
		public void setArtName(String artName) {
			this.artName = artName;
		}
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		public String getIntroduction() {
			return introduction;
		}
		public void setIntroduction(String introduction) {
			this.introduction = introduction;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public double getSubtotal() {
			return subtotal;
		}
		public void setSubtotal(double subtotal) {
			this.subtotal = subtotal;
		}
		public String getPicture() {
			return picture;
		}
		public void setPicture(String picture) {
			this.picture = picture;
		}
		
		
}