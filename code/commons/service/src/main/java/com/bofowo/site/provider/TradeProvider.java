/** Project Name:lymall-service
 * File Name:CategoryProvider.java
 * Package Name:com.bofowo.site.provider
 * Date:2016年3月17日下午11:56:22
 * Copyright (c) 2016, 404886 Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.site.provider;

import com.bofowo.site.query.TradeQuery;

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
public class TradeProvider {
	
																																																																																																																																																																					
	public String columns="ID,TITLE,TOTAL,REAL_PAY,STATUS,PIC,NUM,NOTE,PRODUCT_ID,SHOP_PRACE,SELLER_ID,BUYER_ID,SHOP_NAME,PAY_WAY,CREATED_TIME,MODIFY_TIME";
																																																																																																																																																																						
	public String property="#{id},#{title},#{total},#{realPay},#{status},#{pic},#{num},#{note},#{productId},#{shopPrace},#{sellerId},#{buyerId},#{shopName},#{payWay},#{createdTime},#{modifyTime}";
	
	public String getSearchSql(TradeQuery query){
	String sql="select "+columns+" FROM T_TRADE where 1=1 ";
	if(!StringUtil.isEmpty(query.getByerId())){
		sql+="AND BUYER_ID='"+query.getByerId()+"' ";
	}
	if(!StringUtil.isEmpty(query.getSellerId())){
		sql+="AND SELLER_ID='"+query.getSellerId()+"' ";
	}
	if(!StringUtil.isEmpty(query.getStatus())&&!"0".equals(query.getStatus())){
		sql+="AND STATUS='"+query.getStatus()+"' ";
	}
	sql+="limit #{startRow},#{endRow}";
	return sql;
	}
	
	public String getSearchSqlCount(TradeQuery query){
		String sql="select count(*) FROM T_TRADE where 1=1 ";
		if(!StringUtil.isEmpty(query.getByerId())){
			sql+="AND BUYER_ID='"+query.getByerId()+"' ";
		}
		if(!StringUtil.isEmpty(query.getSellerId())){
			sql+="AND SELLER_ID='"+query.getSellerId()+"' ";
		}
		if(!StringUtil.isEmpty(query.getStatus())&&!"0".equals(query.getStatus())){
			sql+="AND STATUS='"+query.getStatus()+"' ";
		}
		sql+="limit #{startRow},#{endRow}";
		return sql;
		}
}