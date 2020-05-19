package com.mrkb.common.util;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 
 * @author MR.Chen
 *
 */
public class DateUtil {
	private final static SimpleDateFormat SDF_YEAR = new SimpleDateFormat("yyyy");

	private final static SimpleDateFormat SDF_DAY= new SimpleDateFormat(
			"yyyy-MM-dd");
	
	private final static SimpleDateFormat SDF_DAYS = new SimpleDateFormat(
			"yyyyMMdd");

	private final static SimpleDateFormat SDF_TIME = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	/**
	 * 获取YYYY格式
	 * 
	 * @return
	 */
	public static String getYear() {
		return SDF_YEAR.format(new Date());
	}

	/**
	 * 获取YYYY-MM-DD格式
	 * 
	 * @return
	 */
	public static String getDay() {
		return SDF_DAY.format(new Date());
	}
	
	/**
	 * 获取YYYYMMDD格式
	 * 
	 * @return
	 */
	public static String getDays(){
		return SDF_DAYS.format(new Date());
	}

	/**
	 * 获取YYYY-MM-DD HH:mm:ss格式
	 * 
	 * @return
	 */
	public static String getTime() {
		return SDF_TIME.format(new Date());
	}

	/**
	* @author MR.Chen
	* @Title: compareDate
	* @Description: TODO(日期比较，如果s>=e 返回true 否则返回false)
	* @param s
	* @param e
	* @return boolean  
	* @throws
	 */
	public static boolean compareDate(String s, String e) {
		if(fomatDate(s)==null||fomatDate(e)==null){
			return false;
		}
		return fomatDate(s).getTime() >=fomatDate(e).getTime();
	}

