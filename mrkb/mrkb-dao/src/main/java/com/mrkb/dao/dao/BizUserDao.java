package com.mrkb.dao.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;
@Mapper
public interface BizUserDao {

    /*@Select("select * from biz_user")*/
    public List<Map<String, Object>> getObject() throws Exception;

    public int update(Map<String, String> map);

    public int delete(Map<String, String> map);
}
