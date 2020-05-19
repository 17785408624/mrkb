package com.mrkb.service.impl;

import com.mrkb.dao.dao.MemberMapper;
import com.mrkb.dao.modle.exam.MemberEntity;
import com.mrkb.service.MemberServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(rollbackFor = Exception.class)
@Service
public class MemberServiceImpl implements MemberServie {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public int addMember(MemberEntity memberEntity) {
        return memberMapper.addMember(memberEntity);
    }

    @Override
    public List<MemberEntity> queryMemberList(MemberEntity memberEntity) {
        return memberMapper.queryMemberList(memberEntity);
    }
}
