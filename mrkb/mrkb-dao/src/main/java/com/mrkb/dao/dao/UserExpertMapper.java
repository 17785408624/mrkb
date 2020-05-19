package com.mrkb.dao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mrkb.dao.modle.user.ExpertEntity;




@Mapper
public interface UserExpertMapper {
    /**
     * 
     * @Title:             addExpert
     * @Description:     TODO 添加专家
     * @param:             @return   
     * @return:         int  
     * @throws
     */
	int addExpert(ExpertEntity eey);//查询所有用户基本信息及等级
	/**
     * 
     * @Title:             findExpert
     * @Description:     TODO 查询专家
     * @param:             @return   
     * @return:         List<ExpertEntity>  
     * @throws
     */
	List<ExpertEntity> findExpert(ExpertEntity eey);//查询专家
	int updateExpert(ExpertEntity eey);//修改专家
	int deleteExpert(int expert_id);//删除专家
}
