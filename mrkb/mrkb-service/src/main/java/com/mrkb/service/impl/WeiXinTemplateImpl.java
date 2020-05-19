package com.mrkb.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrkb.dao.dao.WeiXinTemplatMapper;
import com.mrkb.service.WeiXinTemplateService;
@Service("weiXinTemplateImpl")
public class WeiXinTemplateImpl implements WeiXinTemplateService {

	@Autowired
	private WeiXinTemplatMapper WeiXinTemplatMapper;
	
	
	@Override
	public List<HashMap<String, Object>> AllUsers(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return WeiXinTemplatMapper.AllUsers(map);
	}


	@Override
	public int AddConten(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return WeiXinTemplatMapper.AddConten(map);
	}


	@Override
	public HashMap<String, Object> SelectArticle(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return WeiXinTemplatMapper.SelectArticle(map);
	}


	@Override
	public List<HashMap<String, Object>> SelectArticleList(
			HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return WeiXinTemplatMapper.SelectArticleList(map);
	}


	@Override
	public int DeleteConten(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return WeiXinTemplatMapper.DeleteConten(map);
	}


	@Override
	public List<HashMap<String, Object>> TopSelectArticleList(
			HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return WeiXinTemplatMapper.TopSelectArticleList(map);
	}


	@Override
	public int updateConten(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return WeiXinTemplatMapper.updateConten(map);
	}


	@Override
	public HashMap<String, Object> picture_add_json(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return WeiXinTemplatMapper.picture_add_json(map);
	}


	@Override
	public List<HashMap<String, Object>> Products_List(
			HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return WeiXinTemplatMapper.Products_List(map);
	}


	@Override
	public List<HashMap<String, Object>> AutoReturn(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return WeiXinTemplatMapper.AutoReturn(map);
	}


	@Override
	public int DeleteStoreid(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return WeiXinTemplatMapper.DeleteStoreid(map);
	}


	@Override
	public HashMap<String, Object> Products_one(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return WeiXinTemplatMapper.Products_one(map);
	}


	@Override
	public HashMap<String, Object> function_updata(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return WeiXinTemplatMapper.function_updata(map);
	}


	@Override
	public List<HashMap<String, Object>> pageSize_List_json(
			HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return WeiXinTemplatMapper.pageSize_List_json(map);
	}


	

}
