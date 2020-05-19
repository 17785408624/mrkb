package com.mrkb.dao.dao;

import com.mrkb.dao.modle.exam.OptionEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OptionMapper {

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
