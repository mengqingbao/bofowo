package com.bofowo.site.query;

import com.common.page.QueryBase;
import java.io.Serializable;

public class ShopScrollQuery extends QueryBase implements Serializable {

	private String status;
	private String pushIndex;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPushIndex() {
		return pushIndex;
	}

	public void setPushIndex(String pushIndex) {
		this.pushIndex = pushIndex;
	}
	
	
	
}
