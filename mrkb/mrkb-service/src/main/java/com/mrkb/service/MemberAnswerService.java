package com.mrkb.service;

import com.mrkb.dao.modle.exam.MemberAnswerEntity;

public interface MemberAnswerService {

    /**
     * 添加考生答题信息
     * @param memberAnswerEntity
     * @return
     */
    public int addMemberAnswer(MemberAnswerEntity memberAnswerEntity);
}
