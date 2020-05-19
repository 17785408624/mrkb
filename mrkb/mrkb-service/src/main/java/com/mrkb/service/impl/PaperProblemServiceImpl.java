package com.mrkb.service.impl;

import com.mrkb.dao.dao.PaperProblemMapper;
import com.mrkb.dao.modle.exam.PaperProblemEntity;
import com.mrkb.service.PaperProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PaperProblemServiceImpl implements PaperProblemService {

    @Autowired
    private PaperProblemMapper paperProblemMapper;

    @Override
    public int addPaperProblem(PaperProblemEntity paperProblemEntity) {
        return paperProblemMapper.addPaperProblem(paperProblemEntity);
    }
}
