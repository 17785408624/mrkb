package com.mrkb.dao.dao;

import java.util.HashMap;
import java.util.List;

import com.mrkb.dao.modle.user.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface BasicUserMapper {

	int selectUidMax();//查询值最大的用户id
    UserInformationEntity findUserInfo(UserWeixin uw);//根据微信ID查询用户信息
	int addUserWeixin(UserWeixin uw);//添加微信信息
    int addBasicsUser(BasicsUser bu);//添加用户信息
    BasicsUser finduserWeixinone(UserWeixin uw);
    BasicsUser selectUserBToUid(int user_basics_id);
    BasicsUser findUserWeixin(UserWeixin uw);
    BasicsUser findUserBasics(int user_basics_id);//通过user_basics_id查询用户基本信息
    int updateUserBasics(BasicsUser basicsUser);//修改用户基本信息
    TeamInformation findTeamInformationById(int user_basics_id);//查询单个会员信息
    /**
     * 
     * @Title:             selectAllUserBasicsAndGrade
     * @Description:     TODO 查询用户表与用户等级表。
     * @param:             @return   
     * @return:         List<BasicsUser> 用户信息实体类集合  
     * @throws
     */
    List<BasicsAndGradeEntity> selectAllUserBasicsAndGrade();//查询所有用户基本信息及等级
    /**
     * 
     * @Title:             selectUserBasicsAndGradeId
     * @Description:     TODO 根据用户ID查询详细信息
     * @param:             @return   
     * @return:         List<BasicsUser> 用户信息实体类集合  
     * @throws
     */
    BasicsAndGradeEntity selectUserBasicsAndGradeId(int user_basics_id);//根据会员ID查询用户信息
    /**
     * 
     * @Title:             selectUserBasicsGrade
     * @Description:     TODO 根据会员条件查询用户信息
     * @param:             @param Grade 会员等级id
     * @param:             @return   用户信息数据
     * @return:         List<BasicsUser>   用户数据实体集合
     * @throws
     */
    List<BasicsUser> selectUserBasicsToGrade(int grade);//根据会员条件查询用户基本信息
    List<BasicsUser> selectAllUserBasics();//查询所有会员基本信息
    /**
     * 
     * @Title:             findTeamInformationByPage
     * @Description:     TODO 查询用户积分信息、奖金和团队信息
     * @param:             @param 
     * @param:             @return   用户信息数据
     * @return:         List<TeamInformation>   用户数据实体集合
     * @throws
     */
    List<TeamInformation> findTeamInformationByPage(@Param("information_compellation")String information_compellation,@Param("information_card")String information_card,@Param("user_basics_id")Integer user_basics_id,@Param("co_user_basics_id")Integer co_user_basics_id);//查询用户积分信息、奖金和团队信息
    /**
     * 
     * @Title:             findTeamInformationRecord
     * @Description:     TODO 根据用户ID查询积分信息、奖金和团队信息
     * @param:             @param 
     * @param:             @return   用户信息数据
     * @return:         List<TeamInformation>   用户数据实体集合
     * @throws
     */
    TeamInformation findTeamInformationRecord(int user_basics_id);//根据用户ID查询积分信息、奖金和团队信息
    /**
     * 
     * @Title:             findTeamRecordId
     * @Description:     TODO 根据用户ID查询下级团队的团队积分信息、奖金和团队信息
     * @param:             @param 
     * @param:             @return   用户信息数据
     * @return:         List<TeamInformation>   用户数据实体集合
     * @throws
     */
    List<TeamInformation> findTeamRecordId(int user_basics_id);//根据用户ID查询下级团队的团队积分信息、奖金和团队信息
    /**
     * 
     * @Title:             selectUserBasicsToAccountNum
     * @Description:     TODO 根据用户账号查询用户信息
     * @param:             @param user_account_num 用户账号
     * @param:             @return   
     * @return:         BasicsUser   用户基本信息
     * @throws
     */
    List<BasicsUser> selectUserBasicsToAccountNum(String user_account_num);//根据用户账号查询用户信息
    BasicsUser selectUserBasicsToAccountNumOne(String user_account_num);//根据用户账号查询用户
    /**
     * 
     * @Title:             findGrade
     * @Description:     TODO 查询公司到达绿卡巴以上用户
     * @param:             @param 
     * @param:             @return   
     * @return:         BasicsUser   用户基本信息
     * @throws
     */
    List<BasicsUser> findGrade(HashMap<String,Object> map);//查询公司到达绿卡巴以上用户
    /**
     * 
     * @Title:             selectUserBasicsToAccountNumUserPassword
     * @Description:     TODO 通过用户账号和密码查询用户信息
     * @param:             @param accountNum 用户账号
     * @param:             @param userPassword 用户密码
     * @param:             @return   
     * @return:         BasicsUser  用户信息实体类 
     * @throws
     */
    BasicsUser selectUserBasicsToAccountNumUserPassword(
    		@Param("user_account_num")String user_account_num,@Param("user_password")String user_password);//通过用户账号和密码查询用户信息
    /**
     * 
     * @Title:             selectUserGradeIdCount
     * @Description:统计各个奖金池人数     TODO
     * @param:             @param user_grade_id
     * @param:             @return   
     * @return:         BasicsUser   
     * @throws
     */
    int selectUserGradeIdCount(@Param("user_grade_id")Integer user_grade_id,@Param("integral_basics")Integer integral_basics );//统计各个奖金池人数
    /**
     * 
     * @Title:             updateUserMoneyPlus
     * @Description:     TODO 增加用户余额
     * @param:             @param num 改变的值
     * @param:             @param user_basics_id 用户id
     * @param:             @return   
     * @return:         int   
     * @throws
     */
    int updateUserMoneyPlus(@Param("num")Double num,@Param("user_basics_id")int user_basics_id);//增加用户余额
    /**
     * 
     * @Title:             updateUserMoneyReduce
     * @Description:     TODO 减少用户余额
     * @param:             @param num 改变的值
     * @param:             @param user_basics_id 用户id
     * @param:             @return   
     * @return:         int   
     * @throws
     */
    int updateUserMoneyReduce(@Param("num")Double num,@Param("user_basics_id")int user_basics_id);//减少用户余额
    /**
     * 
     * @Title:             updateUserMoneyPlusToUid_Bid
     * @Description:     TODO 通过奖金兑换申请id增加用户余额
     * @param:             @param bonus_extract_apply_id 奖金兑换余额申请表id
     * @param:             @return   
     * @return:         int   
     * @throws
     */
    int updateUserMoneyPlusToUid_Bid(Integer bonus_extract_apply_id);//增加用户余额
    /**
     * 
     * @Title:             selectUserMoneyToUid
     * @Description:     TODO 通过用户id查询单个用户的余额
     * @param:             @param user_basics_id 用户id
     * @param:             @return   
     * @return:         int   用户id
     * @throws
     */
    Double selectUserMoneyToUid(int user_basics_id);//通过用户id查询单个用户的余额
    /**
     * 
     * @Title:             updateAdminUser
     * @Description:     TODO 修改用户名密码，账号
     * @param:             @param basicsUser 用户对象
     * @param:             @return   
     * @return:         int   用户id
     * @throws
     */
    int updateAdminUser(BasicsUser basicsUser);//修改用户名密码，账号
}
