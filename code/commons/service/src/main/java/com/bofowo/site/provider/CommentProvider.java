/** Project Name:lymall-service
 * File Name:CategoryProvider.java
 * Package Name:com.bofowo.site.provider
 * Date:2016年3月17日下午11:56:22
 * Copyright (c) 2016, 404886 Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.site.provider;

import com.bofowo.site.query.CommentQuery;

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
public class CommentProvider {
	
																																																																																																																																																																																									
	public String columns="ID,BUYER_ID,ORDER_ID,SERVICE_RATE,ITEM_RATE,POST_RATE,COMMENT,CREATED_TIME,T_ORDER_COMMENT,MODIFIED_TIME,STATUS,SHOP_ID,SELLER_ID,EX_COMMENT,EX_SERVICE_RATE,EX_ITEM_RATE,EX_POST,TRADE_ID,ITEM_ID";
																																																																																																																																																																																										
	public String property="#{id},#{buyerId},#{orderId},#{serviceRate},#{itemRate},#{postRate},#{comment},#{createdTime},#{tOrderComment},#{modifiedTime},#{status},#{shopId},#{sellerId},#{exComment},#{exServiceRate},#{exItemRate},#{exPost},#{tradeId},#{itemId}";
	
	public String getSearchSql(CommentQuery query){
	String sql="select "+columns+" FROM T_COMMENT where 1=1 ";
	if(!StringUtil.isEmpty(query.getSellerId())){
		sql+="and SELLER_ID='"+query.getSellerId()+"' ";
	}
	if(!StringUtil.isEmpty(query.getBuyerId())){
		sql+="and BUYER_ID='"+query.getSellerId()+"' ";
	}
	sql+="limit #{startRow},#{endRow}";
	return sql;
	}
	
	public String getSearchSqlCount(CommentQuery query){
		String sql="select count(*) FROM T_COMMENT where 1=1 ";
		if(!StringUtil.isEmpty(query.getSellerId())){
			sql+="and SELLER_ID='"+query.getSellerId()+"' ";
		}
		if(!StringUtil.isEmpty(query.getBuyerId())){
			sql+="and BUYER_ID='"+query.getSellerId()+"' ";
		}
		return sql;
		}
}