/** Project Name:lymall-service
 * File Name:CategoryProvider.java
 * Package Name:com.lyun.site.provider
 * Date:2016年3月17日下午11:56:22
 * Copyright (c) 2016, 404886 Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.site.provider;

import com.bofowo.site.query.MyShowQuery;

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
public class MyShowProvider {
	
																																			
	public String columns="ID,NAME,PASSWORD";
																																				
	public String property="#{id},#{name},#{password}";
	
	public String getSearchSql(MyShowQuery query){
	String sql="select "+columns+" FROM T_MY_SHOW where 1=1 ";

	sql+="limit #{startRow},#{endRow}";
	return sql;
	}
	
	public String getSearchSqlCount(MyShowQuery query){
		String sql="select count(*) FROM T_MY_SHOW where 1=1 ";

		sql+="limit #{startRow},#{endRow}";
		return sql;
		}
}