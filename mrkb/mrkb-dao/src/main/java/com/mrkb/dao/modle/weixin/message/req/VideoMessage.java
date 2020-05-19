package com.mrkb.dao.modle.weixin.message.req;

/**
* 类名: VideoMessage 
* 描述: 请求消息之视频消息
* 开发人员： 万祖权
* 创建时间： 2017-12-20 
 */
public class VideoMessage  extends BaseMessage{

    // 媒体ID
    private String MediaId;
    // 语音格式
    private String ThumbMediaId;

    public String getMediaId() {
        return MediaId;
    }
    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }
    public String getThumbMediaId() {
        return ThumbMediaId;
    }
    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }
    
    
    
}