package com.mrkb.common.utils.test;

public class Main implements CallBackInterface{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 Caller caller = new Caller();  
	        caller.setCaller(new Main());  
	        caller.clall();  
	    }  
	  
	    public void method() {  
	        System.out.println("回调");  
	    }  

	

}
