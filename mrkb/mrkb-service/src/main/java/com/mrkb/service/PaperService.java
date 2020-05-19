package com.mrkb.service;

import com.mrkb.dao.modle.exam.PaperEntity;

import java.util.List;

public interface PaperService {

    /**
     * 录入试卷
     * @param paperEntity
     * @return
     */
    public int addPaper(PaperEntity paperEntity);

    /**
     * 查询试卷列表
     * @param paperEntity
     * @return
     */
    public List<PaperEntity> queryPaperList(PaperEntity paperEntity);
}
