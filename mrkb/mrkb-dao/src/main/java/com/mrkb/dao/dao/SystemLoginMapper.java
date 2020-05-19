/**
 * FileName:         SystemLoginMapper.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-6-1     下午4:53:30
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-6-1     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.dao.dao;

import org.apache.ibatis.annotations.Mapper;

import com.mrkb.dao.modle.system.AdminLoginRecordEntity;

/**
 *@param
 *@return
 * @author moerka-1
 *
 */
@Mapper
public interface SystemLoginMapper {
 
	int insertAdminLoginRecordEntity(AdminLoginRecordEntity adminLoginRecordEntity);
}
