/** Project Name:lymall-service
 * File Name:CategoryProvider.java
 * Package Name:com.bofowo.site.provider
 * Date:2016年3月17日下午11:56:22
 * Copyright (c) 2016, 404886 Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.site.provider;

import com.bofowo.site.query.ShopCategoryQuery;

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
public class ShopCategoryProvider {
	
																																																																																																																																																											
	public String columns="ID,NAME,IMAGE,DESC_,CREATOR,CREATED_TIME,CHECKER,CHECKED_TIME,MODIFIER,MODIFIED_TIME,STATUS,TYPE,CONTENT,SELLER_ID,SHOP_ID";
																																																																																																																																																												
	public String property="#{id},#{name},#{image},#{desc},#{creator},#{createdTime},#{checker},#{checkedTime},#{modifier},#{modifiedTime},#{status},#{type},#{content},#{sellerId},#{shopId}";
	
	public String getSearchSql(ShopCategoryQuery query){
	String sql="select "+columns+" FROM T_SHOP_CATEGORY where 1=1 ";
	if(!StringUtil.isEmpty(query.getSellerId())){
		sql+="AND SELLER_ID='"+query.getSellerId()+"' ";
	}
	if(!StringUtil.isEmpty(query.getShopId())){
		sql+="AND SHOP_ID='"+query.getShopId()+"' ";
	}
	sql+="ORDER BY ORDER_ limit #{startRow},#{endRow} ";
	return sql;
	}
	
	public String getSearchSqlCount(ShopCategoryQuery query){
		String sql="select count(*) FROM T_SHOP_CATEGORY where 1=1 ";
		if(!StringUtil.isEmpty(query.getSellerId())){
			sql+="AND SELLER_ID='"+query.getSellerId()+"' ";
		}
		if(!StringUtil.isEmpty(query.getShopId())){
			sql+="AND SHOP_ID='"+query.getShopId()+"' ";
		}
		return sql;
		}
}