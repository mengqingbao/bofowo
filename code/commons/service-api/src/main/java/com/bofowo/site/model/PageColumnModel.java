package com.bofowo.site.model;

import java.io.Serializable;

public class PageColumnModel implements Serializable{

		private int id;
		private int pageId;
		private String content;
		private String status;
		private String dataJson;
		private String type;
		private int order;
		
		public int getId(){
		return id;
	}
		public int getPageId(){
		return pageId;
	}
		public String getContent(){
		return content;
	}
		public String getStatus(){
		return status;
	}
		public String getDataJson(){
		return dataJson;
	}
		public String getType(){
		return type;
	}
		public int getOrder(){
		return order;
	}
		
		public void setId(int id){
		this.id = id;
	}
		public void setPageId(int pageId){
		this.pageId = pageId;
	}
		public void setContent(String content){
		this.content = content;
	}
		public void setStatus(String status){
		this.status = status;
	}
		public void setDataJson(String dataJson){
		this.dataJson = dataJson;
	}
		public void setType(String type){
		this.type = type;
	}
		public void setOrder(int order){
		this.order = order;
	}
		
}