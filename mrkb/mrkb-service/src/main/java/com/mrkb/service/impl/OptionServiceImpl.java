package com.mrkb.service.impl;

import com.mrkb.dao.dao.OptionMapper;
import com.mrkb.dao.modle.exam.OptionEntity;
import com.mrkb.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OptionServiceImpl implements OptionService {

    @Autowired
    private OptionMapper optionMapper;

    @Override
    public int addOption(OptionEntity optionEntity) {
        return optionMapper.addOption(optionEntity);
    }

    @Override
    public List queryOption(Integer problemId) {
        return optionMapper.queryOption(problemId);
    }
}
