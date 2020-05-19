/**
 * FileName:         CompanyServiceImpl.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-4-8     下午5:07:57
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-4-8     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.service.impl;

import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.stereotype.Service;

import com.mrkb.common.utils.encryption.Md5Util;
import com.mrkb.dao.dao.BasicUserMapper;
import com.mrkb.dao.dao.CompanyMapper;
import com.mrkb.dao.dao.UserAchievementMapper;
import com.mrkb.dao.dao.UserInformationMapper;
import com.mrkb.dao.dao.UserRecommendMapper;
import com.mrkb.dao.modle.user.BasicsUser;
import com.mrkb.dao.modle.user.UserInformationEntity;
import com.mrkb.service.CompanyService;


/**
 * @param
 * @return
 * @author moerka-1
 * 
 */
@Service
public class CompanyServiceImpl implements CompanyService {
	@Resource
	CompanyMapper companyMapper;
	@Resource
	private UserInformationMapper userInformationMapper;
	@Resource
	private UserRecommendMapper userRecommendMapper;
	@Resource
	private UserAchievementMapper userAchievementMapper;
	@Resource
	private BasicUserMapper basicUserMapper;

	/**
	 * <p>
	 * Title: addCompany
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @return
	 * @see com.medicinefood.service.CompanyService#addCompany()
	 */
//	@Override
//	public int addCompany(CompanyBasicsEntity companyBasicsEntity) {// 添加公司
//		Integer user_basics_id = companyBasicsEntity.getUser_basics_id();
//		companyMapper.insertCompany(companyBasicsEntity);
//		//将新公司老总的上级(推荐人)更改为上级公司的老总
//		CompanyBasicsEntity cbe2=new CompanyBasicsEntity();
//		cbe2.setCompany_id(companyBasicsEntity.getSuper_company_id());
//		cbe2=companyMapper.findone(cbe2);
//		int super_user_id=cbe2.getUser_basics_id();
//		UserRecommend ur=new UserRecommend();
//		ur.setRecommend_superior(super_user_id);
//		ur.setUser_basics_id(user_basics_id);
//		userRecommendMapper.updateUserRecommend(ur);
//		// 添加公司老总
//		UserInformationEntity uife = new UserInformationEntity();
//		
//		uife.setUser_basics_id(user_basics_id);//
//		uife.setCompany_id(companyBasicsEntity.getCompany_id());// 所属公司
//		uife.setCo_founder(2);// 领衔创办人
//		userInformationMapper.updateUserInformation(uife);// 添加领衔创办人
//		// 添加分公司会员
//		UserInformationEntity uife2 = new UserInformationEntity();
//		Integer[] userids = new Integer[] { user_basics_id };
//		int userid;
//		if (userids.length > 0) {
//			do {
//
//				userids = userRecommendMapper.findSubordinate(userids);
//				if (userids.length < 1) {
//					break;
//				}
//				if (userids.length != 0 || userids != null) {
//					for (int j = 0; j < userids.length; j++) {
//						userid = userids[j];
//						uife2.setUser_basics_id(userid);
//						uife2.setCompany_id(companyBasicsEntity.getCompany_id());// 公司编号
//						uife2.setCo_founder(1);
//						userInformationMapper.updateUserInformation(uife2);// 添加分公司会员
//						uife2 = new UserInformationEntity();
//					}
//				}
//
//			} while (userids.length != 0 || userids != null);
//			uife = new UserInformationEntity();// 清空联合创办人实体
//		}
//
//		// 所添加的公司为下级公司的上级
//		String low_company_ids = companyBasicsEntity.getLow_company_id();
//		if (low_company_ids != null && !low_company_ids.equals("")) {
//			String[] low_company_ides = low_company_ids.split(";");
//			int super_company_id = companyBasicsEntity.getCompany_id();// 所添加的公司为下级公司的上级
//			int company_id;
//			CompanyBasicsEntity cbe = new CompanyBasicsEntity();
//			cbe.setSuper_company_id(super_company_id);
//			for (int i = 0; i < low_company_ides.length; i++) {
//				company_id = Integer.valueOf(low_company_ides[i]);// 所添加的下级公司为下级的公司ID
//				cbe.setCompany_id(company_id);
//				companyMapper.updateCompany(cbe);
//			}
//		}
//		return 1;
//	}

