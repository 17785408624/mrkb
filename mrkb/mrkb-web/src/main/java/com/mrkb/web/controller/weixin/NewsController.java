package com.mrkb.web.controller.weixin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.session.SessionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.StringUtil;
import com.mrkb.common.util.ResponseData;
import com.mrkb.dao.modle.news.News;
import com.mrkb.dao.modle.news.NewsEvaluation;
import com.mrkb.dao.modle.user.UserWeixin;
import com.mrkb.service.NewsService;
import com.mrkb.service.UserService;
import com.mrkb.shiro.cookieutil.SessionEntity;


@Controller("weixin/weixin_news")
@RequestMapping("/weixin/weixin_news")
public class NewsController {
	@Autowired
	private NewsService newsService;
	@Autowired
	private UserService userService;
	@RequestMapping("toAddnews")
	public String toAddnews(HttpServletResponse response,HttpServletRequest request) {
		
			return "admin/news/addnewsknow";
		
	}
	
	
	/**
	 * 查看知识动态
	 * 
	 * @param request
	 * @param jsonData
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("findNews")
	@ResponseBody
	public ResponseData findNews(HttpServletRequest request) {// 查看知识动态
			Integer news_id =0;
			String news_idstr=request.getParameter("news_id");
			if(StringUtil.isNotEmpty(news_idstr)){
				news_id = Integer.valueOf(news_idstr);
			}
			HashMap<String,Object> map = new HashMap<String,Object>();
			Integer news_type=0;
			String news_typestr=request.getParameter("news_type");
			if(StringUtil.isNotEmpty(news_typestr)){
				news_type=Integer.valueOf(news_typestr);
			}
			map.put("news_type", news_type);
			ResponseData rs = new ResponseData();
		    List<News> news=newsService.findNews(map);
		    rs.setData(news);
		    rs.setIsSuccess(true);
			return rs;
	}
	
	/**
	 * 查看单个知识动态
	 * 
	 * @param request
	 * @param jsonData
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("findNewsOne")
	@ResponseBody
	public ResponseData findNewsOne(HttpServletResponse response,HttpServletRequest request) {// 查看知识动态

		    Integer news_type=0;

			HashMap<String,Object> map = new HashMap<String,Object>();
			try {
				Integer news_id = Integer.valueOf(request.getParameter("news_id"));//编号
				map.put("news_id", news_id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			try {
				news_type=Integer.valueOf(request.getParameter("news_type"));//
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			if(news_type!=0){
				map.put("news_type", news_type);
			}
			
			ResponseData rs = new ResponseData();
		    News news=newsService.findNewsOne(map);
		    rs.setData(news);
		    rs.setIsSuccess(true);
			return rs;
	}
	/**
	 * 浏览知识动态视频
	 * 
	 * @param request
	 * @param jsonData
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("browseNum")
	public @ResponseBody ResponseData browseNum(HttpServletResponse response,
			HttpServletRequest request) {// 浏览知识动态
		    System.out.println("进入浏览知识动态页面");
			HashMap<String,Object> map = new HashMap<String,Object>();
			Integer news_id=Integer.valueOf(request.getParameter("news_id"));//
			Integer news_type=Integer.valueOf(request.getParameter("news_type"));//
			map.put("news_id", news_id);
			map.put("news_type", news_type);
			ResponseData rs = new ResponseData();
		    int news=newsService.readNews(map);
		    System.out.println("查询出来的结果：："+news);
		    rs.setData(news);
		    rs.setIsSuccess(true);
			return rs;
	}
	/**
	 * 点赞
	 * 
	 * @param request
	 * @param jsonData
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("thumbsUp")
	public @ResponseBody ResponseData thumbsUp(HttpServletResponse response,
			HttpServletRequest request) {// 浏览知识动态
		    System.out.println("进入点赞页面");
			HashMap<String,Object> map = new HashMap<String,Object>();
			Integer news_id=Integer.valueOf(request.getParameter("news_id"));//
			Integer news_type=Integer.valueOf(request.getParameter("news_type"));//
			map.put("news_id", news_id);
			map.put("news_type", news_type);
			ResponseData rs = new ResponseData();
		    int news=newsService.thumbsNews(map);
		    System.out.println("查询出来的结果：："+news);
		    rs.setData(news);
			return rs;
	}
	/**
	 * 查询精华
	 * 
	 * @param request
	 * @param jsonData
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("findEssence")
	public @ResponseBody ResponseData findEssence(HttpServletResponse response,
			HttpServletRequest request) {// 查询精华
		    System.out.println("进入查询精华方法");
		    List<HashMap<String,Object>> listEssence=newsService.findAllEssence();
		    List<Integer> list=new ArrayList<>();
		    for(int i=0;i<listEssence.size();i++){
		    	Integer news_id=Integer.valueOf(String.valueOf(listEssence.get(i).get("news_id")));
		    	list.add(news_id);
		    }
		    List<News> listNews=newsService.findEssence(list);
		    ResponseData rs = new ResponseData();
		    System.out.println("查询出来的结果：："+listNews);
		    rs.setData(listNews);
			return rs;
	}
	/**
	 * 添加精华评论
	 * 
	 * @param request
	 * @param jsonData
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("addEssenceEvaluation")
	public @ResponseBody ResponseData addNewsEvaluation(HttpServletResponse response,
			HttpServletRequest request) {//添加精华评论
		    System.out.println("进入添加精华评论管理器");
		    SessionEntity se = null;
		    Integer user_basics_id=4;
		    Integer news_type=1;
		    Integer super_evaluation_id=0;
		    Long time=System.currentTimeMillis();
			try {
				se = new SessionEntity(request);
				user_basics_id=se.getUser_basics_id();
			} catch (SessionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				news_type=Integer.valueOf(request.getParameter("news_type"));
			} catch (NullPointerException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			try {
				super_evaluation_id=Integer.valueOf(request.getParameter("super_evaluation_id"));
			} catch (NullPointerException e) {
				// TODO: handle exception
			}
			String evaluation_value=String.valueOf(request.getParameter("evaluation_value"));
			Integer news_id=Integer.valueOf(request.getParameter("news_id"));
			UserWeixin uv=userService.findUserWeixinUserBasicsId(user_basics_id);
			String weixin_nickname=uv.getWeixin_nickname();
			String weixin_portrait=uv.getWeixin_portrait();
			NewsEvaluation nen=new NewsEvaluation();
			nen.setNews_id(news_id);
			nen.setNews_type(news_type);
			nen.setWeixin_nickname(weixin_nickname);
			nen.setWeixin_portrait(weixin_portrait);
			nen.setAdd_date(time);
			nen.setEvaluation_value(evaluation_value);
			nen.setSuper_evaluation_id(super_evaluation_id);
			nen.setRead_num(0);
			nen.setUser_basics_id(user_basics_id);
			NewsEvaluation ne=newsService.addEssenceEvaluation(nen);
			ResponseData rs = new ResponseData();
		    System.out.println("成功添加：："+ne);
		    rs.setData(ne);
			return rs;
	}
	/**
	 * 查询精华评论
	 * 
	 * @param request
	 * @param jsonData
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("findEssenceEvaluation")
	public @ResponseBody ResponseData findEssenceEvaluation(HttpServletResponse response,
		HttpServletRequest request) {// 查询精华评论
		System.out.println("进入查看精华评论管理器");
		Integer news_id=Integer.valueOf(request.getParameter("news_id"));//
		NewsEvaluation nel=new NewsEvaluation();
		nel.setNews_id(news_id);
		ResponseData rs = new ResponseData();
		List<NewsEvaluation> newsEvaluation=newsService.findEssenceEvaluation(nel);
		System.out.println("查询出来的结果：："+newsEvaluation);
		rs.setData(newsEvaluation);
		return rs;
	}
	/**
	 * 添加视频评论
	 * 
	 * @param request
	 * @param jsonData
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("addViewEvaluation")
	public @ResponseBody ResponseData addViewEvaluation(HttpServletResponse response,
			HttpServletRequest request) {//添加视频评论
		    System.out.println("进入添加精华评论管理器");
		    SessionEntity se = null;
		    Integer user_basics_id=0;
		    Integer news_type=1;
		    Integer super_evaluation_id=0;
		    Long time=System.currentTimeMillis();
			try {
				se = new SessionEntity(request);
				user_basics_id=se.getUser_basics_id();
			} catch (SessionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				news_type=Integer.valueOf(request.getParameter("news_type"));
			} catch (NullPointerException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			try {
				super_evaluation_id=Integer.valueOf(request.getParameter("super_evaluation_id"));
			} catch (NullPointerException e) {
				// TODO: handle exception
			}
			String evaluation_value=String.valueOf(request.getParameter("evaluation_value"));
			Integer news_id=Integer.valueOf(request.getParameter("news_id"));
			UserWeixin uv=userService.findUserWeixinUserBasicsId(user_basics_id);
			String weixin_nickname=uv.getWeixin_nickname();
			String weixin_portrait=uv.getWeixin_portrait();
			NewsEvaluation nen=new NewsEvaluation();
			nen.setNews_id(news_id);
			nen.setNews_type(news_type);
			nen.setWeixin_nickname(weixin_nickname);
			nen.setWeixin_portrait(weixin_portrait);
			nen.setAdd_date(time);
			nen.setEvaluation_value(evaluation_value);
			nen.setSuper_evaluation_id(super_evaluation_id);
			nen.setRead_num(0);
			nen.setUser_basics_id(user_basics_id);
			NewsEvaluation ne=newsService.addViewEvaluation(nen);
			ResponseData rs = new ResponseData();
		    System.out.println("成功添加：："+ne);
		    rs.setData(ne);
			return rs;
	}
	/**
	 * 查询视频评论
	 * 
	 * @param request
	 * @param jsonData
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("findViewEvaluation")
	public @ResponseBody ResponseData findViewEvaluation(HttpServletResponse response,
		HttpServletRequest request) {// 查询视频评论
		System.out.println("进入查询视频评论管理器");
		Integer news_id=Integer.valueOf(request.getParameter("news_id"));//
		NewsEvaluation nel=new NewsEvaluation();
		nel.setNews_id(news_id);
		ResponseData rs = new ResponseData();
		List<NewsEvaluation> newsEvaluation=newsService.findViewEvaluation(nel);
		rs.setData(newsEvaluation);
		rs.setData(newsEvaluation);
		return rs;
	}
	
	
	
	/**
	 * 根据ID查询首页轮播图详细
	 */
	@ResponseBody
	@RequestMapping("/findIndexDetailStoreById/{news_id}")
	public ResponseData findIndexDetailStoreById(@PathVariable("news_id") Integer news_id){
		ResponseData R = new ResponseData();
		Map<String, Object> map = new HashMap<String, Object>();
		map = newsService.findIndexDetailStoreById(news_id);
		R.setData(map);
		return R;
	}
}
