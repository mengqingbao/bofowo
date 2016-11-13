package com.bofowo.site.model;

import java.io.Serializable;

public class DatabaseModel implements Serializable{

		private int id;
		private String databasename;
		private String driverclassname;
		private String url;
		private String username;
		private String password;
		private String initialsize;
		private String maxactive;
		private String maxidle;
		private String minidle;
		private String maxwait;
		private String removeabandoned;
		private String removeabandonedtimeout;
		private String timebetweenevictionrunsmillis;
		private String minevictableidletimemillis;
		private String validationquery;
		private String testwhileidle;
		private String testonborrow;
		private String testonreturn;
		private String poolpreparedstatements;
		private String maxpoolpreparedstatementperconnectionsize;
		private String filters;
		private String status;
		
		public int getId(){
		return id;
	}
		public String getDatabasename(){
		return databasename;
	}
		public String getDriverclassname(){
		return driverclassname;
	}
		public String getUrl(){
		return url;
	}
		public String getUsername(){
		return username;
	}
		public String getPassword(){
		return password;
	}
	
		public String getInitialsize(){
		return initialsize;
	}
		public String getMaxactive(){
		return maxactive;
	}
		public String getMaxidle(){
		return maxidle;
	}
		public String getMinidle(){
		return minidle;
	}
		public String getMaxwait(){
		return maxwait;
	}
		public String getRemoveabandoned(){
		return removeabandoned;
	}
		public String getRemoveabandonedtimeout(){
		return removeabandonedtimeout;
	}
		public String getTimebetweenevictionrunsmillis(){
		return timebetweenevictionrunsmillis;
	}
		public String getMinevictableidletimemillis(){
		return minevictableidletimemillis;
	}
		public String getValidationquery(){
		return validationquery;
	}
		public String getTestwhileidle(){
		return testwhileidle;
	}
		public String getTestonborrow(){
		return testonborrow;
	}
		public String getTestonreturn(){
		return testonreturn;
	}
		public String getPoolpreparedstatements(){
		return poolpreparedstatements;
	}
		public String getMaxpoolpreparedstatementperconnectionsize(){
		return maxpoolpreparedstatementperconnectionsize;
	}
		public String getFilters(){
		return filters;
	}
		public String getStatus(){
		return status;
	}
		
		public void setId(int id){
		this.id = id;
	}
		public void setDatabasename(String databasename){
		this.databasename = databasename;
	}
		public void setDriverclassname(String driverclassname){
		this.driverclassname = driverclassname;
	}
		public void setUrl(String url){
		this.url = url;
	}
		public void setUsername(String username){
		this.username = username;
	}
		public void setPassword(String password){
		this.password = password;
	}
		public void setInitialsize(String initialsize){
		this.initialsize = initialsize;
	}
		public void setMaxactive(String maxactive){
		this.maxactive = maxactive;
	}
		public void setMaxidle(String maxidle){
		this.maxidle = maxidle;
	}
		public void setMinidle(String minidle){
		this.minidle = minidle;
	}
		public void setMaxwait(String maxwait){
		this.maxwait = maxwait;
	}
		public void setRemoveabandoned(String removeabandoned){
		this.removeabandoned = removeabandoned;
	}
		public void setRemoveabandonedtimeout(String removeabandonedtimeout){
		this.removeabandonedtimeout = removeabandonedtimeout;
	}
		public void setTimebetweenevictionrunsmillis(String timebetweenevictionrunsmillis){
		this.timebetweenevictionrunsmillis = timebetweenevictionrunsmillis;
	}
		public void setMinevictableidletimemillis(String minevictableidletimemillis){
		this.minevictableidletimemillis = minevictableidletimemillis;
	}
		public void setValidationquery(String validationquery){
		this.validationquery = validationquery;
	}
		public void setTestwhileidle(String testwhileidle){
		this.testwhileidle = testwhileidle;
	}
		public void setTestonborrow(String testonborrow){
		this.testonborrow = testonborrow;
	}
		public void setTestonreturn(String testonreturn){
		this.testonreturn = testonreturn;
	}
		public void setPoolpreparedstatements(String poolpreparedstatements){
		this.poolpreparedstatements = poolpreparedstatements;
	}
		public void setMaxpoolpreparedstatementperconnectionsize(String maxpoolpreparedstatementperconnectionsize){
		this.maxpoolpreparedstatementperconnectionsize = maxpoolpreparedstatementperconnectionsize;
	}
		public void setFilters(String filters){
		this.filters = filters;
	}
		public void setStatus(String status){
		this.status = status;
	}
		
}