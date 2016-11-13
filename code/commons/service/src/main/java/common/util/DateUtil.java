package common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




/**
 * ClassName:DateUtil
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   ThinkPad
 * @version  
 * @since    Ver 1.1
 * @Date	 2011-12-28		上午12:04:30
 *
 * @see 	 
 * @deprecated 
 */
public class DateUtil
{
	
	private  static Logger log = LoggerFactory.getLogger(DateUtil.class);

	public static Date toDate(String str)
	{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try
		{
			return sdf.parse(str);
		}
		catch (ParseException e)
		{
			
			// TODO Auto-generated catch block
			log.error(e.getMessage());
			
		}
		return null;
	}
	public static Date toDateWithoutHHMMSS(String str)
	{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try
		{
			return sdf.parse(str);
		}
		catch (ParseException e)
		{
			log.error(e.getMessage());
		}
		return null;
	}	
	
	public static String toDateStr(Date str)
	{
		if(str==null)
			return "";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			return sdf.format(str);

	}	
	
	public static String toDateWithoutyms(Date str)
	{
		
		SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");

			return sdf.format(str);

	}
	
	
	
	/**
	 * 时间显示规则：当日的时间显示格式为：小时：分钟。
	 * 三天之内的时间显示格式为：昨天，前天。
	 * 三天以上今年之内的时间显示格式为：月日。
	 * 今年之前的时间显示格式为：年月日。（适用于评论、咨询页面等等需要显示时间的板块）
	* @Title: toString
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @param date
	* @param @return    设定文件
	* @return String    返回类型
	* @date 2015年5月29日
	* @author 陈勋
	* @throws
	 */
	public static String toString(Date date)
	{
		
		if(date==null){
			return "";
		}
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		return sdf.format(date);
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String temp=sdf.format(date);
		Date now=new Date();
		Calendar d1 = new GregorianCalendar();  
        d1.setTime(date);  
        Calendar d2 = new GregorianCalendar();  
        d2.setTime(now);  
        int days = d2.get(Calendar.DAY_OF_YEAR)- d1.get(Calendar.DAY_OF_YEAR);
        
		if(date.getYear()!=now.getYear()){
			temp=temp.substring(0,10);  //年月日
		}	  
		else if(days>2)
			temp=temp.substring(5,10);   //月日		
		else if(days==2)
			temp="前天";
		else if(days==1)
			temp="昨天";
		else if(days==0){
		   temp=temp.substring(11,16);  //时分
		}

			
		
		return temp;
		
	}
	
