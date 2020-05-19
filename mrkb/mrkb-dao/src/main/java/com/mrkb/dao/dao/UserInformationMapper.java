/**
 * FileName:         UserInformation.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-4-4     上午9:53:30
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-4-4     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.dao.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mrkb.dao.modle.user.UserInformationEntity;


/**
 *@param
 *@return
 * @author moerka-1
 *
 */
@Mapper
public interface UserInformationMapper {
	/**
	 * 
	 * @Title:             insertUserInformationEntity
	 * @Description:     TODO 插入一条用户补充信息
	 * @param:             @param userInformationEntity
	 * @param:             @return  插入数据的主键
	 * @return:         int   数据的主键
	 * @throws
	 */
	int insertUserInformationEntity (UserInformationEntity userInformationEntity);//插入用户补充信息
	/**
	 * 
	 * @Title:             selectUserInformationEntityToUserId
	 * @Description:     TODO 查询用户补充信息 以用户id作为查询条件
	 * @param:             @param user_basics_id 用户id
	 * @param:             @return   用户补充信息 
	 * @return:         UserInformationEntity  用户补充信息 实体类 
	 * @throws
	 */
	UserInformationEntity selectUserInformationEntityToUserId(int user_basics_id);
	/**
	 * 
	 * @Title:             findUserInformationByPage
	 * @Description:     TODO 查询所有用户补充信息
	 * @param:             @param user_basics_id 用户id
	 * @param:             @return   用户补充信息 
	 * @return:         UserInformationEntity  用户补充信息 实体类 
	 * @throws
	 */
	List<UserInformationEntity> findUserInformationByPage();
	/**
	 * 
	 * @Title:             updateUserInformation
	 * @Description:     TODO 根据用户ID修改用户信息
	 * @param:             @param UserInformationEntity 实体类 
	 * @param:             @return   用户补充信息 
	 * @return:         UserInformationEntity  用户补充信息 实体类 
	 * @throws
	 */
	int updateUserInformation(UserInformationEntity userInformationEntity);//根据用户ID修改用户信息
	/**
	 * 
	 * @Title:             selectUidToCard
	 * @Description:     TODO 根据用户信息查询用户id
	 * @param:             @param information_card 用户身份证号码
	 * @param:             @return   
	 * @return:         Integer 用户id
	 * @throws
	 */
	Integer selectUidToCard(String information_card);//根据用户信息查询用户id
	
	Integer selectUidToCoFounder(int user_basics_id);//根据用户id查询用户类型
	List<UserInformationEntity> findCoFounds(UserInformationEntity ui);//查询品牌大使
	UserInformationEntity selectUserById(UserInformationEntity userInformationEntity);//查询单个用户信息
	int adminUpdateCoFounder(HashMap<String,Object> map);
	List<UserInformationEntity> selectExportDuty(UserInformationEntity ui);//查询当班数据并导出
}
