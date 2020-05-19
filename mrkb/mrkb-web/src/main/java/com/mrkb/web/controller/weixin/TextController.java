package com.mrkb.web.controller.weixin;
import com.mrkb.common.util.ResponseCode;
import com.mrkb.common.util.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@EnableAutoConfiguration
@Controller
@RequestMapping("/weixin/test")
public class TextController {

    private final static Logger logger = LoggerFactory.getLogger(TextController .class);

    @ResponseBody
    @RequestMapping("/controllerText")
    public ResponseData controllerText(){
        ResponseData R = new ResponseData();
        logger.debug("debug日志记录了");
        logger.info("info日志记录了");
        logger.error("erro日志记录了");
        R.setData("log日志测试");
        R.setMessage(ResponseCode.SUCC_DO.getMsg());
        R.setErrorCode(ResponseCode.SUCC_DO.getCode());
        return R;
    }


    @RequestMapping("/htmltext")
    public String htmltext(){
        return "sys/intdex";
    }


    @RequestMapping("/thymeleafText")
    public String thymeleafText(){
        return "weixin/thymeleafText";
    }

}
