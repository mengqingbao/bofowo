/** Project Name:lymall-service
 * File Name:CategoryProvider.java
 * Package Name:com.bofowo.site.provider
 * Date:2016年3月17日下午11:56:22
 * Copyright (c) 2016, 404886 Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.site.provider;

import com.bofowo.site.query.MyCouponQuery;

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
public class MyCouponProvider {
	
																																																																																																									
	public String columns="ID,NAME,COUPON_ID,CONTENT,BUYER_ID,SELLER_ID,CREATED_TIME,TYPE,START_DATE,END_DATE";
																																																																																																										
	public String property="#{id},#{name},#{couponId},#{content},#{buyerId},#{sellerId},#{createdTime},#{type},#{startDate},#{endDate}";
	
	public String getSearchSql(MyCouponQuery query){
	String sql="select "+columns+" FROM T_MY_COUPON where 1=1 ";
	if(!StringUtil.isEmpty(query.getBuyerId())){
		sql+="and BUYER_ID='"+query.getBuyerId()+"'";
	}
	if(!StringUtil.isEmpty(query.getType())){
		sql+="and TYPE='"+query.getType()+"'";
	}
	sql+="limit #{startRow},#{endRow}";
	return sql;
	}
	
	public String getSearchSqlCount(MyCouponQuery query){
		String sql="select count(*) FROM T_MY_COUPON where 1=1 ";
		if(!StringUtil.isEmpty(query.getBuyerId())){
			sql+="and BUYER_ID='"+query.getBuyerId()+"'";
		}
		if(!StringUtil.isEmpty(query.getType())){
			sql+="and TYPE='"+query.getType()+"'";
		}
		sql+="limit #{startRow},#{endRow}";
		return sql;
		}
}