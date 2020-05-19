package com.mrkb.service.impl;

import com.mrkb.dao.dao.MemberAnswerMapper;
import com.mrkb.dao.modle.exam.MemberAnswerEntity;
import com.mrkb.service.MemberAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = Exception.class)
@Service
public class MemberAnswerServiceImpl implements MemberAnswerService {

    @Autowired
    private MemberAnswerMapper memberAnswerMapper;

    @Override
    public int addMemberAnswer(MemberAnswerEntity memberAnswerEntity) {
        return memberAnswerMapper.addMemberAnswer(memberAnswerEntity);
    }
}
