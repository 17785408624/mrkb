package com.mrkb.dao.modle.weixin.message.req;


/**
* 类名: ImageMessage 
* 描述: 请求消息之图片消息，PicUrl是图片链接
    MediaId是图片消息媒体id，可以调用多媒体文件下载接口拉取数据
* 开发人员： 万祖权 
* 创建时间： 2017-12-20 
 */
public class ImageMessage extends BaseMessage {
    // 图片链接
    private String PicUrl;
    private String MediaId;

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

}