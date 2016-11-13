/** Project Name:lymall-service
 * File Name:CategoryProvider.java
 * Package Name:com.bofowo.site.provider
 * Date:2016年3月17日下午11:56:22
 * Copyright (c) 2016, 404886 Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.site.provider;

import com.bofowo.site.query.ManageResourceQuery;

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
public class ManageResourceProvider {
	
																																																																																					
	public String columns="ID,NAME,CONTENT,TYPE_,STATUS,CREATE_DATE,CREATOR,PARENT_ID";
																																																																																						
	public String property="#{id},#{name},#{content},#{type},#{status},#{createDate},#{creator},#{parentId}";
	
	public String getSearchSql(ManageResourceQuery query){
	String sql="select "+columns+" FROM ManageResource where 1=1 ";

	sql+="limit #{startRow},#{endRow}";
	return sql;
	}
	
	public String getSearchSqlCount(ManageResourceQuery query){
		String sql="select count(*) FROM ManageResource where 1=1 ";

		sql+="limit #{startRow},#{endRow}";
		return sql;
		}
}