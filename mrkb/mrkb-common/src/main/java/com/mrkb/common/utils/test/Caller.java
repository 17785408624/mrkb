package com.mrkb.common.utils.test;

public class Caller {  
    public CallBackInterface clallBack;  
      
    public void setCaller(CallBackInterface callBack){  
        this.clallBack = callBack;  
    }  
    public void clall(){  
        this.clallBack.method();  
    }  
}  
