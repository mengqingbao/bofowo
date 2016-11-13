/** Project Name:lymall-service
 * File Name:CategoryProvider.java
 * Package Name:com.bofowo.site.provider
 * Date:2016年3月17日下午11:56:22
 * Copyright (c) 2016, 404886 Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.site.provider;

import com.bofowo.site.query.OrderQuery;

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
public class OrderProvider {
	
																																																																																																																																																																																									
	public String columns="ID,ITEM_ID,TITLE,PIC,NUM,PRICE,TOTAL,STATUS,REAL_PAY,PROPERTIES,SPEC,TID,NOTE,SELLER_ID,BUYER_ID,PAY_WAY,CREATED_TIME,MODIFY_TIME";
																																																																																																																																																																																										
	public String property="#{id},#{itemId},#{title},#{pic},#{num},#{price},#{total},#{status},#{realPay},#{properties},#{spec},#{tid},#{note},#{sellerId},#{buyerId},#{payWay},#{createdTime},#{modifyTime}";
	
	public String getSearchSql(OrderQuery query){
	String sql="select "+columns+" FROM T_ORDER where 1=1 ";

	sql+="limit #{startRow},#{endRow}";
	return sql;
	}
	
	public String getSearchSqlCount(OrderQuery query){
		String sql="select count(*) FROM T_ORDER where 1=1 ";

		sql+="limit #{startRow},#{endRow}";
		return sql;
		}
}