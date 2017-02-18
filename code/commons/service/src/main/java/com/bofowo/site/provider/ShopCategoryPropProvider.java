/** Project Name:lymall-service
 * File Name:CategoryProvider.java
 * Package Name:com.bofowo.site.provider
 * Date:2016年3月17日下午11:56:22
 * Copyright (c) 2016, 404886 Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.site.provider;

import com.bofowo.site.query.ShopCategoryPropQuery;

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
public class ShopCategoryPropProvider {
	
																																																																																															
	public String columns="ID,CATEGORY_ID,NAME,SELLER_ID,SHOP_ID,TYPE,INPUT_TYPE,INPUT_OPTION,STATUS";
																																																																																																
	public String property="#{id},#{categoryId},#{name},#{sellerId},#{shopId},#{type},#{inputType},#{inputOption},#{status}";
	
	public String getSearchSql(ShopCategoryPropQuery query){
	String sql="select "+columns+" FROM T_SHOP_CATEGORY_PROP where 1=1 ";
	if(!StringUtil.isEmpty(query.getType())){
		sql+="and TYPE='"+query.getType()+"' ";
	}
	if(!StringUtil.isEmpty(query.getCurrentUserName())){
		sql+="and SELLER_ID='"+query.getCurrentUserName()+"' ";
	}
	if(!StringUtil.isEmpty(query.getShopCateId())){
		sql+="and CATEGORY_ID='"+query.getShopCateId()+"' ";
	}
	sql+="limit #{startRow},#{endRow}";
	return sql;
	}
	
	public String getSearchSqlCount(ShopCategoryPropQuery query){
		String sql="select count(*) FROM T_SHOP_CATEGORY_PROP where 1=1 ";
		if(!StringUtil.isEmpty(query.getType())){
			sql+="and TYPE='"+query.getType()+"' ";
		}
		if(!StringUtil.isEmpty(query.getCurrentUserName())){
			sql+="and SELLER_ID='"+query.getCurrentUserName()+"' ";
		}
		return sql;
		}
}