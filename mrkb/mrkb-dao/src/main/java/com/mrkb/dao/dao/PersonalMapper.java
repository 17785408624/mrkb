package com.mrkb.dao.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mrkb.dao.modle.personal.PersonalMode;
import com.mrkb.dao.modle.personal.PersonalServer;
import com.mrkb.dao.modle.personal.PersonalType;

@Mapper
public interface PersonalMapper {
	int addServer(PersonalServer personalServer);//添加服务
	int addType(PersonalType personalType);//添加服务方式
	int addMode(PersonalMode personalMode);//添加服务类型
	List<PersonalServer> findPersonalSver(HashMap<String,Object> map);//查询服务
	List<PersonalServer> findBagSver(List<Integer> list);//查询服务包服务
	PersonalServer findPersonalSverOne(HashMap<String,Object> map);//查询单个服务
	List<PersonalType> findPersonalType(HashMap<String,Object> map);//查询服务方式
	List<PersonalMode> findPersonalMode(HashMap<String,Object> map);//查询服务类型
	int deletePersonalType(HashMap<String,Object> map);//删除服务方式
	PersonalServer findPersonalByServerId(HashMap<String,Object> map);//通过server_id查询单个服务
	int updatePersonalSver(PersonalServer personalServer);//通过server_id修改单个服务

}
