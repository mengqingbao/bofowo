/** Project Name:lymall-service
 * File Name:CategoryProvider.java
 * Package Name:com.lyun.site.provider
 * Date:2016年3月17日下午11:56:22
 * Copyright (c) 2016, 404886 Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.site.provider;

import com.bofowo.site.query.ProductaglibQuery;

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
public class ProductaglibProvider {
	
																																																																																																									
	public String columns="ID,PRODUCT_ID,TAGLIB,ABLE_DATA,TAGLIB_ID,TYPE_,ORDER_,STATUS,SELLER_ID,SHOP_ID";
																																																																																																										
	public String property="#{id},#{productId},#{taglib},#{ableData},#{taglibId},#{type},#{order},#{status},#{sellerId},#{shopId}";
	
	public String getSearchSql(ProductaglibQuery query){
	String sql="select "+columns+" FROM T_PRODUCT_TAGLIB where 1=1 ";

	sql+="limit #{startRow},#{endRow}";
	return sql;
	}
	
	public String getSearchSqlCount(ProductaglibQuery query){
		String sql="select count(*) FROM T_PRODUCT_TAGLIB where 1=1 ";

		sql+="limit #{startRow},#{endRow}";
		return sql;
		}
}