package org.mybatis.spring;

import common.security.login.CurrentUserUtil;

public class DataDomian {
	public static String getDataBaseId(){
		if("test01".equals(CurrentUserUtil.getCurrentUserName())){
			return "dataSource1";
		}else{
			return "dataSource2";
		}
	}
}
