package com.mrkb.web.controller.sys;

import com.mrkb.common.utils.payhttp.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	/**
     * 登录页面
     * @return
     */
    @RequestMapping("/login")
    public String login(){
        return "sys/login";
    }
    /**
     * 左侧菜单
     * @return
     */
    @RequestMapping("/left")
    public String left(){
        return "common/left";
    }
    
    /**
     * 主页面
     * @return
     */
    @RequestMapping("/mains")
    public String mains(){
        return "sys/main";
    }
    /**
     * 首页
     * @return
     */
    @RequestMapping("/index")
    public String right(){
        return "common/index";
    }
    /**
     * 顶部导航
     * @return
     */
    @RequestMapping("/top")
    public String top(){return "common/top";}
    /**
     * 错误页面
     * @return
     */
    @RequestMapping("/unauthorized")
    public String unauthorized(){
        return "unauthorized";
    }
    
    /**
     * 用户修改页面跳转
     * @return
     */
    @RequestMapping("/userUpdatePassword")
    public String userUpdatePassword(){
        return "sys/userUpdatePassword";
    }
}
