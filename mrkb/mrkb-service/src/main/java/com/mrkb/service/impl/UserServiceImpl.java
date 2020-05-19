package com.mrkb.service.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrkb.common.utils.publicUtil;
import com.mrkb.common.utils.encryption.Md5Util;
import com.mrkb.common.utils.globalStatic.GlobalStatic;
import com.mrkb.dao.dao.BasicUserMapper;
import com.mrkb.dao.dao.CompanyBasicsMapper;
import com.mrkb.dao.dao.ConverFlowMapper;
import com.mrkb.dao.dao.GradeUpgradeConditionAccomplishMapper;
import com.mrkb.dao.dao.GradeUpgradeConditionGroupConditionMapper;
import com.mrkb.dao.dao.GradeUpgradeConditionGroupMapper;
import com.mrkb.dao.dao.GradeUpgradeConditionMapper;
import com.mrkb.dao.dao.IntegralMapper;
import com.mrkb.dao.dao.OrderMapper;
import com.mrkb.dao.dao.PrivilegeMapper;
import com.mrkb.dao.dao.SystemLoginMapper;
import com.mrkb.dao.dao.UserAchievementMapper;
import com.mrkb.dao.dao.UserConsultServiceMapper;
import com.mrkb.dao.dao.UserExpandIdMapper;
import com.mrkb.dao.dao.UserGradeMapper;
import com.mrkb.dao.dao.UserInformationMapper;
import com.mrkb.dao.dao.UserIntegralMapper;
import com.mrkb.dao.dao.UserMapper;
import com.mrkb.dao.dao.UserRecommendMapper;
import com.mrkb.dao.dao.UserUpdateMapper;
import com.mrkb.dao.dao.UserWeixinMapper;
import com.mrkb.dao.modle.account.IntegralAccount;
import com.mrkb.dao.modle.core.AwardOperationEntity;
import com.mrkb.dao.modle.core.TeamEntity;
import com.mrkb.dao.modle.user.BasicsAndGradeEntity;
import com.mrkb.dao.modle.user.BasicsUser;
import com.mrkb.dao.modle.user.GradeUpgradeConditionEntity;
import com.mrkb.dao.modle.user.GradeUpgradeConditionGroupConditionEntity;
import com.mrkb.dao.modle.user.GradeUpgradeConditionGroupEntity;
import com.mrkb.dao.modle.user.TeamInformation;
import com.mrkb.dao.modle.user.UserAchievement;
import com.mrkb.dao.modle.user.UserAchievementAccount;
import com.mrkb.dao.modle.user.UserBasicsAndWxAndInformationEntity;
import com.mrkb.dao.modle.user.UserConsultServiceEntity;
import com.mrkb.dao.modle.user.UserExpandId;
import com.mrkb.dao.modle.user.UserGrade;
import com.mrkb.dao.modle.user.UserInformationEntity;
import com.mrkb.dao.modle.user.UserIntegral;
import com.mrkb.dao.modle.user.UserRecommend;
import com.mrkb.dao.modle.user.UserRecommendWinxinBasics;
import com.mrkb.dao.modle.user.UserTeamEntity;
import com.mrkb.dao.modle.user.UserWeixin;
import com.mrkb.service.UserService;




