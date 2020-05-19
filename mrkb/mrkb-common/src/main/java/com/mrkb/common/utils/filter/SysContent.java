/**
 * FileName:         SysContent.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-6-11     下午4:13:12
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-6-11     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.common.utils.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *@param
 *@return
 * @author moerka-1
 *
 */
public class SysContent {
	 private static ThreadLocal<HttpServletRequest> requestLocal = new ThreadLocal<HttpServletRequest>();
	    private static ThreadLocal<HttpServletResponse> responseLocal = new ThreadLocal<HttpServletResponse>();

	    public static HttpServletRequest getRequest() {
	        return (HttpServletRequest) requestLocal.get();
	    }

	    public static void setRequest(HttpServletRequest request) {
	        requestLocal.set(request);
	    }

	    public static HttpServletResponse getResponse() {
	        return (HttpServletResponse) responseLocal.get();
	    }

	    public static void setResponse(HttpServletResponse response) {
	        responseLocal.set(response);
	    }

	    public static HttpSession getSession() {
	        return (HttpSession) ((HttpServletRequest) requestLocal.get()).getSession();
	    }

}
