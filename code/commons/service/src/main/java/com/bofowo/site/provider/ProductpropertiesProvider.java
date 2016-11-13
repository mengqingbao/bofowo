/**
 * Project Name:lymall-service
 * File Name:ProductpropertiesProvider.java
 * Package Name:com.bofowo.site.provider
 * Date:2016年3月20日上午1:58:28
 * Copyright (c) 2016,Shanghai bofowo Technology co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.site.provider;

import com.bofowo.site.query.ProducpropertiesQuery;

import common.util.StringUtil;

/**
 * ClassName:ProductpropertiesProvider <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年3月20日 上午1:58:28 <br/>
 * @author   mqb
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class ProductpropertiesProvider {
	public String columns="ID,NAME,INPUT_TYPE,CATEGORY_ID,PROPERTIES_TYPE,TYPE,DESC_,VAL_,CREATOR,CREATED_DATE";
	
	public String property="#{id},#{name},#{inputType},#{categoryId},#{propertiesType},#{type},#{desc},#{val},#{creator},#{createdDate}";
	
	public String getSearchSql(ProducpropertiesQuery query){
		String sql="select "+columns+" FROM T_PRODUCT_PROPERTIES where 1=1 ";
		if(!StringUtil.isEmpty(query.getType())){
			sql+="and type='"+query.getType()+"' ";
		}
		sql+="limit #{startRow},#{endRow}";
		return sql;
	}
	
	public String getSearchSqlCount(ProducpropertiesQuery query){
		String sql="select count(*) from T_PRODUCT_PROPERTIES where 1=1 ";
		if(!StringUtil.isEmpty(query.getType())){
			sql+="and type='"+query.getType()+"' ";
		};
		return sql;
	}
	
}

