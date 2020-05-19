package com.mrkb.dao.modle.weixin.message.resp;


/**
* 类名: TextMessage 
* 描述: 文本消息 
* 开发人员： 万祖权 
* 创建时间：  2017-12-21 
 */
public class TextMessage extends BaseMessage {
    // 回复的消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

	@Override
	public String toString() {
		return "TextMessage [Content=" + Content + ", getContent()="
				+ getContent() + ", getToUserName()=" + getToUserName()
				+ ", getFromUserName()=" + getFromUserName()
				+ ", getCreateTime()=" + getCreateTime() + ", getMsgType()="
				+ getMsgType() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
    
}