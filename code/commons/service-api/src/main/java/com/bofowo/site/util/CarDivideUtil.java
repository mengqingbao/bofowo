/**
 * Project Name:bfwmall-web
 * File Name:CarDivideUtil.java
 * Package Name:com.bofowo.site.util
 * Date:2016年11月25日下午11:14:45
 * Copyright (c) 2016, BOFOWO Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.bofowo.site.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bofowo.site.biz.model.CarCountItem;
import com.bofowo.site.model.CarModel;

/**
 * ClassName:CarDivideUtil <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年11月25日 下午11:14:45 <br/>
 * @author   mqb
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class CarDivideUtil {

	public static Map<String, CarCountItem> toDivide(List<CarModel> cars) {
		Map<String,CarCountItem> result=new HashMap<String,CarCountItem>();
		for(CarModel car:cars){
			String sellerId=car.getSellerId();
			CarCountItem cci=result.get(sellerId);
			if(cci==null){
				cci=new CarCountItem();
			}
			cci.addCarModel(car);
			result.put(sellerId, cci);
		}
		return result;
	}

}

