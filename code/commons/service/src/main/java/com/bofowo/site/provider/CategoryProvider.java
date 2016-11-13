/**
 * Project Name:lymall-service
 * File Name:CategoryProvider.java
 * Package Name:com.bofowo.site.provider
 * Date:2016年3月17日下午11:56:22
 * Copyright (c) 2016,Shanghai bofowo Technology co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.site.provider;

import com.bofowo.site.query.CategoryQuery;

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
public class CategoryProvider {
	
	public String columns="ID,PID,NAME,STATUS,CREATED_DATE,CREATOR,IS_DELETE,TYPE_,DESC_";
	
	public String property="#{id},#{pid},#{name},#{status},#{createdDate},#{creator},#{isDelete},#{type},#{desc}";
	
	
	public String getSearchSql(CategoryQuery query){
	String sql="select "+columns+" FROM T_CATEGORY where TYPE_=#{type} ";
	if(!StringUtil.isEmpty(query.getStatus())){
		sql+="and STATUS='"+query.getStatus()+"' ";
	}

		sql+="and PID='"+query.getPid()+"' ";

	sql+="limit #{startRow},#{endRow}";
	return sql;
	}
	
	public String getSearchSqlCount(CategoryQuery query){
		String sql="select count(*) FROM T_CATEGORY where TYPE_=#{type} ";
		if(!StringUtil.isEmpty(query.getStatus())){
			sql+="and STATUS='"+query.getStatus()+"' ";
		}

			sql+="and PID='"+query.getPid()+"' ";

		sql+="limit #{startRow},#{endRow}";
		return sql;
		}
}

