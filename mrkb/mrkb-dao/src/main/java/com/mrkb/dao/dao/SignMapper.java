package com.mrkb.dao.dao;

import com.mrkb.dao.modle.exam.SignEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SignMapper {

    /**
     * 添加会员报名信息
     * @param exSignEntity
     * @return
     */
    int addSign(SignEntity exSignEntity);

    /**
     * 查询会员报名信息列表
     * @param signEntity
     * @return
     */
    List<SignEntity> querySignList(SignEntity signEntity);

}
