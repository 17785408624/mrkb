package com.mrkb.dao.dao;

import org.apache.ibatis.annotations.Mapper;

import com.mrkb.dao.modle.user.UserWeixin;
@Mapper
public interface UserWeixinMapper {
	Integer findUserBasicsIdWeixinId(String user_weixin);//根据用户微信id查询userid
	Integer editUserWeixin(UserWeixin userWeixin);//编辑userweixin数据，根据user_weixin_id，weixin_id或者user_basics_id作为条件；
	UserWeixin findUserWeixin(String weixin_id);//通过微信id查询用户微信信息
	UserWeixin findUserWeixinUserBasicsId(Integer userBasicsId);//通过用户id查询用户微信信息
	String findUserUserWeinxinNameBasicsId(int userBasicsId);//通过用户id查询用户微信昵称
	UserWeixin findUserWeixinUserBasicsOne(Integer userBasicsId);//通过用户id查询用户微信信息,包含真是姓名
}
