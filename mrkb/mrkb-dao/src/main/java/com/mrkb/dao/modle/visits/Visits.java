/**
 * FileName:         Visits.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-5-31     下午4:40:14
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-5-31     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.dao.modle.visits;

/**
 *@param
 *@return
 * @author moerka-1
 *
 */
public class Visits {
	private String pageUrl ;//页面url
	private String hinUrl;//提示页面
	private String hintMessage;//提示信息
    @Override
	public String toString() {
		return "Visits [pageUrl=" + pageUrl + ", hinUrl=" + hinUrl
				+ ", hintMessage=" + hintMessage + "]";
	}
	public String getPageUrl() {
		return pageUrl;
	}
	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}
	public String getHinUrl() {
		return hinUrl;
	}
	public void setHinUrl(String hinUrl) {
		this.hinUrl = hinUrl;
	}
	public String getHintMessage() {
		return hintMessage;
	}
	public void setHintMessage(String hintMessage) {
		this.hintMessage = hintMessage;
	}
	
   

}
