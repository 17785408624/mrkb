package com.mrkb.service;

import java.util.List;
import java.util.Map;

import com.mrkb.dao.modle.core.AwardOperationEntity;
import com.mrkb.dao.modle.core.AwardOperationEntityAll;
import com.mrkb.dao.modle.core.UserUpgrade;
import com.mrkb.dao.modle.user.UserAchievement;
import com.mrkb.dao.modle.user.UserAchievementAccount;


/**
 * 核心业务层
 * @author moerka-1
 *
 */
public interface CoreService {
	/**
	 * 用户升级优先级值从1开始，从小到大，由低到高
	 * @param user_grade_id 需要传入用户user_grade_id
	 * @return 按照成就提升会员等级的排序
	 */
	Integer findUserUpgradeOrderGradeAchievement(Integer user_grade_id);//获取用户按照成就提升会员等级的排序
	/**
	 * 
	 * @param UpgradeOrderGrade 传入按照成就升级的排序优先级大小
	 * @return 等级id，
	 */
	Integer findUserGradeUpgradeOrderAchievement(Integer UpgradeOrderGrade);//以成就升级的排序获取等级id
	/**
	 * 得到一个按照成就升级等级的条件
	 * @param user_grade_id 等级id
	 * @return 升级条件
	 */
	
	List<Map<String,Object>> findUpgradeAchievementRule(Integer user_grade_id);//获取一个等级按照成就升级的条件
	/**
	 * 
	 * @param userAchievement 用户基本成就
	 * @param achievementAccountList 用户自定义成就集合
	 * @param upgradeConditionList 升级条件集合
	 * @return 返回已达成成就与未达成成就
	 */
	UserUpgrade UpgradeProgressAchievement(UserAchievement userAchievement,List<UserAchievementAccount>achievementAccountList,
			List<Map<String,Object>> upgradeConditionList);//返回当前成就与升级条件的成就值相差值与是否满足条件
	/**
	 * 
	 * @Title:             getLowerBuyWay
	 * @Description:     TODO 获取下家购买奖励规则配置
	 * @param:             @return   奖励规则配置
	 * @return:         Map<String,Object>  map对象键为商品id,值是list集合（奖励规则）
	 * @throws
	 */
	Map<String, Object>  getLowerBuyWay();//获取下家购买奖励规则配置
     /**
	 * 
	 * @Title:             getAwardOperation
	 * @Description:     TODO 得到奖励操作集合
	 * @param:             @param user_basics_id 用户id
	 * @param:             @param correlatedList 奖励规则集合
	 * @param:             @return   
	 * @return:         AwardOperationEntityList 对应多个奖励操作  类中每一个属性对应一种奖励方式（每个集合中计算奖励方式不同）  
	 * @throws
	 */
	AwardOperationEntityAll getAwardOperation(Integer user_basics_id,List<Map<String, Object>> correlatedList);//得到奖励操作集合
	/**
	 * 
	 * @Title:             executeTeamAwardOperation
	 * @Description:     TODO 执行奖励操作（奖励方式按照商品价格的百分比计算）
	 * @param:             @param awardOperationEntityList awardOperationEntityList 奖励操作实体类集合
	 * @param:             @param store_price 商品价格
	 * @param:             @param account_cause 流水类型
	 * @param:             @param account_cause_order 流水相关订单id
	 * @param:             @return   执行条数
	 * @return:         int   
	 * @throws
	 */
	int executeTeamAwardOperation(List<AwardOperationEntity>awardOperationEntityList,Double store_price,int account_cause,int account_cause_order,int user_basics_id,int user_grade_id, int store_id);//执行奖励操作(奖金为按百分比计算)
	/**
	 * 
	 * @Title:             executeAwardDirectOperation
	 * @Description:     TODO  执行奖励操作（奖励方式为直接赋值）
	 * @param:             @param awardOperationEntityList 奖励操作实体类集合
	 * @param:             @return    执行条数
	 * @param:             @param account_cause 流水类型
	 * @param:             @param num 购买数量
	 * @param:             @param account_cause_order 流水相关订单id（触发奖励关联id）
	 * @return:         int   返回更新用户积分数据的条数
	 * @throws
	 */
	int executeTeamAwardOperation(List<AwardOperationEntity>awardOperationEntityList,int account_cause,int account_cause_order,int user_basics_id,int num,int user_grade_id,int store_id);//执行奖励操作(奖金为按百分比计算)
	/**
	 * 
	 * @Title:             userBuyTeamAward
	 * @Description:     TODO //获取用户购买商品后获取奖励的操作
	 * @param:             @param user_basics_id 用户id
	 * @param:             @param store_id 商品id
	 * @param:             @param store_price 商品价格
	 * @param:             @return   
	 * @return:         AwardOperationEntityAll   包含不同奖金计算规则的奖励的操作集合
	 * @throws
	 */
	AwardOperationEntityAll userBuyTeamAward(int user_basics_id,int store_id);//用户购买商品后得到的奖励操作
}
