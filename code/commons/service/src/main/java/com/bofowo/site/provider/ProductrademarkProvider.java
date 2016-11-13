/** Project Name:lymall-service
 * File Name:CategoryProvider.java
 * Package Name:com.bofowo.site.provider
 * Date:2016年3月17日下午11:56:22
 * Copyright (c) 2016, 404886 Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.site.provider;

import com.bofowo.site.query.ProductrademarkQuery;

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
public class ProductrademarkProvider {
	
																																																																																																																			
	public String columns="ID,NAME,DESC_,LOGO_IMG,MODIFY_DATE,CREATOR,SHOP_ID,SELLER_ID,T_PRODUCT_TRADEMAR,CREATED_DATE,STATUS";
																																																																																																																				
	public String property="#{id},#{name},#{desc},#{logoImg},#{modifyDate},#{creator},#{shopId},#{sellerId},#{tProductTrademar},#{createdDate},#{status}";
	
	public String getSearchSql(ProductrademarkQuery query){
	String sql="select "+columns+" FROM T_PRODUCT_TRADEMARK where 1=1 ";
	if(!StringUtil.isEmpty(query.getSellerId())){
		sql+="AND SELLER_ID='"+query.getSellerId()+"'";
	}
	sql+="limit #{startRow},#{endRow}";
	return sql;
	}
	
	public String getSearchSqlCount(ProductrademarkQuery query){
		String sql="select count(*) FROM T_PRODUCT_TRADEMARK where 1=1 ";
		if(!StringUtil.isEmpty(query.getSellerId())){
			sql+="AND SELLER_ID='"+query.getSellerId()+"' ";
		}
		return sql;
		}
}