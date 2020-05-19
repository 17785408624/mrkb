package com.mrkb.common.util;
/**
 * @author Aaron
 * @version 1.00.00
 * 修改日期:2017年2月28日 上午11:51:18
 * </pre>
 */
public enum ResponseCode {

	//错误代码定义规范:
	
	//通用处理成功代码2xx
	SUCC_DO("200", "处理成功"),
	ERROR_FAIL("201","处理失败"),
	//登录
	SUCC_LOGIN("202","登录成功"),
	FAIL_LOGIN("203","登录失败"),
	LOGIN_TIMEOUT("204","登录超时"),
	//通用错误代码4xx
	ERROR_EXPRESSION("401", "表达式验证错误"),
	ERROR_PASSWORD("406","密码错误"),
	ERROR_PATAM_NULL("402", "参数为空"),
	ERROR_SESSION("420","session超时"),
	ERROR_SMS_EX("sms_001","短息服务异常"),
	ERROR_CODE("403", "哎呀！服务器开小差了"),
	ERROR_PHONE_EXISTED("407", "该手机号已经注册过了"),
	ERROR_PHONE_VALIDATE_CODE("408", "手机号验证码错误"),
	ERROR_PHONE_VALIDATE_NULL("409", "没有输入手机号验证码"),
	ERROR_PHONE_VALIDATE_BLANK("410", "手机号验证码为空"),
	ERROR_PHONE_PHONE_BLANK("411", "手机号不能为空"),
	ERROR_TOKEN_EXPIRED("412", "登录超时，请重新登陆"),
	ERROR_TOKEN_NULL("413", "请登陆"),
	ERROR_PHONE_VALIDATE_TIMEOUT("415","验证码超时已过期"),
	ERROR_IMAGE_CODE_FAIL("416", "验证码输入错误"),
	ERROR_PHONE_LENGTH("417", "手机号码错误"),
	ERROR_NONE("204","客官,没有更多数据了哟"),
	ERROR_SMSG_FAIL("418","短信发送失败！！！"),
	ERROR_MESSAGETIME("209","短信还在有效期，请一分钟后再试"),
	ERROR_MESSAGEFAIL("301","验证码失效"),
	ERROR_MESSAGEEXCEED("300","今日短信达上限"),
	ERROR_LOCKED("207","账号被冻结"),
	//短信提示
	USER_NON_EXISTENT("40001", "用户不存在"),
	ERROR_FILE_NULL("205","文件为空"),
	ERROR_FILE_FAIL("206","上传失败");

    private String code;
    private String msg;

    private ResponseCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}