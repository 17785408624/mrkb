package com.mrkb.web.controller.sys;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mrkb.common.util.ResponseCode;
import com.mrkb.common.util.ResponseData;
import com.mrkb.dao.dao.BasicStoreMapper;
import com.mrkb.dao.modle.store.StoreBasics;
import com.mrkb.service.StoreService;

/**
 *
 * @author liangyi 璇剧▼controller Storecontroller
 */
@Controller
@RequestMapping("/store")
public class StoreController {

	@Autowired
	private StoreService storeService;
	@Autowired
	private BasicStoreMapper basicStoreMapper;
	/**
	 * 商品管理跳转页面
	 *
	 * @return 杩斿洖/sys/storeManage.html
	 */
	@RequestMapping("/storeManage")
	public String toStoreList() {
		return "sys/store/storeManage";
	}

	/**
	 *新增商品
	 *
	 * @param vueTest
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/storeAdd")
	public ResponseData storeAdd(@RequestBody StoreBasics storeBasics) {
		System.out.println(storeBasics);
		ResponseData r = new ResponseData();
		StoreBasics storeBasics2 = null;
		storeBasics.setStatus_state(1);// 榛樿鏂板璇剧▼涓哄緟瀹℃牳鐘舵��
		storeBasics.setAdd_date(System.currentTimeMillis());// 鏂板鍟嗗搧鏃剁郴缁熷綋鍓嶆椂闂存埑
		storeBasics.setUser_basics_id(1);// 鑾峰彇褰曞叆鍟嗗搧鐢ㄦ埛id
		storeBasics2 = storeService.addStore(storeBasics);/* 鏂板璇剧▼瀹屾垚鍚庤繑鍥炶瀹炰綋瀵硅薄 */
		int store_id=storeBasics2.getStore_id();
		/*List<StoreGift> sg=storeBasics.getSg();
		for(int i=0;i<sg.size();i++){
			sg.get(i).setStore_id(store_id);
		}
		if(storeBasics.getStore_type()==1&&storeBasics.getIs_gift().equals(2)){//为大礼包类型时，新增
			storeService.addStoreGift(sg);
		}
		*/
		if (storeBasics2 != null) {
			r.setErrorCode(ResponseCode.SUCC_DO.getCode());
			r.setMessage(ResponseCode.SUCC_DO.getMsg());
			return r;
		}
		r.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		r.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		return r;
	}

	/**
	 * 商品管理列表信息展示
	 *
	 * @param pageNum
	 * @param pageSize
	 * @param name
	 * @return
	 *//*
	@ResponseBody
	@RequestMapping("/storeList/{pageNum}/{pageSize}")
	public ResponseData storeList(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize,
			HttpServletRequest req) {
		ResponseData R = new ResponseData();
		StoreBasics storeBasics = new StoreBasics();
		storeBasics.setStatus_state(0);
		 鑾峰彇鍓嶆store_name鍙傛暟
		String storeName = req.getParameter("name");
		if(storeName  == null ||storeName.length() ==0){
			storeBasics.setStore_name(null);
			storeBasics.setShelf_state(null);
		}else{
			if(StringUtils.isNumeric(storeName)){
				 if(storeName.equals("0")){//鏌ヨ鍏ㄩ儴鍖呭惈宸茬即璐瑰拰鏈即璐圭殑
					 storeBasics.setStore_name(null);
					 storeBasics.setShelf_state(null);
				 }else{
					 storeBasics.setStore_name(null);
					 storeBasics.setShelf_state(Integer.valueOf(storeName));
				 }
			}else{
				 storeBasics.setStore_name(storeName);
				 storeBasics.setShelf_state(null);
			}

		}
		// System.out.println("鎵撳嵃鍟嗗搧鍚嶇О"+storeName);
		PageHelper.startPage(pageNum, pageSize);
		List<StoreBasics> storeList = storeService.findAllStore(storeBasics);
		PageInfo<StoreBasics> PageInfo = new PageInfo<>(storeList);
		R.setErrorCode(ResponseCode.SUCC_DO.getCode());
		R.setMessage(ResponseCode.SUCC_DO.getMsg());
		R.setData(PageInfo);
		return R;
	}*/

	/**
	 * 查询所有课程(不包含套餐)
	 *
	 * @param pageNum
	 * @param pageSize
	 * @param name
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findStore")
	public ResponseData findStore(
			HttpServletRequest req) {
		ResponseData R = new ResponseData();
		StoreBasics storeBasics = new StoreBasics();
		storeBasics.setStatus_state(0);
		storeBasics.setStore_type(1);
		storeBasics.setIs_gift(1);
		List<StoreBasics> storeList = storeService.findAllStore(storeBasics);
		R.setErrorCode(ResponseCode.SUCC_DO.getCode());
		R.setMessage(ResponseCode.SUCC_DO.getMsg());
		R.setData(storeList);
		return R;
	}

	/**
	 * 查询单个商品详情信息
	 *
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getByStoreId/{id}")
	public ResponseData findById(@PathVariable("id") Integer id) {
		ResponseData R = new ResponseData();
		StoreBasics storeBasics = new StoreBasics();
		storeBasics.setStore_id(id);
		StoreBasics storeBasics1 = storeService.findStoreByOne(storeBasics);
		if (storeBasics1 != null) {
			R.setData(storeBasics1);
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setErrorCode(ResponseCode.SUCC_DO.getMsg());
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		return R;
	}

	/**
	 * 修改商品信息
	 *
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/editStore")
	public ResponseData updateMenu(@RequestBody StoreBasics storeBasics) {
		ResponseData R = new ResponseData();
		Integer num = storeService.updateStore(storeBasics);
		if (num > 0) {
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setMessage(ResponseCode.SUCC_DO.getMsg());
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		return R;
	}

	/*
	 * 删除商品信息
	 */
	@ResponseBody
	@RequestMapping("/deleteStore/{id}")
	public ResponseData deleteStore(@PathVariable("id") Integer id,HttpServletRequest request){
		ResponseData R = new ResponseData();
		StoreBasics sbs = new StoreBasics();
		sbs.setStore_id(id);
		StoreBasics sb = storeService.findStoreBasics(sbs);//鑾峰彇褰撳墠鍟嗗搧鐨勪俊鎭�
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
		Integer num =storeService.deleteStore(id);
		System.out.println("num澶т簬"+num);
		if(num>0){
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setMessage(ResponseCode.SUCC_DO.getMsg());
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		return R;
	}

	/*删除上传图片*/
	/*
	 * 删除商品信息
	 */
	@ResponseBody
	@RequestMapping("/deletePictureOne")
	public ResponseData deletePictureOne(@PathVariable("store_picture") String store_picture,HttpServletRequest request){
		ResponseData R = new ResponseData();
		StoreBasics sbs = new StoreBasics();
		if(store_picture!=null){
			String[] picturess = store_picture.split(";");
			String pathRoot = "C:/file";//图片保存根路径
			for (int i = 0; i < picturess.length; i++) {
				String path = pathRoot;//鍥剧墖缁濆璺緞
				path += picturess[i];
				File file = new File(path);
				file.delete();
			}
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setMessage("删除成功");
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		return R;
	}
	/**
	 * 修改商品是否下架
	 *
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateShelfState")
	public ResponseData updateShelfState(@RequestBody StoreBasics storeBasics) {
		ResponseData R = new ResponseData();
		if(storeBasics.getShelf_state()==1){
			storeBasics.setShelf_state(2);
		}else{
			storeBasics.setShelf_state(1);
		}
		Integer num = basicStoreMapper.updateStoreShelfState(storeBasics);
		if (num > 0) {
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setMessage(ResponseCode.SUCC_DO.getMsg());
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		return R;
	}
	@ResponseBody
	@RequestMapping("/storeList")
	public ResponseData storeListTest(
			HttpServletRequest req) {
		ResponseData R = new ResponseData();
		StoreBasics storeBasics = new StoreBasics();
		storeBasics.setStatus_state(0);
		/* 鑾峰彇鍓嶆store_name鍙傛暟 */
		try {
			String storeName = req.getParameter("store_name");
			storeBasics.setStore_name(storeName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			String shelfState = req.getParameter("shelf_state");
			if (shelfState.equals("0")) {
				storeBasics.setShelf_state(null);
			} else {
				storeBasics.setShelf_state(Integer.valueOf(shelfState));
			}
			storeBasics.setShelf_state(Integer.valueOf(shelfState));
		} catch (Exception e) {
			e.printStackTrace();
		}
		Integer pageNum =Integer.valueOf(req.getParameter("pageIndex"));
		Integer pageSize =Integer.valueOf(req.getParameter("pageSize"));
		// System.out.println("鎵撳嵃鍟嗗搧鍚嶇О"+storeName);
		PageHelper.startPage(pageNum, pageSize);
		List<StoreBasics> storeList = storeService.findAllStore(storeBasics);
		PageInfo<StoreBasics> PageInfo = new PageInfo<>(storeList);
		R.setErrorCode(ResponseCode.SUCC_DO.getCode());
		R.setMessage(ResponseCode.SUCC_DO.getMsg());
		R.setData(PageInfo);
		return R;
	}
}
