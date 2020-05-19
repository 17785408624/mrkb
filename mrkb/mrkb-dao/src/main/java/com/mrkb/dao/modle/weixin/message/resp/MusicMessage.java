package com.mrkb.dao.modle.weixin.message.resp;


/**
* 类名: MusicMessage 
* 描述: 音乐消息 
* 开发人员： 万祖权 
* 创建时间：  2017-12-24 
 */
public class MusicMessage extends BaseMessage {
    // 音乐
    private Music Music;

    public Music getMusic() {
        return Music;
    }

    public void setMusic(Music music) {
        Music = music;
    }
}