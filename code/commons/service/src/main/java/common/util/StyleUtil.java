package common.util;

import java.util.HashMap;
import java.util.Map;

public class StyleUtil {
	
	private static Map map=new HashMap(){};
	
	public static String getClass(String key){
		if("reporting".equals(key)){
			return "glyphicon-list-alt";
		}
		if("home".equals(key)){
			return "glyphicon-home";
		}
		if("webcontent".equals(key)){
			return "glyphicon-font";
		}
		if("topic".equals(key)){
			return "glyphicon-leaf";
		}
		if("doc".equals(key)){
			return "glyphicon-file";
		}
		if("help".equals(key)){
			return "glyphicon-wrench";
		}
		if("account".equals(key)){
			return "glyphicon-user";
		}
		return "glyphicon-tasks";
	}
	
	public static String getMethodType(String key){
		if("reporting".equals(key)){
			return "ajax-link";
		}
		if("webcontent".equals(key)){
			return "ajax-link";
		}
		return "accordion";
	}
}
