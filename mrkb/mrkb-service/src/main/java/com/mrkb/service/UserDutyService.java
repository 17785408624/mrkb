package com.mrkb.service;

import java.util.HashMap;
import java.util.List;

import com.mrkb.dao.modle.store.StoreBasics;
import com.mrkb.dao.modle.store.StoreGiftRecordEntity;
import com.mrkb.dao.modle.store.UserDuty;

public interface UserDutyService {

	List<UserDuty> findUserDuty(UserDuty userDuty);//用户查询自己的当班情况
	int duty(UserDuty userDuty);//当班
	int giftCourse(int gift_id, int store_id,int user_basics_id,int gift_user_id);//赠送课程，被赠送者能提升会员等级，但其上级没有对应的比例分红
	HashMap<String, Object> storeGiftList(int  user_basics_id,int order_id);//获取用户所购买的课程套餐
	List<StoreBasics> getStoreBasics(int gift_id,int gift_user_id);//通过gift_id,查找套餐包含的课程
	int countDuty(int user_basics_id);//获取该用户已当班课程的数量
	HashMap<String, Object> storeGiftRecordList(int user_basics_id);//历史课程赠送记录
	StoreGiftRecordEntity findStoreGiftRecordById(StoreGiftRecordEntity storeGiftRecordEntity);//查询单个课程赠送记录

}
