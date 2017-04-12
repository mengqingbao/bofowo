/** Project Name:lymall-service
 * File Name:CategoryProvider.java
 * Package Name:com.lyun.site.provider
 * Date:2016年3月17日下午11:56:22
 * Copyright (c) 2016, 404886 Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.site.provider;

import com.bofowo.site.query.PicSliderQuery;

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
public class PicSliderProvider {
	
																																																																																					
	public String columns="ID,TITLE,PIC,SELLER_ID,SHOP_ID,URL,DESC_,STATUS";
																																																																																						
	public String property="#{id},#{title},#{pic},#{sellerId},#{shopId},#{url},#{desc},#{status}";
	
	public String getSearchSql(PicSliderQuery query){
	String sql="select "+columns+" FROM T_PIC_SLIDER where 1=1 ";
	if(!StringUtil.isEmpty(query.getSellerId())){
		sql+="and SELLER_ID='"+query.getSellerId()+"' ";
	}
	sql+="limit #{startRow},#{endRow}";
	return sql;
	}
	
	public String getSearchSqlCount(PicSliderQuery query){
		String sql="select count(*) FROM T_PIC_SLIDER where 1=1 ";
		if(!StringUtil.isEmpty(query.getSellerId())){
			sql+="and SELLER_ID='"+query.getSellerId()+"' ";
		}
		sql+="limit #{startRow},#{endRow}";
		return sql;
		}
}