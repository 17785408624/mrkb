package com.mrkb.dao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mrkb.dao.modle.apply.WithdrawalApplyEntity;

@Mapper
public interface WithdrawalApplyMapper {
	/**
	 * 
	 * @Title:             insertWithdrawalApply
	 * @Description:     TODO 插入一条提现数据
	 * @param:             @param withdrawalApplyEntity
	 * @param:             @return   
	 * @return:         int  插入条数 
	 * @throws
	 */
	int insertWithdrawalApply(WithdrawalApplyEntity withdrawalApplyEntity);//插入一条提现数据
	int updateWithdrawalApply(WithdrawalApplyEntity withdrawalApplyEntity);//修改提现申请
	/**
	 * 
	 * @Title:             selectWithdrawalApplyToId
	 * @Description:     TODO 根据申请id查询申请信息
	 * @param:             @param withdrawal_apply_id 申请id
	 * @param:             @return   
	 * @return:         WithdrawalApplyEntity   
	 * @throws
	 */
	WithdrawalApplyEntity selectWithdrawalApplyToId(int withdrawal_apply_id);//根据申请id查询申请信息
	/**
	 * 
	 * @Title:             listWithdrawalApply
	 * @Description:     TODO 根据申请状态查询提现申请信息
	 * @param:             @param apply_status 申请状态（1审核中，2已通过，3已拒绝，4已删除）  
	 * @param:             @return   
	 * @return:         List<WithdrawalApplyEntity>
	 * @throws
	 */
	List<WithdrawalApplyEntity> selectWithdrawalApplyToApplyStatus(int apply_status);//根据申请状态查询提现申请信息
	
	/*根据多个id查询提现审核列表信息*/
    List<WithdrawalApplyEntity>  findWithdrawalApplyToApplyIds(@Param("withdrawal_apply_ids")int[] idsArray);
    
}
