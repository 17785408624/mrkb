package com.mrkb.service.impl;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrkb.dao.dao.BasicUserMapper;
import com.mrkb.dao.dao.IntegralMapper;
import com.mrkb.dao.dao.UserAchievementMapper;
import com.mrkb.dao.dao.UserGradeMapper;
import com.mrkb.dao.dao.UserIntegralMapper;
import com.mrkb.dao.dao.UserRecommendMapper;
import com.mrkb.dao.dao.UserWeixinMapper;
import com.mrkb.dao.modle.account.IntegralAccount;
import com.mrkb.dao.modle.core.AwardOperationEntity;
import com.mrkb.dao.modle.core.AwardOperationEntityAll;
import com.mrkb.dao.modle.core.UserUpgrade;
import com.mrkb.dao.modle.user.BasicsUser;
import com.mrkb.dao.modle.user.UserAchievement;
import com.mrkb.dao.modle.user.UserAchievementAccount;
import com.mrkb.dao.modle.user.UserGrade;
import com.mrkb.dao.modle.user.UserRecommend;
import com.mrkb.service.CoreService;


@Service("coreServiceImpl")
@Transactional(rollbackFor = Exception.class) 
public class CoreServiceImpl implements CoreService{
	@Resource
	private UserRecommendMapper userRecommendMapper;//奖励配置
	@Resource
	private UserIntegralMapper userIntegralMapper;//积分数据层
	@Resource
	private IntegralMapper integralMapper;//流水记录数据层
	@Resource
	private UserWeixinMapper userWeixinMapper;//用户微信信息数据层
	@Resource
	private UserAchievementMapper userAchievementMapper;//用户基本成就数据层
	@Resource
	private UserGradeMapper userGradeMapper;//用户等级数据层
	@Resource
	private BasicUserMapper basicUserMapper;//用户基本信息数据层
	
	
	
