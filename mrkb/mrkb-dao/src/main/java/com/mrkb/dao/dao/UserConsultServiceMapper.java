package com.mrkb.dao.dao;



import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mrkb.dao.modle.user.UserConsultServiceEntity;




@Mapper
public interface UserConsultServiceMapper {
	int addUserConsultService(UserConsultServiceEntity userConsultServiceEntity);//新增用户的乐唐顾问及高级经理
	List<UserConsultServiceEntity> findAllUserConsultService(UserConsultServiceEntity userConsultServiceEntity);//查询所有用户对应的乐唐顾问及高级经理
	UserConsultServiceEntity findUserConsultserviceById(UserConsultServiceEntity userConsultServiceEntity);//查询单个我的顾问信息
	int updateUserConsultservice(UserConsultServiceEntity userConsultServiceEntity);//修改单个我的顾问信息
}                                                                              