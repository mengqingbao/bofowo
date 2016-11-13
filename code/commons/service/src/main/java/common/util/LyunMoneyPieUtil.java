package common.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LyunMoneyPieUtil {
	
	
	/**
	 * 判断当前集合是否包含目标类别名称
	 * @param typeName
	 * @param tempMap
	 * @return
	 */
	public static boolean checkTheListHasTheMap(String typeId,Map<String, Double> tempMap){
		boolean flag = false;
		Iterator it = tempMap.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry entry = (Map.Entry) it.next();
			   String key = (String) entry.getKey();
			   if(key.equals(typeId)){
				   flag = true;
			   }
		}
		return flag;
	}
	

	/**
	 * 设置制定类别的值
	 * @param typeName
	 * @param tempMap
	 * @param tempValue
	 */
	public static void setTheMapValue(String typeId,Map<String, Double> tempMap,Double tempValue){
		Iterator it = tempMap.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry entry = (Map.Entry) it.next();
				   String key = (String) entry.getKey();
				  
				   if(key.equals(typeId)){
					   Double value = (Double) entry.getValue();
					   tempMap.put(typeId, value+tempValue);
					   break;
				   }
				   
			   }
	}
	
	/**
	 * 获取所有类别所占的百分比
	 * @param tempMap
	 * @param sumValue
	 * @return
	 */
	public static Map<String, Double> getPercentMap(Map<String, Double> tempMap,Double sumValue){
		
		java.text.DecimalFormat df = new java.text.DecimalFormat("#.0000");
		Map<String, Double> allPercentMapList = new HashMap<String, Double>();//保存各类别的所占的百分比
		
		 Iterator it = tempMap.entrySet().iterator();
		  while (it.hasNext()) {
		   Map.Entry entry = (Map.Entry) it.next();
		   String key = (String) entry.getKey();
		   Double value = (Double) entry.getValue();
		        Double percentValue =   Double.valueOf(df.format(value/sumValue));
		        allPercentMapList.put(key, percentValue);
		  }
		return allPercentMapList;
	}

}
