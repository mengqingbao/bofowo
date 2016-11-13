/** Project Name:lymall-service
 * File Name:CategoryProvider.java
 * Package Name:com.bofowo.site.provider
 * Date:2016年3月17日下午11:56:22
 * Copyright (c) 2016, 404886 Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.site.provider;

import com.bofowo.site.query.BuyerCollectionQuery;

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
public class BuyerCollectionProvider {
	
																																																																																																																													
	public String columns="ID,ITEM_ID,TITLE,IMAGE,BUYER_ID,SELLER_ID,SHOP_ID,SHOP_NAME,TYPE_,CREATED_TIME,T_BUYER_COLLECTIONcol,IS_DELETE";
																																																																																																																														
	public String property="#{id},#{itemId},#{title},#{image},#{buyerId},#{sellerId},#{shopId},#{shopName},#{type},#{createdTime},#{tBuyerCollectioncol},#{isDelete}";
	
	public String getSearchSql(BuyerCollectionQuery query){
	String sql="select "+columns+" FROM T_BUYER_COLLECTION where 1=1 ";
	if(!StringUtil.isEmpty(query.getBuyerId())){
		sql+="and BUYER_ID='"+query.getBuyerId()+"'";
	}
	sql+="limit #{startRow},#{endRow}";
	return sql;
	}
	
	public String getSearchSqlCount(BuyerCollectionQuery query){
		String sql="select count(*) FROM T_BUYER_COLLECTION where 1=1 ";
		if(!StringUtil.isEmpty(query.getBuyerId())){
			sql+="and BUYER_ID='"+query.getBuyerId()+"'";
		}
		return sql;
		}
}