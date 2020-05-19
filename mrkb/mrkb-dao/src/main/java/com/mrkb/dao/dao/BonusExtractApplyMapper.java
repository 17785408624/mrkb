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

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mrkb.dao.modle.apply.BonusExtractApplyEntity;


/**
 *@param
 *@return
 * @author moerka-1
 *
 */
@Mapper
public interface BonusExtractApplyMapper {
	/**
	 * 
	 * @Title:             addBonusExtractApply
	 * @Description:     TODO 添加奖金提现申请 添加成功后 实体类已包含数据主键
	 * @param:             @param bonusExtractApplyEntity 申请（奖金提现）
	 * @param:             @return  添加结果
	 * @return:         int   结果1为成功 -1为失败
	 * @throws
	 */
    int addBonusExtractApply(BonusExtractApplyEntity bonusExtractApplyEntity);//添加奖金提现申请
   
    /**
     * 
     * @Title:             findBonusExtractApply
     * @Description:     TODO 查询提现申请记录
     * @param:             @param bonusExtractApplyEntity 
     * bonus_extract_apply_id 首选条件 申请记录的id 查询一条记录；
     * user_basics_id 次选条件 为用户的id 查询用户所有的流水信息 ；
     * apply_status//申请状态（1：审核中，2：已拒绝  3：已通过） 查询不同状态的申请记录；
     * 如不设置属性为查看全部申请   如不设置apply_status属性为查看状态不为6的申请   
     * @param:             @return 申请记录
     * @return:         List<BonusExtractApplyEntity> 申请实体类 集合
     * @throws
     */
    List<BonusExtractApplyEntity> findBonusExtractApply(BonusExtractApplyEntity bonusExtractApplyEntity);
    List<BonusExtractApplyEntity> findBonusPutForward(HashMap<String, Object> map);//查询提现申请记录
    List<BonusExtractApplyEntity> findBonusMoney(HashMap<String, Object> map);//查询打款申请记录
    List<BonusExtractApplyEntity> findCombinatorial(HashMap<String, Object> map);//组合(多条件)查询打款状态
    List<BonusExtractApplyEntity> findPfCombinatorial(HashMap<String, Object> map);//组合(多条件)查询提现状态
    List<BonusExtractApplyEntity> findTimeCombination(HashMap<String, Object> map);//打款时间组合查询
    List<BonusExtractApplyEntity> presentTimeCombination(HashMap<String, Object> map);//提现时间组合查询
    /**
     * 
     * @Title:             findBonusExtractApply
     * @Description:     TODO 修改提现申请记录
     * @param:             @param bonusExtractApplyEntity 
     * bonus_extract_apply_id 首选条件 申请记录的id 查询一条记录；
     * user_basics_id 次选条件 为用户的id 查询用户所有的流水信息 ；
     * apply_status//申请状态（1：审核中，2：等待用户确认  3：待打款， 4：已打款 ，5： 已删除） 修改不同状态的申请记录；
     * @param:             @return 申请记录
     * @return:         List<BonusExtractApplyEntity> 申请实体类 集合
     * @throws
     */
    int updatebonusstate(BonusExtractApplyEntity bonusExtractApplyEntity);
    /**
     * zrm
     * @Title:             findBonusExtractApply
     * @Description:     TODO 查看单个申请记录
     * @param:             @param bonusExtractApplyEntity 
     * bonus_extract_apply_id 首选条件 申请记录的id 查询一条记录；
     * user_basics_id 次选条件 为用户的id 查询用户所有的流水信息 ；
     * apply_status//申请状态（1：审核中，2：等待用户确认  3：待打款， 4：已打款 ，5： 已删除） 修改不同状态的申请记录；
     * @param:             @return 申请记录
     * @return:         List<BonusExtractApplyEntity> 申请实体类 集合
     * @throws
     */
    BonusExtractApplyEntity findbonus(int bonus_extract_apply_id);
    /**
     * 
     * @Title:             findBonusExtractApplyState
     * @Description:     TODO 查询提现记录
     * @param:             @param bonusExtractApplyEntity 
     * bonus_extract_apply_id 首选条件 申请记录的id 查询一条记录；
     * user_basics_id 次选条件 为用户的id 查询用户所有的流水信息 ；
     * @param:             @return 提现记录
     * @return:         List<BonusExtractApplyEntity> 申请实体类 集合
     * @throws
     */
    List<BonusExtractApplyEntity> findBonusExtractApplyState(HashMap<String, Object> map);
    List<BonusExtractApplyEntity> findBonusExtractOne(int user_basics_id);//根据用户ID查询提现记录
    /*根据多个id查询提现审核列表信息*/
    List<BonusExtractApplyEntity>  findBonusExtractByApplyIds(@Param("bonus_extract_apply_ids")int[] idsArray);
}
