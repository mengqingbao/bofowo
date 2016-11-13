/** Project Name:lymall-service
 * File Name:CategoryProvider.java
 * Package Name:com.bofowo.site.provider
 * Date:2016年3月17日下午11:56:22
 * Copyright (c) 2016, 404886 Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.site.provider;

import com.bofowo.site.query.TradeConsoleQuery;

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
public class TradeConsoleProvider {
	
																																																																																					
	public String columns="ID,ASKER_ID,ANSWER_ID,TYPE_,CONTEN,CREATE_TIME,PID,STATUS";
																																																																																						
	public String property="#{id},#{askerId},#{answerId},#{type},#{conten},#{createTime},#{pid},#{status}";
	
	public String getSearchSql(TradeConsoleQuery query){
	String sql="select "+columns+" FROM T_TRADE_CONSOLE where 1=1 ";
	if(!StringUtil.isEmpty(query.getAnswerId())){
		sql+="and ANSWER_ID='"+query.getAnswerId()+"' ";
	}
	if(!StringUtil.isEmpty(query.getAskerId())){
		sql+="and ASKER_ID='"+query.getAskerId()+"' ";
	}
	sql+="limit #{startRow},#{endRow}";
	return sql;
	}
	
	public String getSearchSqlCount(TradeConsoleQuery query){
		String sql="select count(*) FROM T_TRADE_CONSOLE where 1=1 ";
		if(!StringUtil.isEmpty(query.getAnswerId())){
			sql+="and ANSWER_ID='"+query.getAnswerId()+"' ";
		}
		if(!StringUtil.isEmpty(query.getAskerId())){
			sql+="and ASKER_ID='"+query.getAskerId()+"' ";
		}
		sql+="limit #{startRow},#{endRow}";
		return sql;
		}
}