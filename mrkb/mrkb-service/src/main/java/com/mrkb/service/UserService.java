package com.mrkb.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.mrkb.dao.modle.core.TeamEntity;
import com.mrkb.dao.modle.exception.LoginExceptionMedifood;
import com.mrkb.dao.modle.user.BasicsAndGradeEntity;
import com.mrkb.dao.modle.user.BasicsUser;
import com.mrkb.dao.modle.user.GradeUpgradeConditionEntity;
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
import com.mrkb.dao.modle.visits.VisitsLogin;

public interface UserService {
	/**
	 * 
	 * @Title: realNameAuthentication @Description: TODO
	 * 验证是否实名认证,返回boolean @param: @param user_basics_id 用户编号 @param: @return
	 * 返回boolean,true为实名认证,false为未实名认证 @return: int 用户id @throws
	 */
	boolean realNameAuthentication(int user_basics_id);// 判断是否实名认证

	/**
	 * 
	 * @Title: addUserWeixin @Description: TODO 微信端添加用户信息
	 * 如果未设置用户昵称则默认将微信昵称存入用户昵称 @param: @param bu 用户基本信息 @param: @param uw
	 * 用户微信信息 @param: @return 添加数据的主键 @return: int 用户id @throws
	 */
	int addUserWeixin(BasicsUser bu, UserWeixin uw, String recommend_superior_winxin);// 微信端添加用户信息

	int findUidToCard(String information_card);// 通过用户身份证号查询用户id

	BasicsUser findUserWeixin(UserWeixin uw);// 通过微信信息,查询是否有该用户

	BasicsUser finduserWeixinone(UserWeixin uw);//

	BasicsUser finduserBasics(int user_basics_id);// 通过user_basics_id查询用户基本信息

	int createUserRecommend(UserRecommend ur);// 为用户创建推荐关系

	int findUserBasicsIdWeixinId(String winxinId);// 根据用户微信id查询userid

	int createUserIntegral(UserIntegral ui);// 为用户创建积分

	int updateIntegral(Map<String, Object> map);// 更新用户积分积分

	UserRecommend findUserSuperiorUserid(int userid, int round);// 查询用户推荐人，round记录级数

	int addUserAchievement(UserAchievement userAchievement);// 创建用户成就

	int updateLineAchievement(Map<String, String> updateMap);// 更改一行用户成就数据

	int updateUserBasics(BasicsUser basicsUser);// 更改用户等级id,密码

	Integer editUserWeixin(UserWeixin userWeixin);// 编辑用户微信资料根据user_weixin_id，weixin_id或者user_basics_id作为条件；

	UserWeixin findUserWeixin(String weixin_id);// 通过微信id查询用户微信信息

	UserWeixin findUserWeixinUserBasicsId(Integer weixin_id);// 通过用户id查询用户微信信息

	UserAchievement findUserAchievement(int user_basics_id); // 通过用户id查询用户成就值

	UserExpandId addaddress(HashMap<String, Object> map);// 添加用户补充信息

	List<UserExpandId> findaddress(HashMap<String, Object> map);// 查询用户补充信息

	List<UserAchievementAccount> findUserAchievementAccount(int user_basics_id);// 通过用户id查询用户自定义成就值

	TeamEntity findUserSubordinateUserWeixinUserid(int user_basics_id, int series);// 查询下级微信信息

	TeamEntity findUserSubordinateBuyUserWeixinUserid(int user_basics_id, int series);// 查询用户已购买商品的下级微信信息

	/**
	 * 
	 * @Title: findUserGrade @Description: TODO 根据等级id查询等级信息 @param: @param
	 * user_grade_id 等级id @param: @return @return: UserGrade 会员等级信息实体类 @throws
	 */
	UserGrade findUserGrade(int user_grade_id);// 根据等级id查询等级信息

