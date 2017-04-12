package com.bofowo.site.query;

import com.common.page.QueryBase;
import java.io.Serializable;

public class WebContentQuery extends QueryBase implements Serializable {

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 * @since JDK 1.7
	 */
	private static final long serialVersionUID = 1L;
	private Integer tablibId;

	public Integer getTablibId() {
		return tablibId;
	}

	public void setTablibId(Integer tablibId) {
		this.tablibId = tablibId;
	}
	
}
