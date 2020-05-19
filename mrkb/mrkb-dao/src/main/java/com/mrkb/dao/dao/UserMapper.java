/**
 * FileName:         UserMapper.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-5-29     下午5:26:35
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-5-29     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.dao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mrkb.dao.modle.user.UserBasicsAndWxAndInformationEntity;
import com.mrkb.dao.modle.user.UserImportantEntity;


/**
 *@param
 *@return
 * @author moerka-1
 *
 */
@Mapper
public interface UserMapper {
	/**
	 * 
	 * @Title:             selectUserBasicsAndWxAndInformationtoUserid
	 * @Description:     TODO 通过用户id查询用户基本信息和微信信息与用户详细信息
	 * @param:             @param user_basics_id 用户id
	 * @param:             @return   
	 * @return:         UserBasicsAndWxAndInformationEntity 用户id查询用户基本信息和微信信息与用户详细信息实体类  
	 * @throws
	 */
	UserBasicsAndWxAndInformationEntity selectUserBasicsAndWxAndInformationtoUserId(
			int user_basics_id);//通过用户id查询用户基本信息和微信信息与用户详细信息
	/**
	 * 
	 * @Title:             selectUserToadministrativeId
	 * @Description:     TODO 通过管理组id查询管理组包含的用户信息
	 * @param:             @param administrative_id 管理组id
	 * @param:             @return   用户信息 包含用户微信信息，详细信息
	 * @return:         UserBasicsAndWxAndInformationEntity   
	 * @throws
	 */
	List<UserBasicsAndWxAndInformationEntity> selectUserToadministrativeId(
			int administrative_id);//通过管理组id查询管理组包含的用户信息
	/**
	 * 
	 * @Title:             selectUserImportantEntityToUid
	 * @Description:     TODO 通过用户id查询用户关键信息
	 * @param:             @param user_basics_id 用户id
	 * @param:             @return   
	 * @return:         UserImportantEntity  用户 重要信息实体类 
	 * @throws
	 */
	UserImportantEntity selectUserImportantEntityToUid(int user_basics_id);//通过用户id查询用户关键信息
	

}
