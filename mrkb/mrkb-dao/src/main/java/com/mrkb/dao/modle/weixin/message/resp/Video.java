package com.mrkb.dao.modle.weixin.message.resp;

/**
* 类名: Video 
* 描述: 视频model 
* 开发人员： 万祖权 
* 创建时间：  2017-12-22 
 */
public class Video {
    // 媒体文件id
    private String MediaId;
    // 缩略图的媒体id
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
