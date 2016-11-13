/** Project Name:lymall-service
 * File Name:CategoryProvider.java
 * Package Name:com.bofowo.site.provider
 * Date:2016年3月17日下午11:56:22
 * Copyright (c) 2016, 404886 Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.site.provider;

import com.bofowo.site.query.TaglibQuery;

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
public class TaglibProvider {
	
																																																																																																									
	public String columns="ID,NAME,TYPE,STATUS,IS_DELETE,CREATED_DATE,MODIFIED_DATE,DESC_,SELLER_ID,SHOP_ID";
																																																																																																										
	public String property="#{id},#{name},#{type},#{status},#{isDelete},#{createdDate},#{modifiedDate},#{desc},#{sellerId},#{shopId}";
	
	public String getSearchSql(TaglibQuery query){
	String sql="select "+columns+" FROM T_TAGLIB where 1=1 ";

	sql+="limit #{startRow},#{endRow}";
	return sql;
	}
	
	public String getSearchSqlCount(TaglibQuery query){
		String sql="select count(*) FROM T_TAGLIB where 1=1 ";

		sql+="limit #{startRow},#{endRow}";
		return sql;
		}
}