package com.mrkb.dao.modle.weixin.message.req;


/**
* 类名: TextMessage
* 描述: 请求消息之文本消息，文本消息类TextMessage ，主要是文本消息内容。
* 开发人员： 万祖权
* 创建时间：2017-12-20 
 */

public class TextMessage extends BaseMessage {

    // 消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}