	/**
	 * 获取用户按照成就提升会员等级的排序,需要传入用户user_grade_id,如果没有对应顺序默认为1
	 */
	@Override
	public Integer findUserUpgradeOrderGradeAchievement(Integer user_grade_id) {//以成就升级的排序获取等级id
		String upgradeOrder="";
		Integer userGradeUpgradeOrder = null;
		if(upgradeOrder.equals("null")){
			userGradeUpgradeOrder=0;//没有排序配置默认为零
		}else{
			String regEx="[^0-9]";   
			Pattern p = Pattern.compile(regEx);   
			Matcher m = p.matcher(upgradeOrder);
			upgradeOrder=m.replaceAll("").trim();//去掉字符串部分
			 Integer.valueOf(upgradeOrder);
		}
		return userGradeUpgradeOrder;
	}
	/**
	 * 
	 */
	@Override
	public Integer findUserGradeUpgradeOrderAchievement(Integer UpgradeOrderGrade) {//获取用户按照成就提升会员等级的排序
		String regEx="[^0-9]";//正则表达式格式   
		Pattern p = Pattern.compile(regEx);
		String user_grade_idNext="";
		user_grade_idNext=p.matcher(user_grade_idNext).replaceAll("").trim();//截取数字；获得按照成就排序的下一级别等级id
		return Integer.valueOf(user_grade_idNext);
	}
	/**
	 * 
	 */
	@Override
	public List<Map<String, Object>> findUpgradeAchievementRule(//获取一个等级按照成就升级的条件
			Integer user_grade_id) {
		Map<String,Object> upgradeMap=null;//获取级别的升级规则
		List<Map<String,Object>> upgradeConditionList=(List) upgradeMap.get("upgradeCondition");//升级条件集合
		return upgradeConditionList;
	}
	/**
	 * 
	 */
	@Override
	public UserUpgrade UpgradeProgressAchievement(
			UserAchievement userAchievement,
			List<UserAchievementAccount> achievementAccountList,
			List<Map<String, Object>> upgradeConditionList) {//返回当前成就与升级条件的成就值相差值与是否满足条件
		List<Map<String,Object>>accomplishList=new ArrayList<>();//已达成的升级条件
		List<Map<String,Object>>unrealizedList=new ArrayList<>();//未达成的升级条件
		int conclude=1;//是否达到升级条件（2为已满足条件，1为未满足条件）；
		for(int i=0;i<upgradeConditionList.size();i++){//遍历升级条件
			conclude=1;
			Map<String,Object> map=upgradeConditionList.get(i);//接收其中一个条件
			String achievementType=String.valueOf(map.get("achievementType"));//条件类型
			Integer achievementValue=Integer.valueOf(String.valueOf(map.get("achievementValue")));//升级条件值
			Map<String,Object> AchievementProgressMap=new HashMap();//成就进度
			if(achievementType.equals("custom")){//条件为自定义，achievementValue为对应自定义条件的id
				//成就类型
				AchievementProgressMap.put("type", "custom");
				//成就名
				AchievementProgressMap.put("Name","");
				//成就对应key
				AchievementProgressMap.put("key", achievementValue);
				//成就目标
				AchievementProgressMap.put("objective", "完成"+"");
				if(achievementAccountList==null||achievementAccountList.size()==0){
					AchievementProgressMap.put("present","未进行");
					unrealizedList.add(AchievementProgressMap);
					continue;
				}
				for (UserAchievementAccount userAchievementAccount : achievementAccountList) {//遍历用户的自定义成就
					//获取自定义条件的内容
					if(userAchievementAccount.getAchievement_cutom_id()
							==achievementValue){//如果用户的自定义成就内含有升级的条件
						if(userAchievementAccount.getStatus()==1){//成就正在进行中
							//目前进度
							AchievementProgressMap.put("present","进行中");
							unrealizedList.add(AchievementProgressMap);
							conclude=2;
							break;
						}else if(userAchievementAccount.getStatus()==2){//成就已达成
							//目前已达成
							AchievementProgressMap.put("present","已完成");
							accomplishList.add(AchievementProgressMap);
							break;
						}else{
							AchievementProgressMap.put("present","未进行");
							break;
						}
					}
				}
				
			}else{//条件为成就基本信息，achievementValue为对应类型的值
				
				//成就类型
				AchievementProgressMap.put("type", achievementType);
				//成就名
				AchievementProgressMap.put("Name","");
				//成就对应key
				AchievementProgressMap.put("key", achievementType);
				//成就目标
				AchievementProgressMap.put("objective", achievementValue);
				try {
					//根据get加上achievementType得到方法名，achievementType对应类的属性
					if(userAchievement==null){//未满足此条件,基本成就为空
						//目前已达成
						AchievementProgressMap.put("present",0);
						unrealizedList.add(AchievementProgressMap);
						conclude=1;
						continue;
					}
					Class<?> c = Class.forName(userAchievement.getClass().getName());
					//拼出get属性的方法
					String methodName="get"+(achievementType.substring(0, 1).toUpperCase() + achievementType.substring(1));
					Method method=c.getMethod(methodName);
					Integer userAchievementValue= (Integer) method.invoke(userAchievement);
					//目前已达成
					AchievementProgressMap.put("present",userAchievementValue);
					
					if(userAchievementValue>=achievementValue){//已满足此条件
						accomplishList.add(AchievementProgressMap);
						conclude=2;
					}else{//未满足此条件
						unrealizedList.add(AchievementProgressMap);
						conclude=1;
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		UserUpgrade userUpgrade=new UserUpgrade(conclude,accomplishList,unrealizedList);
		return userUpgrade;
	}
	/**
	 * <p>Title: getLowerBuyWay</p>
	 * <p>Description: </p>
	 * @return
	 * @see com.medicinefood.service.CoreService#getLowerBuyWay()
	 */ 
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getLowerBuyWay() {
		// TODO Auto-generated method stub
		
		return null;
	}
	/**
	 * <p>Title: getAwardOperation</p>
	 * <p>Description: </p>
	 * @param user_basics_id
	 * @param correlatedList
	 * @return
	 * @see com.medicinefood.service.CoreService#getAwardOperation(java.lang.Integer, java.util.List)
	 */ 
	public AwardOperationEntityAll getAwardOperation(Integer user_basics_id,
			List<Map<String, Object>> correlatedList) {//得到奖励操作集合
		@SuppressWarnings("unused")
		List<AwardOperationEntity> percentAwardList=new ArrayList<>();//按百分比计算金额的奖励操作集合
		List<AwardOperationEntity> directAwardList=new ArrayList<>();//直接赋值奖励金额的奖励操作集合
		for (Map<String, Object> map : correlatedList) {//遍历奖励规则集合
			String superName=String.valueOf(map.get("奖励对象名"));//获取奖励的对象
			Integer bonusArithmetic=Integer.valueOf(String.valueOf(map.get("奖励算法")));//获取奖励算法方式
			String bonusValue=String.valueOf(map.get("奖励值"));//获取奖励值配置
			String optionAward=String.valueOf(map.get("奖励项"));//获取奖励项
			AwardOperationEntity awardOperationEntity =new AwardOperationEntity();//奖励操作实体类
			if(superName.substring(0,1).equals("S")){//奖励人群为上家
				superName=superName.substring(1);//获取级数
				UserRecommend ur=userRecommendMapper.findUserSuperiorUserid(Integer.valueOf(user_basics_id), Integer.valueOf(superName));//获取superName级推荐人id
				if(ur==null){
					break;
				}
				awardOperationEntity.setAwardUserID(ur.getRecommend_superior());//奖励人id
			}else if(superName.substring(0,1).equals("L")){//奖励人群为下家
				
			};
			awardOperationEntity.setAwardOption(optionAward);//奖励项
			awardOperationEntity.setBonusArithmetic(Integer.valueOf(bonusArithmetic));//奖励算法
			awardOperationEntity.setAwardValue(bonusValue);//奖励值
			if(bonusArithmetic==1){//直接设置奖金
				directAwardList.add(awardOperationEntity);
			}else if(bonusArithmetic==2){//以商品价格百分比设置奖金
				percentAwardList.add(awardOperationEntity);
			}
		}
		
		// TODO Auto-generated method stub
		AwardOperationEntityAll awardOperationEntityList=new AwardOperationEntityAll();
		
		return awardOperationEntityList;
	}
	/**
	 * <p>Title: executeAwardOperation</p>
	 * <p>Description: </p>
	 * @param awardOperationEntityList
	 * @param store_price
	 * @return
	 * @see com.medicinefood.service.CoreService#executeAwardOperation(java.util.List, int)
	 */ 
	@Override
	public int executeTeamAwardOperation(//执行奖励操作（奖励方式按照商品价格的百分比计算）
			List<AwardOperationEntity> awardOperationEntityList, Double store_price
			,int integral_account_type,int integral_trigger,int user_basics_id,int user_grade_id,int store_id) {
		int updateNum=0;
		for (AwardOperationEntity awardOperationEntity2 : awardOperationEntityList) {
			Integer awardValue=Integer.valueOf(awardOperationEntity2.getAwardValue());
			awardOperationEntity2.setAwardValue(String.valueOf(awardValue*store_price/100));//按商品价格与设置比例算出奖励金额
			
			if(user_grade_id <2&&awardOperationEntity2.getAwardOption().equals("integral_bonus")){
				awardOperationEntity2.setAwardValue(String.valueOf(Double.valueOf(String.valueOf(awardValue))+700));
			}
			IntegralAccount integralAccount=new IntegralAccount();
			integralAccount.setAccount_add_date(new Date().getTime());//更改积分时间（添加数据时间）
			integralAccount.setAccount_option_name("");//改变数据的名字
			integralAccount.setAccount_option(awardOperationEntity2.getAwardOption());//改变的数据
			String userWeixinNickname=userWeixinMapper.findUserUserWeinxinNameBasicsId(user_basics_id);//查出购买用户的微信昵称
			integralAccount.setIntegral_account_explain(userWeixinNickname+"购买商品获取奖励");//流水说明
			integralAccount.setIntegral_account_num(awardOperationEntity2.getAwardValue());//更改的值
			integralAccount.setUser_basics_id(awardOperationEntity2.getAwardUserID());//改变积分项的用户（关联user_basics表）
			integralAccount.setIntegral_account_type(integral_account_type);//设置流水类型，1为购买商品
			integralAccount.setIntegral_trigger(integral_trigger);//设置流水相关订单id
			BasicsUser basicsUser= basicUserMapper.findUserBasics(awardOperationEntity2.getAwardUserID());//获取奖励对象信息
			UserGrade userGrade=userGradeMapper.findUserGrade(
					basicsUser.getUser_grade_id());//获取受奖励人的等级信息
			if(userGrade==null||userGrade.getUpgrade_order()==null||Integer.valueOf(userGrade.getUpgrade_order())<2){//奖励对象非正式注册会员
				integralAccount.setIntegral_account_explain(userWeixinNickname+"购买商品--非正式会员无法获取奖励"+(awardValue*store_price/100));//流水说明
				integralAccount.setIntegral_account_num("0");//更改的值
				integralMapper.addIntegralAccount(integralAccount);//添加流水记录
				continue;
			}
			//userIntegralMapper.operationIntegral(awardOperationEntity2);//添加奖励
			integralMapper.addIntegralAccount(integralAccount);//添加流水记录
			UserAchievement userAchievement=new UserAchievement();//用户基本成就实体类
			if(awardOperationEntity2.getAwardOption().equals("integral_basics")){//奖励项为积分
				userAchievement.setRecords_integral(Integer.valueOf(awardOperationEntity2.getAwardValue()));
				userAchievement.setUser_basics_id(awardOperationEntity2.getAwardUserID());//设置增加成就的用户id
			}else if(awardOperationEntity2.getAwardOption().equals("integral_bonus")){//奖励项为奖金
//				HashMap<String,Object> map=new HashMap<String,Object>();
//				if(user_grade_id <2){
//					map.put("integral_bonus", Integer.valueOf(awardOperationEntity2.getAwardValue())+700);
//				}else{
//					map.put("integral_bonus", Integer.valueOf(awardOperationEntity2.getAwardValue()));
//				}
//				map.put("user_basics_id", awardOperationEntity2.getAwardUserID());
//				userIntegralMapper.updateIntegralBonus(map);
				userAchievement.setRecords_bonus(awardOperationEntity2.getAwardValue());
				userAchievement.setUser_basics_id(awardOperationEntity2.getAwardUserID());//设置增加成就的用户id
			}
			if(userAchievement.getUser_basics_id()!=null){//已设置添加成就的用户
				userAchievementMapper.augmentUserAchievement(userAchievement);//增加用户基本成就
			}
			updateNum++;
		}
		
		// TODO Auto-generated method stub
		return updateNum;
	}
	/**
	 * <p>Title: executeAwardDirectOperation</p>
	 * <p>Description: </p>
	 * @param awardOperationEntityList
	 * @return
	 * @see com.medicinefood.service.CoreService#executeAwardDirectOperation(java.util.List)
	 */ 
	@Override
	public int executeTeamAwardOperation(//用户购买商品，为奖励对象执行奖励操作（奖励方式为直接赋值）
			List<AwardOperationEntity> awardOperationEntityList,
			int integral_account_type,int integral_trigger,
			int user_basics_id,int num,int user_grade_id,int store_id) {
		int updateNum=0;
		int storeId = store_id;//商品id
		for (AwardOperationEntity awardOperationEntity2 : awardOperationEntityList) {
			int awardValue=num*Integer.valueOf(awardOperationEntity2.getAwardValue());//算出奖励值
			IntegralAccount integralAccount=new IntegralAccount();//积分流水记录实体类
			integralAccount.setAccount_add_date(new Date().getTime());//更改积分时间（添加数据时间）
			integralAccount.setAccount_option_name(awardOperationEntity2.getAwardOptionName());//改变数据的名字
			integralAccount.setAccount_option(awardOperationEntity2.getAwardOption());//改变的数据
			String userWeixinNickname=userWeixinMapper.findUserUserWeinxinNameBasicsId(user_basics_id);//查出购买用户的微信昵称
			integralAccount.setIntegral_account_explain(userWeixinNickname+"购买商品获取奖励：");//流水说明
			integralAccount.setIntegral_account_num(String.valueOf(awardValue));//更改的值
			integralAccount.setUser_basics_id(awardOperationEntity2.getAwardUserID());//改变积分项的用户（关联user_basics表）
			integralAccount.setIntegral_account_type(integral_account_type);//设置流水类型，1为购买商品
			integralAccount.setIntegral_trigger(integral_trigger);//设置流水相关订单id
			BasicsUser basicsUser= basicUserMapper.findUserBasics(awardOperationEntity2.getAwardUserID());//获取奖励对象信息
			UserGrade userGrade=userGradeMapper.findUserGrade(basicsUser.getUser_grade_id());//获取受奖励人的等级信息
			if(userGrade==null||userGrade.getUpgrade_order()==null||Integer.valueOf(userGrade.getUpgrade_order())<2){//奖励对象非正式注册会员
				 if(user_basics_id == basicsUser.getUser_basics_id()){
					 if(storeId ==76){
						 integralAccount.setIntegral_account_explain(userWeixinNickname+"购买商品--首次购买可获取指数奖励1个豆：");//流水说明
							integralAccount.setIntegral_account_num("1");//更改的值
							integralMapper.addIntegralAccount(integralAccount);//添加流水记录
							continue;
					 }else{
						 integralAccount.setIntegral_account_explain(userWeixinNickname+"购买商品--首次购买可获取指数奖励10个豆：");//流水说明
							integralAccount.setIntegral_account_num("10");//更改的值
							integralMapper.addIntegralAccount(integralAccount);//添加流水记录
							continue;
					 }
					 
						
				 }else{
					 if(awardOperationEntity2.getAwardOption().equals("integral_basics")){
						 if(storeId ==76){
							 integralAccount.setIntegral_account_explain(userWeixinNickname+"购买商品--非正式会员无法获取能量值奖励：1个豆");//流水说明
						 }else{
							 integralAccount.setIntegral_account_explain(userWeixinNickname+"购买商品--非正式会员无法获取能量值奖励：10个豆");//流水说明
						 }
					 }else if(awardOperationEntity2.getAwardOption().equals("integral_bonus")){
						 integralAccount.setIntegral_account_explain(userWeixinNickname+"购买商品--非正式会员无法获取奖金："+integralAccount.getIntegral_account_num()+"元");//流水说明
					 }else if(awardOperationEntity2.getAwardOption().equals("integral_travel")){
						 if(storeId ==76){
							 integralAccount.setIntegral_account_explain(userWeixinNickname+"购买商品--非正式会员无法获取智慧值奖励：1个豆");//流水说明
						 }else{
							 integralAccount.setIntegral_account_explain(userWeixinNickname+"购买商品--非正式会员无法获取智慧值奖励：10个豆");//流水说明
						 }
						// integralAccount.setIntegral_account_explain(userWeixinNickname+"购买商品--非正式会员无法获取智慧值奖励：10个豆");//流水说明
					 }
					
					integralAccount.setIntegral_account_num("0");//更改的值
					integralMapper.addIntegralAccount(integralAccount);//添加流水记录
					continue;
					}
				 }
			awardOperationEntity2.setAwardValue(String.valueOf(awardValue));
			UserRecommend ur=userRecommendMapper.findUserSuperiorUserid(user_basics_id,1);
			
			if(user_grade_id <2&&awardOperationEntity2.getAwardOption().equals("integral_bonus")&&ur.getRecommend_superior().equals(basicsUser.getUser_basics_id())){
				if(storeId ==76){
					 awardOperationEntity2.setAwardValue(String.valueOf(Integer.valueOf(String.valueOf(awardValue))+70));
				 }else{
					 awardOperationEntity2.setAwardValue(String.valueOf(Integer.valueOf(String.valueOf(awardValue))+700));
			          }				 
				//awardOperationEntity2.setAwardValue(String.valueOf(Integer.valueOf(String.valueOf(awardValue))+700));
			}
			if(user_grade_id <2&&awardOperationEntity2.getAwardOption().equals("integral_basics")&&user_basics_id == basicsUser.getUser_basics_id()){
				if(storeId ==76){
					integralAccount.setIntegral_account_num(String.valueOf(Integer.valueOf(String.valueOf(awardValue))+1));//更改的值
				 }else{
					 integralAccount.setIntegral_account_num(String.valueOf(Integer.valueOf(String.valueOf(awardValue))+10));//更改的值
			          }	
				//integralAccount.setIntegral_account_num(String.valueOf(Integer.valueOf(String.valueOf(awardValue))+10));//更改的值
				integralAccount.setIntegral_account_explain(userWeixinNickname+"购买商品--首次购买商品获取奖励：");//流水说明
			}
			integralMapper.addIntegralAccount(integralAccount);//添加积分记录
			userIntegralMapper.operationIntegral(awardOperationEntity2);//添加用户奖金;
			UserAchievement userAchievement=new UserAchievement();//用户基本成就实体类
			if(awardOperationEntity2.getAwardOption().equals("integral_basics")){//奖励项为积分 setRecords_integral
				userAchievement.setRecords_integral(Integer.valueOf(awardOperationEntity2.getAwardValue()));//设置增加成就的值
				userAchievement.setUser_basics_id(awardOperationEntity2.getAwardUserID());//设置增加成就的用户id
			}else if(awardOperationEntity2.getAwardOption().equals("integral_bonus")){//奖励项为奖金 setRecords_bonus
//				HashMap<String,Object> map=new HashMap<String,Object>();
//				if(user_grade_id <2){
//					map.put("integral_bonus", Integer.valueOf(awardOperationEntity2.getAwardValue())+700);
//				}else{
//					map.put("integral_bonus", Integer.valueOf(awardOperationEntity2.getAwardValue()));
//				}
//				map.put("user_basics_id", awardOperationEntity2.getAwardUserID());
//				userIntegralMapper.updateIntegralBonus(map);
				userAchievement.setRecords_bonus(String.valueOf(awardValue));//设置增加成就的值
				userAchievement.setUser_basics_id(awardOperationEntity2.getAwardUserID());//设置增加成就的用户id
			}
			if(userAchievement.getUser_basics_id()!=null){//已设置添加成就的用户
				userAchievementMapper.augmentUserAchievement(userAchievement);//增加用户基本成就
			}
			updateNum++;
		}
		return updateNum;
	}
	/**
	 * <p>Title: userBuyTeamAward</p>
	 * <p>Description: </p>
	 * @param user_basics_id
	 * @param store_id
	 * @param store_price
	 * @return
	 * @see com.medicinefood.service.CoreService#userBuyTeamAward(int, int, int)
	 */ 
	@SuppressWarnings("unchecked")
	@Override
	public AwardOperationEntityAll userBuyTeamAward(int user_basics_id, int store_id) {//得到购买商品触发团队奖励操作
		AwardOperationEntityAll awardOperationEntityAll=new AwardOperationEntityAll();//奖励操作类
		Map<String, Object>lowerBuyWayMap= null;//获取购买商品的奖励规则
		System.out.println("ew4r53232"+lowerBuyWayMap);
		List<Map<String, Object>> correlatedList=new ArrayList<Map<String, Object>>();//奖励规则集合
		correlatedList=(List<Map<String, Object>>) lowerBuyWayMap.get(String.valueOf(store_id));//获取当前商品id对应的奖励规则
		System.out.println("ew4r53232"+correlatedList);
		if(correlatedList==null){//当前商品无购买奖励返回null
			System.out.println("当前商品无购买奖励");
			return null;
		}
        List<AwardOperationEntity> percentAwardList=new ArrayList<>();//按百分比计算金额的奖励操作集合
		List<AwardOperationEntity> directAwardList=new ArrayList<>();//直接赋值奖励金额的奖励操作集合
		for (Map<String, Object> map : correlatedList) {//遍历奖励规则集合
			String superName=String.valueOf(map.get("奖励对象名"));//获取奖励的对象
			Integer bonusArithmetic=Integer.valueOf(String.valueOf(map.get("奖励算法")));//获取奖励算法方式
			String bonusValue=String.valueOf(map.get("奖励值"));//获取奖励值配置
			String optionAward=String.valueOf(map.get("奖励项"));//获取奖励项
			AwardOperationEntity awardOperationEntity =new AwardOperationEntity();//奖励操作实体类
			if(superName.substring(0,1).equals("S")){//奖励人群为上家
				String superNameNum=superName.substring(1);//获取级数
			if(superNameNum.equals("0")){
				awardOperationEntity.setAwardUserID(Integer.valueOf(Integer.valueOf(user_basics_id)));//自己id
			}else{
				UserRecommend ur=userRecommendMapper.findUserSuperiorUserid(Integer.valueOf(user_basics_id), Integer.valueOf(superNameNum));//获取superName级推荐人id
				if(ur==null){
					break;
				}
				awardOperationEntity.setAwardUserID(ur.getRecommend_superior());//奖励人id
			}
				
			}else if(superName.substring(0,1).equals("L")){//奖励人群为下家
				
			};
//			if(superName.equals("M0")){//给自身加积分
//				awardOperationEntity.setAwardUserID(Integer.valueOf(Integer.valueOf(user_basics_id)));//自己id
//			}
			awardOperationEntity.setAwardOption(optionAward);//奖励项
			awardOperationEntity.setAwardOptionName("");//奖励项名字
			awardOperationEntity.setBonusArithmetic(Integer.valueOf(bonusArithmetic));//奖励算法
			awardOperationEntity.setAwardValue(bonusValue);//奖励值
			awardOperationEntity.setBuyUserTeamRelation(superName);//受奖者与购买人的团队关系
			if(bonusArithmetic==1){//直接设置奖金
				directAwardList.add(awardOperationEntity);
			}else if(bonusArithmetic==2){//以商品价格百分比设置奖金
				percentAwardList.add(awardOperationEntity);
			}
			
		}
		awardOperationEntityAll.setPercentAwardList(percentAwardList);
		awardOperationEntityAll.setDirectAwardList(directAwardList);
		return  awardOperationEntityAll;		
	}
	

}