	/**
	 * 格式化日期
	 * 
	 * @return
	 */
	public static Date fomatDate(String date) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return fmt.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 校验日期是否合法
	 * 
	 * @return
	 */
	public static boolean isValidDate(String s) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			fmt.parse(s);
			return true;
		} catch (Exception e) {
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			return false;
		}
	}
	public static int getDiffYear(String startTime,String endTime) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			int years=(int) (((fmt.parse(endTime).getTime()-fmt.parse(startTime).getTime())/ (1000 * 60 * 60 * 24))/365);
			return years;
		} catch (Exception e) {
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			return 0;
		}
	}
	  /**
     * <li>功能描述：时间相减得到天数
     * @param beginDateStr
     * @param endDateStr
     * @return
     * long 
     * @author Administrator
     */
    public static long getDaySub(String beginDateStr,String endDateStr){
        long day=0;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate = null;
        Date endDate = null;
        
            try {
				beginDate = format.parse(beginDateStr);
				endDate= format.parse(endDateStr);
			} catch (ParseException e) {
				e.printStackTrace();
			}
            day=(endDate.getTime()-beginDate.getTime())/(24*60*60*1000);
            //System.out.println("相隔的天数="+day);
      
        return day;
    }
    
    /**
     * 得到n天之后的日期
     * @param days
     * @return
     */
    public static String getAfterDayDate(String days) {
    	int daysInt = Integer.parseInt(days);
    	// java.util包
        Calendar canlendar = Calendar.getInstance();
        // 日期减 如果不够减会将月变动
        canlendar.add(Calendar.DATE, daysInt); 
        Date date = canlendar.getTime();
        
        SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdfd.format(date);
        
        return dateStr;
    }
    
    /**
     * 得到n天之后是周几
     * @param days
     * @return
     */
    public static String getAfterDayWeek(String days) {
    	int daysInt = Integer.parseInt(days);
    	// java.util包
        Calendar canlendar = Calendar.getInstance(); 
        // 日期减 如果不够减会将月变动
        canlendar.add(Calendar.DATE, daysInt); 
        Date date = canlendar.getTime();
        
        SimpleDateFormat sdf = new SimpleDateFormat("E");
        String dateStr = sdf.format(date);
        
        return dateStr;
    }
    
    public static void main(String[] args) {
    	//System.out.println(getDays());
    	/*System.out.println("1526617800="+stampToDate("1526617800"));*/
		/*System.out.println(dateSubMini(new Date(),DateUtil.strToDate("2018-6-9 13:49:23", "yyyy-MM-dd HH:mm:ss")));*/

		/*DateToStr(new Date());*/
		getDistanceTime("2018-6-9 15:14:22","2018-6-9 15:15:22");
		System.out.println(getDistanceTime("2018-6-9 15:15:22","2018-6-9 15:15:22"));
    }



    public static Date stampToDate(String s){
      
        long lt = new Long(s);
        Date  date = new Date(lt*1000);
   
        return date;
    }
    
	public static String LongToDate(String time) throws ParseException {
	    String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(time);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;    
    }
	
	
	
	
	/**
	 * @author MR.Chen
	 * @comments 格式化时间格式为数字
	 * @time 2018年5月8日 上午11:27:01
	 * @param startDate
	 * @throws ParseException 
	 * @returnType int
	 * @modification
	 */
    public static int formatDate(Date startDate){  
    	/*Date date=null; 
	    SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	    try {
			date=formatter.parse(startDate);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new BizException("DateUtil.getDayString","转换时间",ErrorCode.ERROR_NONE.getMsg(),ErrorCode.ERROR_CODE.getCode());
		} */
        int offSet = Calendar.getInstance().getTimeZone().getRawOffset();  
        long today = (System.currentTimeMillis()+offSet)/86400000;  
        long start = (startDate.getTime()+offSet)/86400000;  
        return (int) (start-today);  
    }
    
    
    
    /**
     * @author MR.Chen
     * @comments 获取今天明天后天时间字符串
     * @time 2018年5月8日 上午11:31:16
     * @returnType String
     * @modification
     */
    public static String getStringDate(Date startDate) {
	    SimpleDateFormat formatter=new SimpleDateFormat("HH:mm");
	    String date=formatter.format(startDate);
    	String time="";
    	switch (formatDate(startDate)) {
		case -2:
			time ="前天"+date;
			break;
		case -1:
			time ="昨天"+date;
			break;
		case 0:
			time ="今天"+date;
			break;
		case 1:
			time ="明天"+date;
			break;
		case 2:
			time ="后天"+date;
			break;
		default:
			time =startDate.toString();
			break;
		}
		return time;
    }

	public static int dateSub(Date endDate, Date nowDate) {
		  long nd = 1000 * 60 * 60;
		  int diff =(int)(nowDate.getTime()-endDate.getTime());
		  return (int)(diff/nd);
	}
	
	
	/**
	 * @author MR.Chen
	 * @comments 时间相减（分钟为单位）
	 * @time 2018年5月10日 下午5:47:21
	 * @param endDate
	 * @param nowDate
	 * @returnType int
	 * @modification
	 */
	public static int dateSubMini(Date endDate, Date nowDate) {
		  long nd = 1000 * 60;
		  int diff =(int)(nowDate.getTime()-endDate.getTime());
		System.out.println((int)(diff/nd));
		  return (int)(diff/nd);
	}
	
	
	public static boolean isOverlap(String startdate1, String enddate1,String startdate2, String enddate2) {    
        Date leftStartDate = null;    
        Date leftEndDate = null;    
        Date rightStartDate = null;    
        Date rightEndDate = null;   
        
        try {    
            leftStartDate = SDF_TIME.parse(startdate1);    
            leftEndDate = SDF_TIME.parse(enddate1);    
            rightStartDate = SDF_TIME.parse(startdate2);    
            rightEndDate = SDF_TIME.parse(enddate2);    
        } catch (ParseException e) {    
            return false;
        }    
        
        long diff = leftStartDate.getTime() - rightStartDate.getTime();//这样得到的差值是微秒级别  
        long days = diff / (1000 * 60 * 60 * 24);  
        long hours = (diff-days*(1000 * 60 * 60 * 24))/(1000* 60 * 60);  
        long minutes = (diff-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60))/(1000* 60);  
        System.out.println("开始时间相差："+days+"天"+hours+"小时"+minutes+"分");
        
        long diffs = leftEndDate.getTime() - rightEndDate.getTime();//这样得到的差值是微秒级别  
        long dayss = diffs / (1000 * 60 * 60 * 24);  
        long hourss = (diffs-dayss*(1000 * 60 * 60 * 24))/(1000* 60 * 60);  
        long minutess = (diffs-dayss*(1000 * 60 * 60 * 24)-hourss*(1000* 60 * 60))/(1000* 60);  
        System.out.println("结束时间相差："+dayss+"天"+hourss+"小时"+minutess+"分");  
       
        return     
            ((leftStartDate.getTime() >= rightStartDate.getTime())     
                    && leftStartDate.getTime() < rightEndDate.getTime())    
            ||    
            ((leftStartDate.getTime() > rightStartDate.getTime())     
                    && leftStartDate.getTime() <= rightEndDate.getTime())    
            ||    
            ((rightStartDate.getTime() >= leftStartDate.getTime())     
                    && rightStartDate.getTime() < leftEndDate.getTime())    
            ||    
            ((rightStartDate.getTime() > leftStartDate.getTime())     
                    && rightStartDate.getTime() <= leftEndDate.getTime());    
                
        
    }




	/**
	 * 字符串转换为时间
	 *
	 * @param date
	 * @param formateType
	 * @return
	 */
	public static Date strToDate(String date, String formateType) {
		SimpleDateFormat dateformat = new SimpleDateFormat(formateType);
		if (date == null || "".equals(date)) {
			return null;
		}
		Date formatedate = null;
		try {
			formatedate = dateformat.parse(date);
		} catch (ParseException e) {
			return formatedate;
		}
		return formatedate;
	}


	/**
	 * 日期转换成字符串
	 * @return
	 */
	public static String DateToStr(Date date){
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.format(date);
		return  sdf.format(date);
	}


	/**
	 * 计算时间相差
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static long getDistanceTime(String str1, String str2) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date one;
		Date two;
		long day = 0;
		long hour = 0;
		long min = 0;
		long sec = 0;
		try {
			one = df.parse(str1);
			two = df.parse(str2);
			long time1 = one.getTime();
			long time2 = two.getTime();
			long diff ;
			if(time1<time2) {
				diff = time2 - time1;
			} else {
				diff = time1 - time2;
			}
			day = diff / (24 * 60 * 60 * 1000);
			hour = (diff / (60 * 60 * 1000) - day * 24);
			min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
			sec = (diff/1000-day*24*60*60-hour*60*60-min*60);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return min;
	}
}
