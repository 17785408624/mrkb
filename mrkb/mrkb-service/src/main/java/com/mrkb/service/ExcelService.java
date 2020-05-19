/**
 * FileName:         ExcelService.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-5-28     下午3:11:43
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-5-28     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.service;

import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;


/**
 *@param
 *@return
 * @author bbc
 *
 */
public interface ExcelService {
	/**
	 * 
	 * @Title:             export
	 * @Description:     TODO  提现审核excel导出
	 * @param:             @param titles
	 * @param:             @param out   
	 * @return:         void   
	 * @throws
	 */
	public void export(String title,String[] body1,String body2,String[] body3,int[] ids,OutputStream out);
	
	/**
	 * 
	 * @Title:             exportRemit
	 * @Description:     TODO  提款审核excel导出
	 * @param:             @param titles
	 * @param:             @param out   
	 * @return:         void   
	 * @throws
	 */
	public void exportRemit(String title,String[] body1,String body2,String[] body3,int[] ids,OutputStream out);
	/**
	 * 
	 * @Title:             downloadExcel
	 * @Description:     TODO 根据指定文件路径下载excel表
	 * @param:             @param fileUrl
	 * @param:             @return   
	 * @return:         String   
	 * @throws
	 */
	public void downloadExcel(String fileUrl, HttpServletResponse response)throws Exception;
		
 

}
