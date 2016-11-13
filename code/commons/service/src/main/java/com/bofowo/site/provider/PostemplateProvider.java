/** Project Name:lymall-service
 * File Name:CategoryProvider.java
 * Package Name:com.bofowo.site.provider
 * Date:2016年3月17日下午11:56:22
 * Copyright (c) 2016, 404886 Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.site.provider;

import com.bofowo.site.query.PostemplateQuery;

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
public class PostemplateProvider {
	
																																																																																															
	public String columns="ID,SELLER_ID,TITTLE,FEE,FIRST_FEE,EX_WEIGHT,EX_WEIGHT_FEE,FREE_AREA,STATUS";
																																																																																																
	public String property="#{id},#{sellerId},#{tittle},#{fee},#{firstFee},#{exWeight},#{exWeightFee},#{freeArea},#{status}";
	
	public String getSearchSql(PostemplateQuery query){
	String sql="select "+columns+" FROM T_POST_TEMPLATE where 1=1 ";
	sql+= "and SELLER_ID='"+query.getCurrentUserName()+"' ";
	sql+="limit #{startRow},#{endRow}";
	return sql;
	}
	
	public String getSearchSqlCount(PostemplateQuery query){
		String sql="select count(*) FROM T_POST_TEMPLATE where 1=1 ";
		sql+= "and SELLER_ID='"+query.getCurrentUserName()+"' ";
		sql+="limit #{startRow},#{endRow}";
		return sql;
		}
}