package com.mrkb.dao.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
/**
 * 以uid为条件改变数据
 * @author moerka-1
 *
 */
@Mapper
public interface UserUpdateMapper {
	int updateNumLine(Map<String,String> map);//更改一行数据，值为数字。需要表名，列名，改变的值
     
}
