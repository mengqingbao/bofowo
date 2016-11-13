package common.util;

import java.util.HashMap;
import java.util.Map;

public class ContentTranslate {
	public static Map<String,String> map=new HashMap<String,String>(){{
		put("1","valid");put("0","invalid");}};

	public static String getValidateString(String str){
		return map.get(str);
	}

}
