package com.mrkb.dao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mrkb.dao.modle.company.GoldPoolShare;

@Mapper
public interface GoldPoolShareMapper {
	int addGoldPoolShare(GoldPoolShare goldPoolShare);
	List<GoldPoolShare> findUserShare(GoldPoolShare goldPoolShare);
}