	public static String toSimpleDateString(Date date)
	{
		if(date==null){
			return "";
		}
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	
	}
	
	
	/**
	 * 
	* @Title: isSameDate
	* @Description: TODO(是否同一周)
	* @param @param date1
	* @param @param date2
	* @param @return    设定文件
	* @return boolean    返回类型
	* @date 2015年5月29日
	* @author 陈勋
	* @throws
	 */
	public static boolean isSameDate(Date date1,Date date2)
	 {
	  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");


	  Calendar cal1 = Calendar.getInstance();
	  Calendar cal2 = Calendar.getInstance();
	  cal1.setTime(date1);
	  cal2.setTime(date2);
	  int subYear = cal1.get(Calendar.YEAR)-cal2.get(Calendar.YEAR);
	  //subYear==0,说明是同一年
	  if(subYear == 0)
	  {
	   if(cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR))
	    return true;
	  }
	    return false;
	 }
	
	

	public static Date parseDate(String startDate) throws ParseException
	{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return	sdf.parse(startDate);
		
	}
	
	public static String toStringWidthoutHHMMSS(Date date)
	{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		return	sdf.format(date);	
	}
	
	public static Date parseDateWidthoutHHMMSS(String date) throws ParseException
	{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try
		{
			return	sdf.parse(date);
		}
		catch (ParseException e)
		{
			throw e;
		}
			
	}
	
	public static Date addDayDate(Date date,int i)
	{
		date= new Date(date.getTime()+i*24*3600*1000l);
		return date;
	}
	/**
	 *  
	* @Title: DateDiff
	* @Description: TODO(返回时间差的字符表达date1- date2)
	* 60分钟内：**分钟。
	* 24小时内：**小时；
	* 超过一天一周内: **几周
	* 1月前、超过之后就是精确到日的日期，例如：2010-4-29.
	* @param @param date1
	* @param @param date2
	* @param @return    
	* @return String    
	* @author ChenXun
	* @date 2015年4月29日
	* @throws
	 */
	public static String DateDiff(Date date1,Date date2){
		
		  long diff=date1.getTime()-date2.getTime();
	      long minutes= diff /(1000 * 60 );
	      long hours=diff/(1000*60*60);
	      long days=diff/(1000*60*60*24);
          if(minutes<1){
        	  return "刚刚";
          }
	      
	      if(minutes<60){ //分钟
	    	 return minutes+"分钟前";
	      }
	      else if(hours<24){
	    	  return hours+"小时前";
	      }
	      else if(days<7){
	    	  return days+"天前";
	      }
	      else if(days<31){
	    	  return days/7+"周前";
	      }
	      
	      SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		  return	sdf.format(date2);	
	
	}
	
	
	/*** *************************************2015-07-01*******************************************/
	
	/**
	 * 获取给定时间所在周的第一天(Sunday)的日期和最后一天(Saturday)的日期
	 * 
	 * @param calendar
	 * @return Date数组，[0]为第一天的日期，[1]最后一天的日期
	 */
	public static Date[] getWeekStartAndEndDate(Calendar calendar) {
		Date[] dates = new Date[2];
		Date firstDateOfWeek, lastDateOfWeek;
		// 得到当天是这周的第几天
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		// 减去dayOfWeek,得到第一天的日期，因为Calendar用０－６代表一周七天，所以要减一
		calendar.add(Calendar.DAY_OF_WEEK, -(dayOfWeek - 1));
		firstDateOfWeek = calendar.getTime();
		// 每周7天，加６，得到最后一天的日子
		calendar.add(Calendar.DAY_OF_WEEK, 6);
		lastDateOfWeek = calendar.getTime();

		dates[0] = firstDateOfWeek;
		dates[1] = lastDateOfWeek;
		return dates;
	}

	/**
	 * 获取给定时间所在月的第一天Ｆ的日期和最后一天的日期
	 * 
	 * @param calendar
	 * @return Date数组，[0]为第一天的日期，[1]最后一天的日期
	 */
	public static Date[] getMonthStartAndEndDate(Calendar calendar) {
		Date[] dates = new Date[2];
		Date firstDateOfMonth, lastDateOfMonth;
		// 得到当天是这月的第几天
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		// 减去dayOfMonth,得到第一天的日期，因为Calendar用０代表每月的第一天，所以要减一
		calendar.add(Calendar.DAY_OF_MONTH, -(dayOfMonth - 1));
		firstDateOfMonth = calendar.getTime();
		// calendar.getActualMaximum(Calendar.DAY_OF_MONTH)得到这个月有几天
		calendar.add(Calendar.DAY_OF_MONTH,
				calendar.getActualMaximum(Calendar.DAY_OF_MONTH) - 1);
		lastDateOfMonth = calendar.getTime();

		dates[0] = firstDateOfMonth;
		dates[1] = lastDateOfMonth;
		return dates;
	}
	
	
	/**
	 * 获取当前日期和当前日期一个月后的日期
	 * 
	 * @param calendar
	 * @return Date数组，[0]为第一天的日期，[1]加上一个月之后的日期
	 */
	public static String[] getMonthAddOnemonth() {
		
		Calendar calendar = Calendar.getInstance();
		
		String[] dates = new String[2];
		Date firstDateOfMonth, lastDateOfMonth;
		firstDateOfMonth = calendar.getTime();
		calendar.add(Calendar.MONTH,1);
		lastDateOfMonth = calendar.getTime();
		
		
		 
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		String firstDateOfMonthString = sdf1.format(firstDateOfMonth);

		dates[0] = firstDateOfMonthString;
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		String lastDateOfMonthStr = sdf1.format(lastDateOfMonth);

		dates[1] = lastDateOfMonthStr;
		return dates;
	}
	
	
	
	
	/**
	 * 获取给定时间所在月的前三个月和前三个月最后一天的日期
	 * 
	 * @param calendar
	 * @return Date数组，[0]为第一天的日期，[1]最后一天的日期
	 */
	public static Date[] getNearlyThreeMonthsEndDate(Calendar calendar) {
		Date[] dates = new Date[2];
		Date firstDateOfMonth, lastDateOfMonth;
		
		
		
		   int month1 = calendar.get(Calendar.MONTH);
		   calendar.set(calendar.MONTH, month1-3);
		   calendar.set(calendar.DAY_OF_MONTH,1);
		   firstDateOfMonth = calendar.getTime();  
		   

		   Calendar endCalendar = Calendar.getInstance();
		   int month = endCalendar.get(endCalendar.MONTH);
		   endCalendar.set(endCalendar.MONTH, month-1);
		   endCalendar.set(endCalendar.DAY_OF_MONTH,endCalendar.getActualMaximum(endCalendar.DAY_OF_MONTH));  
		   lastDateOfMonth = endCalendar.getTime();  
		
		
		
		
		dates[0] = firstDateOfMonth;
		dates[1] = lastDateOfMonth;
		return dates;
	}
	
	/**
	 * 获取获取当前月的第一天和最后一天
	 * 
	 * @param calendar
	 * @return Date数组，[0]为第一天的日期，[1]最后一天的日期
	 */
	public static Date[] getTheMonthStateEndDate(Calendar calendar) {
		Date[] dates = new Date[2];
		Date firstDateOfMonth, lastDateOfMonth;
		
		
		
		   int month1 = calendar.get(Calendar.MONTH);
		   calendar.set(calendar.MONTH, month1);
		   calendar.set(calendar.DAY_OF_MONTH,1);
		   firstDateOfMonth = calendar.getTime();  
		   

		   Calendar endCalendar = Calendar.getInstance();
		   int month = endCalendar.get(endCalendar.MONTH);
		   endCalendar.set(endCalendar.MONTH, month);
		   endCalendar.set(endCalendar.DAY_OF_MONTH,endCalendar.getActualMaximum(endCalendar.DAY_OF_MONTH));  
		   lastDateOfMonth = endCalendar.getTime();  
		
		
		
		
		dates[0] = firstDateOfMonth;
		dates[1] = lastDateOfMonth;
		return dates;
	}

	public static String[] getWeekStartAndEndDate() {
		String array[] = new String[2];
		DateUtil dateUtil = new DateUtil();
		Calendar now = Calendar.getInstance();
		Date[] weekDates = dateUtil.getWeekStartAndEndDate(now);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		array[0] = format.format(weekDates[0]);
		array[1] = format.format(weekDates[1]);
		return array;
	}
	
	/**
	 * 当前日期的前三个月记录，不包含本月
	 * @return
	 */
	public static String[] getNearlyThreeMonthsAndEndDate() {
		String array[] = new String[2];
		DateUtil dateUtil = new DateUtil();
		Calendar now = Calendar.getInstance();
		Date[] weekDates = dateUtil.getNearlyThreeMonthsEndDate(now);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		array[0] = format.format(weekDates[0]);
		array[1] = format.format(weekDates[1]);
		return array;
	}
	
	
	/**
	 * 当前日期的第一天和最后一天
	 * @return
	 */
	public static String[] getTheMonthStateEndDate() {
		String array[] = new String[2];
		DateUtil dateUtil = new DateUtil();
		Calendar now = Calendar.getInstance();
		Date[] weekDates = dateUtil.getTheMonthStateEndDate(now);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		array[0] = format.format(weekDates[0]);
		array[1] = format.format(weekDates[1]);
		return array;
	}


	public static String[] getMonthStartAndEndDate() {
		String array[] = new String[2];
		DateUtil dateUtil = new DateUtil();
		Calendar now = Calendar.getInstance();
		Date[] weekDates = dateUtil.getMonthStartAndEndDate(now);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		array[0] = format.format(weekDates[0]);
		array[1] = format.format(weekDates[1]);
		return array;
	}
	
	/**
	 * Gets the current date next date.
	 * 当前日期后一天
	 * @return the current date next date
	 */
	public static String getCurrentDateAfterDate(Calendar calendar) {
		calendar.add(Calendar.DAY_OF_MONTH, +1);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(calendar.getTime());
	}
	
	/**
	 * Gets the current date before date.
	 * 当前日期前一天
	 * @return the current date before date
	 */
	public static String getCurrentDateBeforeDate(Calendar calendar) {
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(calendar.getTime());
	}
	
	/**
	 * Gets the current date.
	 * 当前日期
	 * @return the current date
	 */
	public static String getCurrentDate() {
		Calendar now = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(now.getTime());
	}
	
	

