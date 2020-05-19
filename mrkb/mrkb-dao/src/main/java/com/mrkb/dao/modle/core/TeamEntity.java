/**
 * FileName:         TeamEntity.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-2-2     上午6:03:59
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-2-2     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.dao.modle.core;

import java.util.List;
import java.util.Map;

import com.mrkb.dao.modle.user.UserWeixin;


/**
 * 
 *@param
 *@return
 * @author moerka-1
 *
 */
public class TeamEntity {//团队实体类
	private int series;//存入的级数
	private Map<Integer,List<UserWeixin>> subordinateMessage;//下级微信信息
	Map<Integer,List<Map<String, Object>>> subordinateMessageSuperiorName;//下级微信信息包含下级推荐人名字
	private Map<Integer,Integer> subordinateNum;//下级人数
	
	
	public Map<Integer, List<Map<String, Object>>> getSubordinateMessageSuperiorName() {
		return subordinateMessageSuperiorName;
	}
	public void setSubordinateMessageSuperiorName(
			Map<Integer, List<Map<String, Object>>> subordinateMessageSuperiorName) {
		this.subordinateMessageSuperiorName = subordinateMessageSuperiorName;
	}
	public int getSeries() {
		return series;
	}
	public void setSeries(int series) {
		this.series = series;
	}
	public Map<Integer, List<UserWeixin>> getSubordinateMessage() {
		return subordinateMessage;
	}
	public void setSubordinateMessage(
			Map<Integer, List<UserWeixin>> subordinateMessage) {
		this.subordinateMessage = subordinateMessage;
	}
	public Map<Integer, Integer> getSubordinateNum() {
		return subordinateNum;
	}
	public void setSubordinateNum(Map<Integer, Integer> subordinateNum) {
		this.subordinateNum = subordinateNum;
	}
	public TeamEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TeamEntity(Map<Integer, List<UserWeixin>> subordinateMessage,
			Map<Integer, Integer> subordinateNum) {
		super();
		this.subordinateMessage = subordinateMessage;
		this.subordinateNum = subordinateNum;
	}
	

}
