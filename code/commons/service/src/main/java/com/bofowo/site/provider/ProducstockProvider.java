/** Project Name:lymall-service
 * File Name:CategoryProvider.java
 * Package Name:com.bofowo.site.provider
 * Date:2016年3月17日下午11:56:22
 * Copyright (c) 2016, 404886 Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.site.provider;

import com.bofowo.site.query.ProducstockQuery;

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
public class ProducstockProvider {
	
																																																																																																																																																	
	public String columns="ID,SHOP_ID,SELLER_ID,ITEM_ID,PROP_ID,PROP_NAME,PROP_VALUE,STOCK_NUM,LEFT_NUM,IMAGE,PRICE,SPEC_ID,SPEC_NAME,SPEC_VALUE";
																																																																																																																																																		
	public String property="#{id},#{shopId},#{sellerId},#{itemId},#{propId},#{propName},#{propValue},#{stockNum},#{leftNum},#{image},#{price},#{specId},#{specName},#{specValue}";
	
	public String getSearchSql(ProducstockQuery query){
	String sql="select "+columns+" FROM T_PRODUCT_STOCK where 1=1 ";

	sql+="limit #{startRow},#{endRow}";
	return sql;
	}
	
	public String getSearchSqlCount(ProducstockQuery query){
		String sql="select count(*) FROM T_PRODUCT_STOCK where 1=1 ";

		sql+="limit #{startRow},#{endRow}";
		return sql;
		}
}