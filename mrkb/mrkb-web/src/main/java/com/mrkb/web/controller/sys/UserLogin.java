package com.mrkb.web.controller.sys;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserLogin {

    /**
     * 用户登录界面跳转
     * @return
     */
    @RequestMapping("/user_login")
    public String userLoginPage(){
        return "sys/user_login";
    }
    
    
    
}
