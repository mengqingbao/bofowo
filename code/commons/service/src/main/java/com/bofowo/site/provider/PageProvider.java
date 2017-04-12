/** Project Name:lymall-service
 * File Name:CategoryProvider.java
 * Package Name:com.bofowo.site.provider
 * Date:2016年3月17日下午11:56:22
 * Copyright (c) 2016, 404886 Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.site.provider;

import com.bofowo.site.query.PageQuery;

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
public class PageProvider {
	
																																																																																																									
	public String columns="ID,NAME,URL,TYPE_,STATUS,LAYOUT,THEME_ID,CONTENT,HEADER,FOOTER";
																																																																																																										
	public String property="#{id},#{name},#{url},#{type},#{status},#{layout},#{themeId},#{content},#{header},#{footer}";
	
	public String getSearchSql(PageQuery query){
	String sql="select "+columns+" FROM T_PAGE where 1=1 ";
	if(StringUtil.isNotEmpty(query.getType())){
		sql+="and TYPE_='"+query.getType()+"' ";
	}
	sql+="limit #{startRow},#{endRow}";
	return sql;
	}
	
	public String getSearchSqlCount(PageQuery query){
		String sql="select count(*) FROM T_PAGE where 1=1 ";
		if(StringUtil.isNotEmpty(query.getType())){
			sql+="and TYPE_='"+query.getType()+"' ";
		}
		sql+="limit #{startRow},#{endRow}";
		return sql;
		}
}