package com.mrkb.web.controller.sys;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UnauthorizedController {
	
	
	/**
	 * 无权限页面
	 * @return
	 */
	@RequestMapping("/unauthorized")
	public String unauthorized_page(){
		return "unauthorized";
	}

}
