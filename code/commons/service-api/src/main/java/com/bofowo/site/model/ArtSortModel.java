package com.bofowo.site.model;

import java.io.Serializable;
import java.util.Date;

public class ArtSortModel implements Serializable{
	
	 
	 	 	private int id;
	 	 	private String name;
	 	 	private String remark;
	 
			public void setId(int id){
			this.id=id;
		}
	
	
	    public int getId(){
          return id;
	    }
	
	
			public void setName(String name){
			this.name=name;
		}
	
	
	    public String getName(){
          return name;
	    }
	
	
			public void setRemaRk(String remark){
			this.remark=remark;
		}
	
	
	    public String getRemaRk(){
          return remark;
	    }
	
	
	
		
}