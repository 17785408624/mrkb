/**
 * FileName:         UserLoginException.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-5-31     下午3:50:17
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-5-31     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.dao.modle.exception;

/**
 *@param
 *@return
 * @author moerka-1
 *
 */
public class LoginExceptionMedifood extends Exception{
	/**  
	  * @Fields serialVersionUID :            TODO
	  */   
	private static final long serialVersionUID = 1L;
	String message; // 定义String类型变量 
	
	  public LoginExceptionMedifood(String ErrorMessagr) { // 父类方法 
	    message = ErrorMessagr; 
	  } 
	   
	  public String getMessage() { // 覆盖getMessage()方法 
	    return message; 
	  } 

}
