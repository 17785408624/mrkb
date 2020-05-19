package com.mrkb.dao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mrkb.dao.modle.store.UserDuty;

@Mapper
public interface UserDutyMapper {
	List<UserDuty> findUserDuty(UserDuty userDuty);//用户查询自己的当班情况
	int duty(UserDuty userDuty);//当班
	int isduty(int user_basics_id);//已当班乐唐大学课程数量
	int addUserDuty(UserDuty userDuty);//新增信息
	int countDuty(int user_basics_id);//获取该用户已当班课程的数量
	List<UserDuty> noduty(int user_basics_id);
	UserDuty findOne(int user_basics_id);//查询单个当班
}
