/** Project Name:lymall-service
 * File Name:CategoryProvider.java
 * Package Name:com.bofowo.site.provider
 * Date:2016年3月17日下午11:56:22
 * Copyright (c) 2016, 404886 Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.site.provider;

import com.bofowo.site.query.ThemeQuery;

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
public class ThemeProvider {
	
																																																																																																																			
	public String columns="ID,NAME,CONTENT,STATUS,LEVEL,PRICE,SELLER_ID,AVATAR,DRAW,CREATE_TIME,MODIFY_TIME";
																																																																																																																				
	public String property="#{id},#{name},#{content},#{status},#{level},#{price},#{sellerId},#{avatar},#{draw},#{createTime},#{modifyTime}";
	
	public String getSearchSql(ThemeQuery query){
	String sql="select "+columns+" FROM T_THEME where 1=1 ";

	sql+="limit #{startRow},#{endRow}";
	return sql;
	}
	
	public String getSearchSqlCount(ThemeQuery query){
		String sql="select count(*) FROM T_THEME where 1=1 ";

		sql+="limit #{startRow},#{endRow}";
		return sql;
		}
}