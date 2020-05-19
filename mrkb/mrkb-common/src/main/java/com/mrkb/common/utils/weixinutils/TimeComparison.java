package com.mrkb.common.utils.weixinutils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
*
* @author hp
*/
public class TimeComparison {

  //  public static void main(String args[]) {
   //    int i= compare_date("1995-11-12 15:21:00", "1999-12-11 09:59:00");
   //    System.out.println("i=="+i);
   // }

    public  boolean compare_date(String DATE1, String DATE2) {
        
        
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            if (dt1.getTime() > dt2.getTime()) {
              
                return true;
            } else if (dt1.getTime() < dt2.getTime()) {
               
                return false;
            } else {
                return false;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return false;
    }
}