package com.mrkb.service.impl;

import com.mrkb.dao.dao.SignMapper;
import com.mrkb.dao.modle.exam.SignEntity;
import com.mrkb.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(rollbackFor = Exception.class)
@Service
public class SignServiceImpl implements SignService {

    @Autowired
    private SignMapper signMapper;

    @Override
    public int addSign(SignEntity signEntity) {
        return signMapper.addSign(signEntity);
    }

    @Override
    public List<SignEntity> querySignList(SignEntity signEntity) {
        return signMapper.querySignList(signEntity);
    }
}
