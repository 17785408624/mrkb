package com.mrkb.service;

import com.mrkb.dao.modle.exam.PaperProblemEntity;

public interface PaperProblemService {

    /**
     * 添加试卷题目关联信息
     * @param paperProblemEntity
     * @return
     */
    public int addPaperProblem(PaperProblemEntity paperProblemEntity);
}
