/** Project Name:lymall-service
 * File Name:CategoryProvider.java
 * Package Name:com.bofowo.site.provider
 * Date:2016年3月17日下午11:56:22
 * Copyright (c) 2016, 404886 Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.site.provider;

import com.bofowo.site.query.CustomerServiceQuery;

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
public class CustomerServiceProvider {
	
																																																																																																																																																																																																													
	public String columns="ID,BUYER_ID,SELLER_ID,TRADE_ID,ORDER_ID,NAME,PIC,PRICE,QUESTION,REPLAY,RESULT,SERVICER,TYPE,ITEM_ID,CREATED_TIME,REPLAY_TIME,END_TIME,SHOP_ID,SHOP_NAME,REPALY_RATE,STATUS,EXPRESS_CODE,EXPRESS_CONTENT";
	
	public String property="#{id},#{buyerId},#{sellerId},#{tradeId},#{orderId},#{name},#{pic},#{price},#{question},#{replay},#{result},#{servicer},#{type},#{itemId},#{createdTime},#{replayTime},#{endTime},#{shopId},#{shopName},#{repalyRate},#{status},#{expressCode},#{expressContent}";
	
	public String getSearchSql(CustomerServiceQuery query){
	String sql="select "+columns+" FROM T_CUSTOMER_SERVICE where 1=1 ";
	if(!StringUtil.isEmpty(query.getType())){
		sql+="and TYPE='"+query.getType()+"' ";
	}
	if(!StringUtil.isEmpty(query.getBuyerId())){
		sql+="and BUYER_ID='"+query.getBuyerId()+"' ";
	}
	if(!StringUtil.isEmpty(query.getSellerId())){
		sql+="and SELLER_ID='"+query.getSellerId()+"' ";
	}
	sql+="limit #{startRow},#{endRow}";
	return sql;
	}
	
	public String getSearchSqlCount(CustomerServiceQuery query){
		String sql="select count(*) FROM T_CUSTOMER_SERVICE where 1=1 ";
		if(!StringUtil.isEmpty(query.getType())){
			sql+="and TYPE='"+query.getType()+"' ";
		}
		if(!StringUtil.isEmpty(query.getBuyerId())){
			sql+="and BUYER_ID='"+query.getBuyerId()+"' ";
		}
		if(!StringUtil.isEmpty(query.getSellerId())){
			sql+="and SELLER_ID='"+query.getSellerId()+"' ";
		}
		return sql;
		}
}