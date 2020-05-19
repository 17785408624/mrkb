package com.mrkb.dao.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mrkb.dao.modle.user.BasicsUser;
import com.mrkb.dao.modle.user.UserInformationEntity;
import com.mrkb.dao.modle.user.UserRecommend;
import com.mrkb.dao.modle.user.UserRecommendWinxinBasics;
import com.mrkb.dao.modle.user.UserTeamEntity;
import com.mrkb.dao.modle.user.UserWeixin;

@Mapper
public interface UserRecommendMapper {
	int addSysUser (int id);
	int addUserRecommend(UserRecommend ur);//添加推荐表数据
	int updateUserRecommend(UserRecommend ur);//修改推荐人
	UserRecommend findUserSuperiorUserid(@Param("userid")int userid,@Param("round")int round);//查询用户推荐人round为上级级数
    List<UserWeixin> findUserSubordinateUserWeixinUserid(int user_basics_id);//查询下一级，返回微信信息
	List<UserWeixin> findUserSubordinateBuyUserWeixinUserid(int user_basics_id);//查询已购商品的下级用户微信信息
	int findUserSubordinateBuyUserWeixinUseridNum(int user_basics_id);//查询用户已购买商品的下一级人数
	int findUserSubordinateUserWeixinUseridNum(int user_basics_id);//查询下一级人数
	List<UserWeixin> findUserSubordinateNotBuyUserWeixinUserid(int user_basics_id);//查询下级未购买用户
	List<Map<String,Object>>findUserSubordinateSuperiorName(int user_basics_id);//以useriid查询下级用户，包含下级推荐人
	List<Map<String,Object>>findUserSubordinateNotBuySuperiorName(int user_basics_id);//查询未购买的下级用户，包含推荐人名字
	List<Map<String,Object>>findUserSubordinateBuySuperiorName(int user_basics_id);//查询已购买的下级用户，包含推荐人名字
	BasicsUser selectRecommendById(int user_basics_id);//根据用户认id查询推荐人id以及推荐人会员等级
	/**
	 * 
	 * @Title:             findUserUserRecommendWinxinBasicsTorecommend_superior
	 * @Description:     TODO 根据推荐人用户id查询用户信息；
	 * @param:             @param recommend_superiors 多个推荐人id
	 * @param:             @return 用户信息与推荐人信息
	 * @return:         List<UserRecommendWinxinBasics>   
	 * @throws
	 */
	List<UserRecommendWinxinBasics>selectUserRecommendWinxinBasicsToRecommend_superior
	(@Param("recommend_superiors") int[] recommend_superiors);//根据推荐人id查询用户信息；
	/**
	 * 
	 * @Title:             selectUserRecommendIncludeOrderBasics
	 * @Description:     TODO
	 * @param:             @param recommend_superiors
	 * @param:             @return   
	 * @return:         List<UserRecommendWinxinBasics>   
	 * @throws
	 */
	List<UserTeamEntity>selectUserRecommendIncludeOrderBasics
	(@Param("recommend_superiors") int[] recommend_superiors);//根据推荐人id查询用户信息 包含用户订单信息；
	List<UserTeamEntity>selectUserRecommendIncludeOrderBasics3
	(@Param("recommend_superiors") int[] recommend_superiors);//根据推荐人id查询用户信息 包含用户订单信息三代；
	/**
	 * 
	 * @Title:             findSubordinate
	 * @Description:     TODO
	 * @param:             @param barr
	 * @param:             @return   
	 * @return:         int[] barr
	 * @throws
	 */
	Integer[] findSubordinate
	(@Param("barr") Integer[] barr);
	/**
	 * 
	 * @Title:             selectUserCountToSuperiorIdGradeId
	 * @Description:     TODO 根据推荐人id 与等级id查询用户数量
	 * @param:             @param recommend_superior 推荐人id
	 * @param:             @param user_grade_id 等级id
	 * @param:             @return   
	 * @return:         int   符合条件的数量
	 * @throws
	 */
	int selectUserCountToSuperiorIdGradeId(@Param("recommend_superior") int recommend_superior,@Param("user_grade_id")int user_grade_id);
	/**
	 * 
	 * @Title:             selectOlderUser
	 * @Description:     TODO 根据用户id查询上级用户ID
	 * @param:             @param user_basics_id 用户ID
	 * @param:             @param user_grade_id 等级id
	 * @param:             @return   
	 * @return:         UserTeamEntity  
	 * @throws
	 */
	UserInformationEntity selectOlderUser(int user_basics_id);
	/**
	 * 
	 * @Title:             selectOlderUser
	 * @Description:     TODO 根据用户id查询上级用户ID
	 * @param:             @param user_basics_id 用户ID
	 * @param:             @param user_grade_id 等级id
	 * @param:             @return   
	 * @return:         UserTeamEntity  
	 * @throws
	 */
	UserWeixin selectOlderUserWx(int user_basics_id);
	/**
	 * 
	 * @Title:             selectSuperUserId
	 * @Description:     TODO 根据用户id查询上级用户ID
	 * @param:             @param user_basics_id 用户ID
	 * @param:             @return   
	 * @return:         user_basics_id  
	 * @throws
	 */
	int selectSuperUserId(int user_basics_id);
	
}