	/**
	 * 
	 * @Title: findAllUserGrade @Description: TODO
	 * 查询所有会员等级信息 @param: @return @return: List<UserGrade> 会员信息集合 @throws
	 */
	List<UserGrade> findAllUserGrade();// 查询所有会员等级信息

	/**
	 * 
	 * @Title: updateUserGrade @Description: TODO
	 * 修改单个会员等级信息 @param: @return @return: UserGrade 修改后的会员信息 @throws
	 */
	int updateUserGrade(UserGrade userGrade);

	int findUserSubordinateBuyUserWeixinUseridNum(int user_basics_id, int series);// 查询用户已购买商品的下级人数

	int findUserSubordinateUserWeixinUseridNum(int user_basics_id, int series);// 查询下级人数，series为查询级数

	TeamEntity findUserSubordinateNotBuyUserWeixinUserid(int user_basics_id, int series);// 查询用户未购买的下级

	TeamEntity findUserSubordinateSuperiorName(int user_basics_id, int series);// 以useriid查询下级用户，包含下级推荐人

	TeamEntity findUserSubordinateNotBuySuperiorName(int user_basics_id, int series);// 查询未购买的下级用户，包含推荐人微信昵称

	TeamEntity findUserSubordinateBuySuperiorName(int user_basics_id, int series);// 查询已购买的下级用户，包含推荐人微信昵称

	/**
	 * 
	 * @Title: augmentUserDirectTeamConsumeAchievement @Description: TODO
	 * //用户购买成功后推荐人增加直推团队消费成就 @param: @param user_basics_id 购买人id @param: @param
	 * store_price 商品价格 @param: @return @return: int 执行状态 @throws
	 */
	int augmentUserDirectTeamConsumeAchievement(int user_basics_id, int store_price);// 用户购买成功后推荐人增加直推团队消费成就

	/**
	 * 
	 * @Title: findUserIntegral @Description: TODO @param: @param user_basics_id
	 * 用户id @param: @param listName 查询的积分名 @param: @return @return: UserIntegral
	 * 用户积分，只包含查询的积分值 @throws
	 */
	UserIntegral findUserIntegral(Integer user_basics_id, String listName);// 通过用户id和积分名查询用户积分

	/**
	 * 
	 * @Title: findUserIntegral @Description: TODO @param: @param
	 * user_basics_id @param: @return @return: UserIntegral @throws
	 */
	UserIntegral findUserIntegral(Integer user_basics_id);// 通过用户id查询用户所有积分

	/**
	 * 
	 * @Title: findUserAchievement @Description: TODO 查询成就记录 @param: @param
	 * user_basics_id 用户id @param: @param listName
	 * 查询的成就名，列名称 @param: @return @return: UserAchievement @throws
	 */
	UserAchievement findUserAchievement(int user_basics_id, String listName);// 查询成就记录

	/**
	 * 
	 * @Title: initializeUserData @Description: TODO 初始化微信注册的用户数据 @param: @param
	 * user_basics_id 用户id @param: @param recommend_superior_winxin
	 * 用户推荐人微信id @param: @return @return: int 0为执行成功，1为执行失败 @throws
	 */
	int initializeUserData(int user_basics_id, String recommend_superior_winxin);// 初始化微信注册的用户数据

	/**
	 * 
	 * @Title: findAllUserBasics @Description: TODO 查询所有用户基本信息 @param: @return
	 * 用户基本信息 @return: List<BasicsUser> 用户数据实体类集合 @throws
	 */
	List<BasicsAndGradeEntity> findAllUserBasicsAndGrade();// 查询所有用户基本信息

	/**
	 * 
	 * @Title: selectUserBasicsAndGradeId @Description: TODO
	 * 根据用户ID查询会员信息，包含用户等级信息 @param: @return @return: List<BasicsUser>
	 * 用户信息实体类集合 @throws
	 */
	BasicsAndGradeEntity selectUserBasicsAndGradeId(int user_basics_id);// 根据用户ID查询会员信息，包含用户等级信息

