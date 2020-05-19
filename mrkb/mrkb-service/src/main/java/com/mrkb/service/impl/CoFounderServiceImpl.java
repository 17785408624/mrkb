package com.mrkb.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrkb.dao.dao.CoFounderMonSaleMapper;
import com.mrkb.dao.dao.UserRecommendMapper;
import com.mrkb.dao.modle.company.CoFounderMonSale;
import com.mrkb.service.CoFounderService;


@Service
@Transactional(rollbackFor = Exception.class)
public class CoFounderServiceImpl implements CoFounderService{
	@Resource
	private CoFounderMonSaleMapper coFounderMonSaleMapper;
	@Resource
	private UserRecommendMapper userRecommendMapper;
	
	@Override
	public List<CoFounderMonSale> findCompanyCo(HashMap<String, Object> map) {
		return coFounderMonSaleMapper.findCompanyCo(map);
	}

	@Override
	public Map<String, List<CoFounderMonSale>> find2SubordinateCo(int series,
			int user_basics_id,String month_date) {
		Map<String, List<CoFounderMonSale>> map=
				new HashMap<String, List<CoFounderMonSale>>();//包含查询的下级所有信息
		for(int i =0;i<series;i++){
			List<CoFounderMonSale> list = null;//下级信息集合
			int []user_basics_ids = null;//推荐人id数组;
			if(i==0){//第一次循环
				List<CoFounderMonSale> listUserRecommendone=coFounderMonSaleMapper.
						find2SubordinateCoOne(user_basics_id,month_date);//根据推荐人id查询出
				map.put(String.valueOf(0), listUserRecommendone);//将查询出的下级添加进 包含查询下级的所有信息的map对象中
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
			List<CoFounderMonSale> listUserRecommend=new ArrayList<CoFounderMonSale>();
			if(user_basics_ids!=null){//推荐人id组不为空
				
				listUserRecommend=coFounderMonSaleMapper.
						find2SubordinateCo(user_basics_ids,month_date);//根据推荐人id查询出
				
			}
			map.put(String.valueOf(i+1), listUserRecommend);//将查询出的下级添加进 包含查询下级的所有信息的map对象中
		}
		return map;
	}

}
