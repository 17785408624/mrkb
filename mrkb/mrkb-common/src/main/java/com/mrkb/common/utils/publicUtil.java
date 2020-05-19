package com.mrkb.common.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

public class publicUtil {
	/**
	 * csz
	 * @Title:             isNum
	 * @Description:     TODO 判断字符串能否转为数字
	 * @param:             @param str 字符串对象
	 * @param:             @return   
	 * @return:         boolean   可以转换返回true 转换异常返回false
	 * @throws
	 */
	public static boolean isNum(String str) {// 判断字符串能否转为数字
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}

	}
    /**
     * 
     * @Title:             dataTransform
     * @Description:     TODO 字符串与时间戳相互转换
     * @param:             @param param 字符串必须为yyyy-MM-dd HH:mm:ss格式 时间戳必须为13位
     * @param:             @return   
     * @return:         Object   
     * @throws
     */
	public static Object dataTransform(Object param) {// 字符串与时间戳相互转换
		Object returnParam = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (param instanceof Long) {// 参数为时间戳
			returnParam = format.format(param);
		} else {// 参数为字符串
			Date date;
			try {
				date = format.parse(String.valueOf(param));
				returnParam = date.getTime();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return returnParam;
	}
    /**
     * 
     * @Title:             dataTransform
     * @Description:     TODO 字符串与时间戳相互转换
     * @param:             @param param 时间参数可以为时间戳或字符串 
     * @param:             @param format 自定义字符串形式
     * @param:             @return   
     * @return:         Object   
     * @throws
     */
	public static Object dataTransform(Object param, SimpleDateFormat format) {// 字符串与时间戳相互转换
		Object returnParam = null;
		if (param instanceof Long) {// 参数为时间戳
			returnParam = format.format(param);
		} else if(param instanceof Integer){//参数为int类型时间戳
			returnParam = format.format(param);
		}else {// 参数为字符串
			Date date;
			try {
				date = format.parse(String.valueOf(param));
				returnParam = date.getTime();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
		return returnParam;
	}

	public String replace(String str, char oldChar, char newChar) {
		if (oldChar != newChar) {
            int len = str.length();
			int i = -1;
			char[] val = str.toCharArray(); /* avoid getfield opcode */
			int off = 1; /* avoid getfield opcode */

			while (++i < len) {
				if (val[off + i] == oldChar) {
					break;
				}
			}
			if (i < len) {
				char buf[] = new char[len];
				for (int j = 0; j < i; j++) {
					buf[j] = val[off + j];
				}
				while (i < len) {
					char c = val[off + i];
					buf[i] = (c == oldChar) ? newChar : c;
					i++;
				}
				return new String(val);
			}
		}
		return str;
	}
/**
 * 
 * @Title:             getIpAddr
 * @Description:     TODO 获取pc端前端访问的ip地址
 * @param:             @param request HttpServletRequest
 * @param:             @return   
 * @return:         String   ip地址
 * @throws
 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if (ip.equals("0:0:0:0:0:0:0:1")) {
			ip = "本地";
		}
		 // 多个路由时，取第一个非unknown的ip
	    final String[] arr = ip.split(",");
	    for (final String str : arr) {
	        if (!"unknown".equalsIgnoreCase(str)) {
	        	ip = str;
	            break;
	        }
	    }
	 
	    return ip;
	}
	public static boolean isUser_basics_id(int num){//判断是否为用户id类型的数字
		return true;
		
	}
	public static boolean isInformation_card(String str){//判断是否为身份证号类型的数字
		return true;
		
	}
	public static boolean isInformation_phone(int num){//判断是否为手机号类型的数字
		return true;
		
	}
	public static boolean isNick_name(String str){//判断是否为用户昵称类型的字符串
		return true;
		
	}
	public static boolean isInformation_compellation(String str){//判断是否为用户姓名类型的字符串
		return true;
		
	}
	public static boolean isUser_account_num(String str){//判断是否为用户账号类型的字符串
		return true;
		
	}
	public static boolean isWeixin_nickname(String str){//判断是否为用户微信昵称类型的字符串
		return true;
		
	}
	/**
	 * 
	 * @Title:             orderList
	 * @Description:     TODO 将list排序
	 * @param:             @param list 集合
	 * @param:             @param orderField 排序的字段
	 * @param:             @param orderRule 规则ASC升序  DESC降序
	 * @return:         void   
	 * @throws
	 */
    public static List orderList(List list,String orderField,String orderRule){
    	return list;
    	
    }
    /**
     * 还原utf8数据库中保存的含转换后emoji表情的字符串
     * @param str
     * @return
     */
    public static String emojiRecovery(String str) {
    	if(str==null){
    		return "";
    	}
        String patternString = "\\[\\[(.*?)\\]\\]";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while(matcher.find()) {
            try {
                matcher.appendReplacement(sb,
                        URLDecoder.decode(matcher.group(1), "UTF-8"));
            } catch(UnsupportedEncodingException e) {
                return "";
            }
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
    
}
