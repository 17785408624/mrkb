package com.mrkb.dao.dao;

import com.mrkb.dao.modle.exam.PaperEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaperMapper {

    /**
     * 录入试卷
     * @param paperEntity
     * @return
     */
     int addPaper(PaperEntity paperEntity);

    /**
     * 查询试卷列表
     * @param paperEntity
     * @return
     */
     List<PaperEntity> queryPaperList(PaperEntity paperEntity);

}
