package com.mrkb.dao.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mrkb.dao.modle.core.AwardOperationEntity;
import com.mrkb.dao.modle.user.UserIntegral;

@Mapper
public interface UserIntegralMapper {
	int addUserIntegral(UserIntegral ui);//添加一条用户积分记录
	/**
	 * 
	 * @Title:             updateIntegral
	 * @Description:     TODO 增加/减少用户积分
	 * @param:             @param map 
	 * integral键 的值为 修改的数据字段名 
	 * integralOperate键 的值为 正数增加
	 * 负数减少  
	 * user_basics_id键 的值为 修改用户的id
	 * @param:             @return   
	 * @return:         int   
	 * @throws
	 */
	int updateIntegralBonus(Map<String, Object> map);//增加/减少用户奖金
	int updateIntegralBonus1(Map<String, Object> map);//增加/减少用户奖金
	int updateIntegral(Map<String, Object> map);//增加/减少用户积分
	int updateConver(Map<String, Object> map);//增加/减少卡巴积分
	int addBonus(Map<String, Object> map);//增加用户奖金
	UserIntegral findUserIntegralAll(HashMap<String,Object> map);//查询用户所有类型的积分
	int useUserIntegral(HashMap<String,Object> map);//兑换奖金池使用积分
	int operationIntegral(AwardOperationEntity awardOperationEntity);//添加奖金
	/**
	 * 
	 * @Title:             findUserIntegral
	 * @Description:     TODO 查询用户的其中一项积分，查询一列数据
	 * @param:             @param user_basics_id 用户id
	 * @param:             @param listName 积分名字 
	 * @param:             @return   用户积分
	 * @return:         UserIntegral  只有查询的字段有值
	 * @throws
	 */
	UserIntegral findUserIntegral(@Param("user_basics_id")int user_basics_id,@Param("listName")String listName);//查询用户的其中一项积分，查询一列数据
}