	/**
	 * <p>
	 * Title: findCompanyShow
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param company_type
	 * @return
	 * @see com.medicinefood.service.CompanyService#findCompanyShow(int)
	 */
//	@Override
//	public List<CompanyShow> findCompanyShow(int company_type) {// 查询前端显示公司信息所需数据
//		return companyMapper.selectCompanyShow(company_type);
//	}

//	@Override
//	public List<CompanyBasicsEntity> findLv(
//			CompanyBasicsEntity companyBasicsEntity) {
//		return companyMapper.findLv(companyBasicsEntity);
//	}

//	@Override
//	public CompanyBasicsEntity findone(CompanyBasicsEntity companyBasicsEntity) {
//		return companyMapper.findone(companyBasicsEntity);
//	}
	//添加品牌大使
	@Override
	public int adminAddCoFounder(HashMap<String, Object> map) {
		int user_grade_id=Integer.valueOf(String.valueOf(map.get("user_grade_id")));
		
		int user_basics_id = Integer.valueOf(String.valueOf(map.get("user_basics_id")));// 品牌大使用户编号
		String user_account_num=String.valueOf(map.get("user_account_num"));
		String user_password=String.valueOf(map.get("user_password"));
		int company_id = 1;// 公司编号
		if(user_grade_id==5||user_grade_id==7){
			//int user_basics_id_sup = Integer.valueOf(String.valueOf(map.get("user_basics_id_sup")));// 公司老总ID
//			CompanyBasicsEntity cbey=new CompanyBasicsEntity();
//			cbey.setCompany_id(company_id);
//			CompanyBasicsEntity cbe=companyMapper.findone(cbey);
//			if(cbe.getIf_co()==2){
//				return -2;
//			}
			// 将推荐人换为目标公司老总
//			UserRecommend ur = new UserRecommend();
//			ur.setRecommend_superior(user_basics_id_sup);
//			ur.setUser_basics_id(user_basics_id);
//			int update=userRecommendMapper.updateUserRecommend(ur);// 将推荐人换为目标公司老总
			// 添加品牌大使
			UserInformationEntity uife = new UserInformationEntity();
			uife.setUser_basics_id(user_basics_id);
			uife.setCo_user_basics_id(user_basics_id);
			uife.setCo_founder(3);
            if(String.valueOf(map.get("consult_picture"))!=null&&!String.valueOf(map.get("consult_picture")).equals("")){
                uife.setConsult_picture(String.valueOf(map.get("consult_picture")));
            }
            if(String.valueOf(map.get("consult_view"))!=null&&!String.valueOf(map.get("consult_view")).equals("")){
                uife.setConsult_view(String.valueOf(map.get("consult_view")));
            }
			if(user_grade_id==7){
				uife.setCo_founder(4);
			}
			uife.setCompany_id(company_id);
			userInformationMapper.updateUserInformation(uife);// 添加品牌大使
			// 手动添加品牌大使时,添加历史积分
//			HashMap<String, Object> bonusMap1 = new HashMap<String, Object>();
//			bonusMap1.put("user_basics_id",user_basics_id);
//			bonusMap1.put("records_integral", GlobalStatic.co_send);
//			userAchievementMapper.updateArchivement1(bonusMap1);
			// 添加分公司会员
			UserInformationEntity uife2 = new UserInformationEntity();
			Integer[] userids = new Integer[] { user_basics_id };
			int userid;
			if (userids.length > 0) {
				do {

					userids = userRecommendMapper.findSubordinate(userids);
					if (userids.length < 1) {
						break;
					}
					if (userids.length != 0 || userids != null) {
						for (int j = 0; j < userids.length; j++) {
							
							userid = userids[j];
							UserInformationEntity u=userInformationMapper.selectUserInformationEntityToUserId(userid);
							if(u.getCo_founder()==3){
								userids[j]=0;
								for(int k=j;k< userids.length-1;k++){
									userids[k]=userids[k+1];
								   	}
								continue;
							}
							
							uife2.setUser_basics_id(userid);
							uife2.setCompany_id(company_id);// 公司编号
							uife2.setCo_user_basics_id(user_basics_id);//所属品牌大使
							uife2.setCo_founder(0);
							userInformationMapper.updateUserInformation(uife2);// 添加总公司会员
							uife2 = new UserInformationEntity();
						}
					}

				} while (userids.length != 0 || userids != null);
				uife = new UserInformationEntity();// 清空品牌大使实体
			}
		}else if(user_grade_id==7){//员工
			UserInformationEntity uife = new UserInformationEntity();
			uife.setUser_basics_id(user_basics_id);
			uife.setIs_employee(1);
			userInformationMapper.updateUserInformation(uife);//添加员工标识
		}
		BasicsUser bu=new BasicsUser();
        if(user_password!=null&&!user_password.equals("")){
            user_password = new Sha256Hash( user_password ).toHex();
            bu.setUser_password(user_password);
        }
		bu.setUser_account_num(user_account_num);
		bu.setUser_basics_id(user_basics_id);
		bu.setUser_grade_id(user_grade_id);
		int update=basicUserMapper.updateAdminUser(bu);
		return update;
	}

	@Override
	public int adminUpdateCoFounder(HashMap<String, Object> map) {
		int update=userInformationMapper.adminUpdateCoFounder(map);
		UserInformationEntity ue=new UserInformationEntity();
		ue.setUser_basics_id(Integer.valueOf(String.valueOf(map.get("old_user_basics_id"))));
		ue.setCo_founder(0);
		ue.setCo_user_basics_id(0);
		userInformationMapper.updateUserInformation(ue);
		return update;
	}

}
