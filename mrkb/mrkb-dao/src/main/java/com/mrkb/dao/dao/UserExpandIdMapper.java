package com.mrkb.dao.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mrkb.dao.modle.user.UserExpandId;


@Mapper
public interface UserExpandIdMapper {
	UserExpandId addaddress(HashMap<String,Object> map);//添加地址
	List<UserExpandId> findaddress(HashMap<String,Object> map);//查询用户所有地址

}
