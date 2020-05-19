/**
 * FileName:         AwardOperationEntityList.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-2-6     下午2:21:40
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-2-6     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.dao.modle.core;

import java.util.List;

/**
 *@param
 *@return
 * @author moerka-1
 *
 */
public class AwardOperationEntityAll {//奖励操作集合，每个属性对应不同计算金额的奖励操作
	List<AwardOperationEntity>directAwardList;//直接赋值奖励金额的奖励操作集合
	List<AwardOperationEntity>percentAwardList;//按百分比计算金额的奖励操作集合
	public List<AwardOperationEntity> getPercentAwardList() {
		return percentAwardList;
	}
	/**
	 * 
	 * @Title:             setPercentAwardList
	 * @Description:     TODO 设置按商品百分比设置奖励值的集合
	 * @param:             @param percentAwardList  按商品百分比设置奖励值的集合
	 * @return:         void   
	 * @throws
	 */
	public void setPercentAwardList(List<AwardOperationEntity> percentAwardList) {
		this.percentAwardList = percentAwardList;
	}
	public List<AwardOperationEntity> getDirectAwardList() {
		return directAwardList;
	}
	/**
	 * 
	 * @Title:             setDirectAwardList
	 * @Description:     TODO 设置直接赋值奖励集合的值
	 * @param:             @param directAwardList 直接赋值的奖励操作集合  
	 * @return:         void   
	 * @throws
	 */
	public void setDirectAwardList(List<AwardOperationEntity> directAwardList) {
		this.directAwardList = directAwardList;
	}
	@Override
	public String toString() {
		return "AwardOperationEntityList [percentAwardList=" + percentAwardList
				+ ", directAwardList=" + directAwardList + "]";
	}
	

}
