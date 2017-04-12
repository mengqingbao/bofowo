package com.bofowo.site.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ProducpropertiesModel implements Serializable{

		private int id;
		private String name;
		private String inputType;
		private int categoryId;
		private String propertiesType;
		private String type;
		private String desc;
		private String val;
		private String creator;
		private Date createdDate;
		private List<String> props;
		
		public int getId(){
		return id;
	}
		public String getName(){
		return name;
	}
		public String getInputType(){
		return inputType;
	}
		public int getCategoryId(){
		return categoryId;
	}
		public String getPropertiesType(){
		return propertiesType;
	}
		public String getType(){
		return type;
	}
		public String getDesc(){
		return desc;
	}
		public String getVal(){
		return val;
	}
		public String getCreator(){
		return creator;
	}
		public Date getCreatedDate(){
		return createdDate;
	}
		
		public void setId(int id){
		this.id = id;
	}
		public void setName(String name){
		this.name = name;
	}
		public void setInputType(String inputType){
		this.inputType = inputType;
	}
		public void setCategoryId(int categoryId){
		this.categoryId = categoryId;
	}
		public void setPropertiesType(String propertiesType){
		this.propertiesType = propertiesType;
	}
		public void setType(String type){
		this.type = type;
	}
		public void setDesc(String desc){
		this.desc = desc;
	}
		public void setVal(String val){
		this.val = val;
	}
		public void setCreator(String creator){
		this.creator = creator;
	}
		public void setCreatedDate(Date createdDate){
		this.createdDate = createdDate;
	}
		public String[] getProps() {
			if(val==null||val==""){
				
				return null;
			}
			return val.split(",");
		}
		public void setProps(List<String> props) {
			this.props = props;
		}
		
}