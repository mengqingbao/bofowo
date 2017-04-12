package com.bofowo.site.model;

import java.io.Serializable;
import java.util.Date;

public class WebContentModel implements Serializable{

		private int id;
		private String title;
		private String author;
		private String from;
		private Date createDate;
		private Date modifyDate;
		private String creator;
		private String modifier;
		private String contentA;
		private String contentB;
		private String contentC;
		private int categoryId;
		private String status;
		private String isDelete;
		private String desc;
		private int tagLibId;
		private String seoTittle;
		private String seoKey;
		private String seoDesc;
		private String pic;
		
		public int getId(){
		return id;
	}
		public String getTitle(){
		return title;
	}
		public String getAuthor(){
		return author;
	}
		public String getFrom(){
		return from;
	}
		public Date getCreateDate(){
		return createDate;
	}
		public Date getModifyDate(){
		return modifyDate;
	}
		public String getCreator(){
		return creator;
	}
		public String getModifier(){
		return modifier;
	}
		public String getContentA(){
		return contentA;
	}
		public String getContentB(){
		return contentB;
	}
		public String getContentC(){
		return contentC;
	}
		public int getCategoryId(){
		return categoryId;
	}
		public String getStatus(){
		return status;
	}
		public String getIsDelete(){
		return isDelete;
	}
		public String getDesc(){
		return desc;
	}
		public int getTagLibId(){
		return tagLibId;
	}
		public String getSeoTittle(){
		return seoTittle;
	}
		public String getSeoKey(){
		return seoKey;
	}
		public String getSeoDesc(){
		return seoDesc;
	}
		
		public void setId(int id){
		this.id = id;
	}
		public void setTitle(String title){
		this.title = title;
	}
		public void setAuthor(String author){
		this.author = author;
	}
		public void setFrom(String from){
		this.from = from;
	}
		public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}
		public void setModifyDate(Date modifyDate){
		this.modifyDate = modifyDate;
	}
		public void setCreator(String creator){
		this.creator = creator;
	}
		public void setModifier(String modifier){
		this.modifier = modifier;
	}
		public void setContentA(String contentA){
		this.contentA = contentA;
	}
		public void setContentB(String contentB){
		this.contentB = contentB;
	}
		public void setContentC(String contentC){
		this.contentC = contentC;
	}
		public void setCategoryId(int categoryId){
		this.categoryId = categoryId;
	}
		public void setStatus(String status){
		this.status = status;
	}
		public void setIsDelete(String isDelete){
		this.isDelete = isDelete;
	}
		public void setDesc(String desc){
		this.desc = desc;
	}
		public void setTagLibId(int tagLibId){
		this.tagLibId = tagLibId;
	}
		public void setSeoTittle(String seoTittle){
		this.seoTittle = seoTittle;
	}
		public void setSeoKey(String seoKey){
		this.seoKey = seoKey;
	}
		public void setSeoDesc(String seoDesc){
		this.seoDesc = seoDesc;
	}
		public String getPic() {
			return pic;
		}
		public void setPic(String pic) {
			this.pic = pic;
		}
		
}