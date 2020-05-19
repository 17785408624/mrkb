package com.mrkb.web.controller.sys;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
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
import com.mrkb.dao.modle.VueTest;
import com.mrkb.service.VueTestService;

@Controller
@RequestMapping("/vue")
public class VueTestController {
	
	@Autowired
	private VueTestService testService;
	
	 @RequiresPermissions("user:ces")
	 @RequestMapping("/showVueTestPage")
	 public String showVueTestPage(){
		return "sys/vueTest";
	 }
	
	 /**
	  * 权限测试
	  * @return
	  */
	 @RequiresPermissions("user:detail")
	 @RequestMapping("/jqgrid")
	 public String jqgridTest(){
		 return "sys/jqgridTest";
	 }
	 
	
	/**
	 * 删除
	 * @param id
	 * @return
	 * 参数遵循Restful接口设计风格
	 */
	@ResponseBody
	@RequestMapping("/VueTestDel/{id}")
	public ResponseData del(@PathVariable("id")Integer id){
		ResponseData r = new ResponseData();
		Integer num = testService.del(id);
		if(num>0){
			r.setErrorCode(ResponseCode.SUCC_DO.getCode());
			r.setMessage(ResponseCode.SUCC_DO.getMsg());
			return r;
		}
		r.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		r.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		return r;
	}
	
	
	/**
	 * 新增
	 * @param vueTest
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/VueTestadd")
	public ResponseData add(@RequestBody VueTest vueTest){
		ResponseData r = new ResponseData();
		Integer num = testService.add(vueTest);
		if(num>0){
			r.setErrorCode(ResponseCode.SUCC_DO.getCode());
			r.setMessage(ResponseCode.SUCC_DO.getMsg());
			return r;
		}
		r.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		r.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		return r;
	}
	
	
	/**
	 * 修改
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/VueTestedit")
	public ResponseData edit(@RequestBody VueTest vueTest){
		ResponseData r = new ResponseData();
		Integer num=testService.edit(vueTest);
		if(num>0){
			r.setErrorCode(ResponseCode.SUCC_DO.getCode());
			r.setMessage(ResponseCode.SUCC_DO.getMsg());
			return r;
		}
		r.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		r.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		return r;
	}
	
	
	@ResponseBody
	@RequestMapping("/VueTestlist/{pageNum}/{pageSize}/{name}")
	public ResponseData getlist(@PathVariable("pageNum") Integer pageNum,@PathVariable("pageSize") Integer pageSize,@PathVariable("name") String name){
	    ResponseData R = new ResponseData();
	    VueTest  v = new VueTest();
	    v.setName(name);
        PageHelper.startPage(pageNum, pageSize);
        List<VueTest> vuelist = testService.list(v);
        PageInfo<VueTest> PageInfo = new PageInfo<>(vuelist);
        R.setErrorCode(ResponseCode.SUCC_DO.getCode());
        R.setMessage(ResponseCode.SUCC_DO.getMsg());
        R.setData(PageInfo);
        return R;
	}

}
