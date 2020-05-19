/**
 * FileName:         ReadFontByteProperties.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-6-1     上午11:24:42
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-6-1     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.common.utils.serviceutil.serviceutilimpl;

import java.io.InputStream;
import java.util.Properties;



/**
 *@param
 *@return
 * @author moerka-1
 *
 */
public class ReadFontByteProperties {

	    static private String fontByteStr = null;
	    static {
	        loads();
	    }
	    synchronized static public void loads() {
	        if (fontByteStr == null) {
	            InputStream is = ReadFontByteProperties.class.getResourceAsStream("/fontByte.properties");
	            Properties dbproperties = new Properties();
	            try {
	                dbproperties.load(is);
	                fontByteStr = dbproperties.getProperty("fontByteStr").toString();
	            } catch (Exception e) {
	                //System.err.println("不能读取属性文件. " + "请确保fontByte.properties在CLASSPATH指定的路径中");
	            }
	        }
	    }
	    public static String getFontByteStr() {
	        if (fontByteStr == null)
	            loads();
	        return fontByteStr;
	    }
	}