	/**
	 * 
	 * @Title: updateUserInformation @Description: TODO
	 * 根据用户ID修改用户信息 @param: @return @return: UserInformationEntity
	 * 用户信息实体类 @throws
	 */
	Integer updateUserInformation(UserInformationEntity userInformationEntity);// 根据用户ID修改用户信息

	/**
	 * 
	 * @Title: findUserBasics @Description: TODO 根据会员等级条件查询用户信息 @param: @param
	 * grade 等级id @param: @return 一个等级的所有用户基本信息 @return: List<BasicsUser>
	 * 用户基本信息实体集合 @throws
	 */
	List<BasicsUser> findUserBasics(int grade);// 根据会员等级条件查询用户信息

	/**
	 * 
	 * @Title: addUserAdmin @Description: TODO 后台添加用户 @param: @param basicsUser
	 * BasicsUser实体类 @param: @param userInformationEntity
	 * 用户重要信息实体类 @param: @return 返回添加basicsUser的主键 用户id @return: int
	 * basicsUser数据的主键 @throws
	 */
	int addUserAdmin(BasicsUser basicsUser, UserInformationEntity userInformationEntity, UserRecommend userRecommend,
			UserIntegral userIntegral, UserAchievement userAchievement);// 后台添加用户

	/**
	 * 
	 * @Title: findUserInformation @Description: TODO
	 * 以用户id作为条件查询用户补充信息 @param: @param user_basics_id
	 * 用户id @param: @return @return: UserInformationEntity 用户补充信息实体类 @throws
	 */
	UserInformationEntity findUserInformation(int user_basics_id);// 查询用户补充信息

	/**
	 * 
	 * @Title: findAllGrade @Description: TODO 查询所有等级信息 @param: @return @return:
	 * List<UserGrade> 等级信息实体类集合 @throws
	 */
	List<UserGrade> findAllGrade();// 查询所有等级信息

	/**
	 * 
	 * @Title: findUserTeamSubordinate @Description: TODO
	 * 查询用户的下级信息 @param: @param series 查询的级数 @param: @param user_basics_id
	 * 用户id @param: @return @return: Map<String,List<UserRecommendWinxinBasics>>
	 * 键为等级数字型的字符串。值为对应级数的下级用户信息 @throws
	 */

	Map<String, List<UserRecommendWinxinBasics>> findUserTeamSubordinate(int series, int user_basics_id);// 查询用户的下级信息

	/**
	 * 
	 * @Title: findUserTeamSubordinateIncludeOrderBasics @Description: TODO
	 * 查询用户的下级信息，包含订单信息 @param: @param series 查询的级数 @param: @param
	 * user_basics_id 用户id @param: @return @return:
	 * Map<String,List<UserRecommendWinxinBasics>>
	 * 键为等级数字型的字符串。值为对应级数的下级用户信息 @throws
	 */
	Map<String, List<UserTeamEntity>> findUserTeamSubordinateIncludeOrderBasics(int series, int user_basics_id);// 查询用户的下级信息，包含订单信息

	/**
	 * 
	 * @Title: addUserGradeUpgradeCondition @Description: TODO
	 * 添加等级的升级条件 @param: @param gradeUpgradeConditionEntity
	 * 等级的升级条件实体类 @param: @param condition_group_id
	 * 会员等级升级条件组id @param: @return @return: int @throws
	 */
	int addUserGradeUpgradeCondition(GradeUpgradeConditionEntity gradeUpgradeConditionEntity, int condition_group_id);// 等级的升级条件实体类

	/**
	 * 
	 * @Title: userUpgradeSchedule @Description: TODO
	 * 按照升级顺序，将满足条件的用户升级。将以满足条件与为满足条件写入数据库 @param: @param user_basics_id
	 * 用户id @param: @param user_grade_id 等级id @param: @return @return:
	 * List<UserUpgradeSchedule> 用户等级升级达成信息实体类集合 @throws
	 */
	void userUpgradeSchedule(int user_basics_id, int user_grade_id);// 按照升级顺序，将满足条件的用户升级。将以满足条件与为满足条件写入数据库

