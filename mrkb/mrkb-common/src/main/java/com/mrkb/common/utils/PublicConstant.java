/**
 * FileName:         PublicConstant.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-2-6     下午8:19:58
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-2-6     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.common.utils;

import java.io.UnsupportedEncodingException;

/**
 *@param
 *@return
 * @author moerka-1
 *
 */
public class PublicConstant {
	public static String getTomcatProjectPath(){//获取项目在tomcat中的绝对路径
		
		
		try {
			return java.net.URLDecoder.decode(PublicConstant.getTomcatProjectPath().getClass().getResource("/").getFile().toString(),"utf-8").replace("\\", "/");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}
