package com.mrkb.service;

public interface RemittanceSeriviceUtil {
	/**
	 * 
	 * @Title:             remittance
	 * @Description:     TODO 打款操作
	 * @param:             @param withdrawal_apply_id 提现申请id
	 * @param:             @param describe 描述
	 * @param:             @param weixin_id 用户微信id、
	 * @param:             @param information_compellation 用户真实姓名
	 * @param:             @param apply_value 提现的值
	 * @param:             @return   
	 * @return:         boolean   执行结果，true为成功 false失败
	 * @throws
	 */
	boolean remittance(int withdrawal_apply_id,String describe,String weixin_id,
			String information_compellation,Double apply_value);//打款操作

}
