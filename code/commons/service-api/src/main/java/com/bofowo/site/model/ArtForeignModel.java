package com.bofowo.site.model;

public class ArtForeignModel {
	private int id;
	private String chinesename;//网站名称及图片
	private String picture;
	private String url;//网站url
	private String introduces;//特点介绍
	private String remark;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getChinesename() {
		return chinesename;
	}
	public void setChinesename(String chinesename) {
		this.chinesename = chinesename;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIntroduces() {
		return introduces;
	}
	public void setIntroduces(String introduces) {
		this.introduces = introduces;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
}
