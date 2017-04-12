/** Project Name:lymall-service
 * File Name:CategoryProvider.java
 * Package Name:com.lyun.site.provider
 * Date:2016年3月17日下午11:56:22
 * Copyright (c) 2016, 404886 Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.site.provider;

import com.bofowo.site.query.BuyerBrowseHistoryQuery;

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
public class BuyerBrowseHistoryProvider {
	
																																																							
	public String columns="PID,CREATED_DATE,BUYER_ID,TIMES,LAST_VISIT_DATE";
																																																								
	public String property="#{pid},#{createdDate},#{buyerId},#{times},#{lastVisitDate}";
	
	public String getSearchSql(BuyerBrowseHistoryQuery query){
	String sql="select "+columns+" FROM T_BUYER_BROWSE_HISTORY where 1=1 ";

	sql+="limit #{startRow},#{endRow}";
	return sql;
	}
	
	public String getSearchSqlCount(BuyerBrowseHistoryQuery query){
		String sql="select count(*) FROM T_BUYER_BROWSE_HISTORY where 1=1 ";

		sql+="limit #{startRow},#{endRow}";
		return sql;
		}
}