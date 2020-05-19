package com.mrkb.dao.modle.core;

import java.util.List;
import java.util.Map;

import com.mrkb.dao.modle.user.UserGrade;


public class UserUpgrade {
private int conclude;//是否达到升级条件（1为以达成，2为未满足）
private List<Map<String,Object>>accomplishList;//已达成的升级条件
private List<Map<String,Object>>unrealizedList;//未达成的升级条件
private UserGrade userGrade;//当前等级信息
private UserGrade nextUserGrade;//下一集的等级信息

public int getConclude() {
	return conclude;
}

public void setConclude(int conclude) {
	this.conclude = conclude;
}

public List<Map<String, Object>> getAccomplishList() {
	return accomplishList;
}

public void setAccomplishList(List<Map<String, Object>> accomplishList) {
	this.accomplishList = accomplishList;
}

public List<Map<String, Object>> getUnrealizedList() {
	return unrealizedList;
}

public void setUnrealizedList(List<Map<String, Object>> unrealizedList) {
	this.unrealizedList = unrealizedList;
}

public UserGrade getUserGrade() {
	return userGrade;
}

public void setUserGrade(UserGrade userGrade) {
	this.userGrade = userGrade;
}

public UserGrade getNextUserGrade() {
	return nextUserGrade;
}

public void setNextUserGrade(UserGrade nextUserGrade) {
	this.nextUserGrade = nextUserGrade;
}

public UserUpgrade(int conclude, List<Map<String, Object>> accomplishList,
		List<Map<String, Object>> unrealizedList) {
	super();
	this.conclude = conclude;
	this.accomplishList = accomplishList;
	this.unrealizedList = unrealizedList;
}




}
