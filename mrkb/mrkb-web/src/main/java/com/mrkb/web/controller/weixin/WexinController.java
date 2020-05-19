package com.mrkb.web.controller.weixin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/weixin/weixin")
public class WexinController {
	
	
	/**
	 * 跳转进入微信首页
	 * @return
	 */
	@RequestMapping("/weixinidex")
	public String showWixinIndex(){
		return "weixin/thymeleafText";
	}

}
