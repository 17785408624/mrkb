package com.mrkb.service;

import com.mrkb.dao.modle.exam.SignEntity;

import java.util.List;

public interface SignService {

    /**
     * 添加会员报名考试信息
     * @param signEntity
     * @return
     */
    int addSign(SignEntity signEntity);

    /**
     * 查询会员报名考试信息
     * @param signEntity
     * @return
     */
    List<SignEntity> querySignList(SignEntity signEntity);
}
