/**
 * FileName:         ApplyService.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-2-12     下午10:31:25
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-2-12     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.service;

import java.util.HashMap;
import java.util.List;

import com.mrkb.dao.modle.apply.BonusExtractApplyEntity;
import com.mrkb.dao.modle.apply.BonusExtractApplyRecordEntity;
import com.mrkb.dao.modle.apply.WithdrawalApplyEntity;
import com.mrkb.dao.modle.exception.ApplyExceptionMedifood;
import com.mrkb.dao.modle.exception.RemittanceException;


/**
 *@param
 *@return
 * @author moerka-1
 *
 */
public interface ApplyService {
	int addBonusExtractApply(BonusExtractApplyEntity bonusExtractApplyEntity);//添加一条提现记录
	/**
	 * 
	 * @Title:             useBonusExtractMoneyApply
	 * @Description:     TODO 使用奖金兑换余额
	 * @param:             @param user_basics_id 申请用户id
	 * @param:             @param useBonusNum 使用积分数量
	 * @param:             @param receive_bank_card 收款账号（收款银行卡号）
	 * @param:             @param receive_name 收款人姓名
	 * @param:             @param fromTerminal 申请方式（ 1，微信端提交申请）
	 * @param:             @return   
	 * @return:         int   
	 * @throws
	 */
	int useBonusExtractMoneyApply(int user_basics_id,int useBonusNum,Long receive_bank_card,String receive_name,int fromTerminal);//使用奖金提取现金申请

	//int useBonusExtractMoneyApply(int user_basics_id,int useBonusNum,Long receive_bank_card,String receive_name,int fromTerminal);//使用奖金提取现金申请
	 /**
     * 
     * @Title:             
     * @Description:     TODO 查询提现申请记录
     * @param:             @param bonusExtractApplyEntity 
     * bonus_extract_apply_id 首选条件 申请记录的id 查询一条记录；
     * user_basics_id 次选条件 为用户的id 查询用户所有的流水信息 ；
     * apply_status//申请状态（1：审核中，2：等待用户确认  3：待打款， 4：已打款 ，5： 已删除） 查询不同状态的申请记录；
     * 如不设置属性为查看全部申请
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
	int updatebonusstate(BonusExtractApplyEntity bonusExtractApplyEntity);//修改兑换奖金申请的状态
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
	List<BonusExtractApplyEntity> findBonusExtractApplyState(HashMap<String, Object> map);//查询提现记录
	List<BonusExtractApplyEntity> findBonusExtractOne(int user_basics_id);//根据用户ID查询提现记录
	/**
	 * 
	 * @Title:             addBonusExtractApplyRecord
	 * @Description:     新增一条excel导出提现申请记录
	 * @param:             @param bonusExtractApplyEntity
	 * @param:             @return   
	 * @return:         int 
	 * @author liangyi  
	 * @throws
	 */
	int addBonusExtractApplyRecord(BonusExtractApplyRecordEntity bonusExtractApplyRecordEntity);//新增一条excel导出提现申请记录表
	/**
	 * 
	 * @Title:             addWithdrawalApply
	 * @Description:     TODO 添加余额提现申请 
	 * @param:             @param withdrawalApplyEntity 提现申请实体类
	 * @param:             @param user_basics_id 用户id
	 * @param:             @throws ApplyExceptionMedifood 申请异常，在用户余额不足的情况下将会抛出
	 * @return:         int 申请的编号   
	 * @throws
	 */
	int addWithdrawalApply(
			WithdrawalApplyEntity withdrawalApplyEntity,int user_basics_id)throws ApplyExceptionMedifood;//添加余额提现申请
	/**
	 * 
	 * @Title:             remitWithdrawalApplyOfStatus
	 * @Description:     TODO 通过提现申请
	 * @param:             @param apply_status 申请的状态 2为通过申请 3为拒绝申请 4为删除
	 * @param:             @param withdrawal_apply_id 申请编号 申请id
	 * @param:             @param edit_notes 申请编号 修改备注
	 * @param:             @param edit_user_basics_id 修改人id
	 * @param:             @return 
	 * @throws RemittanceException 打款错误
	 * @return:         int   
	 * @throws
	 */
	int remitWithdrawalApply(
			int withdrawal_apply_id,String edit_notes,int edit_user_basics_id)throws RemittanceException;//改变申请的状态
	/**
	 * 
	 * @Title:             selectWithdrawalApply
	 * @Description:     TODO 根据申请状态查询申请信息
	 * @param:             @param apply_status 申请的状态值（1审核中，2已通过，3已拒绝，4已删除）
	 * @param:             @return   
	 * @return:         List<WithdrawalApplyEntity>  满足条件的申请信息集合 
	 * @throws
	 */
	List<WithdrawalApplyEntity>selectWithdrawalApplyToStatus(int apply_status);//根据申请状态查询申请信息
	void rejectWithdrawalApply(int withdrawal_apply_id,String edit_notes, int edit_user_basics_id);
}
