package com.mrkb.service.impl;

import com.mrkb.dao.dao.ProblemMapper;
import com.mrkb.dao.modle.exam.ProblemEntity;
import com.mrkb.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProblemServiceImpl implements ProblemService {

    @Autowired
    private ProblemMapper problemMapper;


    @Override
    public int addProblem(ProblemEntity problemEntity) {
        return problemMapper.addProblem(problemEntity);
    }

    @Override
    public List<ProblemEntity> queryProblem(Integer paperId) {
        return problemMapper.queryProblem(paperId);
    }
}
