/**
 * FileName:         JsonUtils.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-3-27     下午2:43:42
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-3-27     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.common.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

/**
 *@param
 *@return
 * @author moerka-1
 *
 */
public class JsonUtils {
	/**
	 * 
	 * @Title:             getJsonStr
	 * @Description:     TODO 获取前端提交的json数据 并转换为json字符串
	 * @param:             @param request HttpServletRequest
	 * @param:             @return   json字符串
	 * @return:         String   
	 * @throws
	 */
	public static String getJsonStr(HttpServletRequest request) {//获取前端提交的json数据 并转换为json字符串
		String jsonStr="";
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			System.out.println("编码错误，转码utf-8失败");
			e1.printStackTrace();
		}
		ServletInputStream sis = null;
		try {
			sis=request.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		InputStreamReader isr = null;
		try {
			isr=new InputStreamReader(sis,"utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			System.out.println("编码错误，转码utf-8失败");
			e1.printStackTrace();
		}
		BufferedReader br=new BufferedReader(isr);
		String line=null;
		try {
			while((line=br.readLine())!=null){
				jsonStr+=line;
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonStr;
	}

}
