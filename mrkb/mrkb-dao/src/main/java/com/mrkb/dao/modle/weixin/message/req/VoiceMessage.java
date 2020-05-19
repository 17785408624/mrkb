package com.mrkb.dao.modle.weixin.message.req;
/**
* 类名: VoiceMessage 
* 描述: 请求消息之语音消息 ，
MediaId	语音消息媒体id，可以调用多媒体文件下载接口拉取数据。
Format	语音格式，如amr，speex等
* 开发人员： 万祖权 
* 创建时间： 2017-12-20
 */
public class VoiceMessage extends BaseMessage {

    // 媒体ID
    private String MediaId;
    // 语音格式
    private String Format;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }
}