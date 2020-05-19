package com.mrkb.shiro.controller;

import java.awt.image.BufferedImage;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;

@Controller
public class NewKaptchaController {
	
	@Resource
	private Producer captchaProducer;
	
	
	/**
	 * 生成图片验证码
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/kaptcha.jpg")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
        response.setDateHeader("Expires", 0);
        // 设置头部无缓存
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        // 网络格式
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        // 设置无缓存
        response.setHeader("Pragma", "no-cache");
        // 定义返回格式
        response.setContentType("image/jpeg");
        // 获取随机字符
        String capText = captchaProducer.createText();
        // 验证码存入session
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
        // 把文字放到图片上面
        BufferedImage bi = captchaProducer.createImage(capText);
        ServletOutputStream out = response.getOutputStream();
        // 写出图片
        ImageIO.write(bi, "jpg", out);
        try {
            out.flush();
        } finally {
            out.close();
        }
        return null;
    }
	
	
	
	
	
	/**
	 * 检验验证码是否正确
	 * @param request
	 * @param kaptchaReceived
	 * @return
	 */
	public static boolean loginCheck(HttpServletRequest request,String kaptchaReceived){
        //用户输入的验证码的值
        String kaptchaExpected = (String) request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
        //校验验证码是否正确
        if (kaptchaReceived == null || !kaptchaReceived.equals(kaptchaExpected)) {
        	//返回验证码错误
        	return false;
        }
        //校验通过返回成功
        return true; 
    }

}
