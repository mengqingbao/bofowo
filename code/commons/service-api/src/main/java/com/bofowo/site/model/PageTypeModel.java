package com.bofowo.site.model;

import java.io.Serializable;
import java.util.Date;

public class PageTypeModel implements Serializable{
	
	 
	 	 	private int id;
	 	 	private String className;
	 	 	private int quantityLimitation;
	 	 	private String pageTypeId;
	 
			public void setId(int id){
			this.id=id;
		}
	
	
	    public int getId(){
          return id;
	    }
	
	
			public void setClassName(String className){
			this.className=className;
		}
	
	
	    public String getClassName(){
          return className;
	    }
	
	
			public void setQuantityLimitation(int quantityLimitation){
			this.quantityLimitation=quantityLimitation;
		}
	
	
	    public int getQuantityLimitation(){
          return quantityLimitation;
	    }


		public String getPageTypeId() {
			return pageTypeId;
		}


		public void setPageTypeId(String pageTypeId) {
			this.pageTypeId = pageTypeId;
		}
	
	
	
		
}