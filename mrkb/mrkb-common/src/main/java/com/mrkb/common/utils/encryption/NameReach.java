package com.mrkb.common.utils.encryption;

public class NameReach {
	public static String getEncoding(String str) {        
	       String encode = "GB2312";        
	      try {        
	          if (str.equals(new String(str.getBytes(encode), encode))) {      //判断是不是GB2312  
	               String s = encode;        
	              return s;      //是的话，返回“GB2312“，以下代码同理  
	           }        
	       } catch (Exception exception) {        
	       }        
	       encode = "ISO-8859-1";        
	      try {        
	          if (str.equals(new String(str.getBytes(encode), encode))) {      //判断是不是ISO-8859-1  
	               String s1 = encode;        
	              return s1;        
	           }        
	       } catch (Exception exception1) {        
	       }        
	       encode = "UTF-8";        
	      try {        
	          if (str.equals(new String(str.getBytes(encode), encode))) {   //判断是不是UTF-8  
	               String s2 = encode;        
	              return s2;        
	           }        
	       } catch (Exception exception2) {        
	       }        
	       encode = "GBK";        
	      try {        
	          if (str.equals(new String(str.getBytes(encode), encode))) {      //判断是不是GBK  
	               String s3 = encode;        
	              return s3;        
	           }        
	       } catch (Exception exception3) {        
	       }        
	      return ""; //如果都不是，说明输入的内容不属于常见的编码格式
	} 
	 public final static String reach(String charName) {//加密字符
		 String encryptionString=new String();
		 char[]str=charName.toCharArray();
		 
		 for(int i=0;i<str.length;i++){
             str[i]+=(i+str.length);
            if(i<str.length-1){
            	encryptionString+=(str[i]+0)+"/";
            }else{
                encryptionString+=(str[i]+0);
        		
            }
        }
		

		 
		 
		return encryptionString;
		 
	 }
	 /**
	  * 
	  * @Title:             unbind
	  * @Description:     TODO 解密字符 如果不为特定的加密方式将解密失败返回字符本身
	  * @param:             @param encryptionString 需要解密的字符
	  * @param:             @return   
	  * @return:         String   成功解密的字符或是传入的字符
	  * @throws
	  */
	 public final static String unbind(String encryptionString) {//解密字符
		 String[] strArray = null;   
	     strArray = encryptionString.split("/");
	     int []charNum=new int[strArray.length];
	     for(int i=0;i<strArray.length;i++){
	    	 try {//如果需要解密的字符不为特定的加密方式将会报错。
	    		 charNum[i]=Integer.valueOf(strArray[i]);
			} catch (Exception e) {
				// TODO: handle exception
				return encryptionString;
			}
	    	
	     }
	     //System.out.println(strArray[19]);
	     char[]str=new char[charNum.length];
	     for(int i=0;i<charNum.length;i++){
             str[i]=(char) (charNum[i]-(i+charNum.length));
        }
		String tableName=new String(str);
//		 char[] str=new char[tableName.length()];
//		 for(int i=0;i<tableName.length();i++){
//			 char a=tableName.substring(i,i+1);
//		 }
		 
		 
		return tableName;
		 
	 }
	 public static void main(String[] args) {
		String str=reach("cbb_car_business");
		 System.out.println(str);
		  str=unbind(str);
        System.out.println(str);
		 //str=unbind(str);
//	        System.out.println(str);

	    }
}
