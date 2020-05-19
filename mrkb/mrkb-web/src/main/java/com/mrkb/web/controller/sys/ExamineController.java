package com.mrkb.web.controller.sys;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mrkb.common.util.ResponseCode;
import com.mrkb.common.util.ResponseData;
import com.mrkb.dao.modle.news.News;
import com.mrkb.dao.modle.news.NewsEvaluation;
import com.mrkb.dao.modle.protocol.ProtocolEntity;
import com.mrkb.dao.modle.store.StoreBasics;
import com.mrkb.dao.modle.store.StoreEvaluation;
import com.mrkb.service.NewsService;
import com.mrkb.service.ProtocolService;
import com.mrkb.service.StoreService;

/**
 * 
 * @author ly 审核管理controller
 */
@Controller
@RequestMapping("/examine")
public class ExamineController {
	@Autowired
	private StoreService storeService;

	@Autowired
	private NewsService newsService;
	@Autowired
	 private ProtocolService protocolService;
	/**
	 * 
	 * 商品审核跳转页面
	 * 
	 * @return 跳转至 /examine/storeExamineManage.html
	 */
	@RequestMapping("/storeExamineManage")
	public String toStoreList() {
		return "sys/examine/storeExamineManage";
	}

	/*
	 * 删除商品信息
	 */
	@ResponseBody
	@RequestMapping("/deleteStore/{id}")
	public ResponseData deleteStore(@PathVariable("id") Integer id, HttpServletRequest request) {
		ResponseData R = new ResponseData();
		StoreBasics sbs = new StoreBasics();
		sbs.setStore_id(id);
		StoreBasics sb = storeService.findStoreBasics(sbs);// 鑾峰彇褰撳墠鍟嗗搧鐨勪俊鎭�
		String pictures = sb.getStore_picture();
		if(pictures!=null){
			String[] picturess = pictures.split(";");
			String pathRoot = "C:/file";//图片保存根路径
			for (int i = 0; i < picturess.length; i++) {
				String path = pathRoot;//鍥剧墖缁濆璺緞
				path += picturess[i];
				File file = new File(path);
				file.delete();
			}
		}
		Integer num = storeService.deleteStores(id);// 物理删除该商品
		if (num > 0) {
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setMessage(ResponseCode.SUCC_DO.getMsg());
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		return R;
	}

	/**
	 * 查询审核商品 status_state =1的商品
	 */
	/**
	 * 商品管理列表信息展示
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @param name
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/storeList/{pageNum}/{pageSize}")
	public ResponseData storeList(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize,
			HttpServletRequest req) {
		ResponseData R = new ResponseData();
		StoreBasics storeBasics = new StoreBasics();
		storeBasics.setStatus_state(1);
		/* 鑾峰彇鍓嶆store_name鍙傛暟 */
		String storeName = req.getParameter("name");
		// System.out.println("鎵撳嵃鍟嗗搧鍚嶇О"+storeName);
		storeBasics.setStore_name(storeName);
		PageHelper.startPage(pageNum, pageSize);
		List<StoreBasics> storeList = storeService.findStoreByState(storeBasics);
		PageInfo<StoreBasics> PageInfo = new PageInfo<>(storeList);
		R.setErrorCode(ResponseCode.SUCC_DO.getCode());
		R.setMessage(ResponseCode.SUCC_DO.getMsg());
		R.setData(PageInfo);
		return R;
	}

