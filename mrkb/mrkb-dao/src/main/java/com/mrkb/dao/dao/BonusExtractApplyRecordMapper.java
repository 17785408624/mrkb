/**
 * FileName:         BonusExtractApply.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-2-12     下午9:38:42
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-2-12     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.dao.dao;

import org.apache.ibatis.annotations.Mapper;

import com.mrkb.dao.modle.apply.BonusExtractApplyRecordEntity;

/**
 *@param
 *@return
 * @author moerka-1
 *
 */
@Mapper
public interface BonusExtractApplyRecordMapper {
	/**
	 * 
	 * @Title:             addBonusExtractApply
	 * @Description:    新增一条excel导出提现申请记录表
	 * @param:             @param bonusExtractApplyEntity 申请（奖金提现）
	 * @param:             @return  添加结果
	 * @return:         int   结果1为成功 -1为失败
	 * @throws
	 */
    int addBonusExtractApplyRecord(BonusExtractApplyRecordEntity bonusExtractApplyRecordEntity);//
   
    
}
