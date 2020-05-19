/**
 * FileName:         UserGradeMapper.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-2-2     上午3:03:35
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-2-2     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.dao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mrkb.dao.modle.user.UserGrade;


/**
 *@param
 *@return
 * @author moerka-1
 *
 */
@Mapper
public interface UserGradeMapper {
	UserGrade findUserGrade(int user_grade_id);//根据等级id查询等级信息
	List<UserGrade> selectAllGrade ();//查询所有等级信息
	/**
	 * 
	 * @Title:             selectGradeToUpgrade_order
	 * @Description:     TODO
	 * @param:             @param upgrade_order
	 * @param:             @return   
	 * @return:         List<UserGrade>   
	 * @throws
	 */
	UserGrade selectGradeToUpgrade_order(int upgrade_order);//通过upgrade_order字段查询会员等级
	int updateUserGrade(UserGrade userGrade);//修改单个会员等级信息
	int userGradeAdd(UserGrade userGrade);//新增会员等级
}
