/** Project Name:lymall-service
 * File Name:CategoryProvider.java
 * Package Name:com.bofowo.site.provider
 * Date:2016年3月17日下午11:56:22
 * Copyright (c) 2016, 404886 Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.site.provider;

import com.bofowo.site.query.PageColumnQuery;

import antlr.StringUtils;
import common.util.StringUtil;

/**
 * ClassName:CategoryProvider <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年3月17日 下午11:56:22 <br/>
 * @author   mqb
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class PageColumnProvider {
	
																																																																											
	public String columns="ID,PAGE_ID,CONTENT,STATUS,DATA_JSON,TYPE_,ORDER_";
																																																																												
	public String property="#{id},#{pageId},#{content},#{status},#{dataJson},#{type},#{order}";
	
	public String getSearchSql(PageColumnQuery query){
	String sql="select "+columns+" FROM T_PAGE_COLUMN where 1=1 ";

	sql+="limit #{startRow},#{endRow}";
	return sql;
	}
	
	public String getSearchSqlCount(PageColumnQuery query){
		String sql="select count(*) FROM T_PAGE_COLUMN where 1=1 ";

		sql+="limit #{startRow},#{endRow}";
		return sql;
		}
}