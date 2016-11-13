package com.bofowo.site.model;

import java.io.Serializable;

public class TaglibRefModel implements Serializable{

		private int id;
		private int tagId;
		private String type;
		
		public int getId(){
		return id;
	}
		public int getTagId(){
		return tagId;
	}
		public String getType(){
		return type;
	}
		
		public void setId(int id){
		this.id = id;
	}
		public void setTagId(int tagId){
		this.tagId = tagId;
	}
		public void setType(String type){
		this.type = type;
	}
		
}