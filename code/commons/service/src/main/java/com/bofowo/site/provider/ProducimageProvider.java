/** Project Name:lymall-service
 * File Name:CategoryProvider.java
 * Package Name:com.bofowo.site.provider
 * Date:2016年3月17日下午11:56:22
 * Copyright (c) 2016, 404886 Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.site.provider;

import com.bofowo.site.query.ProducimageQuery;

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
public class ProducimageProvider {
	
																																																																											
	public String columns="ID,ITEM_ID,PATH,STATUS,SELLER_ID,CREATED_DATE,SHOP_ID";
																																																																												
	public String property="#{id},#{itemId},#{path},#{status},#{sellerId},#{createdDate},#{shopId}";
	
	public String getSearchSql(ProducimageQuery query){
	String sql="select "+columns+" FROM T_PRODUCT_IMAGE where 1=1 ";

	sql+="limit #{startRow},#{endRow}";
	return sql;
	}
	
	public String getSearchSqlCount(ProducimageQuery query){
		String sql="select count(*) FROM T_PRODUCT_IMAGE where 1=1 ";

		sql+="limit #{startRow},#{endRow}";
		return sql;
		}
}