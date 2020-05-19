package com.mrkb.web.controller.weixin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.session.SessionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mrkb.common.util.ResponseCode;
import com.mrkb.common.util.ResponseData;
import com.mrkb.dao.modle.store.StoreBasics;
import com.mrkb.dao.modle.store.StoreEvaluation;
import com.mrkb.dao.modle.store.StoreGiftRecordEntity;
import com.mrkb.dao.modle.user.UserWeixin;
import com.mrkb.service.OrderService;
import com.mrkb.service.StoreService;
import com.mrkb.service.UserDutyService;
import com.mrkb.service.UserService;
import com.mrkb.shiro.cookieutil.SessionEntity;

@Controller
@RequestMapping("/weixin/wenxin_store")
public class BasicsStoreContorller {
	@Autowired
	private StoreService storeService;
	@Autowired
	private UserService userService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private UserDutyService userDutyService;

	@RequestMapping("toAddEvaluate")
	public String toAddEvaluate(HttpServletResponse response, HttpServletRequest request) {
		int store_id = Integer.valueOf(String.valueOf(request.getParameter("store_id")));
		int order_id = Integer.valueOf(String.valueOf(request.getParameter("order_id")));
		System.out.println("store_id:::::::::" + store_id);
		request.setAttribute("store_id", store_id);
		request.setAttribute("order_id", order_id);
		return "weixin/wx_ltone/mine/evaluate";

	}