	/*
	 * 审核商品信息
	 */
	@ResponseBody
	@RequestMapping("/examineStore/{id}/{state}")
	public ResponseData examineStore(@PathVariable("id") Integer id, @PathVariable("state") Integer state,
			HttpServletRequest request) {
		ResponseData R = new ResponseData();
		StoreBasics sbs = new StoreBasics();
		sbs.setStore_id(id);
		sbs.setStatus_state(state);
		Integer num = storeService.updateStoreByStatus(sbs);
		if (num > 0) {
			if (state == 0) {
				R.setErrorCode(ResponseCode.SUCC_DO.getCode());
				R.setMessage("审核通过");
			} else if (state == 2) {
				R.setErrorCode(ResponseCode.SUCC_DO.getCode());
				R.setMessage("审核不通过");
			}
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		return R;
	}

	/**
	 * 
	 * 首页审核跳转页面
	 * 
	 * @return 跳转至 /examine/storeExamineManage.html
	 */
	@RequestMapping("/newsExamineManage")
	public String toSNewsList() {
		return "sys/examine/newsExamineManage";
	}

	/*
	 * 删除首页功能（1 知识，2 动态，3 基金，4 视频 5 基金视频）信息
	 */
	@ResponseBody
	@RequestMapping("/deleteNews/{id}")
	public ResponseData deleteNews(@PathVariable("id") Integer id, HttpServletRequest request) {
		ResponseData R = new ResponseData();
		News news = newsService.findNewsId(id);// 鑾峰彇褰撳墠鍟嗗搧鐨勪俊鎭�
		String pictures = news.getNews_picture();
		String[] picturess = pictures.split(";");
		String pathRoot = "C:/file";// 图片保存根路径
		for (int i = 0; i < picturess.length; i++) {
			String path = pathRoot;
			path += picturess[i]; // 获取图片存放全路径
			File file = new File(path);
			file.delete();
		}
		Integer num = newsService.deleteNews(id);
		if (num > 0) {
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setMessage(ResponseCode.SUCC_DO.getMsg());
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		return R;
	}

	/**
	 * 查询审核首页功能status_state =1的首页信息
	 */
	/**
	 * 首页功能列表信息展示
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @param name
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/newsList/{pageNum}/{pageSize}")
	public ResponseData newsList(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize,
			HttpServletRequest req) {
		ResponseData R = new ResponseData();
		News news = new News();
		news.setStatus_state(1);

		PageHelper.startPage(pageNum, pageSize);
		List<News> newsList = newsService.findNewsByState(news);
		if (newsList != null && newsList.size() > 0) {
			PageInfo<News> PageInfo = new PageInfo<>(newsList);
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setMessage(ResponseCode.SUCC_DO.getMsg());
			R.setData(PageInfo);
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		return R;

	}

	/*
	 * 审核首页功能信息
	 */
	@ResponseBody
	@RequestMapping("/examineNews/{id}/{state}")
	public ResponseData examineNews(@PathVariable("id") Integer id, @PathVariable("state") Integer state,
			HttpServletRequest request) {
		ResponseData R = new ResponseData();
		News news = new News();
		news.setNews_id(id);
		news.setStatus_state(state);
		Integer num = newsService.updateViewstate(news);
		if (num > 0) {
			if (state == 0) {
				R.setErrorCode(ResponseCode.SUCC_DO.getCode());
				R.setMessage("审核通过");
			} else if (state == 2) {
				R.setErrorCode(ResponseCode.SUCC_DO.getCode());
				R.setMessage("审核不通过");
			}
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		return R;
	}
	
	/**
	 * 
	 * 协议跳转页面
	 * 
	 * @return 跳转至 /examine/protocolExamineManage.html
	 */
	@RequestMapping("/protocolExamineManage")
	public String toProtocolList() {
		return "sys/examine/protocolExamineManage";
	}

	/*
	 * 删除协议信息
	 */
	@ResponseBody
	@RequestMapping("/deleteProtocols/{id}")
	public ResponseData deleteProtocol(@PathVariable("id") Integer id,HttpServletRequest request){
		ResponseData R = new ResponseData();
		ProtocolEntity pEntity = new ProtocolEntity();
		pEntity.setProtocol_id(id);
		int num = protocolService.deleteProtocols(pEntity);//删除协议
		if(num>0){
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setMessage(ResponseCode.SUCC_DO.getMsg());
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		return R;
	}

	/**
	 * 查询审核首页功能status_state =1的首页信息
	 */
	/**
	 * 协议管理列表信息展示
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @param name
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/protocolList/{pageNum}/{pageSize}")
	public ResponseData protocolList(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize,
			HttpServletRequest req) {
		ResponseData R = new ResponseData();
		ProtocolEntity pEntity = new ProtocolEntity();
		pEntity.setStatus_state(1);
		String protocol_title = req.getParameter("name");//根据协议标题查询数据
		pEntity.setProtocol_title(protocol_title);
		PageHelper.startPage(pageNum, pageSize);
		List<ProtocolEntity> protocolList = protocolService.findAllProtocol(pEntity);//查询协议列表
		PageInfo<ProtocolEntity> PageInfo = new PageInfo<>(protocolList);
		R.setErrorCode(ResponseCode.SUCC_DO.getCode());
		R.setMessage(ResponseCode.SUCC_DO.getMsg());
		R.setData(PageInfo);
		return R;
	}
	/*
	 * 审核首页功能信息
	 */
	@ResponseBody
	@RequestMapping("/examineProtocol/{id}/{state}")
	public ResponseData examineProtocol(@PathVariable("id") Integer id, @PathVariable("state") Integer state,
			HttpServletRequest request) {
		ResponseData R = new ResponseData();
		ProtocolEntity protocolEntity  = new ProtocolEntity();
		protocolEntity.setProtocol_id(id);
		protocolEntity.setStatus_state(state);
		Integer num = protocolService.updateProtocolState(protocolEntity);
		if (num > 0) {
			if (state == 0) {
				R.setErrorCode(ResponseCode.SUCC_DO.getCode());
				R.setMessage("审核通过");
			} else if (state == 2) {
				R.setErrorCode(ResponseCode.SUCC_DO.getCode());
				R.setMessage("审核不通过");
			}
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		return R;
	}
	/**
	 * 
	 * 首页知识审核跳转页面
	 * 
	 * @return 跳转至 /examine/newsEvaluationExamineManage.html
	 */
	@RequestMapping("/newsEvaluationExamineManage")
	public String toNewsEvaluationList() {
		return "sys/examine/newsEvaluationExamineManage";
	}
	
	/*
	 * 删除首页知识评论功能（1 知识，2 动态，3 基金，4 视频 5 基金视频）信息
	 */
	@ResponseBody
	@RequestMapping("/deleteNewsEvaluation/{id}")
	public ResponseData deleteNewsEvaluation(@PathVariable("id") Integer id, HttpServletRequest request) {
		ResponseData R = new ResponseData();
		
		Integer num = newsService.deleteNewsEvaluation(id);
		if (num > 0) {
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setMessage(ResponseCode.SUCC_DO.getMsg());
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		return R;
	}

	/**
	 * 查询审核首页评论功能status_state =1的首页信息
	 */
	/**
	 * 首页功能评论列表信息展示
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @param name
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/newsEvaluationList/{pageNum}/{pageSize}")
	public ResponseData newsEvaluationList(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize,
			HttpServletRequest req) {
		ResponseData R = new ResponseData();
		NewsEvaluation news = new NewsEvaluation();
		news.setStatus_state(1);

		PageHelper.startPage(pageNum, pageSize);
		List<NewsEvaluation> newsList = newsService.findEssEvaluations(news);
		if (newsList != null && newsList.size() > 0) {
			PageInfo<NewsEvaluation> PageInfo = new PageInfo<>(newsList);
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setMessage(ResponseCode.SUCC_DO.getMsg());
			R.setData(PageInfo);
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		return R;

	}
	/**
	 * 
	 * @Title:             getByNewsEvaluationId
	 * @Description:     TODO 查询知识评论
	 * @param:             @param id
	 * @param:             @return   R
	 * @return:            
	 * @throws
	 */
	
	@RequestMapping("getByNewsEvaluationId/{id}")
	public @ResponseBody ResponseData getByNewsEvaluationId(@PathVariable("id") Integer id){
	    ProtocolEntity  pEntity  =new ProtocolEntity();
	    ResponseData R = new ResponseData();
	    NewsEvaluation news = new NewsEvaluation();
	    news.setNews_evaluation_id(id);
		NewsEvaluation newsEvaluation  = newsService.findNewsEvaluationById(news);
		if (newsEvaluation != null) {
			R.setData(newsEvaluation);
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setErrorCode(ResponseCode.SUCC_DO.getMsg());
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		return R;
	}

	/*
	 * 审核首页知识评论功能信息
	 */
	@ResponseBody
	@RequestMapping("/examineNewsEvaluation/{id}/{state}")
	public ResponseData examineNewsEvaluation(@PathVariable("id") Integer id, @PathVariable("state") Integer state,
			HttpServletRequest request) {
		ResponseData R = new ResponseData();
		NewsEvaluation news = new NewsEvaluation();
		news.setNews_evaluation_id(id);;
		news.setStatus_state(state);
		Integer num = newsService.updateNewsEvaluationByState(news);
		if (num > 0) {
			if (state == 0) {
				R.setErrorCode(ResponseCode.SUCC_DO.getCode());
				R.setMessage("审核通过");
			} else if (state == 2) {
				R.setErrorCode(ResponseCode.SUCC_DO.getCode());
				R.setMessage("审核不通过");
			}
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		return R;
	}
	/**
	 * 
	 * 首页视频审核跳转页面
	 * 
	 * @return 跳转至 /examine/videoEvaluationExamineManage.html
	 */
	@RequestMapping("/videoEvaluationExamineManage")
	public String toVideoEvaluationList() {
		return "sys/examine/videoEvaluationExamineManage";
	}
	
	/*
	 * 删除首页视频评论功能（1 知识，2 动态，3 基金，4 视频 5 基金视频）信息
	 */
	@ResponseBody
	@RequestMapping("/deleteVideoEvaluation/{id}")
	public ResponseData deleteVideoEvaluation(@PathVariable("id") Integer id, HttpServletRequest request) {
		ResponseData R = new ResponseData();
		
		Integer num = newsService.deleteVideoEvaluation(id);
		if (num > 0) {
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setMessage(ResponseCode.SUCC_DO.getMsg());
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		return R;
	}

	/**
	 * 查询审核视频评论功能status_state =1的首页信息
	 */
	/**
	 * 首页功能视频评论列表信息展示
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @param name
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/videoEvaluationList/{pageNum}/{pageSize}")
	public ResponseData videoEvaluationList(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize,
			HttpServletRequest req) {
		ResponseData R = new ResponseData();
		HashMap<String, Object> map  = new HashMap<String, Object>();
		map.put("status_state",1);
		PageHelper.startPage(pageNum, pageSize);
		List<NewsEvaluation> newsList = newsService.findNewsState(map);
		if (newsList != null && newsList.size() > 0) {
			PageInfo<NewsEvaluation> PageInfo = new PageInfo<>(newsList);
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setMessage(ResponseCode.SUCC_DO.getMsg());
			R.setData(PageInfo);
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		return R;

	}
	/**
	 * 
	 * @Title:             getByVideoEvaluationId
	 * @Description:     TODO 查询视频评论
	 * @param:             @param id
	 * @param:             @return   R
	 * @return:            
	 * @throws
	 */
	
	@RequestMapping("getByVideoEvaluationId/{id}")
	public @ResponseBody ResponseData getByVideoEvaluationId(@PathVariable("id") Integer id){
	    ProtocolEntity  pEntity  =new ProtocolEntity();
	    ResponseData R = new ResponseData();
	    NewsEvaluation news = new NewsEvaluation();
	    news.setNews_evaluation_id(id);
		NewsEvaluation newsEvaluation  = newsService.findVideoEvaluationById(news);
		if (newsEvaluation != null) {
			R.setData(newsEvaluation);
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setErrorCode(ResponseCode.SUCC_DO.getMsg());
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		return R;
	}

	/*
	 * 审核首页视频评论功能信息
	 */
	@ResponseBody
	@RequestMapping("/examineVideoEvaluation/{id}/{state}")
	public ResponseData examineVideoEvaluation(@PathVariable("id") Integer id, @PathVariable("state") Integer state,
			HttpServletRequest request) {
		ResponseData R = new ResponseData();
		NewsEvaluation news = new NewsEvaluation();
		news.setNews_evaluation_id(id);;
		news.setStatus_state(state);
		Integer num = newsService.updateVideostate(news);
		if (num > 0) {
			if (state == 0) {
				R.setErrorCode(ResponseCode.SUCC_DO.getCode());
				R.setMessage("审核通过");
			} else if (state == 2) {
				R.setErrorCode(ResponseCode.SUCC_DO.getCode());
				R.setMessage("审核不通过");
			}
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		return R;
	}
	/**
	 * 
	 * 商品评论审核跳转页面
	 * 
	 * @return 跳转至 /examine/storeEvaluationExamineManage.html
	 */
	@RequestMapping("/storeEvaluationExamineManage")
	public String toStoreEvaluationList() {
		return "sys/examine/storeEvaluationExamineManage";
	}
	
	/*
	 * 删除商品视频评论功能（1 知识，2 动态，3 基金，4 视频 5 基金视频）信息
	 */
	@ResponseBody
	@RequestMapping("/deleteStoreEvaluation/{id}")
	public ResponseData deleteStoreEvaluation(@PathVariable("id") Integer id, HttpServletRequest request) {
		ResponseData R = new ResponseData();
		StoreEvaluation storeEvaluation  =  new StoreEvaluation();
		storeEvaluation.setEvaluation_id(id);
		Integer num = storeService.deleteStoreEvaluationById(storeEvaluation);
		if (num > 0) {
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setMessage(ResponseCode.SUCC_DO.getMsg());
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		return R;
	}

	/**
	 * 查询审核商品评论功能status_state =1的首页信息
	 */
	/**
	 * 商品视频评论列表信息展示
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @param name
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/storeEvaluationList/{pageNum}/{pageSize}")
	public ResponseData storeEvaluationList(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize,
			HttpServletRequest req) {
		ResponseData R = new ResponseData();
		HashMap<String, Object> map  = new HashMap<String, Object>();
		map.put("status_state",1);
		PageHelper.startPage(pageNum, pageSize);
		List<StoreEvaluation> storeList = storeService.findEvaluation(map);
		if (storeList != null && storeList.size() > 0) {
			PageInfo<StoreEvaluation> PageInfo = new PageInfo<>(storeList);
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setMessage(ResponseCode.SUCC_DO.getMsg());
			R.setData(PageInfo);
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		return R;

	}
	/**
	 * 
	 * @Title:             getByStoreEvaluationId
	 * @Description:     TODO 查询商品评论
	 * @param:             @param id
	 * @param:             @return   R
	 * @return:            
	 * @throws
	 */
	
	@RequestMapping("getByStoreEvaluationId/{id}")
	public @ResponseBody ResponseData getByStoreEvaluationId(@PathVariable("id") Integer id){
	    ProtocolEntity  pEntity  =new ProtocolEntity();
	    ResponseData R = new ResponseData();
	    StoreEvaluation storeEvaluation  =  new StoreEvaluation();
		storeEvaluation.setEvaluation_id(id);
	    StoreEvaluation storeEvaluations  = storeService.findStoreEvaluationById(storeEvaluation);
		if (storeEvaluations != null) {
			R.setData(storeEvaluations);
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setErrorCode(ResponseCode.SUCC_DO.getMsg());
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		return R;
	}

	/*
	 * 审核首页视频评论功能信息
	 */
	@ResponseBody
	@RequestMapping("/examineStoreEvaluation/{id}/{state}")
	public ResponseData examineStoreEvaluation(@PathVariable("id") Integer id, @PathVariable("state") Integer state,
			HttpServletRequest request) {
		ResponseData R = new ResponseData();
		StoreEvaluation storeEvaluation = new StoreEvaluation();
		storeEvaluation.setEvaluation_id(id);
		storeEvaluation.setStatus_state(state);
		Integer num = storeService.updateStoreEvaluationState(storeEvaluation);
		if (num > 0) {
			if (state == 0) {
				R.setErrorCode(ResponseCode.SUCC_DO.getCode());
				R.setMessage("审核通过");
			} else if (state == 2) {
				R.setErrorCode(ResponseCode.SUCC_DO.getCode());
				R.setMessage("审核不通过");
			}
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		return R;
	}
}
