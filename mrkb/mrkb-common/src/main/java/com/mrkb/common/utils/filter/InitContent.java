/**
 * FileName:         InitContent.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-6-11     下午4:12:07
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

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *@param
 *@return
 * @author moerka-1
 *
 */
public class InitContent implements Filter{
	@Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
            throws IOException, ServletException {
        SysContent.setRequest((HttpServletRequest) arg0);
        SysContent.setResponse((HttpServletResponse) arg1);
        arg2.doFilter(arg0, arg1);
    }
	

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }
    @Override
    public void destroy() {
    }

}
