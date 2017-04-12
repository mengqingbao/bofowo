/** Project Name:lymall-service
 * File Name:CategoryProvider.java
 * Package Name:com.lyun.site.provider
 * Date:2016年3月17日下午11:56:22
 * Copyright (c) 2016, 404886 Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.site.provider;

import com.bofowo.site.query.SellerInfoQuery;

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
public class SellerInfoProvider {
	
																																																																																																																																																	
	public String columns="ID,NAME,ID_CARD,ID_CARD_PIC,DEPOSIT,TYPE_,STATUS,CREATED_DATE,CREATOR,USER_ID,SHOPER_NAME,COMPANY_CERT,PROXY_CERT,FIST_PROXY_CERT";
																																																																																																																																																		
	public String property="#{id},#{name},#{idCard},#{idCardPic},#{deposit},#{type},#{status},#{createdDate},#{creator},#{userId},#{shoperName},#{companyCert},#{proxyCert},#{fistProxyCert}";
	
	public String getSearchSql(SellerInfoQuery query){
	String sql="select "+columns+" FROM T_SELLER_INFO where 1=1 ";

	sql+="limit #{startRow},#{endRow}";
	return sql;
	}
	
	public String getSearchSqlCount(SellerInfoQuery query){
		String sql="select count(*) FROM T_SELLER_INFO where 1=1 ";

		sql+="limit #{startRow},#{endRow}";
		return sql;
		}
}