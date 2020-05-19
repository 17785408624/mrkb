package com.mrkb.web.controller.sys;

import java.io.File;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.mrkb.common.util.ResponseCode;
import com.mrkb.common.util.ResponseData;
import com.mrkb.dao.modle.news.News;
import com.mrkb.dao.modle.news.NewsEvaluation;
import com.mrkb.dao.modle.user.UserWeixin;
import com.mrkb.service.NewsService;
import com.mrkb.service.UserService;
import com.mrkb.shiro.cookieutil.SessionEntity;


@Controller("admin_news")
@RequestMapping("/admin_news")
public class NewsController {
	@Autowired
	private NewsService newsService;
	@Autowired
	private UserService userService;





	@RequestMapping("news")
	public String bigFoison(HttpServletRequest request,HttpServletResponse response ){
		return "sys/news/news";
	}
	/**
	 * 添加知识动态
	 *
	 * @param request
	 * @param jsonData
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("addNews")
	public @ResponseBody ResponseData addNews(HttpServletResponse response,
											  HttpServletRequest request,
											  @RequestBody News news) {// 添加知识动态
		System.out.println("进入添加知识管理器");
		Long update_date=System.currentTimeMillis();
		Long add_date=update_date;
		ResponseData rs = new ResponseData();
		Integer read_num=0;
		Integer thumbs_up=0;
		news.setUpdate_date(update_date);
		news.setRead_num(read_num);
		news.setThumbs_up(thumbs_up);
		news.setAdd_date(add_date);
		News newss=newsService.addNews(news);
		if(newss!=null){
			rs.setErrorCode(ResponseCode.SUCC_DO.getCode());
			rs.setMessage(ResponseCode.SUCC_DO.getMsg());
		}else{

		}
		rs.setData(newss);
		rs.setIsSuccess(true);
		return rs;
	}
	/**
	 * 修改知识动态
	 *
	 * @param request
	 * @param jsonData
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("updateNews")
	public @ResponseBody ResponseData updateNews(HttpServletResponse response,
												 HttpServletRequest request,
												 @RequestBody Map<String, Object> jsonData) {// 添加知识动态
		System.out.println("进入修改知识管理器");
		Long update_date=System.currentTimeMillis();
		Long add_date=update_date;
		ResponseData rs = new ResponseData();
		String news_title=String.valueOf(jsonData.get("title"));//标题
		Integer news_type=Integer.valueOf(String.valueOf(jsonData.get("news_type")));//类型

		String detail_content=String.valueOf(jsonData.get("detail_content"));//内容
		String news_picture=String.valueOf(jsonData.get("news_picture"));//图片
		News news=new News();
		try {
			Integer news_id=Integer.valueOf(String.valueOf(jsonData.get("news_id")));//编号
			news.setNews_id(news_id);
		} catch (Exception e) {

		}
		try {
			String news_mp3=String.valueOf(jsonData.get("news_mp3"));//音乐链接
			news.setNews_mp3(news_mp3);
		} catch (Exception e) {

		}
		try {
			Double fund_money=Double.valueOf(String.valueOf(jsonData.get("fund_money")));//
			news.setFund_money(fund_money);
		} catch (Exception e) {
			news.setFund_money(0.00);
		}
		if(news_type!=5){
			news.setFund_money(0.00);
		}
		news.setNews_type(news_type);
		news.setNews_title(news_title);
		news.setUpdate_date(update_date);
		news.setDetail_content(detail_content);
		news.setNews_picture(news_picture);
		int newss=newsService.updateNews(news);
		rs.setIsSuccess(true);
		return rs;
	}
	/**
	 * 查看知识动态
	 *
	 * @param request
	 * @param jsonData
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("findNews/{pageNum}/{pageSize}")
	public  ResponseData findNews(HttpServletResponse response,@PathVariable("pageNum") Integer pageNum,
								  @PathVariable("pageSize") Integer pageSize,
								  HttpServletRequest request) {// 查看知识动态
		System.out.println("进入查看知识管理器");
		HashMap<String,Object> map = new HashMap<String,Object>();
		String news_type2=request.getParameter("news_type");

		if(!StringUtil.isEmpty(news_type2)){
			Integer news_type=Integer.valueOf(request.getParameter("news_type"));
			map.put("news_type", news_type);
		}
		String status_state2=request.getParameter("status_state");
		if(!StringUtil.isEmpty(status_state2)){
			Integer status_state=Integer.valueOf(request.getParameter("status_state"));
			map.put("status_state", status_state);
		}
		ResponseData rs = new ResponseData();
		PageHelper.startPage(pageNum, pageSize);
		List<News> news=newsService.findNews(map);
		PageInfo<News> PageInfo = new PageInfo<>(news);
		rs.setData(PageInfo);
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
	@RequestMapping("findNewsOne/{id}")
	public @ResponseBody ResponseData findNewsOne(@PathVariable("id") Integer id) {// 查看知识动态
		System.out.println("进入查看知识管理器");
		Integer news_id = id;//编号
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("news_id", news_id);
		ResponseData rs = new ResponseData();
		News news=newsService.findNewsOne(map);
		if(news!=null){
			rs.setData(news);
			rs.setIsSuccess(true);
			rs.setMessage(ResponseCode.SUCC_DO.getMsg());
		}else{
			rs.setIsSuccess(false);
		}
		return rs;
	}
	/**
	 * 删除知识动态
	 *
	 * @param request
	 * @param jsonData
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("deleteNew/{id}")
	public @ResponseBody ResponseData deleteNew(@PathVariable("id") Integer id,HttpServletRequest request) {// 删除知识动态
		Integer news_id = id;//编号
		HashMap<String,Object> map =new HashMap<String,Object>();
		map.put("news_id", news_id);
		News news=newsService.findNewsOne(map);
		String news_pictures=news.getNews_picture();
		if(news_pictures!=null&&!news_pictures.equals("")){
			String[] news_picture=news_pictures.split(";");
			String basePath=request.getSession().getServletContext().getRealPath("");
			for(int i=0;i<news_picture.length;i++){
				String path=basePath+"/file/store/img/";
				path+=news_picture[i];
				File file=new File(path);
				file.delete();
			}
		}
		ResponseData rs = new ResponseData();
		int dele=newsService.deleteNew(news_id);
		if(dele>0){
			rs.setMessage("删除成功！");
			rs.setIsSuccess(true);
		}else{
			rs.setMessage("删除失败！");
			rs.setIsSuccess(false);
		}
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
												  HttpServletRequest request,
												  @RequestBody Map<String, Object> jsonData) {// 查询精华
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
		rs.setIsSuccess(true);
		return rs;
	}
	/**
	 * 添加精华
	 *
	 * @param request
	 * @param jsonData
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("addEssence")
	public @ResponseBody ResponseData addEssence(HttpServletResponse response,
												 HttpServletRequest request,
												 @RequestBody Map<String, Object> jsonData) {//添加精华
		System.out.println("进入添加精华方法");
		Long time=System.currentTimeMillis();
		HashMap<String,Object> map = new HashMap<String,Object>();
		Integer news_id=Integer.valueOf(String.valueOf(jsonData.get("news_id")));//
		try {
			Integer news_type=Integer.valueOf(String.valueOf(jsonData.get("news_type")));//
		} catch (Exception e) {
			// TODO: handle exception
		}

		int ne =newsService.findEssenceOne(news_id);
		ResponseData rs = new ResponseData();
		if(ne>0){
			rs.setIsSuccess(true);
			return rs;
		}else{
			map.put("news_id", news_id);
			map.put("priority_level", 5);
			map.put("add_date", time);
			int news=newsService.addEssence(map);
			System.out.println("添加的条数：："+news);
			rs.setIsSuccess(true);
			return rs;
		}

	}
	/**
	 * 删除精华
	 *
	 * @param request
	 * @param jsonData
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("deleteEssence")
	public @ResponseBody ResponseData deleteEssence(HttpServletResponse response,
													HttpServletRequest request,
													@RequestBody Map<String, Object> jsonData) {//删除精华
		System.out.println("进入删除精华管理器");
		News news=new News();
		Integer news_id=Integer.valueOf(String.valueOf(jsonData.get("news_id")));
		news.setNews_id(news_id);
		int delete =newsService.deleteEssence(news);
		ResponseData rs = new ResponseData();
		System.out.println("删除成功的条数：："+delete);
		rs.setData(news_id);
		rs.setIsSuccess(true);
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
														HttpServletRequest request,
														@RequestBody Map<String, Object> jsonData) {//添加精华评论
		System.out.println("进入添加精华评论管理器");
		SessionEntity se = null;
		Integer user_basics_id=4;
		Integer news_type=1;
		Integer super_evaluation_id=0;
		Long time=System.currentTimeMillis();
		Integer news_id=Integer.valueOf(String.valueOf(jsonData.get("news_id")));
		try {
			se = new SessionEntity(request);
			user_basics_id=se.getUser_basics_id();
		} catch (SessionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		News news=newsService.findNewsO(news_id);
		news_type=news.getNews_type();

		try {
			super_evaluation_id=Integer.valueOf(String.valueOf(jsonData.get("super_evaluation_id")));
		} catch (NullPointerException e) {
			// TODO: handle exception
		}
		String evaluation_value=String.valueOf(jsonData.get("evaluation_value"));

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
		rs.equals(ne);
		rs.setIsSuccess(true);
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
															HttpServletRequest request,
															@RequestBody Map<String, Object> jsonData) {// 查询精华评论
		System.out.println("进入查看精华评论管理器");
		Integer news_id=Integer.valueOf(String.valueOf(jsonData.get("news_id")));//
		NewsEvaluation nel=new NewsEvaluation();
		nel.setNews_id(news_id);
		ResponseData rs = new ResponseData();
		List<NewsEvaluation> newsEvaluation=newsService.findEssenceEvaluation(nel);
		System.out.println("查询出来的结果：："+newsEvaluation);
		System.out.println("查询出来的结果：："+newsEvaluation.get(0));
		rs.setData(newsEvaluation);
		rs.setIsSuccess(true);
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
														HttpServletRequest request,
														@RequestBody Map<String, Object> jsonData) {//添加视频评论
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
		Integer user_basics_id1=Integer.valueOf(String.valueOf(user_basics_id));
		try {
			news_type=Integer.valueOf(String.valueOf(jsonData.get("news_type")));
		} catch (NullPointerException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try {
			super_evaluation_id=Integer.valueOf(String.valueOf(jsonData.get("super_evaluation_id")));
		} catch (NullPointerException e) {
			// TODO: handle exception
		}
		String evaluation_value=String.valueOf(jsonData.get("evaluation_value"));
		Integer news_id=Integer.valueOf(String.valueOf(jsonData.get("news_id")));
		UserWeixin uv=userService.findUserWeixinUserBasicsId(user_basics_id1);
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
		rs.setIsSuccess(true);
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
														 HttpServletRequest request,
														 @RequestBody Map<String, Object> jsonData) {// 查询视频评论
		System.out.println("进入查询视频评论管理器");
		Integer news_id=Integer.valueOf(String.valueOf(jsonData.get("news_id")));//
		NewsEvaluation nel=new NewsEvaluation();
		nel.setNews_id(news_id);
		ResponseData rs = new ResponseData();
		List<NewsEvaluation> newsEvaluation=newsService.findViewEvaluation(nel);
		rs.setData(newsEvaluation);
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
	@RequestMapping("findNewsId")
	public @ResponseBody ResponseData findNewsId(HttpServletResponse response,
												 HttpServletRequest request,
												 @RequestBody Map<String, Object> jsonData) {
		Integer news_id = Integer.valueOf(String.valueOf(jsonData.get("news_id")));//编号
		ResponseData rs = new ResponseData();
		News news=newsService.findNewsId(news_id);
		rs.setData(news);
		rs.setIsSuccess(true);
		return rs;
	}
	/**
	 *
	 * @Title:             findNewsByState
	 * @Description:     TODO 根据审核状态为0查看知识动态
	 * @param:             @param response
	 * @param:             @param request
	 * @param:             @param jsonData
	 * @param:             @return
	 * @return:         VisitConsequenceParent
	 * @throws
	 */
	@RequestMapping("findNewsByState")
	public @ResponseBody ResponseData findNewsByState(HttpServletResponse response,
													  HttpServletRequest request,
													  @RequestBody Map<String, Object> jsonData) {
		ResponseData rs = new ResponseData();
		News newsEntity  = new News();
		Integer status_state=0;
		newsEntity.setStatus_state(status_state);

		List<News> news=newsService.findNewsByState(newsEntity);
		if(news!=null){
			rs.setData(news);
			rs.setIsSuccess(true);
		}else{
			rs.setIsSuccess(false);
		}
		return rs;
	}
	/**
	 *
	 * @Title:             deleteEssEvaluations
	 * @Description:     TODO 删除首页功能的单条评论
	 * @param:             @param response
	 * @param:             @param request
	 * @param:             @param jsonData
	 * @param:             @return
	 * @return:         VisitConsequenceParent
	 * @throws
	 */
	@RequestMapping("deleteEssEvaluations")
	public @ResponseBody ResponseData deleteEssEvaluations(HttpServletResponse response,
														   HttpServletRequest request,
														   @RequestBody Map<String, Object> jsonData) {
		ResponseData rs = new ResponseData();
		Integer news_evaluation_id = null;//评论新闻id
		try {
			news_evaluation_id  = Integer.valueOf(String.valueOf(jsonData.get("news_evaluation_id")));
		} catch (Exception e) {
			rs.setIsSuccess(false);
		}
		int delete = newsService.deleteNewsEvaluation(news_evaluation_id);
		if(delete>0){
			rs.setIsSuccess(true);

		}else{
			rs.setIsSuccess(false);
		}
		return rs;
	}

