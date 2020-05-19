package com.mrkb.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mrkb.dao.dao.CompanyBasicsMapper;
import com.mrkb.dao.dao.CompanyMapper;
import com.mrkb.dao.dao.UserInformationMapper;
import com.mrkb.dao.dao.UserRecommendMapper;
import com.mrkb.dao.modle.company.CompanyBasicsEntity;
import com.mrkb.dao.modle.company.CompanyLeadFounderEntity;
import com.mrkb.dao.modle.user.UserInformationEntity;
import com.mrkb.service.CompanyBasicsService;

@Service("CompanyBasicsServiceImpl")
public class CompanyBasicsServiceImpl implements CompanyBasicsService {
	@Resource
	private CompanyBasicsMapper companyBasicsMapper;
	@Resource
	private UserInformationMapper userInformationMapper;
	@Resource
	private UserRecommendMapper userRecommendMapper;
	@Resource
	private CompanyMapper companyMapper;
	@Override
	public int addCompany(CompanyBasicsEntity companyBasicsEntity) {
		int addnum=companyBasicsMapper.addCompany(companyBasicsEntity);
		Integer user_basics_id=companyBasicsEntity.getUser_basics_id();
		UserInformationEntity uife=new UserInformationEntity();
		//添加领衔创办人
		uife.setUser_basics_id(user_basics_id);//
		uife.setCompany_id(companyBasicsEntity.getCompany_id());//所属公司
		uife.setCo_founder(2);//领衔创办人
		userInformationMapper.updateUserInformation(uife);//添加领衔创办人
		uife=new UserInformationEntity();//清空领衔创办人实体
		Integer[] barr=new Integer[]{user_basics_id};
		//添加联合创办人
		Integer[] user_basics_ids=userRecommendMapper.findSubordinate(barr);
		
		int userid;
		UserInformationEntity uife2=new UserInformationEntity();
		for(int i=0;i<user_basics_ids.length;i++){
			//判断是否达到联合创办人的要求
			user_basics_id=user_basics_ids[i];
			uife.setUser_basics_id(user_basics_id);//用户编号
//			BasicsUser bur=basicUsermapper.findUserBasics(user_basics_id);//查询用户等级
//			Integer user_grade_id=bur.getUser_grade_id();
			
			uife.setCompany_id(companyBasicsEntity.getCompany_id());//所属公司
			uife.setCo_founder(3);//联合创办人
			uife.setCo_user_basics_id(user_basics_id);//所属联合创办人
			Integer co_user_basics_id=null;
//			if(user_grade_id>=3){//大于3表示已是正式会员可以成为联合创办人
				userInformationMapper.updateUserInformation(uife);//添加联合创办人
				co_user_basics_id=uife.getCo_user_basics_id();
//			}else{
//				uife.setCo_founder(1);//未达到联合创办人要求，设置为普通员工
//				userInformationMapper.updateUserInformation(uife);
//			}
			Integer[] userids=new Integer[]{user_basics_id};
			if(userids.length>0){
				
			
			//添加分公司会员
			do {
				
				userids=userRecommendMapper.findSubordinate(userids);
				if(userids.length<1){
					break;
				}
				if(userids.length!=0||userids!=null){
					for(int j=0;j<userids.length;j++){
						userid=userids[j];
						uife2.setUser_basics_id(userid);
						uife2.setCompany_id(companyBasicsEntity.getCompany_id());//公司编号
						uife2.setCo_founder(1);
						uife2.setCo_user_basics_id(co_user_basics_id);
						userInformationMapper.updateUserInformation(uife2);//添加分公司会员
						uife2=new UserInformationEntity(); 
					}
				}
				
			} while (userids.length!=0||userids!=null);
			uife=new UserInformationEntity();//清空联合创办人实体
			}
		}
		
		
		return addnum;
	}

	@Override
	public int updateCompanyBasicsState(CompanyBasicsEntity companyBasics) {
		return companyBasicsMapper.updateCompanyBasicsState(companyBasics);
	}

	@Override
	public List<CompanyBasicsEntity> findCompanyBasics(HashMap<String, Object> map) {
		return companyBasicsMapper.findCompanyBasicsmp(map);
	}

	@Override
	public CompanyBasicsEntity upComBasicsAnduinformation(CompanyBasicsEntity companyBasics) {
		companyBasicsMapper.updateCompanyBasics(companyBasics);
		companyBasicsMapper.updateuserinformation(companyBasics);
		return companyBasics;
	}

	@Override
	public int updateCompanyBasicsAgree(CompanyBasicsEntity companyBasics) {
		return companyBasicsMapper.updateCompanyBasicsAgree(companyBasics);
	}

	@Override
	public List<CompanyLeadFounderEntity> findAllLeadFounder(HashMap<String,Object> map) {
		return companyMapper.findAllLeadFounder(map);
	}

}
