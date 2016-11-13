package common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class LyunDateUtil {

	/**
	 * 日期转字符
	 * @param str
	 * @return
	 */
	public static String toDateStr(Date str){
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
			return sdf.format(str);

	}	

	/**
	 * 字符转日期
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date parse(String date) throws ParseException{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 
	  return	format.parse(date);
		 
		   
		   
	}
	
	
	/**
	 * 昨天
	 * @return
	 */
	public static String matter(){
		Calendar   cal   =   Calendar.getInstance();
		  cal.add(Calendar.DATE,   -1);
		  cal.set(Calendar.HOUR_OF_DAY, 0);
		  cal.set(Calendar.SECOND, 0);
		  cal.set(Calendar.MINUTE, 0);
		  cal.set(Calendar.HOUR_OF_DAY, 23);
		  cal.set(Calendar.SECOND, 59);
		  cal.set(Calendar.MINUTE, 59);
		  return  new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss").format(cal.getTime());
		
	}
	/**
	 * 明天
	 * @return
	 */
	public static String tomorrow(){
		Calendar   cal   =   Calendar.getInstance();
		  cal.add(Calendar.DATE,   1);
		  cal.set(Calendar.HOUR_OF_DAY, 0);
		  cal.set(Calendar.SECOND, 0);
		  cal.set(Calendar.MINUTE, 0);
	
		  return  new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss").format(cal.getTime());
	}

}
