package com.mrkb.dao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mrkb.dao.modle.sowing.SowingEntity;





@Mapper
public interface SowingMapper {
	List<SowingEntity> findAllSowing(SowingEntity sowingEntity);//查询所有轮播图信息
	SowingEntity  findSowingById(SowingEntity sowingEntity);//根据id查询轮播图详情信息
    int deleteSowingById(SowingEntity sowingEntity);//根据id修改轮播图状态(审核状态(0.通过，1.待审核，2拒绝，3.删除))
    int addSowing(SowingEntity sowingEntity);//添加轮播图信息
    int updateSowing(SowingEntity sowingEntity);//修改轮播图

}