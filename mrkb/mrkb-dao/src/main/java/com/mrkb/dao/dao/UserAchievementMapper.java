package com.mrkb.dao.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mrkb.dao.modle.user.UserAchievement;
import com.mrkb.dao.modle.user.UserAchievementAccount;

/**
 * 用户基本成就数据层
 *@param
 *@return
 * @author moerka-1
 *
 */
@Mapper
public interface UserAchievementMapper {
	int addUserAchievement(UserAchievement userAchievement);//添加用户基本成就记录
	UserAchievement findUserAchievementAll(int user_basics_id);//查询用户所有基本成就记录
	/**
	 * 
	 * @Title:             findUserAchievement
	 * @Description:     TODO 查询用户成就
	 * @param:             @param user_basics_id 用户id
	 * @param:             @param listName 成就名，列名；
	 * @param:             @return   
	 * @return:         UserAchievement 成就实体类，只有查询的列有值  
	 * @throws
	 */
	UserAchievement findUserAchievement(@Param("user_basics_id")int user_basics_id,@Param("listName")String listName);//查询成就记录
	List<UserAchievementAccount>findUserAchievementAccount(int user_basics_id);//查询用户自定义成就数据
	/**
	 * 
	 * @Title:             augmentUserAchievement
	 * @Description:     TODO 增加用户成就值
	 * @param:             @param userAchievement 字段中设置的值为用户对应成就增加的值
	 * @param:             @return 修改结果是否成功  
	 * @return:         int   修改条数
	 * @throws
	 */
	int augmentUserAchievement(UserAchievement userAchievement);//增加用户成就值，实体类设置的值为该字段增加的值
	int updateArchivement(Map<String, Object> map);//增加/减少历史奖金
	int updateArchivement1(Map<String, Object> map);//增加/减少历史奖金
	int updateArchivementAll(@Param("list")List<UserAchievement> list);
}
