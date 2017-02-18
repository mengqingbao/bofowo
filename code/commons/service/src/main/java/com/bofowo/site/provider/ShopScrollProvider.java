/** Project Name:lymall-service
 * File Name:CategoryProvider.java
 * Package Name:com.lyun.site.provider
 * Date:2016年3月17日下午11:56:22
 * Copyright (c) 2016, 404886 Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.site.provider;

import com.bofowo.site.query.ShopScrollQuery;

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
public class ShopScrollProvider {
	
																																																																																					
	public String columns="ID,URL,TITLE,DESC_,PIC,SELLER_ID,STATUS,SHOP_ID,PUSH_INDEX";
	
	public String property="#{id},#{url},#{title},#{desc},#{pic},#{sellerId},#{status},#{shopId},#{pushIndex}";
																																																																																			
	
	public String getSearchSql(ShopScrollQuery query){
	String sql="select "+columns+" FROM T_SHOP_SCROLL where 1=1 ";
	if(!StringUtil.isEmpty(query.getCurrentUserName())){
		sql+="and SELLER_ID='"+query.getCurrentUserName()+"' ";
	}
	if(!StringUtil.isEmpty(query.getStatus())){
		sql+="and STATUS='"+query.getStatus()+"' ";
	}
	if(!StringUtil.isEmpty(query.getPushIndex())){
		sql+="and PUSH_INDEX='"+query.getPushIndex()+"' ";
	}
	sql+="limit #{startRow},#{endRow}";
	return sql;
	}
	
	public String getSearchSqlCount(ShopScrollQuery query){
		String sql="select count(*) FROM T_SHOP_SCROLL where 1=1 ";
		if(!StringUtil.isEmpty(query.getCurrentUserName())){
			sql+="and SELLER_ID='"+query.getCurrentUserName()+"' ";
		}
		if(!StringUtil.isEmpty(query.getStatus())){
			sql+="and STATUS='"+query.getStatus()+"' ";
		}
		if(!StringUtil.isEmpty(query.getPushIndex())){
			sql+="and PUSH_INDEX='"+query.getPushIndex()+"' ";
		}
		return sql;
		}
}