package com.bofowo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebUtils {

	private static Logger log = LoggerFactory.getLogger(WebUtils.class);
	public static String sendHttp(String url, Object parameters)
			throws Exception {
		String outStr = "";
		System.out.println("请求的url............................" + url);
		try {
			String charSet = "UTF-8";
			String timeOut = "30000";// 自行配置
			outStr = HttpClientHelper.doHttp(url, charSet, parameters, timeOut);
			if (outStr == null) {
				throw new Exception("请求接口失败!");
			}
			System.out.println("outStr=" + outStr);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new Exception("请求接口失败!");
		}
		return outStr;
	}
}