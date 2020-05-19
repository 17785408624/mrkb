package com.mrkb.dao.dao;

import com.mrkb.dao.modle.exam.PaperProblemEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaperProblemMapper {

    /**
     * 添加试卷题目关联信息
     * @param paperProblemEntity
     * @return
     */
    public int addPaperProblem(PaperProblemEntity paperProblemEntity);
}
