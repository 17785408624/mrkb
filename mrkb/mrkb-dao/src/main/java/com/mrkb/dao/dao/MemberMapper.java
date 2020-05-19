package com.mrkb.dao.dao;

import com.mrkb.dao.modle.exam.MemberEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    /**
     * 添加考试会员
     * @param memberEntity
     * @return
     */
    int addMember(MemberEntity memberEntity);

    /**
     * 条件查询会员
     * @param memberEntity
     * @return
     */
    List<MemberEntity> queryMemberList(MemberEntity memberEntity);

}
