package com.mrkb.shiro.controller;


import com.mrkb.common.util.ConmmonVariable;
import com.mrkb.common.util.ResponseCode;
import com.mrkb.common.util.ResponseData;
import com.mrkb.shiro.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Administrator
 * @create 2017/12/2
 * @since 1.0.0
 */
@Controller
@RequestMapping("/user")
public class SysUserLoginController {
	
	//得到log对象 操作日志 可以通过log去打印日志信息
    private static final transient Logger log = LoggerFactory.getLogger(SysUserLoginController.class);
	

    /**
     * 登出
     * @return
     */
    @RequestMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        if(subject != null){
            subject.logout();
        }
        return "sys/login";
    }

    
    
    /**
     * 用户登录
     * @param username
     * @param password
     * @param vCode
     * @return
     */
    @ResponseBody
    @RequestMapping("/loginUser")
    public static ResponseData loginUser(@RequestParam("username") String username, @RequestParam("password") String password,
										 @RequestParam("vCode") String vCode, @RequestParam("rememberme") boolean rememberme, HttpServletRequest request){
    	ResponseData R = new ResponseData();
    	HttpSession session = request.getSession();
    	User user = new User();
    	if(vCode!=null || !vCode.equals("")){
    		if(NewKaptchaController.loginCheck(request, vCode)){
    			password = new Sha256Hash( password ).toHex();
    			UsernamePasswordToken token = new UsernamePasswordToken(username,password);
    			token.setRememberMe(rememberme);
    	        Subject subject = SecurityUtils.getSubject();
    	        System.out.println("登陆用户"+username+" ****** 登录密码"+password);
    	        try {
    	            subject.login(token);
    	            user = (User)subject.getPrincipal();
    	            session.setAttribute("LOGINUSER",user);
    	            R.setData(user);
    	        	R.setErrorCode(ResponseCode.SUCC_LOGIN.getCode());
    	        	R.setMessage(ResponseCode.SUCC_LOGIN.getMsg());
    	            return R;
    	        }catch (UnknownAccountException uae){
    	        	//返回用户名不存在
    	        	log.info(username+":用户名不存在---" + token.getPrincipal());
    	        	R.setErrorCode(ResponseCode.USER_NON_EXISTENT.getCode());
    	        	R.setMessage(ResponseCode.USER_NON_EXISTENT.getMsg());
    	            return R;
    	        }catch (IncorrectCredentialsException ice) {
                	//密码错误
                    log.info(username+":密码错误----- " + token.getPrincipal());
                    R.setErrorCode(ResponseCode.ERROR_PASSWORD.getCode());
    	        	R.setMessage(ResponseCode.ERROR_PASSWORD.getMsg());
    	            return R;
                } catch (LockedAccountException lae) {
                	//账号冻结
                    log.info("账号被冻结" + token.getPrincipal());
                    R.setErrorCode(ResponseCode.ERROR_LOCKED.getCode());
    	        	R.setMessage(ResponseCode.ERROR_LOCKED.getMsg());
    	            return R;
                }
                catch (AuthenticationException ae) {
                    //其他的错误信息，返回登录失败
                	R.setErrorCode(ResponseCode.FAIL_LOGIN.getCode());
    	        	R.setMessage(ResponseCode.FAIL_LOGIN.getMsg());
    	        	return R;
                }
    	        catch (Exception e) {
                    //其他的错误信息，返回登录失败
                	R.setErrorCode(ResponseCode.FAIL_LOGIN.getCode());
    	        	R.setMessage(ResponseCode.FAIL_LOGIN.getMsg());
    	        	return R;
                }
    		}
    		else{
        		//返回验证码输入错误
        		R.setErrorCode(ResponseCode.ERROR_IMAGE_CODE_FAIL.getCode());
        		R.setMessage(ResponseCode.ERROR_IMAGE_CODE_FAIL.getMsg());
        		R.setIsSuccess(false);
        		return R;
        	}
    	}
    	//返回登录失败
    	R.setIsSuccess(false);
    	R.setErrorCode(ResponseCode.FAIL_LOGIN.getCode());
    	R.setMessage(ResponseCode.FAIL_LOGIN.getMsg());
		return R;
    }
    
}