@Transactional(rollbackFor = Exception.class)
@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
	@Autowired
	SystemLoginMapper systemLoginMapper;
	@Resource
	private UserMapper userMapper;
	@Resource
	private IntegralMapper integralMapper;
	@Resource
	private BasicUserMapper basicUsermapper;
	@Resource
	private CompanyBasicsMapper companyBasicsMapper;
	@Resource
	private ConverFlowMapper converFlowMapper;
	@Resource
	private UserWeixinMapper userWeixinMapper;
	@Resource
	private UserRecommendMapper userRecommendMapper;
	@Resource
	private UserIntegralMapper userIntegralMapper;
	@Resource
	private UserAchievementMapper userAchievementMapper;
	@Resource
	private UserUpdateMapper userUpdateMapper;
	@Resource
	private UserExpandIdMapper userExpandIdMapper;
	@Resource
	private UserGradeMapper userGradeMapper;
	@Resource
	private UserInformationMapper userInformationMapper;
	@Resource
	private GradeUpgradeConditionMapper gradeUpgradeConditionMapper;
	@Resource
	private OrderMapper basicOrderMapper;
	@Resource
	private GradeUpgradeConditionAccomplishMapper gradeUpgradeConditionAccomplishMapper;
	@Resource
	BasicUserMapper basicUserMapper;
	@Resource
	PrivilegeMapper privilegeMapper;
	@Resource
	GradeUpgradeConditionGroupMapper gradeUpgradeConditionGroupMapper;
	@Resource
	GradeUpgradeConditionGroupConditionMapper gradeUpgradeConditionGroupConditionMapper;
	@Resource
	UserConsultServiceMapper userConsultServiceMapper;
	public int addUserWeixin(BasicsUser bu, UserWeixin uw,
							 String recommend_superior_winxin) {
		int userBasicsId = 0;
		// 如果用户信息中没有用户昵称，将用户昵称存为微信昵称
		if ((bu.getUser_nickname() == null || bu.getUser_nickname() == "")
				&& (uw.getWeixin_nickname() != null && uw.getWeixin_nickname() != "")) {
			bu.setUser_nickname(uw.getWeixin_nickname());
		}
		bu.setUser_grade_id(1);//等级默认为1
		int b = basicUsermapper.addBasicsUser(bu);
		userBasicsId = bu.getUser_basics_id();
		uw.setUser_basics_id(userBasicsId);
		basicUsermapper.addUserWeixin(uw);

		UserRecommend userRecommend = new UserRecommend();// 基本推荐关系类
		UserInformationEntity userInformationEntity = new UserInformationEntity();// 用户补充信息
		int company_id = 0;// 用户所属公司id
		int superior_userid = 0;// 用户推荐人id
		int co_founder=0;//创办人标识，0：总公司会员，1：分公司会员，2：领衔创办人，3：联合创办人 ,4:员工
		int co_user_basics_id=-1;//所属联合创办人ID
		if(recommend_superior_winxin == null
				|| recommend_superior_winxin == "null"
				|| recommend_superior_winxin == ""||recommend_superior_winxin.equals("")){
			recommend_superior_winxin="1";
		}
		if (recommend_superior_winxin != null
				&& recommend_superior_winxin != "null"
				&& recommend_superior_winxin != "") {
			superior_userid = userWeixinMapper.findUserBasicsIdWeixinId(recommend_superior_winxin);// 查出推荐人的userid
			/**
			 * zrm
			 * 查询推荐人是否为联合创办人，所属公司，所属联合创办人
			 */
			UserInformationEntity userInformationEntity1 =  //推荐人信息
					userInformationMapper.selectUserInformationEntityToUserId(superior_userid);
			//推荐人无所属公司id，用户公司id为1
			company_id=userInformationEntity1==null?1:userInformationEntity1.getCompany_id();
			co_founder=userInformationEntity1.getCo_founder();
			try {
				if(userInformationEntity1.getCo_user_basics_id()!=null&&!userInformationEntity1.getCo_user_basics_id().equals("")){
					co_user_basics_id=userInformationEntity1.getCo_user_basics_id();
				}

				//如果为联合创办人，则所属联合创办人为自己
				if(co_founder==1){//上级为分公司会员
					co_founder=1;
					userInformationEntity.setCo_user_basics_id(co_user_basics_id);//所属联合创办人ID
				}else if(co_founder==2){//上级为领衔创办人
					co_founder=1;
//					CompanyBasicsEntity cbe=companyBasicsMapper.findCompanyOne(company_id);
//					if(cbe.getIf_co()==1){//公司可以添加联合创办人
//						co_founder=3;
//						userInformationEntity.setCo_user_basics_id(bu.getUser_basics_id());//自己为所属联合创办人ID
//					}else if(cbe.getIf_co()==2){//公司不能添加联合创办人
//						co_user_basics_id=-1;
//						co_founder=1;
//					}
				}
				else if(co_founder==3||co_founder==4){//上级为联合创办人或员工
					co_founder=1;
					userInformationEntity.setCo_user_basics_id(userInformationEntity1.getUser_basics_id());//所属联合创办人ID为上级ID
				}
				else if(co_founder==0){//上级为总公司会员
					co_founder=0;
//					userInformationEntity.setCo_user_basics_id(0);//总公司会员所属联合创办人ID为0
				}else{
					co_founder=0;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

		} else {
			return 1;

		}

		Integer recommend_type = 1;// 推荐方式
		userInformationEntity.setUser_basics_id(userBasicsId);//设置用户id
		userInformationEntity.setCompany_id(company_id);// 设置用户所属公司id
		userInformationEntity.setCo_founder(co_founder);//创办人标识
		userInformationMapper.insertUserInformationEntity(userInformationEntity);// 添加用户补充信息
		// /////////////
		userRecommend.setRecommend_superior(superior_userid);
		userRecommend.setRecommend_type(recommend_type);
		userRecommend.setUser_basics_id(userBasicsId);
		int recommend_id=userRecommendMapper.addUserRecommend(userRecommend);// 建立用户基本推荐关系数据
		// 添加sys_user
		try {
			userRecommendMapper.addSysUser(userBasicsId);
		} catch (Exception e) {

		}

		/**
		 * zrm
		 * 推荐人添加积分流水
		 */
		IntegralAccount integralAccount=new IntegralAccount();//积分流水记录实体类
		integralAccount.setAccount_add_date(new Date().getTime());//更改积分时间（添加数据时间）
		integralAccount.setAccount_option_name("积分");
		integralAccount.setAccount_option("integral_basics");//改变的数据
		integralAccount.setIntegral_account_explain("推荐公众号获取奖励");//流水说明
		integralAccount.setIntegral_account_num(String.valueOf(GlobalStatic.share_conver_num));//更改的值
		integralAccount.setUser_basics_id(superior_userid);//改变积分项的用户（关联user_basics表）
		integralAccount.setIntegral_account_type(2);//设置流水类型，1为购买商品,2注册，3签到
		integralAccount.setIntegral_trigger(userBasicsId);//设置流水相关订单id
		integralMapper.addIntegralAccount(integralAccount);//添加积分记录
		/**
		 * zrm
		 * 注册用户添加积分流水
		 */
		IntegralAccount integralAccount1=new IntegralAccount();//积分流水记录实体类
		integralAccount1.setAccount_add_date(new Date().getTime());//更改积分时间（添加数据时间）
		integralAccount1.setAccount_option_name("积分");
		integralAccount1.setAccount_option("integral_basics");//改变的数据
		integralAccount1.setIntegral_account_explain("注册获取奖励");//流水说明
		integralAccount1.setIntegral_account_num(String.valueOf(GlobalStatic.share_conver_num));//更改的值
		integralAccount1.setUser_basics_id(userBasicsId);//改变积分项的用户（关联user_basics表）
		integralAccount1.setIntegral_account_type(2);//设置流水类型，1为购买商品,2注册，3签到
		integralAccount1.setIntegral_trigger(userBasicsId);//设置流水相关订单id
		integralMapper.addIntegralAccount(integralAccount1);//添加积分记录

		//推荐人添加积分
		AwardOperationEntity aoe=new AwardOperationEntity();
		aoe.setAwardOption("integral_basics");
		aoe.setAwardValue(String.valueOf(GlobalStatic.share_conver_num));
		aoe.setAwardUserID(superior_userid);
		userIntegralMapper.operationIntegral(aoe);

		//推荐人添加历史积分
		UserAchievement userAchievement1=new UserAchievement();//用户基本成就实体类
		userAchievement1.setUser_basics_id(superior_userid);
		userAchievement1.setRecords_integral(GlobalStatic.share_conver_num);
		userAchievementMapper.augmentUserAchievement(userAchievement1);//增加推荐人历史积分
		// 用户注册加积分
		UserIntegral userIntegral = new UserIntegral();// 用户基本积分类
		userIntegral.setIntegral_basics(GlobalStatic.share_conver_num);//注册送10积分
		userIntegral.setUser_basics_id(userBasicsId);// 设置用户id
		userIntegralMapper.addUserIntegral(userIntegral);// 建立用户基础积分数据
		// 用户注册加历史积分
		UserAchievement userAchievement2 = new UserAchievement();// 用户基本成就类
		userAchievement2.setRecords_integral(GlobalStatic.share_conver_num);
		userAchievement2.setUser_basics_id(userBasicsId);
		userAchievementMapper.addUserAchievement(userAchievement2);// 建立用户基本成就数据
		// 为用户的推荐人增加直推人数成就
		UserAchievement userAchievement = new UserAchievement();// 用户基本成就类
		userAchievement.setDirect_team_num(1);// 直推人数加一

		userAchievement.setUser_basics_id(superior_userid);// 上级用户添加直推人数的成就
		// ////增加用户基本成就
		userAchievementMapper.augmentUserAchievement(userAchievement);// 增加用户基本成就
		return userBasicsId;

	}

	public BasicsUser findUserWeixin(UserWeixin uw) {
		return basicUsermapper.findUserWeixin(uw);
	}

	public BasicsUser finduserWeixinone(UserWeixin uw) {
		return basicUsermapper.finduserWeixinone(uw);
	}

	public int createUserRecommend(UserRecommend ur) {// 创建用户推荐关系
		int i = userRecommendMapper.addUserRecommend(ur);
		// UserAchievement userAchievement=new UserAchievement();//用户基本成就实体类
		// userAchievement.setDirect_team_num(1);//直推人数加一
		// userAchievement.setUser_basics_id(ur.getRecommend_superior());//上级用户添加直推人数的成就
		// //////增加用户基本成就
		// userAchievementMapper.augmentUserAchievement(userAchievement);//增加用户基本成就
		return i;
	}

	public int findUserBasicsIdWeixinId(String recommend_superior_winxin) {
		return userWeixinMapper
				.findUserBasicsIdWeixinId(recommend_superior_winxin);
	}

	public int createUserIntegral(UserIntegral ui) {

		return userIntegralMapper.addUserIntegral(ui);
	}

	public int updateIntegral(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return userIntegralMapper.updateIntegral(map);
	}

	/**
	 * 查询用户的推荐人id，userid为用户id，round为推荐人的级数
	 */
	public UserRecommend findUserSuperiorUserid(int userid, int round) {
		userRecommendMapper.findUserSuperiorUserid(userid, round);
		return userRecommendMapper.findUserSuperiorUserid(userid, round);
	}

	/**
	 * 创建用户成就记录
	 */
	public int addUserAchievement(UserAchievement userAchievement) {
		userAchievementMapper.addUserAchievement(userAchievement);
		int achievement_id = userAchievement.getAchievement_id();// 返回添加数据的主键
		return achievement_id;
	}

	/**
	 * 更改一行数据，值为数字。需要表名，列名，改变的值
	 */
	public int updateLineAchievement(Map<String, String> updateMap) {
		int i = userUpdateMapper.updateNumLine(updateMap);
		return i;
	}

	public BasicsUser findUserBas(UserWeixin uw) {
		return null;
	}

	public BasicsUser finduserBasics(int user_basics_id) {// 根据用户id查询用户基本信息
		return basicUsermapper.findUserBasics(user_basics_id);
	}

	public int updateUserBasics(BasicsUser basicsUser) {
		return basicUsermapper.updateUserBasics(basicsUser);

	}

	public Integer editUserWeixin(UserWeixin userWeixin) {

		return userWeixinMapper.editUserWeixin(userWeixin);
	}

	public UserWeixin findUserWeixin(String weixin_id) {// 根据用户微信id查询微信信息
		publicUtil pc = new publicUtil();
		UserWeixin uw = new UserWeixin();
		uw = userWeixinMapper.findUserWeixin(weixin_id);
		if (uw == null) {
			return null;
		}
		String weixin_nickname = uw.getWeixin_nickname();
		weixin_nickname = pc.emojiRecovery(weixin_nickname);
		uw.setWeixin_nickname(weixin_nickname);
		return uw;
	}

	public UserIntegral findUserIntegral(Integer user_basics_id) {// 通过用户id查询用户积分信息
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("user_basics_id", user_basics_id);
		return userIntegralMapper.findUserIntegralAll(map);
	}

	@Override
	public UserAchievement findUserAchievement(int user_basics_id) {

		return userAchievementMapper.findUserAchievementAll(user_basics_id);
	}

	@Override
	public UserExpandId addaddress(HashMap<String, Object> map) {
		return userExpandIdMapper.addaddress(map);
	}

	@Override
	public List<UserAchievementAccount> findUserAchievementAccount(
			int user_basics_id) {
		return userAchievementMapper.findUserAchievementAccount(user_basics_id);
	}

	@Override
	public UserWeixin findUserWeixinUserBasicsId(Integer weixin_id) {
		// TODO Auto-generated method stub
		return userWeixinMapper.findUserWeixinUserBasicsId(weixin_id);
	}

	@Override
	public List<UserExpandId> findaddress(HashMap<String, Object> map) {
		return userExpandIdMapper.findaddress(map);
	}

	/**
	 *
	 */
	@Override
	public TeamEntity findUserSubordinateUserWeixinUserid(int user_basics_id,
														  int series) {// 根据用户id查询下级微信信息
		Map<Integer, List<UserWeixin>> userWeixinListMap = new HashMap<Integer, List<UserWeixin>>();// 整体全部下级的信息，包含每一级的集合
		Map<Integer, Integer> subordinateNum = new HashMap<Integer, Integer>();// 下级人数
		List<UserWeixin> initialList = new ArrayList<UserWeixin>();// 初始的第一个集合，只有用户本身
		UserWeixin uw = new UserWeixin();
		uw.setUser_basics_id(user_basics_id);
		initialList.add(uw);
		userWeixinListMap.put(0, initialList);
		Integer allNum = 0;// 总人数
		for (int i = 0; i < series; i++) {
			List<UserWeixin> uwList = new ArrayList<UserWeixin>();// 每个下级的信息集合
			for (UserWeixin userWeixin : userWeixinListMap.get(i)) {
				List<UserWeixin> List = userRecommendMapper
						.findUserSubordinateUserWeixinUserid(userWeixin.getUser_basics_id());
				uwList.addAll(List);

			}
			allNum += uwList.size();
			subordinateNum.put(i + 1, uwList.size());
			userWeixinListMap.put(i + 1, uwList);
		}
		userWeixinListMap.remove(0);
		subordinateNum.put(0, allNum);// 零为总量
		TeamEntity teamEntity = new TeamEntity(userWeixinListMap,
				subordinateNum);
		teamEntity.setSeries(series);
		return teamEntity;
	}

	/**
	 * <p>
	 * Title: findUserGrade
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 *
	 * @param user_grade_id
	 * @return
	 * @see com.medicinefood.service.UserService#findUserGrade(int)
	 */
	@Override
	public UserGrade findUserGrade(int user_grade_id) {// 查询用户等级信息
		// TODO Auto-generated method stub
		return userGradeMapper.findUserGrade(user_grade_id);


	}

	/**
	 * <p>
	 * Title: findUserSubordinateBuyUserWeixinUserid
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 查询已购买商品的下级用户
	 *
	 * @param user_basics_id
	 *            用户id
	 * @return
	 * @see com.medicinefood.service.UserService#findUserSubordinateBuyUserWeixinUserid(int)
	 */
	@Override
	public TeamEntity findUserSubordinateBuyUserWeixinUserid(//查询已购买商品的下级用户
															 int user_basics_id, int series) {
		Map<Integer, List<UserWeixin>> userWeixinListMap = new HashMap<Integer, List<UserWeixin>>();// 整体全部下级的信息，包含每一级的集合
		Map<Integer, Integer> subordinateNum = new HashMap<Integer, Integer>();// 下级人数
		List<UserWeixin> initialList = new ArrayList<UserWeixin>();// 初始的第一个集合，只有用户本身
		UserWeixin uw = new UserWeixin();
		uw.setUser_basics_id(user_basics_id);
		initialList.add(uw);
		userWeixinListMap.put(0, initialList);
		Integer allNum = 0;// 总人数
		for (int i = 0; i < series; i++) {
			List<UserWeixin> uwList = new ArrayList<UserWeixin>();// 每个下级的信息集合
			for (UserWeixin userWeixin : userWeixinListMap.get(i)) {
				List<UserWeixin> List = userRecommendMapper
						.findUserSubordinateBuyUserWeixinUserid(userWeixin
								.getUser_basics_id());
				uwList.addAll(List);

			}
			allNum += uwList.size();
			subordinateNum.put(i + 1, uwList.size());
			userWeixinListMap.put(i + 1, uwList);
		}
		userWeixinListMap.remove(0);
		subordinateNum.put(0, allNum);// 零为总量
		TeamEntity teamEntity = new TeamEntity(userWeixinListMap,
				subordinateNum);
		teamEntity.setSeries(series);
		return teamEntity;
	}

	/**
	 * <p>
	 * Title: findUserSubordinateBuyUserWeixinUseridNum
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 *
	 * @param user_basics_id
	 * @param series
	 * @return
	 * @see com.medicinefood.service.UserService#findUserSubordinateBuyUserWeixinUseridNum(int,
	 *      int)
	 */
	@Override
	public int findUserSubordinateBuyUserWeixinUseridNum(int user_basics_id,
														 int series) {// 查询下级人数
		int i = userRecommendMapper
				.findUserSubordinateBuyUserWeixinUseridNum(user_basics_id);
		return 0;
	}

	/**
	 * <p>
	 * Title: findUserSubordinateUserWeixinUseridNum
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 *
	 * @param user_basics_id
	 * @param series
	 * @return
	 * @see com.medicinefood.service.UserService#findUserSubordinateUserWeixinUseridNum(int,
	 *      int)
	 */
	@Override
	public int findUserSubordinateUserWeixinUseridNum(int user_basics_id,
													  int series) {// 查询下级已购买商品的人数
		int i = userRecommendMapper
				.findUserSubordinateUserWeixinUseridNum(user_basics_id);
		return 0;
	}

	@Override
	public TeamEntity findUserSubordinateNotBuyUserWeixinUserid(
			int user_basics_id, int series) {// 查询未购买的下级用户微信昵称和userid
		Map<Integer, List<UserWeixin>> userWeixinListMap = new HashMap<Integer, List<UserWeixin>>();// 整体全部下级的信息，包含每一级的集合
		Map<Integer, Integer> subordinateNum = new HashMap<Integer, Integer>();// 下级人数
		List<UserWeixin> initialList = new ArrayList<UserWeixin>();// 初始的第一个集合，只有用户本身
		UserWeixin uw = new UserWeixin();
		uw.setUser_basics_id(user_basics_id);
		initialList.add(uw);
		userWeixinListMap.put(0, initialList);
		Integer allNum = 0;// 总人数
		for (int i = 0; i < series; i++) {
			List<UserWeixin> uwList = new ArrayList<UserWeixin>();// 每个下级的信息集合
			for (UserWeixin userWeixin : userWeixinListMap.get(i)) {
				List<UserWeixin> List = userRecommendMapper
						.findUserSubordinateNotBuyUserWeixinUserid(userWeixin
								.getUser_basics_id());
				uwList.addAll(List);

			}
			allNum += uwList.size();
			subordinateNum.put(i + 1, uwList.size());
			userWeixinListMap.put(i + 1, uwList);
		}
		userWeixinListMap.remove(0);
		subordinateNum.put(0, allNum);// 零为总量
		TeamEntity teamEntity = new TeamEntity(userWeixinListMap,
				subordinateNum);
		teamEntity.setSeries(series);
		return teamEntity;
	}

	/**
	 * <p>
	 * Title: findUserSubordinateSuperiorName
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 *
	 * @param user_basics_id
	 * @param series
	 * @return
	 * @see com.medicinefood.service.UserService#findUserSubordinateSuperiorName(int,
	 *      int)
	 */
	@Override
	public TeamEntity findUserSubordinateSuperiorName(int user_basics_id,
													  int series) {
		Map<Integer, List<Map<String, Object>>> userWeixinListMap = new HashMap<Integer, List<Map<String, Object>>>();// 整体全部下级的信息，包含每一级的集合
		Map<Integer, Integer> subordinateNum = new HashMap<Integer, Integer>();// 下级人数
		List<Map<String, Object>> initialList = new ArrayList<Map<String, Object>>();// 初始的第一个集合，只有用户本身
		Map uw = new HashMap();
		uw.put("user_basics_id", user_basics_id);
		initialList.add(uw);
		userWeixinListMap.put(0, initialList);
		Integer allNum = 0;// 总人数
		for (int i = 0; i < series; i++) {
			List<Map<String, Object>> uwList = new ArrayList<Map<String, Object>>();// 每个下级的信息集合
			for (Map map : userWeixinListMap.get(i)) {
				List<Map<String, Object>> list = userRecommendMapper
						.findUserSubordinateSuperiorName(Integer.valueOf(String
								.valueOf(map.get("user_basics_id"))));
				uwList.addAll(list);

			}
			allNum += uwList.size();
			subordinateNum.put(i + 1, uwList.size());
			userWeixinListMap.put(i + 1, uwList);
		}
		userWeixinListMap.remove(0);
		subordinateNum.put(0, allNum);// 零为总量
		TeamEntity teamEntity = new TeamEntity();
		teamEntity.setSubordinateNum(subordinateNum);
		teamEntity.setSubordinateMessageSuperiorName(userWeixinListMap);
		teamEntity.setSeries(series);
		return teamEntity;

	}

	/**
	 * <p>
	 * Title: findUserSubordinateNotBuySuperiorName
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 *
	 * @param user_basics_id
	 * @param series
	 * @return
	 * @see com.medicinefood.service.UserService#findUserSubordinateNotBuySuperiorName(int,
	 *      int)
	 */
	@Override
	public TeamEntity findUserSubordinateNotBuySuperiorName(int user_basics_id,
															int series) {// 查询未购买的下级用户，包含推荐人微信昵称
		Map<Integer, List<Map<String, Object>>> userWeixinListMap = new HashMap<Integer, List<Map<String, Object>>>();// 整体全部下级的信息，包含每一级的集合
		Map<Integer, Integer> subordinateNum = new HashMap<Integer, Integer>();// 下级人数
		List<Map<String, Object>> initialList = new ArrayList<Map<String, Object>>();// 初始的第一个集合，只有用户本身
		Map uw = new HashMap();
		uw.put("user_basics_id", user_basics_id);
		initialList.add(uw);
		userWeixinListMap.put(0, initialList);
		Integer allNum = 0;// 总人数
		for (int i = 0; i < series; i++) {
			List<Map<String, Object>> uwList = new ArrayList<Map<String, Object>>();// 每个下级的信息集合
			for (Map map : userWeixinListMap.get(i)) {
				List<Map<String, Object>> list = userRecommendMapper
						.findUserSubordinateNotBuySuperiorName(Integer
								.valueOf(String.valueOf(map
										.get("user_basics_id"))));
				uwList.addAll(list);

			}
			allNum += uwList.size();
			subordinateNum.put(i + 1, uwList.size());
			userWeixinListMap.put(i + 1, uwList);
		}
		userWeixinListMap.remove(0);
		subordinateNum.put(0, allNum);// 零为总量
		TeamEntity teamEntity = new TeamEntity();
		teamEntity.setSubordinateNum(subordinateNum);
		teamEntity.setSubordinateMessageSuperiorName(userWeixinListMap);
		teamEntity.setSeries(series);
		return teamEntity;
	}

	/**
	 * <p>
	 * Title: findUserSubordinateBuySuperiorName
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 *
	 * @param user_basics_id
	 * @return
	 * @see com.medicinefood.service.UserService#findUserSubordinateBuySuperiorName(int)
	 */
	@Override
	public TeamEntity findUserSubordinateBuySuperiorName(// 查询用户已购买的下级，包含推荐人名字
														 int user_basics_id, int series) {
		Map<Integer, List<Map<String, Object>>> userWeixinListMap = new HashMap<Integer, List<Map<String, Object>>>();// 整体全部下级的信息，包含每一级的集合
		Map<Integer, Integer> subordinateNum = new HashMap<Integer, Integer>();// 下级人数
		List<Map<String, Object>> initialList = new ArrayList<Map<String, Object>>();// 初始的第一个集合，只有用户本身
		Map uw = new HashMap();
		uw.put("user_basics_id", user_basics_id);
		initialList.add(uw);
		userWeixinListMap.put(0, initialList);
		Integer allNum = 0;// 总人数
		for (int i = 0; i < series; i++) {
			List<Map<String, Object>> uwList = new ArrayList<Map<String, Object>>();// 每个下级的信息集合
			for (Map map : userWeixinListMap.get(i)) {
				List<Map<String, Object>> list = userRecommendMapper
						.findUserSubordinateBuySuperiorName(Integer
								.valueOf(String.valueOf(map
										.get("user_basics_id"))));
				uwList.addAll(list);

			}
			allNum += uwList.size();
			subordinateNum.put(i + 1, uwList.size());
			userWeixinListMap.put(i + 1, uwList);
		}
		userWeixinListMap.remove(0);
		subordinateNum.put(0, allNum);// 零为总量
		TeamEntity teamEntity = new TeamEntity();
		teamEntity.setSubordinateNum(subordinateNum);
		teamEntity.setSubordinateMessageSuperiorName(userWeixinListMap);
		teamEntity.setSeries(series);
		return teamEntity;
	}

	/**
	 * <p>
	 * Title: augmentUserDirectTeamConsumeAchievement
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 *
	 * @param user_basics_id
	 * @param store_price
	 * @return
	 * @see com.medicinefood.service.UserService#augmentUserDirectTeamConsumeAchievement(int,
	 *      int)
	 */
	@Override
	public int augmentUserDirectTeamConsumeAchievement(int user_basics_id,
													   int store_price) {// 用户购买成功后推荐人增加直推团队消费成就
		UserRecommend ur = userRecommendMapper.findUserSuperiorUserid(
				user_basics_id, 1);
		if (ur.getRecommend_superior() == null) {
			return 7;
		}
		int SuperiorUserid1 = ur.getRecommend_superior();// 一级推荐人id
		UserAchievement userAchievement = new UserAchievement();// 用户基本成就实体类
		userAchievement.setUser_basics_id(SuperiorUserid1);// 添加成就对象为用户推荐人
		userAchievement.setDirect_team_consume(store_price);// 直接推荐团队消费
		return userAchievementMapper.augmentUserAchievement(userAchievement);// 增加用户基本成就;
	}

	/**
	 * <p>
	 * Title: findUserIntegral
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 *
	 * @param user_basics_id
	 * @param listName
	 * @return
	 * @see com.medicinefood.service.UserService#findUserIntegral(java.lang.Integer,
	 *      java.lang.String)
	 */
	@Override
	public UserIntegral findUserIntegral(Integer user_basics_id, String listName) {// 查询用户积分
		// TODO Auto-generated method stub
		return userIntegralMapper.findUserIntegral(user_basics_id, listName);
	}

	/**
	 * <p>
	 * Title: findUserAchievement
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 *
	 * @param user_basics_id
	 * @param listName
	 * @return
	 * @see com.medicinefood.service.UserService#findUserAchievement(int,
	 *      java.lang.String)
	 */
	@Override
	public UserAchievement findUserAchievement(int user_basics_id,
											   String listName) {// 查询用户成就
		// TODO Auto-generated method stub
		return userAchievementMapper.findUserAchievement(user_basics_id,
				listName);
	}

	/**
	 * <p>
	 * Title: initializeUserData
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 *
	 * @param user_basics_id
	 * @param recommend_superior_winxin
	 * @return
	 * @see com.medicinefood.service.UserService#initializeUserData(int, int)
	 */
	@SuppressWarnings("unused")
	@Override
	public int initializeUserData(int user_basics_id,
								  String recommend_superior_winxin) {// 初始化微信注册的用户数据
		// TODO Auto-generated method stub

		return 0;
	}

	/**
	 * <p>
	 * Title: findAllUserBasics
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 *
	 * @return
	 * @see com.medicinefood.service.UserService#findAllUserBasics()
	 */
	@Override
	public List<BasicsAndGradeEntity> findAllUserBasicsAndGrade() {//查询用户基本信息和等级信息
		return basicUsermapper.selectAllUserBasicsAndGrade();
	}

	/**
	 * <p>
	 * Title: findUserBasics
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 *
	 * @param grade
	 * @return
	 * @see com.medicinefood.service.UserService#findUserBasics(int)
	 */
	@Override
	public List<BasicsUser> findUserBasics(int grade) {
		// TODO Auto-generated method stub
		return basicUsermapper.selectUserBasicsToGrade(grade);
	}

	/**
	 * <p>
	 * Title: addUserAdmin
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 *
	 * @param basicsUser
	 * @param userInformationEntity
	 * @return
	 * @see com.medicinefood.service.UserService#addUserAdmin(com.medicinefood.entity.user.BasicsUser,
	 *      com.medicinefood.entity.user.UserInformationEntity)
	 */
	@Override
	public int addUserAdmin(BasicsUser basicsUser,
							UserInformationEntity userInformationEntity,
							UserRecommend userRecommend, UserIntegral userIntegral,
							UserAchievement userAchievement) {// 后台添加用户
		basicsUser.setUser_password(Md5Util.MD5(basicsUser.getUser_password()));// 密码以md5加密
		int i = basicUsermapper.addBasicsUser(basicsUser);// 添加用户基本数据
		int user_basics_id = basicsUser.getUser_basics_id();// 用户id
		userInformationEntity.setUser_basics_id(user_basics_id);
		Integer company_id = null;// 公司id
		if (userRecommend.getRecommend_superior() == null
				|| userRecommend.getRecommend_superior() == 1) {// 推荐人如果是默认1的话。将所属公司设为默认1
			company_id = 1;
		} else if (userInformationEntity.getCompany_id() == null) {// 公司id为空，没有传入
			try {
				// 用户所属公司为推荐人所属公司
				company_id = userInformationMapper
						.selectUserInformationEntityToUserId(user_basics_id)
						.getCompany_id();
			} catch (NullPointerException e) {// 推荐人所属公司为空。
				company_id = 1;// 所属公司为默认
			}
		} else {// userInformationEntity.getCompany_id=1的情况
			company_id = 1;
		}
		userInformationEntity.setCompany_id(company_id);// 设置用户所属公司id
		userInformationMapper
				.insertUserInformationEntity(userInformationEntity);// 添加用户补充信息
		userRecommend.setUser_basics_id(user_basics_id);
		userRecommendMapper.addUserRecommend(userRecommend);// 建立用户基本推荐关系数据
		userAchievement.setUser_basics_id(user_basics_id);
		userAchievementMapper.addUserAchievement(userAchievement);// 建立用户基本成就数据
		userIntegral.setUser_basics_id(user_basics_id);
		userIntegralMapper.addUserIntegral(userIntegral);// 建立用户基础积分数据
		// 如果用户存在推荐人为推荐人增加成就值
		if (userRecommend.getRecommend_superior() != null
				&& userRecommend.getRecommend_superior() != 1) {
			UserAchievement userAchievementSuperior = new UserAchievement();// 用户基本成就类/这里用来操作用户推荐人
			userAchievementSuperior.setUser_basics_id(userRecommend
					.getRecommend_superior());
			userAchievementSuperior.setDirect_team_num(1);// 直推人数加一
			// ////增加用户基本成就
			userAchievementMapper
					.augmentUserAchievement(userAchievementSuperior);// 增加用户基本成就
		}
		return user_basics_id;
	}

	/**
	 * <p>
	 * Title: findUserInformation
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 *
	 * @param user_basics_id
	 * @return
	 * @see com.medicinefood.service.UserService#findUserInformation(int)
	 */
	@Override
	public UserInformationEntity findUserInformation(int user_basics_id) {
		// TODO Auto-generated method stub
		return userInformationMapper
				.selectUserInformationEntityToUserId(user_basics_id);
	}

	/**
	 * <p>Title: findAllGrade</p>
	 * <p>Description: </p>
	 * @return
	 * @see com.medicinefood.service.UserService#findAllGrade()
	 */
	@Override
	public List<UserGrade> findAllGrade() {//查询所有等级信息
		// TODO Auto-generated method stub
		return userGradeMapper.selectAllGrade();
	}

	/**
	 * <p>Title: findUserTeamSubordinate</p>
	 * <p>Description: </p> 查询用户的下级信息
	 * @param series
	 * @param user_basics_id
	 * @return
	 * @see com.medicinefood.service.UserService#findUserTeamSubordinate(int, int)
	 */
	@Override
	public Map<String, List<UserRecommendWinxinBasics>> findUserTeamSubordinate(
			int series, int user_basics_id) {//查询用户的下级信息
		Map<String, List<UserRecommendWinxinBasics>> map=
				new HashMap<String, List<UserRecommendWinxinBasics>>();//包含查询的下级所有信息
		int amount=0;//总人数
		int validSeries=0;//有效的级数
		for(int i =0;i<series;i++){
			List<UserRecommendWinxinBasics> list = null;//下级信息集合
			int []user_basics_ids = null;//推荐人id数组;
			if(i==0){//第一次循环
				user_basics_ids=new int[]{user_basics_id};//第一次的推荐人id组为传来的参数
			}else{
				list=map.get(String.valueOf(i));//获取当前级数的下级信息
				int length=list.size();//推荐人id数组长度
				if(length>0){
					user_basics_ids=new int[length];//长度等于下级信息个数
				}

				for(int a=0;a<list.size();a++){//循环添加推荐人id数组
					user_basics_ids[a]=list.get(a).getUser_basics_id();//推荐人id数组值等于上次查询出下级的userid
				}
			}
			List<UserRecommendWinxinBasics> listUserRecommendWinxinBasics=new ArrayList<UserRecommendWinxinBasics>();
			if(user_basics_ids!=null){//推荐人id组不为空
				listUserRecommendWinxinBasics=userRecommendMapper.
						selectUserRecommendWinxinBasicsToRecommend_superior(user_basics_ids);//根据推荐人id查询出
				validSeries+=1;//有效级数加1
				amount+=user_basics_ids.length;//团队总人数加1
			}
			map.put(String.valueOf(i+1), listUserRecommendWinxinBasics);//将查询出的下级添加进 包含查询下级的所有信息的map对象中
		}
		return map;
	}

	/**
	 * <p>Title: findUserTeamSubordinateIncludeOrderBasics</p>
	 * <p>Description: </p> 查询用户的下级信息 包含订单信息
	 * @param series
	 * @param user_basics_id
	 * @return
	 * @see com.medicinefood.service.UserService#findUserTeamSubordinateIncludeOrderBasics(int, int)
	 */
	@Override
	public Map<String, List<UserTeamEntity>> findUserTeamSubordinateIncludeOrderBasics(
			int series, int user_basics_id) {//查询用户的下级信息 包含订单信息
		Map<String, List<UserTeamEntity>> map=
				new HashMap<String, List<UserTeamEntity>>();//包含查询的下级所有信息
		int amount=0;//总人数
		int validSeries=0;//有效的级数
		for(int i =0;i<series;i++){
			List<UserTeamEntity> list = null;//下级信息集合
			int []user_basics_ids = null;//推荐人id数组;
			if(i==0){//第一次循环
				user_basics_ids=new int[]{user_basics_id};//第一次的推荐人id组为传来的参数
			}else{
				list=map.get(String.valueOf(i));//获取当前级数的下级信息
				int length=list.size();//推荐人id数组长度
				if(length>0){
					user_basics_ids=new int[length];//长度等于下级信息个数
				}

				for(int a=0;a<list.size();a++){//循环添加推荐人id数组
					user_basics_ids[a]=list.get(a).getUser_basics_id();//推荐人id数组值等于上次查询出下级的userid
				}
			}
			List<UserTeamEntity> listUserRecommendWinxinBasics=new ArrayList<UserTeamEntity>();
			if(user_basics_ids!=null){//推荐人id组不为空
				listUserRecommendWinxinBasics=userRecommendMapper.
						selectUserRecommendIncludeOrderBasics3(user_basics_ids);//根据推荐人id查询出
				validSeries+=1;//有效级数加1
				amount+=user_basics_ids.length;//团队总人数加1
			}
			map.put(String.valueOf(i+1), listUserRecommendWinxinBasics);//将查询出的下级添加进 包含查询下级的所有信息的map对象中
		}
		return map;
	}

	/**
	 * <p>Title: findAllUserGrade</p>
	 * <p>Description: </p>
	 * @return
	 * @see com.medicinefood.service.UserService#findAllUserGrade()
	 */
	@Override
	public List<UserGrade> findAllUserGrade() {//查询所有会员等级信息
		// TODO Auto-generated method stub
		return userGradeMapper.selectAllGrade();//查询所有会员信息
	}

	/**
	 * <p>Title: addUserGradeUpgradeCondition</p>
	 * <p>Description: </p> 添加等级的升级条件
	 * @param gradeUpgradeConditionEntity
	 * @return
	 * @see com.medicinefood.service.UserService#addUserGradeUpgradeCondition(com.medicinefood.entity.user.GradeUpgradeConditionEntity)
	 */
	@Override
	public int addUserGradeUpgradeCondition(
			GradeUpgradeConditionEntity gradeUpgradeConditionEntity,int condition_group_id) {

		gradeUpgradeConditionMapper.insertGradeUpgradeCondition(gradeUpgradeConditionEntity);

		GradeUpgradeConditionGroupConditionEntity gradeUpgradeConditionGroupConditionEntity=new GradeUpgradeConditionGroupConditionEntity();
		gradeUpgradeConditionGroupConditionEntity.setCondition_group_id(condition_group_id);
		gradeUpgradeConditionGroupConditionEntity.setCondition_id(gradeUpgradeConditionEntity.getGrade_upgrade_condition_id());
		return gradeUpgradeConditionGroupConditionMapper.insertGradeUpgradeConditionGroupCondition(gradeUpgradeConditionGroupConditionEntity);
	}

	/**
	 * <p>Title: userUpgrade</p>
	 * <p>Description: </p>
	 * @param user_basics_id
	 * @param user_grade_id
	 * @see com.medicinefood.service.UserService#userUpgrade(int, int)
	 */
	@SuppressWarnings({ "null", "unused" })
//	@Override
//	public void userUpgradeSchedule (int user_basics_id, int user_grade_id) {//按照升级顺序，将满足条件的用户升级。将以满足条件与为满足条件写入数据库
//		// TODO Auto-generated method stub
//		List<UserUpgradeSchedule> userUpgradeScheduleList=new ArrayList<UserUpgradeSchedule>();
//		UserGrade userGrade= userGradeMapper.findUserGrade(user_grade_id);//根据等级id查询等级信息
//		String upgrade_order= userGrade.getUpgrade_order();//获取当前的等级升级顺序
//		System.out.println("正在判断用户"+user_basics_id+"是否满足升级条件");
//
//		if(upgrade_order==null||upgrade_order.equals("")){//当前等级没有加入升级功能
//			return;
//		}
//		int frequency;//每次执行判断的级数
//		if(Integer.valueOf(upgrade_order)==1){//如果当前级数为初始等级，升级的对象可能会使是体验会员和注册会员
//			 frequency=1;
//		}else{
//			frequency=1;
//		}
//		UserGrade userGrade1=null;
//		for (int i=frequency;i>0;i--) {//从frequency设置遍历级数的最大开始遍历判断
//			if(user_basics_id==480){
//				System.out.println(111111);
//			}
//			userGrade1=userGradeMapper.selectGradeToUpgrade_order(
//					Integer.valueOf(upgrade_order)+i);//获取按照升级排序后的等级信息
//			if(userGrade1==null){//没有此排序的等级
//				continue;
//			}
//
//			UserUpgradeSchedule userUpgradeSchedule=new UserUpgradeSchedule();//用户等级升级达成信息实体类
//			List<GradeUpgradeConditionEntity>accomplishConditionList=new ArrayList<GradeUpgradeConditionEntity>();//已完成升级条件
//		    List<GradeUpgradeConditionEntity>accomplishConditionNoList=new ArrayList<GradeUpgradeConditionEntity>();//未完成升级条件
//			GradeUpgradeConditionEntity gradeUpgradeConditionEntity=new GradeUpgradeConditionEntity();//查询升级条件所需参数
//			gradeUpgradeConditionEntity.setUser_grade_id(userGrade1.getUser_grade_id());//查询条件为当前遍历等级的id
//			List<GradeUpgradeConditionGroupEntity> list=
//					gradeUpgradeConditionGroupMapper.selectG_U_C_GroupToG_id(userGrade1.getUser_grade_id());//通过等级id查询等级所有升级条件组
//			for(GradeUpgradeConditionGroupEntity gcge: list){//遍历升级条件组
//				int num=0;//判断升级条件是否达成
//				int condition_group_id=gcge.getCondition_group_id();//升级条件组id
//				//List<GradeUpgradeConditionEntity>gradeUpgradeConditionEntityList =
//						//gradeUpgradeConditionMapper.selectGradeUpgradeConditionTo(gradeUpgradeConditionEntity);//以等级id查询升级条件
//				List<GradeUpgradeConditionEntity>gradeUpgradeConditionEntityList =
//						gradeUpgradeConditionMapper.selectG_U_C_ToCondition_group_id(condition_group_id);//升级条件组id查询升级条件
//				for (GradeUpgradeConditionEntity gucE : gradeUpgradeConditionEntityList) {//遍历升级所需要的升级条件
//					GradeUpgradeConditionAccomplishEntity gucaE=gradeUpgradeConditionAccomplishMapper.selectGradeUpgradeConditionAccomplishToUbIdGucId(
//							user_basics_id,gucE.getGrade_upgrade_condition_id());//查询用户的升级条件完成记录
//					if(gucaE!=null&&Integer.valueOf(gucaE.getAccomplish_status())==1){//用户已有此升级条件的记录,状态为已完成
//						accomplishConditionList.add(gucE);//已完成此条件
//						continue;
//					}
//					//添加升级条件完成表所需数据
//					GradeUpgradeConditionAccomplishEntity gradeUpgradeConditionAccomplishEntity=new GradeUpgradeConditionAccomplishEntity();
//	         	    gradeUpgradeConditionAccomplishEntity.setAdd_date(Calendar.getInstance().getTimeInMillis());//添加时间为当前时间戳
//	         		gradeUpgradeConditionAccomplishEntity.setUser_basics_id(user_basics_id);//完成用户id为当前user_basics_id
//	         		gradeUpgradeConditionAccomplishEntity.setGrade_upgrade_condition_id(gucE.getGrade_upgrade_condition_id());//升级条件的id
//	         		gradeUpgradeConditionAccomplishEntity.setUser_basics_id(user_basics_id);//用户id
//	         		gradeUpgradeConditionAccomplishEntity.setCondition_describe(gucE.getCondition_describe());//条件描述
//	         		gradeUpgradeConditionAccomplishEntity.setCondition_type(gucE.getCondition_type());//条件类型
//	         		gradeUpgradeConditionAccomplishEntity.setUser_grade_id(user_grade_id);//等级id
//	         		boolean conditionKey = false;
//	         		switch (Integer.valueOf(gucE.getCondition_type())) {//判断条件的类型
//	         		case 1://1:用户成就
//						if(gucE.getCondition_option().equals("direct_team_num")){//直接推荐人数
//							int judgeKey;//判断是否带有条件补充的数字key
//							if(gucE.getCondition_supplement()!=null&&gucE.getCondition_supplement().equals("userGrade")){//条件补充不为空，补充条件为直推下家等级
//								judgeKey=1;
//							}else{//无补充条件
//								judgeKey=0;
//							}
//							switch (judgeKey) {//判断是否有补充条件
//							case 0://无补充条件
//								UserAchievement userAchievement= userAchievementMapper.findUserAchievement(user_basics_id, "direct_team_num");//查出用户直推人数成就
//								if(userAchievement.getDirect_team_num()>=Integer.valueOf(gucE.getCondition_value())){//满足条件
//									conditionKey=true;
//								}else{//未满足条件
//								}
//								break;
//	                        case 1://补充条件为直推下家等级
//	                        	int userCount=userRecommendMapper.selectUserCountToSuperiorIdGradeId(
//	                        			user_basics_id, gucE.getCondition_correlation_id());//查询符合条件的直推人数
//	                        	if(userCount>=Integer.valueOf(gucE.getCondition_value())){//满足条件
//	                        		conditionKey=true;
//	                        	}else{//未满足条件
//
//	                        	}
//	                        	break;
//
//							default:
//								break;
//							}
//
//						}else if(gucE.getCondition_option().equals("records_integral")){//晋级积分
//							UserAchievement userAchievement= userAchievementMapper.findUserAchievement(user_basics_id, "records_integral");//查出用户晋升积分
//						    if(Integer.valueOf(userAchievement.getRecords_integral())>=Integer.valueOf(gucE.getCondition_value())){//满足晋升积分条件
//						    	conditionKey=true;
//						    }else{//未满足积分条件
//
//						    }
//						}else if(gucE.getCondition_option().equals("direct_team_consume")){//直接推荐团队消费
//
//						}else if(gucE.getCondition_option().equals("records_bonus")){//历史奖金
//
//						}
//
//						break;
//	                case 2://2:自定义成就
//
//						break;
//	                case 3://3:用户购买商品
//	                	int store_id=gucE.getCondition_correlation_id();//获取用条件所需购买的商品id
//	                	int orderStatusAccomplish=11;//订单完成的状态
//	                	OrderBasics orderBasicsParam=new OrderBasics();//查询订单条件
//	                	orderBasicsParam.setOrder_status(orderStatusAccomplish);//订单状态参数
//	                	orderBasicsParam.setUser_basics_id(user_basics_id);//用户id参数
//	                	orderBasicsParam.setStore_id(store_id);
//	                	List<OrderBasics> OrderBasicsList=
//	                			basicOrderMapper.selectOrderBasicsToAnd(orderBasicsParam);//查看用户是否有满足条件的订单
//	                	if(OrderBasicsList==null||OrderBasicsList.size()<1){//没有符合条件的订单,未完成条件
//
//	                	}else{//已完成条件
//	                		conditionKey=true;
//	                	}
//						break;
//	                case 4:// 4:用户团队
//	                	int teamNum=userRecommendMapper.findUserNumToRecommend_superiors(user_basics_id);//用户团队人数
//	                	int Condition_value= Integer.valueOf(gucE.getCondition_value());//条件值；
//	                	if(teamNum>=Condition_value){//条件已完成
//	                		conditionKey=true;
//	                	}else{
//
//	                	}
//			            break;
//
//					default:
//						break;
//					}
//					if(conditionKey){//单个条件已满足
//						gradeUpgradeConditionAccomplishEntity.setAccomplish_status("1");//1为已完成
//						if(gucaE==null){//没有此条件完成记录
//							gradeUpgradeConditionAccomplishMapper.insertGradeUpgradeConditionAccomplish(gradeUpgradeConditionAccomplishEntity);//添加此条件的完成状态数据据
//						}else{
//							gradeUpgradeConditionAccomplishMapper.updateGradeUpgradeConditionAccomplishToGucaIdAstatus(
//									gucaE.getGrade_upgrade_condition_accomplish_id(), 1);
//						}
//						accomplishConditionList.add(gucE);//已完成条件集合+1数据
//					}else{//单个条件未满足
//						num=1;
//						gradeUpgradeConditionAccomplishEntity.setAccomplish_status("2");//2为未完成
//	            		if(gucaE==null){//没有此条件完成记录
//	            			gradeUpgradeConditionAccomplishMapper.insertGradeUpgradeConditionAccomplish(gradeUpgradeConditionAccomplishEntity);//添加此条件的完成状态数据
//	            		}
//	            		accomplishConditionNoList.add(gucE);//未完成条件集合+1
//					}
//			}
//				if(num==1){//未满足升级所需全部条件
//					System.out.println("用户："+user_basics_id+"未满足升级条件");
//				}else if(num==0){//已满足升级所需全部条件
//					BasicsUser basicsUser=new BasicsUser();
//					basicsUser.setUser_grade_id(userGrade1.getUser_grade_id());
//					basicsUser.setUser_basics_id(user_basics_id);
//					basicUserMapper.updateUserBasics(basicsUser);//改变用户等级，将用户等级改为升级后的等级
//					//userUpgradeSchedule(user_basics_id, userGrade1.getUser_grade_id());//再次判断用户是否满足下次升级条件
//					System.out.println("用户："+user_basics_id+"已满足升级条件");
//					return;//以满足其中一个条件组。不再执行剩下的判断
//				}else{//错误
//
//				}
//
//
//
//			}
//
//		}
//	}

	/**
	 * <p>Title: findGradeUpgradeConditionTo</p>
	 * <p>Description: </p>
	 * @param gradeUpgradeConditionEntity
	 * @return
	 * @see com.medicinefood.service.UserService#findGradeUpgradeConditionTo(com.medicinefood.entity.user.GradeUpgradeConditionEntity)
	 */
	@Override
	public List<GradeUpgradeConditionEntity> findGradeUpgradeConditionTo(
			GradeUpgradeConditionEntity gradeUpgradeConditionEntity) {//查询等级升级条件
		// TODO Auto-generated method stub
		return gradeUpgradeConditionMapper.selectGradeUpgradeConditionTo(gradeUpgradeConditionEntity);
	}

	/**
	 * <p>Title: delectGradeUpgradeConditionTo</p>
	 * <p>Description: </p>
	 * @param gradeUpgradeConditionEntity
	 * @return
	 * @see com.medicinefood.service.UserService#delectGradeUpgradeConditionTo(com.medicinefood.entity.user.GradeUpgradeConditionEntity)
	 */
	@Override
	public int removeGradeUpgradeConditionTo(
			GradeUpgradeConditionEntity gradeUpgradeConditionEntity) {//删除等级条件
		// TODO Auto-generated method stub
		int i=1;
		if(gradeUpgradeConditionEntity.getCondition_correlation_id()!=null){
			i=0;
		}
		if(gradeUpgradeConditionEntity.getCondition_option()!=null){
			i=0;
		}
		if(gradeUpgradeConditionEntity.getCondition_supplement()!=null){
			i=0;
		}
		if(gradeUpgradeConditionEntity.getCondition_type()!=null){
			i=0;
		}
		if(gradeUpgradeConditionEntity.getCondition_value()!=null){
			i=0;
		}
		if(gradeUpgradeConditionEntity.getGrade_upgrade_condition_id()!=null){
			i=0;
		}
		if(gradeUpgradeConditionEntity.getUser_grade_id()!=null){
			i=0;
		}
		if(i==0){//进行判断，以防操作错误将数据全部删除
			return gradeUpgradeConditionMapper.delectGradeUpgradeConditionTo(gradeUpgradeConditionEntity);
		}else{
			return 1;
		}


	}

	@Override
	public int updateUserGrade(UserGrade userGrade) {

		return userGradeMapper.updateUserGrade(userGrade);
	}

	/**
	 * <p>Title: findUserInformation</p>
	 * <p>Description: </p>
	 * @param userInformationEntity
	 * @return
	 * @see com.medicinefood.service.UserService#findUserInformation(com.medicinefood.entity.user.UserInformationEntity)
	 */

	/**
	 * <p>Title: findAllUserBasics</p>
	 * <p>Description: </p>
	 * @return
	 * @see com.medicinefood.service.UserService#findAllUserBasics()
	 */
	@Override
	public List<BasicsUser> findAllUserBasics() {
		// TODO Auto-generated method stub
		return basicUsermapper.selectAllUserBasics();
	}

	@Override
	public BasicsAndGradeEntity selectUserBasicsAndGradeId(int user_basics_id) {
		//根据会员条件查询用户信息
		return basicUsermapper.selectUserBasicsAndGradeId(user_basics_id);
	}

	@Override
	public Integer updateUserInformation(
			UserInformationEntity userInformationEntity) {
		return userInformationMapper.updateUserInformation(userInformationEntity);
	}


	@Override
	public TeamInformation findTeamInformationRecord(int user_basics_id) {
		return basicUsermapper.findTeamInformationRecord(user_basics_id);
	}

	@Override
	public List<TeamInformation> findTeamRecordId(int user_basics_id) {
		return basicUsermapper.findTeamRecordId(user_basics_id);
	}

	/**
	 * <p>Title: findUserBasicsAndWxAndInformation</p>
	 * <p>Description: </p> 通过用户id查询用户基本信息和微信信息与用户详细信息
	 * @param user_basics_id
	 * @return
	 * @see com.medicinefood.service.UserService#findUserBasicsAndWxAndInformation(int)
	 */
	@Override
	public UserBasicsAndWxAndInformationEntity findUserBasicsAndWxAndInformation(
			int user_basics_id) {//通过用户id查询用户基本信息和微信信息与用户详细信息
		// TODO Auto-generated method stub
		return userMapper.selectUserBasicsAndWxAndInformationtoUserId(user_basics_id);
	}

	/**
	 * <p>Title: findUserToadministrativeId</p>
	 * <p>Description: </p> 通过管理组id查询管理组包含的用户信息
	 * @param administrative_id
	 * @return
	 * @see com.medicinefood.service.UserService#findUserToadministrativeId(int)
	 */
	@Override
	public List<UserBasicsAndWxAndInformationEntity> findUserToadministrativeId(
			int administrative_id) {//通过管理组id查询管理组包含的用户信息
		// TODO Auto-generated method stub
		return userMapper.selectUserToadministrativeId(administrative_id);
	}
	/**
	 *
	 * <p>Title: adminLogin</p>
	 * <p>Description: </p>
	 * @param loginParam
	 * @param request
	 * @return
	 * @throws LoginExceptionMedifood
	 * @see com.medicinefood.service.UserService#adminLogin(com.medicinefood.entity.LoginParam, javax.servlet.http.HttpServletRequest)
	 */
//	@Override
//	public VisitsLogin adminLogin(LoginParam loginParam,HttpServletRequest request) throws LoginExceptionMedifood {
//		// TODO Auto-generated method stub
//		VisitsLogin visitsLogin=new VisitsLogin();
//		//需要检查验证码图片 并且验证码值错误
//		if(LoginUtilService.isLoginVerifyPicture(request.getSession())&&
//				!LoginUtilService.loginVerifyPicture(request.getSession(), loginParam.getVerifyPictureValue())){
//			visitsLogin.setHintMessage("验证码错误");
//			visitsLogin.setLoginResults(false);
//			return visitsLogin;
//		}
//		int user_basics_id=0;
//		try {
//			user_basics_id=basicUsermapper.selectUserBasicsToAccountNumOne(loginParam.getAccount_num()).getUser_basics_id();
//		} catch (NullPointerException e) {
//			// TODO: handle exception
//			throw new LoginExceptionMedifood("登陆账号不存在用户");
//		}
//		String jsessionid=null;
//		Cookie[] cookies=request.getCookies();
//		for (Cookie cookie : cookies) {
//			if(cookie.getName().equals("JSESSIONID")){
//				jsessionid=cookie.getValue();
//			}
//		}
//		HttpSession session=request.getSession();
//		try {
//			if(LoginUtilService.isLogining(cookies, session)){//判断设备是否在登陆状态
//				throw new repetitionLoginFacility("用户在不需要登陆的情况下发送登陆请求");
//			}
//		} catch (SessionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		BasicsUser basicsUser = null;
//		int loginMode=LoginUtilService.loginMode(loginParam.getAccount_num());//登陆方式
//		switch (loginMode) {
//		case VisitsLogin.loginMode.LOGINACCOUNT://账号密码登陆
//			basicsUser= basicUsermapper.selectUserBasicsToAccountNumUserPassword(loginParam.getAccount_num(),Md5Util.MD5(loginParam.getUser_password()));
//			break;
//        case VisitsLogin.loginMode.LOGINPHONE://手机密码号登陆
//			break;
//		default:
//			break;
//		}
//		AdminLoginRecordEntity adminLoginRecordEntity=new AdminLoginRecordEntity();//后台登陆记录
//		RequestType requestType=new RequestType(request);//创建封装请求信息实体类
//		adminLoginRecordEntity.setLogin_ip(requestType.getLogin_ip());//访问ip
//		adminLoginRecordEntity.setLogin_facility(requestType.getRequestFacility());//登陆设备
//		adminLoginRecordEntity.setLogin_mode(loginMode);//登陆方式
//		adminLoginRecordEntity.setUser_basics_id(user_basics_id);//账号所属用户id
//		adminLoginRecordEntity.setLogin_data(new Date().getTime());//登陆时间
//		if(basicsUser==null){//根据账号密码查询出的用户为空
//			adminLoginRecordEntity.setLogin_finally(2);//登陆结果 2为失败
//			visitsLogin.setLoginResults(false);//登陆结果
//			visitsLogin.setHintMessage("密码错误");//提示信息
//			systemLoginMapper.insertAdminLoginRecordEntity(adminLoginRecordEntity);//插入用户登陆记录
//		}else{
//			UserImportantEntity userImportantEntity=
//					userMapper.selectUserImportantEntityToUid(user_basics_id);//查询用户关键信息
//			String tableName=PrivilegeDataServiceUtil.getUserPrivilegerTableName(user_basics_id);//获取用户存取后台权限的数据表名字
//			String[]privilegeUrls=privilegeMapper.selectPrivilegeUrlToUid(user_basics_id,tableName);//查询用户的后台权限
//			Cookie cookie=LoginUtilService.storageLoginSessionInfo(
//					userImportantEntity, privilegeUrls, request.getSession(),jsessionid);//保存用户登陆的session信息
//			adminLoginRecordEntity.setLogin_finally(1);//登陆结果 2为失败
//			visitsLogin.setLoginResults(true);//登陆结果
//			visitsLogin.setHintMessage("登陆成功");//提示信息
//			visitsLogin.setCookie(cookie);//创建的cookie信息
//			systemLoginMapper.insertAdminLoginRecordEntity(adminLoginRecordEntity);//插入用户登陆记录
//		}
//		return visitsLogin;
//	}

	/**
	 * <p>Title: isUser</p>
	 * <p>Description: </p> 判断用户是否存在
	 * @param condition
	 * @param conditionValue
	 * @return
	 * @see com.medicinefood.service.UserService#isUser(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean isUser(String condition, String conditionValue) {
		// TODO Auto-generated method stub
		if(condition.equals("user_account_num")){//通过账号判断用户是否存在
			List<BasicsUser> basicsUserList=
					basicUsermapper.selectUserBasicsToAccountNum(conditionValue);
			if(basicsUserList==null||basicsUserList.size()<1){
				return false;
			}else{
				return true;
			}

		}
		return false;
	}

	/**
	 * <p>Title: LogOff</p>
	 * <p>Description: </p> 浏览器session对象
	 * @see com.medicinefood.service.UserService#LogOff()
	 */
//	@Override
//	public Cookie LogOff(HttpSession httpSession) {
//		// TODO Auto-generated method stub
//		Cookie cookie = new Cookie(SessionServiceUtil.COOKIENAME, null);
//		cookie.setMaxAge(0);
//		cookie.setPath("/"+WebUrl.PROJECTNAME+"/");
//		httpSession.invalidate();
//		return cookie;
//	}

	@Override
	public GradeUpgradeConditionGroupEntity findG_U_C_GroupToC_G_id(
			int condition_group_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addGradeUpgradeConditionGroupEntity(
			GradeUpgradeConditionGroupEntity gradeUpgradeConditionGroupEntity) {
		// TODO Auto-generated method stub
		int num=gradeUpgradeConditionGroupMapper.insertGradeUpgradeConditionGroupEntity(gradeUpgradeConditionGroupEntity);
		return num;
	}

	@Override
	public List<GradeUpgradeConditionGroupEntity> findG_U_C_GroupToG_id(
			int user_grade_id) {
		// TODO Auto-generated method stub
		return gradeUpgradeConditionGroupMapper.selectG_U_C_GroupToG_id(user_grade_id);
	}

	@Override
	public List<GradeUpgradeConditionEntity> findG_U_C_ToCondition_group_id(
			int condition_group_id) {
		// TODO Auto-generated method stub
		return gradeUpgradeConditionMapper.selectG_U_C_ToCondition_group_id(condition_group_id);
	}

	@Override
	public int removeG_U_C_GroupToG_id(int condition_group_id) {
		// TODO Auto-generated method stub
		gradeUpgradeConditionMapper.deleteG_U_C_ToCondition_group_id(condition_group_id);//删除条件表数据
		gradeUpgradeConditionGroupMapper.deleteG_U_C_GroupToC_G_id(condition_group_id);//删除条件组数据
		gradeUpgradeConditionGroupConditionMapper.deleteG_U_C_G_C_ToCondition_group_id(condition_group_id);//删除条件组条件表数据
		return 2;
	}

	@Override
	public int selectUserGradeIdCount(Integer user_basic_id, Integer integral_basics) {
		// TODO Auto-generated method stub
		return basicUsermapper.selectUserGradeIdCount(user_basic_id,integral_basics);
	}

	@Override
	public Double findUserMoney(int user_basics_id) {
		// TODO Auto-generated method stub
		return basicUsermapper.selectUserMoneyToUid(user_basics_id);
	}

	@Override
	public boolean realNameAuthentication(int user_basics_id) {
		UserInformationEntity uie=userInformationMapper.selectUserInformationEntityToUserId(user_basics_id);
		if(uie.getInformation_compellation()==null||uie.getInformation_compellation().equals("null")||uie.getInformation_compellation().equals("")){
			return false;
		}else if(uie.getInformation_card()==null||uie.getInformation_card().equals("null")||uie.getInformation_card().equals("")){
			return false;
		}else{
			return true;
		}

	}

	@Override
	public int findUidToCard(String information_card) {
		// TODO Auto-generated method stub
		if(userInformationMapper.selectUidToCard(information_card)==null){
			return 0;
		}
		return userInformationMapper.selectUidToCard(information_card);
	}

	@Override
	public void userUpgradeSchedule(int user_basics_id, int user_grade_id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<UserInformationEntity> findUserInformationByPage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TeamInformation> findTeamInformationByPage(String information_compellation, String information_card,
														   Integer user_basics_id,Integer co_user_basics_id) {
		return basicUsermapper.findTeamInformationByPage(information_compellation, information_card, user_basics_id,co_user_basics_id);
	}

	@Override
	public Cookie LogOff(HttpSession httpSession) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateAdminUser(BasicsUser basicsUser) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TeamInformation findTeamInformationById(int user_basics_id) {
		return basicUsermapper.findTeamInformationById(user_basics_id);
	}

	@Override
	public int userGradeAdd(UserGrade userGrade) {
		return userGradeMapper.userGradeAdd(userGrade);
	}

	@Override
	public List<UserInformationEntity> findCoFounds(UserInformationEntity ui) {
		return userInformationMapper.findCoFounds(ui);
	}

	@Override
	public UserInformationEntity selectUserById(UserInformationEntity userInformationEntity) {
		return userInformationMapper.selectUserById(userInformationEntity);
	}

	@Override
	public int addUserConsultService(UserConsultServiceEntity userConsultServiceEntity) {
		return userConsultServiceMapper.addUserConsultService(userConsultServiceEntity);
	}

	@Override
	public List<UserConsultServiceEntity> findAllUserConsultService(UserConsultServiceEntity userConsultServiceEntity) {
		return userConsultServiceMapper.findAllUserConsultService(userConsultServiceEntity);
	}

	@Override
	public UserConsultServiceEntity findUserConsultserviceById(UserConsultServiceEntity userConsultServiceEntity) {
		return userConsultServiceMapper.findUserConsultserviceById(userConsultServiceEntity);
	}

	@Override
	public int updateUserConsultservice(UserConsultServiceEntity userConsultServiceEntity) {
		return userConsultServiceMapper.updateUserConsultservice(userConsultServiceEntity);
	}

	@Override
	public UserAchievement findUserAchievementAll(int user_basics_id) {
		return userAchievementMapper.findUserAchievementAll(user_basics_id);
	}




}
