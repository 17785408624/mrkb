/**
 * FileName:         BonusEntity.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-2-8     下午10:23:51
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-2-8     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.dao.modle.integr;

/**
 *@param
 *@return
 * @author moerka-1
 *
 */
public class BonusEntity {
	private Integer achievementBonus;//历史积分
    private Integer existingBonus;//现有积分
    private Integer awaitBonus;//待打款积分
	public Integer getAchievementBonus() {
		return achievementBonus;
	}
	public void setAchievementBonus(Integer achievementBonus) {
		this.achievementBonus = achievementBonus;
	}
	public Integer getExistingBonus() {
		return existingBonus;
	}
	public void setExistingBonus(Integer existingBonus) {
		this.existingBonus = existingBonus;
	}
	public Integer getAwaitBonus() {
		return awaitBonus;
	}
	public void setAwaitBonus(Integer awaitBonus) {
		this.awaitBonus = awaitBonus;
	}
	@Override
	public String toString() {
		return "BonusEntity [achievementBonus=" + achievementBonus
				+ ", existingBonus=" + existingBonus + ", awaitBonus="
				+ awaitBonus + "]";
	}
}
