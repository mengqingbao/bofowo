/** Project Name:lymall-service
 * File Name:CategoryProvider.java
 * Package Name:com.bofowo.site.provider
 * Date:2016年3月17日下午11:56:22
 * Copyright (c) 2016, 404886 Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.site.provider;

import com.bofowo.site.query.CarQuery;

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
public class CarProvider {
	
																																																																																																																																																											
	public String columns="ID,ITEM_ID,TITLE,PIC,NUM,PRICE,TOTAL,STATUS,PROPERTIES,SPEC,NOTE,SELLER_ID,BUYER_ID,CREATED_TIME,MODIFY_TIME";
																																																																																																																																																												
	public String property="#{id},#{itemId},#{title},#{pic},#{num},#{price},#{total},#{status},#{properties},#{spec},#{note},#{sellerId},#{buyerId},#{createdTime},#{modifyTime}";
	
	public String getSearchSql(CarQuery query){
	String sql="select "+columns+" FROM T_CAR where 1=1 ";
	if(!StringUtil.isEmpty(query.getBuyerId())){
		sql+="AND BUYER_ID='"+query.getBuyerId()+"' ";
	}
	sql+="limit #{startRow},#{endRow}";
	return sql;
	}
	
	public String getSearchSqlCount(CarQuery query){
		String sql="select count(*) FROM T_CAR where 1=1 ";
		if(!StringUtil.isEmpty(query.getBuyerId())){
			sql+=" AND BUYER_ID='"+query.getBuyerId()+"' ";
		}
		return sql;
		}
}