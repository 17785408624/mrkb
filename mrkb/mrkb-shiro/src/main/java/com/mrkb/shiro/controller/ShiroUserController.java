package com.mrkb.shiro.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mrkb.common.util.ResponseCode;
import com.mrkb.common.util.ResponseData;
import com.mrkb.common.utils.encryption.Md5Util;
import com.mrkb.dao.modle.user.BasicsUser;
import com.mrkb.shiro.model.User;
import com.mrkb.shiro.service.ShiroUserService;

@Controller
@RequestMapping("/sysUserMg")
public class ShiroUserController {
	
	
	@Autowired
	private ShiroUserService userService;
	
	
	
	/**
	 * 跳转用户管理页面
	 * @return
	 */
	@RequestMapping("/sysUserMAnagePage")
	public String sysUserMAnagePage(){
		return "sys/sysUser";
	}
	
	
	
	/**
	 * 分页查询用户信息
	 * @param pageSize
	 * @param pageIndex
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getUserPageList")
	public ResponseData getUserPageList(@RequestParam("pageSize") Integer pageSize,@RequestParam("pageIndex") Integer pageIndex,HttpServletRequest req){
		ResponseData R = new ResponseData();
		User user = new User();
		String nickname = req.getParameter("nickname");
		user.setUser_nickname(nickname);
		PageHelper.startPage(pageIndex, pageSize);
		List<User>list = new ArrayList<User>();
		list = userService.getUserPageList(user);
		PageInfo<User> PageInfo = new PageInfo<>(list);
	    R.setErrorCode(ResponseCode.SUCC_DO.getCode());
        R.setMessage(ResponseCode.SUCC_DO.getMsg());
        R.setData(PageInfo);
		return R;
	}
	
	

	/**
	 * 新增系统用户
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addNewUser")
	public ResponseData addNewUser(@RequestBody User user){
		ResponseData R = new ResponseData();
		String role_id=user.getRole_id().toString();
		Integer num=userService.addNewUser(user,role_id);
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
	 * 根据用户编号查询用户信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findUserByUserId/{user_id}")
	public ResponseData findUserByUserId(@PathVariable("user_id") Integer user_id){
		ResponseData R = new ResponseData();
		User user = userService.findUserByUserId(user_id);
		if(user != null){
			R.setData(user);
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setMessage(ResponseCode.SUCC_DO.getMsg());
			return R;
		}
		return R;
	}
	
	
	
	
	
	/**
	 * 编辑用户信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/editUser")
	public ResponseData editUser(@RequestBody User user){
		ResponseData R = new ResponseData();
		Integer num=userService.editUser(user);
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
	 * 删除用户
	 * @return
	 */
	@ResponseBody
	@RequiresPermissions("sys:remove")//系统删除权限
	@RequestMapping("/removeUser/{user_id}")
	public ResponseData removeUser(@PathVariable Integer user_id){
		ResponseData R = new ResponseData();
		Integer num=userService.removeUser(user_id);
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
	 * 
	 * @param request
	 * @return
	 */
  
	@RequestMapping("/updatePassword/{password}/{repassword}")
    @ResponseBody
	public ResponseData updatePassword(HttpServletRequest req,
			@PathVariable("password") String user_password_first,
			@PathVariable("repassword") String user_password_second
			){
		ResponseData R = new ResponseData();
		BasicsUser basicsUser = new BasicsUser();
    	String user_password1=user_password_first;
    	String user_password2=user_password_second;
    	HttpSession session = req.getSession();//获取登录session
    	User user = new User();
    	Subject subject = SecurityUtils.getSubject();
    	user = (User)subject.getPrincipal();
    	
    	if(!user_password1.equals(user_password2)){
    		R.setErrorCode(ResponseCode.FAIL_LOGIN.getCode());
        	R.setMessage("输入的两次密码不一致,请重新输入！");
        	return R;
    	}
    	
    	String user_password=new Sha256Hash( user_password1 ).toHex();
    	basicsUser.setUser_basics_id(Integer.valueOf(user.getUser_basics_id()));
    	basicsUser.setUser_password(user_password);
    	int update=userService.updateUserBasics(basicsUser);
    	if(update>0){
    		R.setErrorCode(ResponseCode.FAIL_LOGIN.getCode());
        	R.setMessage("密码修改成功！");
        	return R;
    		
    	}else{
    		R.setErrorCode(ResponseCode.FAIL_LOGIN.getCode());
        	R.setMessage("密码修改失败！");
        	return R;
    	}

    }

}
