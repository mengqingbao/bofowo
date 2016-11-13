/** Project Name:lymall-service
 * File Name:CategoryProvider.java
 * Package Name:com.bofowo.site.provider
 * Date:2016年3月17日下午11:56:22
 * Copyright (c) 2016, 404886 Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.site.provider;

import com.bofowo.site.query.CouponQuery;

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
public class CouponProvider {
	
																																																																																																																																																											
	public String columns="ID,NAME,DESC_,CREATED_TIME,BEGIN_TIME,END_TIME,STATUS,SHOP_ID,SELLER_ID,TYPE,CONTENT,CATEGORY_IDS,PIC,MODIFY_TIME,MODIFIER";
																																																																																																																																																												
	public String property="#{id},#{name},#{desc},#{createdTime},#{beginTime},#{endTime},#{status},#{shopId},#{sellerId},#{type},#{content},#{categoryIds},#{pic},#{modifyTime},#{modifier}";
	
	public String getSearchSql(CouponQuery query){
	String sql="select "+columns+" FROM T_COUPON where 1=1 ";
	if(!StringUtil.isEmpty(query.getSellerId())){
		sql+="and SELLER_ID='"+query.getSellerId()+"' ";
	}
	if(!StringUtil.isEmpty(query.getType())){
		sql+="and TYPE='"+query.getType()+"'";
	}
	sql+="limit #{startRow},#{endRow}";
	return sql;
	}
	
	public String getSearchSqlCount(CouponQuery query){
		String sql="select count(*) FROM T_COUPON where 1=1 ";
		if(!StringUtil.isEmpty(query.getSellerId())){
			sql+="and SELLER_ID='"+query.getSellerId()+"' ";
		}
		if(!StringUtil.isEmpty(query.getType())){
			sql+="and TYPE='"+query.getType()+"'";
		}
		return sql;
		}
}