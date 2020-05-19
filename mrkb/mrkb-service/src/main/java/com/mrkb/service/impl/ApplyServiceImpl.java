/**
 * FileName:         ApplyServiceImpl.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-2-12     下午10:32:14
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-2-12     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrkb.common.utils.weixinservice.WxCustomerServiceMessageUtil;
import com.mrkb.dao.dao.BasicUserMapper;
import com.mrkb.dao.dao.BonusExtractApplyMapper;
import com.mrkb.dao.dao.BonusExtractApplyRecordMapper;
import com.mrkb.dao.dao.CapitalAccountMapper;
import com.mrkb.dao.dao.IntegralMapper;
import com.mrkb.dao.dao.UserInformationMapper;
import com.mrkb.dao.dao.UserIntegralMapper;
import com.mrkb.dao.dao.UserMapper;
import com.mrkb.dao.dao.UserMoneyAccountMapper;
import com.mrkb.dao.dao.UserWeixinMapper;
import com.mrkb.dao.dao.WithdrawalApplyMapper;
import com.mrkb.dao.modle.account.CapitalAccount;
import com.mrkb.dao.modle.account.IntegralAccount;
import com.mrkb.dao.modle.account.UserMoneyAccountEntity;
import com.mrkb.dao.modle.apply.BonusExtractApplyEntity;
import com.mrkb.dao.modle.apply.BonusExtractApplyRecordEntity;
import com.mrkb.dao.modle.apply.WithdrawalApplyEntity;
import com.mrkb.dao.modle.exception.ApplyExceptionMedifood;
import com.mrkb.dao.modle.exception.RemittanceException;
import com.mrkb.dao.modle.exception.SessionException;
import com.mrkb.dao.modle.user.UserBasicsAndWxAndInformationEntity;
import com.mrkb.dao.modle.user.UserInformationEntity;
import com.mrkb.dao.modle.user.UserIntegral;
import com.mrkb.dao.modle.user.UserWeixin;
import com.mrkb.service.ApplyService;
import com.mrkb.service.RemittanceSeriviceUtil;

import net.sf.json.JSONObject;

/**
 * @param
 * @return
 * @author moerka-1
 * 
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ApplyServiceImpl implements ApplyService {
	@Resource
	private BonusExtractApplyMapper bonusExtractApplyMapper;
	@Resource
	private UserIntegralMapper userIntegralMapper;
	@Resource
	private IntegralMapper integralMapper;
	@Resource
	private UserInformationMapper userInformationMapper;
	@Resource
	private BonusExtractApplyRecordMapper bonusExtractApplyRecordMapper;
	@Resource
	private BasicUserMapper basicUserMapper;
	@Resource
	private UserMoneyAccountMapper userMoneyAccountMapper;
	@Resource
	private WithdrawalApplyMapper withdrawalApplyMapper;
	@Resource
	private CapitalAccountMapper capitalAccountMapper;
	@Autowired
	RemittanceSeriviceUtil remittanceSeriviceUtil;
	@Resource
	UserMapper userMapper;
	@Resource
	UserWeixinMapper userWeixinMapper;

	/**
	 * <p>
	 * Title: addBonusExtractApply
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @return
	 * @see com.medicinefood.service.ApplyService#addBonusExtractApply()
	 */
	@Override
	public int addBonusExtractApply(
			BonusExtractApplyEntity bonusExtractApplyEntity) {
		// TODO Auto-generated method stub
		return bonusExtractApplyMapper
				.addBonusExtractApply(bonusExtractApplyEntity);
	}

	/**
	 * <p>
	 * Title: useBonusExtractMoneyApply
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 申请奖金兑换余额
	 * 
	 * @param user_basics_id
	 * @param useBonusNum
	 * @return
	 * @see com.medicinefood.service.ApplyService#useBonusExtractMoneyApply(int,
	 *      int)
	 */
	@Override
	public int useBonusExtractMoneyApply(int user_basics_id, int useBonusNum,
			Long receive_bank_card, String receive_name, int fromTerminal) {// 使用奖金提取现金申请
		// 查出用户剩余积分
		UserIntegral userIntegral = userIntegralMapper.findUserIntegral(
				user_basics_id, "integral_bonus");
		if (userIntegral.getIntegral_bonus() < useBonusNum) {// 用户剩余积分小于申请提现积分
			System.out.println("奖金不足");
			return 0;
		}
		// 获取user_basics_id的实名信息
		UserInformationEntity userInfo = userInformationMapper
				.selectUserInformationEntityToUserId(user_basics_id);
		String receive_names = userInfo.getInformation_compellation();// 获取实名

		BonusExtractApplyEntity bonusExtractApplyEntity = new BonusExtractApplyEntity();// 申请实体类
		bonusExtractApplyEntity.setApply_add_date(System.currentTimeMillis());// 添加时间，默认当前时间戳
		switch (fromTerminal) {// 获取申请终端
		case 1:// 微信端
			bonusExtractApplyEntity.setApply_postscript("通过微信端提交申请");

			break;

		default:
			break;
		}
		bonusExtractApplyEntity.setApply_status(1);// 申请状态，1为待打款
		bonusExtractApplyEntity.setUser_basics_id(user_basics_id);// 申请人的用户id
		int proportion = 100;// 奖金兑换现金的比例 百分比
		int apply_sum = useBonusNum * proportion / 100;// 算出提现的金额
		bonusExtractApplyEntity.setApply_sum(apply_sum);// 申请金额，单位人民币 （元）
		// bonusExtractApplyEntity.setReceive_bank_card(receive_bank_card);//收款账户
		bonusExtractApplyEntity.setReceive_name(receive_names);// 收款人姓名
		// 添加一条申请记录
		if (bonusExtractApplyMapper
				.addBonusExtractApply(bonusExtractApplyEntity) == 1) {// 添加成功
			Map<String, Object> IntegralUpdateMap = new HashMap<String, Object>();
			IntegralUpdateMap.put("integral", "integral_bonus");// 修改的字段为integral_bonus资金积分

			IntegralUpdateMap.put("integralOperate", -(useBonusNum));// 修改的值为减去使用的数量
			IntegralUpdateMap.put("user_basics_id", user_basics_id);// 修改的用户id
			userIntegralMapper.updateIntegral(IntegralUpdateMap);// 修改积分
		}
		;
		IntegralAccount integralAccount = new IntegralAccount();
		integralAccount.setAccount_add_date(System.currentTimeMillis());// 更改积分时间（添加数据时间）
		integralAccount.setAccount_option("integral_bonus");// 改变的数据
		integralAccount.setAccount_option_name("奖金积分");// 改变数据的名字
		integralAccount.setIntegral_account_explain("使用奖金兑换余额");// 流水说明
		integralAccount.setIntegral_account_num(-useBonusNum + "");// 更改的值
		integralAccount.setIntegral_account_type(3);// 流水触发原因(1,购买商品,3使用奖金提现))
		integralAccount.setIntegral_trigger(bonusExtractApplyEntity
				.getBonus_extract_apply_id());// 流水关联触发订单id
		integralAccount.setUser_basics_id(user_basics_id);// 改变积分项的用户（关联user_basics表）
		integralMapper.addIntegralAccount(integralAccount);// 添加资金积分流水（使用积分，流水为-）
		return bonusExtractApplyEntity.getBonus_extract_apply_id();
	}

	/**
	 * <p>
	 * Title: findBonusExtractApply
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param bonusExtractApplyEntity
	 * @return
	 * @see com.medicinefood.service.ApplyService#findBonusExtractApply(com.medicinefood.entity.apply.BonusExtractApplyEntity)
	 */
	@Override
	public List<BonusExtractApplyEntity> findBonusPutForward(
			HashMap<String, Object> map) {// 查询提现申请记录
		return bonusExtractApplyMapper.findBonusPutForward(map);
	}

	@Override
	public int updatebonusstate(BonusExtractApplyEntity bonusExtractApplyEntity) {// 修改奖金兑换申请
//		HttpServletRequest request = SysContent.getRequest();// 请求的request
//		HttpSession HttpSession = request.getSession();
//		Cookie[] cookies = request.getCookies();
		int apply_status = bonusExtractApplyEntity.getApply_status();
		if (apply_status == 3) {// 通过奖金兑换申请
			BonusExtractApplyEntity bonusE = bonusExtractApplyMapper
					.findbonus(bonusExtractApplyEntity
							.getBonus_extract_apply_id());// 查询申请的信息
			basicUserMapper.updateUserMoneyPlus(
					Double.valueOf(bonusE.getApply_sum()),
					bonusE.getUser_basics_id());// 增加用户余额
			UserMoneyAccountEntity userMoneyAccountEntity = new UserMoneyAccountEntity();// 用户余额流水
			userMoneyAccountEntity.setAccount_add_date(new Date().getTime());// 流水时间
			userMoneyAccountEntity.setAccount_correlation_id(bonusE
					.getBonus_extract_apply_id());// 流水关联id，这里为申请的id
			userMoneyAccountEntity.setAccount_value(Double.valueOf(bonusE
					.getApply_sum()));// 流水值
			userMoneyAccountEntity
					.setUser_basics_id(bonusE.getUser_basics_id());// 流水的用户
			userMoneyAccountEntity.setAccount_reason(1);// 流水触发原因
			userMoneyAccountEntity.setAccount_explain("使用奖金兑换余额");// 流水说明
			userMoneyAccountMapper
					.insertUserMoneyAccount(userMoneyAccountEntity);// 插入一条用户余额流水记录
			return bonusExtractApplyMapper
					.updatebonusstate(bonusExtractApplyEntity);// 改变申请的状态为已通过
		}

		return bonusExtractApplyMapper
				.updatebonusstate(bonusExtractApplyEntity);
	}

	@Override
	public List<BonusExtractApplyEntity> findBonusExtractApplyState(
			HashMap<String, Object> map) {// 查询提现记录
		return bonusExtractApplyMapper.findBonusExtractApplyState(map);
	}

	@Override
	public List<BonusExtractApplyEntity> findBonusExtractOne(int user_basics_id) {
		return bonusExtractApplyMapper.findBonusExtractOne(user_basics_id);
	}

	@Override
	public List<BonusExtractApplyEntity> findBonusMoney(
			HashMap<String, Object> map) {
		return bonusExtractApplyMapper.findBonusMoney(map);
	}

	@Override
	public List<BonusExtractApplyEntity> findCombinatorial(
			HashMap<String, Object> map) {
		return bonusExtractApplyMapper.findCombinatorial(map);
	}

	@Override
	public List<BonusExtractApplyEntity> findBonusExtractApply(
			BonusExtractApplyEntity bonusExtractApplyEntity) {
		return bonusExtractApplyMapper
				.findBonusExtractApply(bonusExtractApplyEntity);
	}

	@Override
	public List<BonusExtractApplyEntity> findPfCombinatorial(
			HashMap<String, Object> map) {
		return bonusExtractApplyMapper.findPfCombinatorial(map);
	}

	@Override
	public int addBonusExtractApplyRecord(
			BonusExtractApplyRecordEntity bonusExtractApplyRecordEntity) {

		return bonusExtractApplyRecordMapper
				.addBonusExtractApplyRecord(bonusExtractApplyRecordEntity);
	}

	@Override
	public List<BonusExtractApplyEntity> findTimeCombination(
			HashMap<String, Object> map) {
		return bonusExtractApplyMapper.findTimeCombination(map);
	}

	@Override
	public List<BonusExtractApplyEntity> presentTimeCombination(
			HashMap<String, Object> map) {
		return bonusExtractApplyMapper.presentTimeCombination(map);
	}

	/**
	 * 
	 * <p>
	 * Title: addWithdrawalApply
	 * </p >
	 * <p>
	 * Description:
	 * </p >
	 * 添加余额提现申请
	 * 
	 * @param withdrawalApplyEntity
	 *            提现申请实体类
	 * @param user_basics_id
	 *            用户id
	 * @return
	 * @throws ApplyExceptionMedifood
	 * @see com.medicinefood.service.ApplyService#addWithdrawalApply(com.medicinefood.entity.apply.WithdrawalApplyEntity,
	 *      int)
	 */
	@Override
	public int addWithdrawalApply(WithdrawalApplyEntity withdrawalApplyEntity,
			int user_basics_id) throws ApplyExceptionMedifood {
		double applyValue = withdrawalApplyEntity.getApply_value();// 申请提现的值
		double userMoney = basicUserMapper.selectUserMoneyToUid(user_basics_id);// 提现的值
		if (userMoney < applyValue) {// 用户申请的金额大于自身的余额
			throw new ApplyExceptionMedifood("用户申请提现金额超出余额");
		}
		withdrawalApplyMapper.insertWithdrawalApply(withdrawalApplyEntity);// 添加一条申请
		basicUserMapper.updateUserMoneyReduce(applyValue, user_basics_id);// 减少用户余额
		UserMoneyAccountEntity userMoneyAccountEntity = new UserMoneyAccountEntity();// 用户余额流水信息实体类
		userMoneyAccountEntity.setUser_basics_id(user_basics_id);// 用户id
		userMoneyAccountEntity.setAccount_value(applyValue);// 流水值
		userMoneyAccountEntity.setAccount_add_date(new Date().getTime());// 流水添加时间
		userMoneyAccountEntity.setAccount_explain("余额申请提现");// 流水说明
		userMoneyAccountEntity.setAccount_reason(2);// 流水触发原因（1：奖金兑换，2使用提现）
		userMoneyAccountEntity.setAccount_correlation_id(withdrawalApplyEntity
				.getWithdrawal_apply_id());// 流水关联id
		userMoneyAccountMapper.insertUserMoneyAccount(userMoneyAccountEntity);
		// TODO Auto-generated method stub
		return withdrawalApplyEntity.getWithdrawal_apply_id();
	}

	/**
	 * 
	 * <p>
	 * Title: remitWithdrawalApplyOfStatus
	 * </p >
	 * <p>
	 * Description:
	 * </p >
	 * 通过提现申请
	 * 
	 * @param: @param apply_status 申请的状态 2为通过申请 3为拒绝申请 4为删除
	 * @param: @param withdrawal_apply_id 申请编号 申请id
	 * @param: @param edit_notes 申请编号 修改备注
	 * @param: @param edit_user_basics_id 修改人id
	 * @return
	 * @throws RemittanceException
	 * @see com.medicinefood.service.ApplyService#alterWithdrawalApplyOfStatus(int)
	 */
	@Override
	public int remitWithdrawalApply(int withdrawal_apply_id, String edit_notes,
			int edit_user_basics_id) throws RemittanceException {
		// TODO Auto-generated method stub
		int num = 0;
		WithdrawalApplyEntity withdrawalApplyEntity = withdrawalApplyMapper
				.selectWithdrawalApplyToId(withdrawal_apply_id);// 查询申请信息
		CapitalAccount capitalAccount = new CapitalAccount();// 资金流水
		capitalAccount.setTo_user_basics_id(withdrawalApplyEntity
				.getUser_basics_id());// 用户id
		capitalAccount.setAccount_explain(withdrawalApplyEntity
				.getApply_explain());// 流水说明
		capitalAccount.setAdd_account_date(new Date().getTime());// 添加时间
		capitalAccount
				.setCapital_number(withdrawalApplyEntity.getApply_value());// 资金数量
		capitalAccount.setCapital_trigger(withdrawalApplyEntity
				.getWithdrawal_apply_id());// 关联触发数据的id
		capitalAccount.setCapital_account_type(2);// 流水类型（1购买商品,2余额提现）
		capitalAccountMapper.insertCapitalAccount(capitalAccount);// 插入资金流水记录
		UserBasicsAndWxAndInformationEntity userAll = userMapper
				.selectUserBasicsAndWxAndInformationtoUserId(withdrawalApplyEntity
						.getUser_basics_id());
		if (!remittanceSeriviceUtil.remittance(withdrawal_apply_id, " ",
				userAll.getWeixin_id(), userAll.getInformation_compellation(),
				withdrawalApplyEntity.getApply_value())) {
			throw new RemittanceException("向用户微信转账失败");

		}
		withdrawalApplyEntity.setWithdrawal_apply_id(withdrawal_apply_id);// 申请编号
		withdrawalApplyEntity.setApply_status(2);// 状态修改为2，已通过
		withdrawalApplyEntity.setApply_edit_date(new Date().getTime());// 修改时间默认为当前时间
		withdrawalApplyEntity.setEdit_notes(edit_notes);// 修改添加的备注
		withdrawalApplyEntity.setEdit_user_basics_id(edit_user_basics_id);// 修改人id
		num = withdrawalApplyMapper
				.updateWithdrawalApply(withdrawalApplyEntity);// 更改提现申请
		return num;
	}

	/**
	 * 
	 * <p>
	 * Title: selectWithdrawalApply
	 * </p >
	 * <p>
	 * Description:
	 * </p >
	 * 根据申请状态查询申请信息
	 * 
	 * @param apply_status
	 *            申请的状态值（1审核中，2已通过，3已拒绝，4已删除）
	 * @see com.medicinefood.service.ApplyService#selectWithdrawalApply(int)
	 */
	@Override
	public List<WithdrawalApplyEntity> selectWithdrawalApplyToStatus(
			int apply_status) {
		// TODO Auto-generated method stub
		return withdrawalApplyMapper
				.selectWithdrawalApplyToApplyStatus(apply_status);// 查询满足条件的申请信息
	}
	@Override
	public void rejectWithdrawalApply(int withdrawal_apply_id,
			String edit_notes, int edit_user_basics_id) {// 拒绝提现申请
		WithdrawalApplyEntity withdrawalApplyEntity = new WithdrawalApplyEntity();
		withdrawalApplyEntity.setWithdrawal_apply_id(withdrawal_apply_id);// 申请编号
		withdrawalApplyEntity.setApply_status(3);// 状态修改为3，已拒绝
		withdrawalApplyEntity.setApply_edit_date(new Date().getTime());// 修改时间默认为当前时间
		withdrawalApplyEntity.setEdit_notes(edit_notes);// 修改添加的备注
		withdrawalApplyEntity.setEdit_user_basics_id(edit_user_basics_id);// 修改人id
		int retu = withdrawalApplyMapper.updateWithdrawalApply(withdrawalApplyEntity);// 更改提现申请
		if(retu>0){
			WithdrawalApplyEntity we=withdrawalApplyMapper.selectWithdrawalApplyToId(withdrawal_apply_id);
			UserWeixin uw2 = userWeixinMapper.findUserWeixinUserBasicsId(we.getUser_basics_id());
			JSONObject jsonObject = new JSONObject();
			String openid = uw2.getWeixin_id();
			StringBuffer buffer = new StringBuffer();
			try {
				jsonObject = new WxCustomerServiceMessageUtil().sendTextMessage(buffer.toString(), openid);
				jsonObject = new WxCustomerServiceMessageUtil()
				.sendTextMessage("您好，您的申请提现,申请编号编号为:\"" + withdrawal_apply_id
						+ "\"\r\n未通过,原因是:" + edit_notes, openid);
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
