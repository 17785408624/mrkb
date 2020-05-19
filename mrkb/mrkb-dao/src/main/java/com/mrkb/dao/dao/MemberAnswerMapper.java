package com.mrkb.dao.dao;

import com.mrkb.dao.modle.exam.MemberAnswerEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberAnswerMapper {

    /**
     * 添加考生答题信息
     * @param memberAnswerEntity
     * @return
     */
    public int addMemberAnswer(MemberAnswerEntity memberAnswerEntity);


}
