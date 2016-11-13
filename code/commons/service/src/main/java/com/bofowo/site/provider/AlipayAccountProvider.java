/** Project Name:lymall-service
 * File Name:CategoryProvider.java
 * Package Name:com.bofowo.site.provider
 * Date:2016年3月17日下午11:56:22
 * Copyright (c) 2016, 404886 Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.site.provider;

import com.bofowo.site.query.AlipayAccountQuery;

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
public class AlipayAccountProvider {
	
																																																																	
	public String columns="ID,SELLER_ID,ALI_PAY_ACCOUNT,CREATE_TIME,MODIFY_TIME,STATUS";
																																																																		
	public String property="#{id},#{sellerId},#{aliPayAccount},#{createTime},#{modifyTime},#{status}";
	
	public String getSearchSql(AlipayAccountQuery query){
	String sql="select "+columns+" FROM T_ALIPAY_ACCOUNT where 1=1 ";

	sql+="limit #{startRow},#{endRow}";
	return sql;
	}
	
	public String getSearchSqlCount(AlipayAccountQuery query){
		String sql="select count(*) FROM T_ALIPAY_ACCOUNT where 1=1 ";

		sql+="limit #{startRow},#{endRow}";
		return sql;
		}
}