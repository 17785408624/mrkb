package com.mrkb.dao.modle.weixin.message.resp;


/**
* 类名: VoiceMessage 
* 描述: 语音消息
* 开发人员： 万祖权 
* 创建时间：  2017-12-21 
 */
public class VoiceMessage extends BaseMessage {
    // 语音
    private Voice Voice;

    public Voice getVoice() {
        return Voice;
    }

    public void setVoice(Voice voice) {
        Voice = voice;
    }
}