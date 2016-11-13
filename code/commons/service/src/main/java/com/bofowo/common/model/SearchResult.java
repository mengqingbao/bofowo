package com.bofowo.common.model;

import java.io.Serializable;
import java.util.Date;

public class SearchResult  implements Serializable{
	
	
	private String title;
	private String desc;
    private String id;
	private Date date;	
	private String picture;
	private int type;
	private String content;
	private String source ;
	private long count;  //总记录数
	
	private String replyRealName;
	private int knowReply;
	private int praiseTimes;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getReplyRealName() {
		return replyRealName;
	}
	public void setReplyRealName(String replyRealName) {
		this.replyRealName = replyRealName;
	}
	public int getKnowReply() {
		return knowReply;
	}
	public void setKnowReply(int knowReply) {
		this.knowReply = knowReply;
	}
	public int getPraiseTimes() {
		return praiseTimes;
	}
	public void setPraiseTimes(int praiseTimes) {
		this.praiseTimes = praiseTimes;
	}
	

}
