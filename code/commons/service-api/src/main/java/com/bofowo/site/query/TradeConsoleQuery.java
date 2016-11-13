package com.bofowo.site.query;

import com.common.page.QueryBase;
import java.io.Serializable;

public class TradeConsoleQuery extends QueryBase implements Serializable {
	private String askerId;
	private String answerId;
	public String getAskerId() {
		return askerId;
	}
	public void setAskerId(String askerId) {
		this.askerId = askerId;
	}
	public String getAnswerId() {
		return answerId;
	}
	public void setAnswerId(String answerId) {
		this.answerId = answerId;
	}
	
	
}
