/** Project Name:lymall-service
 * File Name:CategoryProvider.java
 * Package Name:com.bofowo.site.provider
 * Date:2016年3月17日下午11:56:22
 * Copyright (c) 2016, 404886 Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.site.provider;

import com.bofowo.site.query.ManageUserRoleQuery;

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
public class ManageUserRoleProvider {
	
																									
	public String columns="USER_NAME,ROLE_ID";
																										
	public String property="#{userName},#{roleId}";
	
	public String getSearchSql(ManageUserRoleQuery query){
	String sql="select "+columns+" FROM ManageUserRole where 1=1 ";

	sql+="limit #{startRow},#{endRow}";
	return sql;
	}
	
	public String getSearchSqlCount(ManageUserRoleQuery query){
		String sql="select count(*) FROM ManageUserRole where 1=1 ";

		sql+="limit #{startRow},#{endRow}";
		return sql;
		}
}