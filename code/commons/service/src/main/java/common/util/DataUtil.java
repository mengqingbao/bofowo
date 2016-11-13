package common.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONBuilder;

/**
 * 
* @ClassName: DataUtil
* @Description: TODO(数据处理)
* @author 陈勋
* @date 2015年8月3日 上午10:23:48
*
 */
public class DataUtil {

	/**、
	 * 
	* @Title: toJsonString
	* @Description: TODO(转成json字符串)
	* @param @param obj
	* @param @return    设定文件
	* @return String    返回类型
	* @date 2015年8月3日
	* @author 陈勋
	* @throws
	 */
	public static  String toJsonString(Object obj){
		if(obj==null)
			return "";	
		if(obj.getClass().isArray()||obj instanceof Collection||obj instanceof Map)
			return JSONArray.fromObject(obj).toString();	
		return JSONObject.fromObject(obj).toString();
	} 
	

}
