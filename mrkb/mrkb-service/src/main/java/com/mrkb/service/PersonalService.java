package com.mrkb.service;

import java.util.HashMap;
import java.util.List;

import com.mrkb.dao.modle.personal.PersonalMode;
import com.mrkb.dao.modle.personal.PersonalServer;
import com.mrkb.dao.modle.personal.PersonalType;


public interface PersonalService {
	PersonalServer addServer(PersonalServer personalServer);//添加服务
	PersonalType addType(PersonalType personalType);//添加服务方式
	PersonalMode addMode(PersonalMode personalMode);//添加服务方式
	List<PersonalServer> findPersonalSver(HashMap<String,Object> map);//查询服务
	PersonalServer findPersonalSverOne(HashMap<String,Object> map);//查询单个服务
	List<PersonalServer> findBagSver(List<Integer> list);//查询服务包服务
	List<PersonalType> findPersonalType(HashMap<String,Object> map);//查询服务方式
	List<PersonalMode> findPersonalMode(HashMap<String,Object> map);//查询服务类型
	int deletePersonalType(HashMap<String,Object> map);//删除服务方式 
	PersonalServer findPersonalByServerId(HashMap<String,Object> map);//通过sever_id查询单个服务的业务层方法
    int updatePersonalSver(PersonalServer personalServer);//通过server_id修改单个服务
	
}
