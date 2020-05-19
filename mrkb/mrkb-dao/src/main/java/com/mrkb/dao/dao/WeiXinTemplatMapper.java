package com.mrkb.dao.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface WeiXinTemplatMapper {
	/**
	 * 
	 * @param map 
	 * @return
	 */
	List<HashMap<String, Object>> AllUsers(HashMap<String,Object> map);
	int AddConten(HashMap<String,Object> map);
	HashMap<String, Object> SelectArticle(HashMap<String,Object> map);
	List<HashMap<String, Object>> SelectArticleList(HashMap<String,Object> map);
	List<HashMap<String, Object>> AutoReturn(HashMap<String,Object> map);

	int DeleteConten(HashMap<String,Object> map);
	List<HashMap<String, Object>> TopSelectArticleList(HashMap<String,Object> map);
	
	int updateConten(HashMap<String,Object> map);
	HashMap<String, Object> picture_add_json(HashMap<String,Object> map);
	
	HashMap<String, Object> function_updata(HashMap<String,Object> map);
	
	List<HashMap<String, Object>> Products_List(HashMap<String,Object> map);
	
	int DeleteStoreid(HashMap<String,Object> map);
	
	HashMap<String, Object> Products_one(HashMap<String,Object> map);
	List<HashMap<String, Object>> pageSize_List_json(HashMap<String,Object> map);
	
	
}
