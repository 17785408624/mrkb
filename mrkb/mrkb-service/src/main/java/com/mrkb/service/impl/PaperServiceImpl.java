package com.mrkb.service.impl;

import com.mrkb.dao.dao.PaperMapper;
import com.mrkb.dao.modle.exam.PaperEntity;
import com.mrkb.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class PaperServiceImpl implements PaperService {

    @Autowired
    private PaperMapper paperMapper;


    @Override
    public int addPaper(PaperEntity paperEntity) {
        return paperMapper.addPaper(paperEntity);
    }

    @Override
    public List<PaperEntity> queryPaperList(PaperEntity paperEntity) {
        return paperMapper.queryPaperList(paperEntity);
    }
}
