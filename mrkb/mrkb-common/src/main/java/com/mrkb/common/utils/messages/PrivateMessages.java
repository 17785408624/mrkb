package com.mrkb.common.utils.messages;

public class PrivateMessages {
	
	/**
	 * 该方法用来组装个人消息标签,公众号发送消息部分类
	 */
	public static String getPushMessage(String update,String message){
		String message_content="<div style='margin-top:20px;'>"+
				"<div class='center_div'>"+
				"<div class='center_div_img'>"+
				"<img th:src='@{/img/wx_ltone/icon/mine/ltimg.jpg}'>"+
				"</div>"+
				"<div class='center_div_name'>"+
				"<p style='font-size: 14px;color: #333333;'>摩尔卡巴公众号</p>"+
				"<p style='font-size: 12px;color: #666666;'>"+update+"</p>"+
				"</div>"+
				"</div>"+
				"<div class='demo center_div_name_js'>"+
				message+
				"</div>"+
				"</div>";
		return message_content;
	}
	
}