	/**
	 * 
	 * @Title: findGradeUpgradeConditionTo @Description: TODO 查询等级升级条件
	 * gradeUpgradeConditionEntity设置的值为查询条件，如果设置多个条件之间以并且链接 @param: @param
	 * gradeUpgradeConditionEntity @param: @return @return:
	 * GradeUpgradeConditionEntity 等级升级条件实体类 @throws
	 */
	List<GradeUpgradeConditionEntity> findGradeUpgradeConditionTo(
			GradeUpgradeConditionEntity gradeUpgradeConditionEntity);// 查询等级升级条件

	/**
	 * 
	 * @Title: removeGradeUpgradeConditionTo @Description: TODO @param: @param
	 * gradeUpgradeConditionEntity 等级升级条件实体类
	 * 设置的值为查询条件，如果设置多个条件之间以并且链接 @param: @return @return: int @throws
	 */
	int removeGradeUpgradeConditionTo(GradeUpgradeConditionEntity gradeUpgradeConditionEntity);// 删除等级条件

	/**
	 * 
	 * @Title: findUserInformationByPage @Description: TODO
	 * 查询所有用户补充信息 @param: @param user_basics_id 用户id @param: @return
	 * 用户补充信息 @return: UserInformationEntity 用户补充信息 实体类 @throws
	 */
	List<UserInformationEntity> findUserInformationByPage();

	/**
	 * 
	 * @Title: findUserInformationByPage @Description: TODO
	 * 查询所有品牌大使 @param: @param UserInformationEntity ui @param: @return
	 * 用户补充信息 @return: UserInformationEntity 用户补充信息 实体类 @throws
	 */
	List<UserInformationEntity> findCoFounds(UserInformationEntity ui);

	/**
	 * 
	 * @Title: findTeamInformationByPage @Description: TODO @param: @return:
	 * void @throws
	 */
	List<BasicsUser> findAllUserBasics();

	List<TeamInformation> findTeamInformationByPage(String information_compellation, String information_card,
			Integer user_basics_id,Integer co_user_basics_id);// 查询用户积分信息、奖金和团队信息

	TeamInformation findTeamInformationRecord(int user_basics_id);// 根据用户ID查询积分信息、奖金和团队信息

	List<TeamInformation> findTeamRecordId(int user_basics_id);// 根据用户ID查询下级团队的团队积分信息、奖金和团队信息

	/**
	 * 
	 * @Title: findUserBasicsAndWxAndInformation @Description: TODO
	 * 通过用户id查询用户基本信息和微信信息与用户详细信息 @param: @param user_basics_id
	 * 用户id @param: @return @return: UserBasicsAndWxAndInformationEntity
	 * 用户id查询用户基本信息和微信信息与用户详细信息实体类 @throws
	 */
	UserBasicsAndWxAndInformationEntity findUserBasicsAndWxAndInformation(int user_basics_id);// 通过用户id查询用户基本信息和微信信息与用户详细信息

	/**
	 * 
	 * @Title: findUserToadministrativeId @Description: TODO
	 * 通过管理组id查询管理组包含的用户信息 @param: @param administrative_id
	 * 管理组id @param: @return 用户信息 @return:
	 * List<UserBasicsAndWxAndInformationEntity> 用户信息实体类集合 @throws
	 */
	List<UserBasicsAndWxAndInformationEntity> findUserToadministrativeId(int administrative_id);// 通过管理组id查询管理组包含的用户信息

	/**
	 * 
	 * @Title: isUser @Description: TODO 判断用户是否存在 @param: @param condition
	 * 判断的条件 @param: @param conditionValue 条件值 @param: @return @return: boolean
	 * true为用户存在，false为不存在 @throws
	 */
	boolean isUser(String condition, String conditionValue);// 通过账号判断用户是否存在

