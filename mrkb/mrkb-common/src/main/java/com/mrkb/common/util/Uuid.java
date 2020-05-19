package com.mrkb.common.util;

import java.text.DecimalFormat;
import java.util.UUID;



public class Uuid {

	
	public static String getUUid(){
		java.util.Random r=new java.util.Random();
	    //如生成的随机位数不足6位则自动加零补充
		DecimalFormat g=new DecimalFormat("1000000");
	    //返回时间增量+随机数的序列
		return String.format("%s%s",System.currentTimeMillis(),g.format(r.nextInt(1000000)));
	}
	
	public static String getUUIDStr(){
        UUID uuid=UUID.randomUUID();
        String str = uuid.toString(); 
        String uuidStr=str.replace("-", "");
        return uuidStr;
      }

	
	public static void main(String[] args) {
		String s="1554689993";
		System.out.println(getUUIDStr());
	}
}
