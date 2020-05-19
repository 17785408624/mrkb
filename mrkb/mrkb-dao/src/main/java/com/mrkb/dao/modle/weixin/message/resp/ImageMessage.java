package com.mrkb.dao.modle.weixin.message.resp;



/**
* 类名: ImageMessage 
* 描述: 图片消息
* 开发人员： 万祖权 
* 创建时间：  2017-12-21 
 */
public class ImageMessage extends BaseMessage {
    
    private Image Image;

    public Image getImage() {
        return Image;
    }

    public void setImage(Image image) {
        Image = image;
    }
}