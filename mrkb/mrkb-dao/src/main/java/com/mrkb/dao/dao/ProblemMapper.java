package com.mrkb.dao.dao;

import com.mrkb.dao.modle.exam.ProblemEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProblemMapper {

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
