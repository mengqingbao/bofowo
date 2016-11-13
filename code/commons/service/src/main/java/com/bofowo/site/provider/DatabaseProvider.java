/** Project Name:lymall-service
 * File Name:CategoryProvider.java
 * Package Name:com.bofowo.site.provider
 * Date:2016年3月17日下午11:56:22
 * Copyright (c) 2016, 404886 Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.site.provider;

import com.bofowo.site.query.DatabaseQuery;

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
public class DatabaseProvider {
	
																																																																																																																																																																																																																																																					
	public String columns="ID,databaseName,driverClassName,url,username,password,druid.initialSize,initialSize,maxActive,maxIdle,minIdle,maxWait,removeAbandoned,removeAbandonedTimeout,timeBetweenEvictionRunsMillis,minEvictableIdleTimeMillis,validationQuery,testWhileIdle,testOnBorrow,testOnReturn,poolPreparedStatements,maxPoolPreparedStatementPerConnectionSize,filters,status";
																																																																																																																																																																																																																																																						
	public String property="#{id},#{databasename},#{driverclassname},#{url},#{username},#{password},#{druid.initialsize},#{initialsize},#{maxactive},#{maxidle},#{minidle},#{maxwait},#{removeabandoned},#{removeabandonedtimeout},#{timebetweenevictionrunsmillis},#{minevictableidletimemillis},#{validationquery},#{testwhileidle},#{testonborrow},#{testonreturn},#{poolpreparedstatements},#{maxpoolpreparedstatementperconnectionsize},#{filters},#{status}";
	
	public String getSearchSql(DatabaseQuery query){
	String sql="select "+columns+" FROM T_DATABASE_ where 1=1 ";

	sql+="limit #{startRow},#{endRow}";
	return sql;
	}
	
	public String getSearchSqlCount(DatabaseQuery query){
		String sql="select count(*) FROM T_DATABASE_ where 1=1 ";

		sql+="limit #{startRow},#{endRow}";
		return sql;
		}
}