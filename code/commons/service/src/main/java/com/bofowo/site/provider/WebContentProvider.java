/** Project Name:lymall-service
 * File Name:CategoryProvider.java
 * Package Name:com.bofowo.site.provider
 * Date:2016年3月17日下午11:56:22
 * Copyright (c) 2016, 404886 Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.site.provider;

import com.bofowo.site.query.WebContentQuery;

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
public class WebContentProvider {
	
																																																																																																																																																																																																			
	public String columns="ID,TITLE,AUTHOR,FROM_,CREATE_DATE,MODIFY_DATE,CREATOR,MODIFIER,CONTENT_A,CONTENT_B,CONTENT_C,CATEGORY_ID,STATUS,IS_DELETE,DESC_,TAG_LIB_ID,SEO_TITTLE,SEO_KEY,SEO_DESC";
																																																																																																																																																																																																				
	public String property="#{id},#{title},#{author},#{from},#{createDate},#{modifyDate},#{creator},#{modifier},#{contentA},#{contentB},#{contentC},#{categoryId},#{status},#{isDelete},#{desc},#{tagLibId},#{seoTittle},#{seoKey},#{seoDesc}";
	
	public String getSearchSql(WebContentQuery query){
	String sql="select "+columns+" FROM WebContent where 1=1 ";

	sql+="limit #{startRow},#{endRow}";
	return sql;
	}
	
	public String getSearchSqlCount(WebContentQuery query){
		String sql="select count(*) FROM WebContent where 1=1 ";

		sql+="limit #{startRow},#{endRow}";
		return sql;
		}
}