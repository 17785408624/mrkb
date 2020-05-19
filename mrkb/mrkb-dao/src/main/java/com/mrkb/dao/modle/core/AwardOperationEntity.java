/**
 * FileName:         AwardOperation.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-2-5     下午8:43:26
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-2-5     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.dao.modle.core;

/**
 *@param
 *@return
 * @author moerka-1
 *
 */
public class AwardOperationEntity {//奖励操作实体类
	String buyUserTeamRelation;//奖励的用户相对于购买用户的团队关系 S为上级，L为下级
	Integer AwardUserID;//奖励用户的id
	String AwardOption;//奖励项
	String AwardOptionName;//奖励项名字
	String AwardValue;//奖励值
	Integer bonusArithmetic;//奖励算法1为直接赋值，2为百分比
	public String getBuyUserTeamRelation() {
		return buyUserTeamRelation;
	}
	public void setBuyUserTeamRelation(String buyUserTeamRelation) {
		this.buyUserTeamRelation = buyUserTeamRelation;
	}
	public Integer getAwardUserID() {
		return AwardUserID;
	}
	public void setAwardUserID(Integer awardUserID) {
		AwardUserID = awardUserID;
	}
	public String getAwardOption() {
		return AwardOption;
	}
	public void setAwardOption(String awardOption) {
		AwardOption = awardOption;
	}
	public String getAwardOptionName() {
		return AwardOptionName;
	}
	public void setAwardOptionName(String awardOptionName) {
		AwardOptionName = awardOptionName;
	}
	public String getAwardValue() {
		return AwardValue;
	}
	public void setAwardValue(String awardValue) {
		AwardValue = awardValue;
	}
	public Integer getBonusArithmetic() {
		return bonusArithmetic;
	}
	public void setBonusArithmetic(Integer bonusArithmetic) {
		this.bonusArithmetic = bonusArithmetic;
	}
	@Override
	public String toString() {
		return "AwardOperationEntity [buyUserTeamRelation="
				+ buyUserTeamRelation + ", AwardUserID=" + AwardUserID
				+ ", AwardOption=" + AwardOption + ", AwardOptionName="
				+ AwardOptionName + ", AwardValue=" + AwardValue
				+ ", bonusArithmetic=" + bonusArithmetic + "]";
	}
	
	
	

}
