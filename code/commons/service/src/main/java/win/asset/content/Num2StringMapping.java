/**
 * Project Name:lymall-service
 * File Name:Num2StringMapping.java
 * Package Name:win.asset.content
 * Date:2016年8月3日下午8:13:14
 * Copyright (c) 2016,Shanghai bofowo Technology co., Ltd. All Rights Reserved.
 *
*/

package win.asset.content;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName:Num2StringMapping <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年8月3日 下午8:13:14 <br/>
 * @author   mqb
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class Num2StringMapping {
	public final static Map productStatusMap = new HashMap();  
	static {  
		productStatusMap.put("saling", "1");  
		productStatusMap.put("store", "2");
		productStatusMap.put("illegal", "3");  
		productStatusMap.put("off", "4"); 
		productStatusMap.put("checking", "5");  
		productStatusMap.put("refused", "6");  
	}
	

	

}

