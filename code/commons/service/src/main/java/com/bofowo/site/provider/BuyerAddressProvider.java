/** Project Name:lymall-service
 * File Name:CategoryProvider.java
 * Package Name:com.bofowo.site.provider
 * Date:2016年3月17日下午11:56:22
 * Copyright (c) 2016, 404886 Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.site.provider;

import com.bofowo.site.query.BuyerAddressQuery;

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
public class BuyerAddressProvider {
	
																																																																																																																													
	public String columns="ID,BUYER_ID,PROVINCE,CITY,AREA,ADDRESS,POST_CODE,REAL_NAME,MOBILE,TELE,IS_DEFAULT,IS_DELETE";
																																																																																																																														
	public String property="#{id},#{buyerId},#{province},#{city},#{area},#{address},#{postCode},#{realName},#{mobile},#{tele},#{isDefault},#{isDelete}";
	
	public String getSearchSql(BuyerAddressQuery query){
	String sql="select "+columns+" FROM T_BUYER_ADDRESS where 1=1 ";
	if(!StringUtil.isEmpty(query.getBuyerId())){
		sql+="and BUYER_ID='"+query.getBuyerId()+"' ";
	}
	sql+="limit #{startRow},#{endRow}";
	return sql;
	}
	
	public String getSearchSqlCount(BuyerAddressQuery query){
		String sql="select count(*) FROM T_BUYER_ADDRESS where 1=1 ";
		if(!StringUtil.isEmpty(query.getBuyerId())){
			sql+="and BUYER_ID='"+query.getBuyerId()+"' ";
		}
		return sql;
		}
}