	/**
	 *
	 * @Title:             deleteEssEvaluations
	 * @Description:     TODO 删除视频的单条评论
	 * @param:             @param response
	 * @param:             @param request
	 * @param:             @param jsonData
	 * @param:             @return
	 * @return:         VisitConsequenceParent
	 * @throws
	 */
	@RequestMapping("deleteVideoEvaluations")
	public @ResponseBody ResponseData deleteVideoEvaluations(HttpServletResponse response,
															 HttpServletRequest request,
															 @RequestBody Map<String, Object> jsonData) {
		ResponseData rs = new ResponseData();
		Integer news_evaluation_id = null;//评论新闻id
		try {
			news_evaluation_id  = Integer.valueOf(String.valueOf(jsonData.get("news_evaluation_id")));
		} catch (Exception e) {
			rs.setIsSuccess(false);
			e.printStackTrace();
		}
		int delete = newsService.deleteVideoEvaluation(news_evaluation_id);
		if(delete>0){
			rs.setIsSuccess(true);

		}else{
			rs.setIsSuccess(false);
		}
		return rs;
	}

	/**
	 *关联表删除首页功能news信息
	 *
	 * @param request
	 * @param jsonData
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("deleteNews")
	public @ResponseBody ResponseData deleteNews(HttpServletResponse response,
												 HttpServletRequest request,
												 @RequestBody Map<String, Object> jsonData) {// 查看知识动态
		ResponseData rs = new ResponseData();
		Integer news_id = Integer.valueOf(String.valueOf(jsonData.get("news_id")));//获取编号
		HashMap<String,Object> map =new HashMap<String,Object>();
		map.put("news_id", news_id);
		News news=newsService.findNewsOne(map);//获取该news_id信息
		if(news != null){
			String news_pictures=news.getNews_picture();//获取该news_id对应图片
			String[] news_picture=news_pictures.split(";");
			String basePath=request.getSession().getServletContext().getRealPath("");
			for(int i=0;i<news_picture.length;i++){
				String path=basePath+"/file/store/img/";
				path+=news_picture[i];
				File file=new File(path);
				file.delete();//执行图片删除
			}
		}
		int delete=newsService.deleteNews(news_id);//关联表删除首页功能news信息，成功则返回1
		if(delete>0){
			rs.setIsSuccess(true);
		}else{
			rs.setIsSuccess(false);
		}
		return rs;
	}

}
