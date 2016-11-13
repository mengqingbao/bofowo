package com.bofowo.site.model;

import java.io.Serializable;

public class PageModel implements Serializable{

		private int id;
		private String name;
		private String url;
		private String type;
		private String status;
		private String layout;
		private int themeId;
		private String content;
		private String header;
		private String footer;
		
		public int getId(){
		return id;
	}
		public String getName(){
		return name;
	}
		public String getUrl(){
		return url;
	}
		public String getType(){
		return type;
	}
		public String getStatus(){
		return status;
	}
		public String getLayout(){
		return layout;
	}
		public int getThemeId(){
		return themeId;
	}
		public String getContent(){
		return content;
	}
		public String getHeader(){
		return header;
	}
		public String getFooter(){
		return footer;
	}
		
		public void setId(int id){
		this.id = id;
	}
		public void setName(String name){
		this.name = name;
	}
		public void setUrl(String url){
		this.url = url;
	}
		public void setType(String type){
		this.type = type;
	}
		public void setStatus(String status){
		this.status = status;
	}
		public void setLayout(String layout){
		this.layout = layout;
	}
		public void setThemeId(int themeId){
		this.themeId = themeId;
	}
		public void setContent(String content){
		this.content = content;
	}
		public void setHeader(String header){
		this.header = header;
	}
		public void setFooter(String footer){
		this.footer = footer;
	}
		
}