	/**
	 * 查询单个商品
	 * 
	 * @param request
	 * @param jsonData
	 * @return
	 */
	@RequestMapping("findStore")
	public @ResponseBody ResponseData findStore(HttpServletResponse response, HttpServletRequest request) {// 查询单个商品
		ResponseData R = new ResponseData();
		StoreBasics sb = new StoreBasics();
		sb.setStore_id(Integer.valueOf(request.getParameter("store_id")));
		StoreBasics returnsb = storeService.findStoreBasics(sb);// 查询出商品信息
		if (returnsb != null) {
			R.setData(returnsb);
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setErrorCode(ResponseCode.SUCC_DO.getMsg());
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setErrorCode(ResponseCode.ERROR_FAIL.getMsg());
		return R;
	}

	/**
	 * 私人定制
	 * 
	 * @param request
	 * @param jsonData
	 * @return
	 */
	@RequestMapping("customMade")
	public @ResponseBody ResponseData customMade(HttpServletResponse response, HttpServletRequest request) {// 查询单个商品
		ResponseData R = new ResponseData();
		// StoreBasics sb=new StoreBasics();
		// sb.setStore_id(Integer.valueOf(String.valueOf(jsonData.get("store_id"))));
		Integer store_type = 1;
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("store_type", store_type);
		List<StoreBasics> returnsb = storeService.findPersonalStoreBasics(map);
		if (returnsb != null) {
			R.setData(returnsb);
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setErrorCode(ResponseCode.SUCC_DO.getMsg());
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setErrorCode(ResponseCode.ERROR_FAIL.getMsg());
		return R;

	}

	/**
	 * 查询所有商品
	 * 
	 * @param request
	 * @param jsonData
	 * @return
	 */
	@ResponseBody
	@RequestMapping("findAllStore")
	public ResponseData findAllStore(HttpServletResponse response, HttpServletRequest request) {// 查询所有商品
		ResponseData R = new ResponseData();
		Integer store_type = 0;
		StoreBasics sotBasics = new StoreBasics();
		sotBasics.setStore_type(store_type);
		List<StoreBasics> sbList = storeService.findAllStoreBasics(sotBasics);// 查询出商品信息
		System.out.println("sbList::::=====" + sbList.toString());
		if (sbList != null && sbList.size() != 0) {
			R.setData(sbList);
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setErrorCode(ResponseCode.SUCC_DO.getMsg());
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setErrorCode(ResponseCode.ERROR_FAIL.getMsg());
		return R;
	}

	/**
	 * 查看最新评论
	 * 
	 * @param request
	 * @param response
	 * @param jsonData
	 * @return
	 */
	@RequestMapping("findEvaluationNew")
	public @ResponseBody ResponseData findEvaluationNew(HttpServletRequest request, HttpServletResponse response) {
		ResponseData R = new ResponseData();
		Integer store_id = Integer.valueOf(request.getParameter("store_id"));
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("store_id", store_id);
		StoreEvaluation se = storeService.findEvaluationNew(map);
		if (se != null) {
			R.setData(se);
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setErrorCode(ResponseCode.SUCC_DO.getMsg());
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setErrorCode(ResponseCode.ERROR_FAIL.getMsg());
		return R;
	}

	/**
	 * 查看所有评论
	 * 
	 * @param request
	 * @param response
	 * @param jsonData
	 * @return
	 */
	@RequestMapping("findEvaluation")
	public @ResponseBody ResponseData findEvaluation(HttpServletRequest request, HttpServletResponse response) {
		ResponseData R = new ResponseData();
		Integer store_id = Integer.valueOf(String.valueOf(request.getParameter("store_id")));
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("store_id", store_id);
		map.put("status_state", 0);
		List<StoreEvaluation> se = storeService.findEvaluation(map);
		if (se != null) {
			R.setData(se);
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setErrorCode(ResponseCode.SUCC_DO.getMsg());
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setErrorCode(ResponseCode.ERROR_FAIL.getMsg());
		return R;
	}

	/**
	 * 添加商品评论
	 * 
	 * @param request
	 * @param jsonData
	 * @return
	 */
	@ResponseBody
	@RequestMapping("addEvaluation")
	public ResponseData addEvaluation(HttpServletResponse response, HttpServletRequest request) {// 添加单个评论
		System.out.println("进入添加评论方法");
		ResponseData R = new ResponseData();
		SessionEntity sey = null;
		Integer user_basics_id = 0;
		long time = System.currentTimeMillis();
		try {
			sey = new SessionEntity(request);
			user_basics_id = sey.getUser_basics_id();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (user_basics_id == 0) {
			R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
			R.setErrorCode(ResponseCode.ERROR_FAIL.getMsg());
			R.setData(3);
			// vsi.setState(3);
			return R;
		}
		Integer order_id = Integer.valueOf(String.valueOf(request.getParameter("order_id")));
		String evaluation_value = String.valueOf(request.getParameter("evaluation_value"));
		Integer store_id = Integer.valueOf(request.getParameter("store_id"));
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("order_status", 9);
		map.put("order_edit_date", time);
		map.put("order_id", order_id);
		map.put("user_basics_id", user_basics_id);
		UserWeixin uv = userService.findUserWeixinUserBasicsId(user_basics_id);
		String weixin_nickname = uv.getWeixin_nickname();
		String weixin_portrait = uv.getWeixin_portrait();
		StoreBasics ss = new StoreBasics();
		ss.setStore_id(store_id);
		StoreEvaluation se = new StoreEvaluation();
		se.setStore_id(store_id);
		se.setWeixin_nickname(weixin_nickname);
		se.setWeixin_portrait(weixin_portrait);
		se.setEvaluation_date(time);
		se.setEvaluation_value(evaluation_value);
		se.setSuper_evaluation_id(0);
		se.setRead_num(0);
		se.setUser_basics_id(user_basics_id);
		StoreEvaluation sen = storeService.addEvaluation(se, map, ss);
		if (se != null) {
			R.setData(se);
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setErrorCode(ResponseCode.SUCC_DO.getMsg());
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setErrorCode(ResponseCode.ERROR_FAIL.getMsg());
		return R;

	}

	/**
	 * 查询store_type=2，status_state=0的商品
	 * 
	 * @param request
	 * @param jsonData
	 * @return
	 */
	@ResponseBody
	@RequestMapping("findAllStoreByStoreType")
	public ResponseData findAllStoreByStoreType(HttpServletResponse response, HttpServletRequest request) {// 查询商品类型为2的所有商品
		ResponseData R = new ResponseData();
		// HashMap<String,Object> map=new HashMap<String,Object>();
		StoreBasics ss = new StoreBasics();
		if(request.getParameter("store_type") != null && !request.getParameter("store_type").equals("")){
			
			ss.setStore_type(Integer.valueOf(request.getParameter("store_type")));
		}
		if(request.getParameter("status_state") != null && !request.getParameter("status_state").equals("")){
			ss.setStatus_state(Integer.valueOf(request.getParameter("status_state")));
		}
		if(request.getParameter("academic_type") != null && !request.getParameter("academic_type").equals("")){
			ss.setAcademic_type(Integer.valueOf(request.getParameter("academic_type")));
		}
		if(request.getParameter("course_type") != null && !request.getParameter("course_type").equals("")){
			ss.setCourse_type(Integer.valueOf(request.getParameter("course_type")));
		}
		/*if(request.getParameter("is_gift") != null && !request.getParameter("is_gift").equals("")){
			ss.setIs_gift(Integer.valueOf(request.getParameter("is_gift")));
		}*/
		if(request.getParameter("shelf_state") != null && !request.getParameter("shelf_state").equals("")){
			ss.setShelf_state(Integer.valueOf(request.getParameter("shelf_state")));
		}
		// map.put("store_type", store_type);
		// map.put("status_state", status_state);
		List<StoreBasics> sbList = storeService.findAllStoreBasics(ss);// 查询出商品信息
		System.out.println("打印商品"+sbList);
		if (sbList != null && sbList.size() > 0) {
			R.setData(sbList);
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setErrorCode(ResponseCode.SUCC_DO.getMsg());
			return R;
		}else if(sbList.size() ==0){
			R.setErrorCode("处理成功");
			R.setMessage("数据为空！");
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setErrorCode(ResponseCode.ERROR_FAIL.getMsg());
		return R;
	}
	
	/**
	 * 获取赠送课程套餐
	 * 
	 * @param request
	 * @param response
	 * @param jsonData
	 * @param  user_basics_id, order_id
	 * @return
	 */
	@RequestMapping("findSotreGift")
	public @ResponseBody ResponseData findSotreGift(HttpServletRequest request, HttpServletResponse response) {
		ResponseData R = new ResponseData();
		Integer order_id = Integer.valueOf(String.valueOf(request.getParameter("order_id")));
		SessionEntity seEntity = null;
		Integer user_basics_id = 0;//用户id
		try {
			seEntity = new SessionEntity(request);
		} catch (SessionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			user_basics_id = seEntity.getUser_basics_id();
		} catch (Exception e) {
			R.setIsSuccess(false);
			return R;
		}
		HashMap<String, Object> se = userDutyService.storeGiftList(user_basics_id,order_id);
		if (se != null) {
			R.setData(se);
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setErrorCode(ResponseCode.SUCC_DO.getMsg());
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setErrorCode(ResponseCode.ERROR_FAIL.getMsg());
		return R;
	}
	/**
	 * 通过gift_id,查找套餐包含的课程
	 * 
	 * @param request
	 * @param response
	 * @param jsonData
	 * @param  gift_id
	 * @return
	 */
	@RequestMapping("findStoreGiftBasics")
	public @ResponseBody ResponseData findStoreGiftBasics(HttpServletRequest request, HttpServletResponse response) {
		ResponseData R = new ResponseData();
		Integer gift_id = Integer.valueOf(String.valueOf(request.getParameter("gift_id")));
		Integer gift_user_id = Integer.valueOf(String.valueOf(request.getParameter("gift_user_id")));
		List<StoreBasics> se = userDutyService.getStoreBasics(gift_id,gift_user_id);
		if (se != null) {
			R.setData(se);
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setErrorCode(ResponseCode.SUCC_DO.getMsg());
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setErrorCode(ResponseCode.ERROR_FAIL.getMsg());
		return R;
	}
	/**
	 * 赠送课程
	 * 
	 * @param request
	 * @param response
	 * @param jsonData
	 * @param gift_id,  store_id,  user_basics_id,  gift_user_id
	 * @return
	 */
	@RequestMapping("giftCourse")
	public @ResponseBody ResponseData giftCourse(HttpServletRequest request, HttpServletResponse response) {
		ResponseData R = new ResponseData();
		Integer store_id = Integer.valueOf(String.valueOf(request.getParameter("store_id")));
		Integer gift_id = Integer.valueOf(String.valueOf(request.getParameter("gift_id")));
		Integer gift_user_id = Integer.valueOf(String.valueOf(request.getParameter("gift_user_id")));
		SessionEntity seEntity = null;
		Integer user_basics_id = 0;//用户id
		try {
			seEntity = new SessionEntity(request);
		} catch (SessionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			user_basics_id = seEntity.getUser_basics_id();
		} catch (Exception e) {
			R.setIsSuccess(false);
			return R;
		}
		int se = userDutyService.giftCourse(gift_id, store_id, user_basics_id, gift_user_id);
		if (se == 0) {
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setMessage("赠送成功!");
			return R;
		}else if(se ==-1){
			R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
			R.setMessage("赠送名额已用完!");
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setMessage("赠送失败!");
		return R;
	}
	/**
	 * 通过gift_id,查找大礼包赠送记录
	 * 
	 * @param request
	 * @param response
	 * @param jsonData
	 * @param  gift_id
	 * @return
	 */
	@RequestMapping("findStoreGiftRecord")
	public @ResponseBody ResponseData findStoreGiftRecord(HttpServletRequest request, HttpServletResponse response) {
		ResponseData R = new ResponseData();
		SessionEntity seEntity = null;
		Integer user_basics_id = 0;//用户id
		try {
			seEntity = new SessionEntity(request);
		} catch (SessionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			user_basics_id = seEntity.getUser_basics_id();
		} catch (Exception e) {
			R.setIsSuccess(false);
			return R;
		}
		HashMap<String,Object> se = userDutyService.storeGiftRecordList(user_basics_id);
		if (se != null) {
			R.setData(se);
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setErrorCode(ResponseCode.SUCC_DO.getMsg());
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setErrorCode(ResponseCode.ERROR_FAIL.getMsg());
		return R;
	}
	/**
	 * 通过gift_record_id,查找单个赠送记录
	 * 
	 * @param request
	 * @param response
	 * @param jsonData
	 * @param  gift_id
	 * @return
	 */
	@RequestMapping("findStoreGiftRecordById")
	public @ResponseBody ResponseData findStoreGiftRecordById(HttpServletRequest request, HttpServletResponse response) {
		ResponseData R = new ResponseData();
		StoreGiftRecordEntity entity  =  new StoreGiftRecordEntity();
		entity.setGift_record_id(Integer.valueOf(request.getParameter("gift_record_id")));		
		StoreGiftRecordEntity se = userDutyService.findStoreGiftRecordById(entity);
		if (se != null) {
			R.setData(se);
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setErrorCode(ResponseCode.SUCC_DO.getMsg());
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setErrorCode(ResponseCode.ERROR_FAIL.getMsg());
		return R;
	}
}
