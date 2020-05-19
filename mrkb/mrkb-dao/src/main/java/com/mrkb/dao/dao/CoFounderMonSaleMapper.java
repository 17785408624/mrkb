package com.mrkb.dao.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mrkb.dao.modle.company.CoFounderMonSale;
import com.mrkb.dao.modle.user.UserInformationEntity;

@Mapper
public interface CoFounderMonSaleMapper {
	int insertCoFounderMonSale(CoFounderMonSale cofm);//新增联合创办人奖励
	int updateCoFounderMonSale(CoFounderMonSale cofm);//修改联合创办人奖励
	CoFounderMonSale findCoFounderOne(CoFounderMonSale cofm);//查询单人单月联合创办人奖励
	List<CoFounderMonSale> findCompanyCo(HashMap<String,Object> map);//查询公司所有联合创办人业绩
	List<UserInformationEntity> findCompanyCountCountCo(HashMap<String,Object> map);//根据公司查询公司所有联合创办人数量
	List<CoFounderMonSale> find2SubordinateCo(@Param("user_basics_ids") int[] user_basics_ids,@Param("month_date") String month_date);//查询用户的下2级品牌大使信息
	List<CoFounderMonSale> find2SubordinateCoOne(@Param("user_basics_id") int user_basics_id,@Param("month_date") String month_date);//查询用户的下2级品牌大使信息
}
