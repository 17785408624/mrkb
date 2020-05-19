package com.mrkb.service;

import com.mrkb.dao.modle.exam.MemberEntity;

import java.util.List;

public interface MemberServie {

    /**
     * 添加考试报名会员
     * @param memberEntity
     * @return
     */
    int addMember(MemberEntity memberEntity);

    /**
     * 查询开始会员列表
     * @param memberEntity
     * @return
     */
    List<MemberEntity> queryMemberList(MemberEntity memberEntity);
}
