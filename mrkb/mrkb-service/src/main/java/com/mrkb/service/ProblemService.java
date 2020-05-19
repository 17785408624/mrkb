package com.mrkb.service;

import com.mrkb.dao.modle.exam.ProblemEntity;

import java.util.List;

public interface ProblemService {

    /**
     * 添加题目信息
     * @param problemEntity
     * @return
     */
    public int addProblem(ProblemEntity problemEntity);

    /**
     * 通过试卷id查询对应题目
     * @param paperId
     * @return
     */
    public List<ProblemEntity> queryProblem(Integer paperId);
}
