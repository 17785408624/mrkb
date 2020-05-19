/**
 * FileName:         ReflectUtil.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-3-30     上午10:52:23
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-3-30     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @param
 * @return
 * @author zrm
 * 
 */
public class DateUtil {
	// 返回int类型的年
	public static int yearNowInt() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		return year;// 2019
	}

	// 返回int类型的年月
	public static int monthNowInt() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		String months=String.valueOf(month);
		if(month<10){
			months="0"+month;
		}
		int mon = Integer.valueOf(year + months);
		return mon;// 201901
	}

	// 返回int类型的年月日
	public static int dayNowInt() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		String months=String.valueOf(month);
		if(month<10){
			months="0"+month;
		}
		int days = cal.get(cal.DATE);
		String dayss=String.valueOf(days);
		if(days<10){
			dayss="0"+days;
		}
		int day = Integer.valueOf(year + months + dayss);
		return day;// 20190101
	}
	// 返回long类型本月第一天.13位精确到秒
	public static long getMonStart(){
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmmss");
		Calendar calendar2 = Calendar.getInstance();
		calendar2.add(Calendar.MONTH, 0);// 月
		calendar2.set(Calendar.DAY_OF_MONTH, 1);// 日
		calendar2.set(Calendar.HOUR_OF_DAY, 0);// 时
		calendar2.set(Calendar.MINUTE, 0);// 分
		calendar2.set(Calendar.SECOND, 0);// 秒
		String lastDay = sdf1.format(calendar2.getTime());
		Date firstdateStart = null;
		try {
			firstdateStart = sdf1.parse(lastDay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Long start_time = Long.valueOf(firstdateStart.getTime());
		return start_time;
	}
	//返回long类型下月第一天.精确到秒
	public static long getNextMonStart(){
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmmss");
		Calendar calendar3 = Calendar.getInstance();
		calendar3.add(Calendar.MONTH, 1);// 月
		calendar3.set(Calendar.DAY_OF_MONTH, 1);// 日
		calendar3.set(Calendar.HOUR_OF_DAY, 0);// 时
		calendar3.set(Calendar.MINUTE, 0);// 分
		calendar3.set(Calendar.SECOND, 0);// 秒
		String endDay = sdf1.format(calendar3.getTime());
		Date lastdateStart = null;
		try {
			lastdateStart = sdf1.parse(endDay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Long end_time = Long.valueOf(lastdateStart.getTime());
		return end_time;
	}
}