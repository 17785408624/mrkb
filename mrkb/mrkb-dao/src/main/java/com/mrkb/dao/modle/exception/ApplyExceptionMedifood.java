package com.mrkb.dao.modle.exception;

public class ApplyExceptionMedifood extends Exception{
	private static final long serialVersionUID = 1L;
	String message; // 定义String类型变量 
	
	  public ApplyExceptionMedifood(String ErrorMessagr) { // 父类方法 
	    message = ErrorMessagr; 
	  } 
	   
	  public String getMessage() { // 覆盖getMessage()方法 
	    return message; 
	  } 

}
