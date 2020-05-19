package com.mrkb.dao.modle.exception;

public class RemittanceException extends Exception{//打款错误

	 /**  
	  * @Fields serialVersionUID :            TODO
	  */ 
	
	private static final long serialVersionUID = 1L;
	String message; // 定义String类型变量 
	public RemittanceException(String ErrorMessagr) { // 父类方法 
	    message = ErrorMessagr; 
	  } 
	   
	  public String getMessage() { // 覆盖getMessage()方法 
	    return message; 
	  } 

}
