package com.mrkb.dao.modle.weixin.message.resp;

/**
* 类名: VideoMessage 
* 描述: 视频消息 
* 开发人员： 万祖权 
* 创建时间：  2017-12-23 
 */
public class VideoMessage extends BaseMessage {
    // 视频
    private Video Video;

    public Video getVideo() {
        return Video;
    }

    public void setVideo(Video video) {
        Video = video;
    }
}