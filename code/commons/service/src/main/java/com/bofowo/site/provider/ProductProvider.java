/** Project Name:lymall-service
 * File Name:CategoryProvider.java
 * Package Name:com.bofowo.site.provider
 * Date:2016年3月17日下午11:56:22
 * Copyright (c) 2016, 404886 Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.site.provider;

import com.bofowo.site.query.ProductQuery;

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
public class ProductProvider {
	
																																																																																																																																																																																																																																																																									
	public String columns="ID,NAME,TRADEMARK_ID,MARKET_PRICE,SHOP_PRICE,TYPE_,CODE,CONTENT,SHOP_CATEGORY_ID,SHOP_STATUS,STATUS,IS_RECOMMEND,SEO_KEY,SEO_CONTENT,SEO_TITLE,TIGLIB,PL_BENEFIT,ORDER_,CATEGORY_ID,SHOP_ID,SELLER_ID,CREATED_TIME,MODIFIED_TIME,MODIFIER,NUM,IMAGES";
																																																																																																																																																																																																																																																																										
	public String property="#{id},#{name},#{trademarkId},#{marketPrice},#{shopPrice},#{type},#{code},#{content},#{shopCategoryId},#{shopStatus},#{status},#{isRecommend},#{seoKey},#{seoContent},#{seoTitle},#{tiglib},#{plBenefit},#{order},#{categoryId},#{shopId},#{sellerId},#{createdTime},#{modifiedTime},#{modifier},#{num},#{images}";
	
	public String getSearchSql(ProductQuery query){
	String sql="select "+columns+" FROM T_PRODUCT where 1=1 ";
	if(!StringUtil.isEmpty(query.getType())){
		sql+="and STATUS='"+query.getType()+"'";
	}
	if(query.getShopId()!=null){
		sql+="and SHOP_ID='"+query.getShopId()+"' ";
	}
	if(query.getCateId()!=null){
		sql+="and SHOP_CATEGORY_ID='"+query.getCateId()+"' ";
	}
	if(!StringUtil.isEmpty(query.getTablie())){
		sql+="and TIGLIB='"+query.getTablie()+"' ";
	}
	if(!StringUtil.isEmpty(query.getKeyWord())){
		sql+="and NAME like '%"+query.getKeyWord()+"%' ";
	}
	sql+="limit #{startRow},#{endRow}";
	return sql;
	}
	
	public String getSearchSqlCount(ProductQuery query){
		String sql="select count(*) FROM T_PRODUCT where 1=1 ";
		if(!StringUtil.isEmpty(query.getType())){
			sql+="and STATUS='"+query.getType()+"'";
		}
		if(query.getShopId()!=null){
			sql+="and SHOP_ID='"+query.getShopId()+"' ";
		}
		if(query.getCateId()!=null){
			sql+="and SHOP_CATEGORY_ID='"+query.getCateId()+"' ";
		}
		if(!StringUtil.isEmpty(query.getTablie())){
			sql+="and TIGLIB='"+query.getTablie()+"' ";
		}
		if(!StringUtil.isEmpty(query.getKeyWord())){
			sql+="and NAME like '%"+query.getKeyWord()+"%' ";
		}
		return sql;
		}
}