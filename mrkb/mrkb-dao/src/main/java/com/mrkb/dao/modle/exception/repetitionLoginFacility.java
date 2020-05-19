/**
 * FileName:         repetitionLoginFacility.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-6-13     下午1:22:40
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-6-13     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.dao.modle.exception;

/**
 *@param
 *@return
 * @author moerka-1
 *
 */
public class repetitionLoginFacility extends LoginExceptionMedifood{

	/**  
	  * @Fields serialVersionUID :            TODO
	  */   
	private static final long serialVersionUID = 1L;
	/**
	 * @Title:            repetitionLoginFacility
	 * @Description:    TODO
	 * @param:            @param ErrorMessagr
	 * @throws
	 */
	String message; // 定义String类型变量 
	public repetitionLoginFacility(String ErrorMessagr) {//同一设备重复登陆
		super(ErrorMessagr);
		message = ErrorMessagr; 
		// TODO Auto-generated constructor stub
	}
	 public String getMessage() { // 覆盖getMessage()方法 
		    return message; 
		  } 

}