	/**
	 * 
	 * @Title: LogOff @Description: TODO 注销登陆 @param: @param httpSession
	 * 浏览器session对象 @param: @return @return: Cookie 需要销毁的cookie信息 @throws
	 */
	Cookie LogOff(HttpSession httpSession);// 注销登陆

	/**
	 * 
	 * @Title: findG_U_C_GroupToC_G_id @Description: TODO
	 * 通过条件组id查询条件组数据 @param: @param condition_group_id
	 * 条件组id @param: @return @return: GradeUpgradeConditionGroupEntity @throws
	 */
	GradeUpgradeConditionGroupEntity findG_U_C_GroupToC_G_id(int condition_group_id);// 通过条件组id查询条件组数据

	/**
	 * 
	 * @Title: insertGradeUpgradeConditionGroupEntity @Description: TODO
	 * 插入一条条件组数据 @param: @param gradeUpgradeConditionGroupEntity
	 * 升级条件组实体类 @param: @return @return: int @throws
	 */
	int addGradeUpgradeConditionGroupEntity(GradeUpgradeConditionGroupEntity gradeUpgradeConditionGroupEntity);// 插入一条条件组数据

	/**
	 * 
	 * @Title: findG_U_C_GroupToG_id @Description: TODO
	 * 通过会员等级id查询条件组数据 @param: @param user_grade_id
	 * 会员等级id @param: @return @return: GradeUpgradeConditionGroupEntity
	 * 升级条件组实体类 @throws
	 */
	List<GradeUpgradeConditionGroupEntity> findG_U_C_GroupToG_id(int user_grade_id);// 通过会员等级id查询条件组数据

	/**
	 * 
	 * @Title: findG_U_C_ToCondition_group_id @Description: TODO
	 * 通过条件组id查询升级条件 @param: @param condition_group_id
	 * 通过条件组id @param: @return @return:
	 * List<GradeUpgradeConditionEntity> @throws
	 */
	List<GradeUpgradeConditionEntity> findG_U_C_ToCondition_group_id(int condition_group_id);// 通过条件组id查询升级条件

	/**
	 * 
	 * @Title: removeG_U_C_GroupToG_id @Description: TODO 通过等级升级条件组id删除条件数据
	 * 包含升级条件组条件、升级条件组、升级条件数据 @param: @param condition_group_id
	 * 条件组id @param: @return 删除是否成功 @return: int 2表示成功 @throws
	 */
	int removeG_U_C_GroupToG_id(int condition_group_id);// 通过等级升级条件组id删除条件数据
														// 包含升级条件组条件、升级条件组、升级条件数据

	int selectUserGradeIdCount(Integer user_grade_id, Integer integral_basics);// 统计各个奖金池人数

	Double findUserMoney(int user_basics_id);// 以用户id为条件查询用户的余额

	int updateAdminUser(BasicsUser basicsUser);// 修改用户名密码，账号

	TeamInformation findTeamInformationById(int user_basics_id);// 查询单个会员信息

	int userGradeAdd(UserGrade userGrade);// 新增会员等级

	UserInformationEntity selectUserById(UserInformationEntity userInformationEntity);// 查询单个用户信息

	int addUserConsultService(UserConsultServiceEntity userConsultServiceEntity);// 新增用户的乐唐顾问及高级经理

	List<UserConsultServiceEntity> findAllUserConsultService(UserConsultServiceEntity userConsultServiceEntity);// 查询所有用户对应的乐唐顾问及高级经理

	UserConsultServiceEntity findUserConsultserviceById(UserConsultServiceEntity userConsultServiceEntity);// 查询单个我的顾问信息

	int updateUserConsultservice(UserConsultServiceEntity userConsultServiceEntity);// 修改单个我的顾问信息
	
	UserAchievement findUserAchievementAll(int user_basics_id);//查询用户所有基本成就记录

}
