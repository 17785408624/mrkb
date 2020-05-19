package com.mrkb.service;

import com.mrkb.dao.modle.exam.OptionEntity;

import java.util.List;

public interface OptionService {

    /**
     * 添加题目选项信息
     * @param optionEntity
     * @return
     */
    public int addOption(OptionEntity optionEntity);

    /**
     * 通过题目id查询对应选项
     * @param problemId
     * @return
     */
    public List queryOption(Integer problemId);
}
