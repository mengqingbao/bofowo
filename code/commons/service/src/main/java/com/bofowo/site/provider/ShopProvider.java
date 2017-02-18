/** Project Name:lymall-service
 * File Name:CategoryProvider.java
 * Package Name:com.bofowo.site.provider
 * Date:2016年3月17日下午11:56:22
 * Copyright (c) 2016, 404886 Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.site.provider;

import com.bofowo.site.query.ShopQuery;

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
public class ShopProvider {
	
																																																																																																																																																																																																																																																																																																																																																									
	public String columns="ID,NAME,DESC_,LOGO_IMG,CREATOR,URL,OWNER_,CREATED_TIME,SERVICE_SCORE_TOTAL,DRAW_SCORE_TOTAL,POST_SCORE_TOTAL,COMMENT_TIMES,LEVEL_,NOTICE,HEADER,LAYOUT,LAYOUT_COLUMN_TOTAL,FOOTER,ORDER_,STATUS_,BODY,SHOP_ID,SELLER_ID,TYPE_,ADDRESS,TELE,QQ,WANGWANG,SEO_KEY,SEO_CONTENT,PROVINCE,CITY,AREA,CATEGORY_ID";
																																																																																																																																																																																																																																																																																																																																																										
	public String property="#{id},#{name},#{desc},#{logoImg},#{creator},#{url},#{owner},#{createdTime},#{serviceScoreTotal},#{drawScoreTotal},#{postScoreTotal},#{commentTimes},#{level},#{notice},#{header},#{layout},#{layoutColumnTotal},#{footer},#{order},#{status},#{body},#{shopId},#{sellerId},#{type},#{address},#{tele},#{qq},#{wangwang},#{seoKey},#{seoContent},#{province},#{city},#{area},#{categoryId}";
	
	public String getSearchSql(ShopQuery query){
	String sql="select "+columns+" FROM T_SHOP where 1=1 ";

	sql+="limit #{startRow},#{endRow}";
	return sql;
	}
	
	public String getSearchSqlCount(ShopQuery query){
		String sql="select count(*) FROM T_SHOP where 1=1 ";

		sql+="limit #{startRow},#{endRow}";
		return sql;
		}
}