//	public static void main(String[] args) {
//
//		DateUtil dateUtil = new DateUtil();
//		Calendar now = Calendar.getInstance();
//		Date[] weekDates = dateUtil.getWeekStartAndEndDate(now);
//		Date[] monthDates = dateUtil.getMonthStartAndEndDate(now);
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		System.out.println("firstDateOfWeek: " + format.format(weekDates[0])
//				+ " ,lastDateOfWeek: " + format.format(weekDates[1]));
//		System.out.println("firstDateOfMonth: " + format.format(monthDates[0])
//				+ " ,lastDateOfMonth: " + format.format(monthDates[1]));
//
//	}

	public static long getBetweenDate(Date startDate,Date endDate){
		if(startDate==null||endDate==null){
			return 0;
		}
		long  betweenValue=endDate.getTime()-startDate.getTime();
		if(betweenValue>0){
			return betweenValue/1000;
		}
		return 0;
		
	}
	
	
	public static String getNowDateTime(){
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		String result = sdf.format(date);
		
		
		return result;
	}
	
   public static String getNowDateTimeforymd(){
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String result = sdf.format(date);
		
		
		return result;
	}
   
   /**
    * 格式yyyyMMdd
    * @return
    */
   public static String getNowDateymd(){
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String result = sdf.format(date);
		return result;
	}
   
   public static void getTestMesages(){
	   
	   Calendar calendar1 = Calendar.getInstance();  
	   int month1 = calendar1.get(Calendar.MONTH);
	   calendar1.set(calendar1.MONTH, month1-3);
	   calendar1.set(calendar1.DAY_OF_MONTH,1);
	   Date strDateTo1 = calendar1.getTime();  
	   SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
	   System.out.println(sdf1.format(strDateTo1));;
	   
	   Calendar calendar = Calendar.getInstance();  
	   int month = calendar.get(Calendar.MONTH);
	   calendar.set(Calendar.MONTH, month-1);
	   calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DAY_OF_MONTH));  
	   Date strDateTo = calendar.getTime();  
	   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	   System.out.println(sdf.format(strDateTo));
	   
	   
	   
   }
   
   public static void getTestMesages2(){
	   
	   Calendar calendar1 = Calendar.getInstance();  
	   int month1 = calendar1.get(Calendar.MONTH);
	   calendar1.set(calendar1.MONTH, month1);
	   calendar1.set(calendar1.DAY_OF_MONTH,1);
	   Date strDateTo1 = calendar1.getTime();  
	   SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
	   System.out.println(sdf1.format(strDateTo1));;
	   
	   Calendar calendar = Calendar.getInstance();  
	   int month = calendar.get(Calendar.MONTH);
	   calendar.set(Calendar.MONTH, month);
	   calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DAY_OF_MONTH));  
	   Date strDateTo = calendar.getTime();  
	   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	   System.out.println(sdf.format(strDateTo));
	   
	   
	   
   }
   
   /**
    * 时间戳转date
    * @param unixDate
    * @return
    */
   public static String getDate(String unixDate) {
	   
	   SimpleDateFormat fm1 = new SimpleDateFormat();
	   SimpleDateFormat fm2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	   long unixLong = 0;
	   String date = "";
	   try {
	   unixLong = Long.parseLong(unixDate)*1000;
	   } catch(Exception ex) {
	   System.out.println("String转换Long错误，请确认数据可以转换！");
	   }
	   try {
	   //date = fm1.format(unixLong);
	   date = fm2.format(new Date(unixLong));
	   } catch(Exception ex) {
	   System.out.println("String转换Date错误，请确认数据可以转换！");
	   }
	   return date;
	   }
   
//   public static void main(String arge[]){
//	   String[] arry = getMonthAddOnemonth();
//		   System.out.println(arry[0]+"==="+arry[1]);
//   }
   
   



	
}

