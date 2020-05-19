package com.mrkb.dao.modle.weixin.message.resp;

/**
* 类名: Image
* 描述: 图片
* 开发人员：万祖权
* 创建时间：  2017-12-21
 */
public class Image {
    
	 private String MediaId;
	    
	    private String Title;
	    private String Description;
	    private String PicUrl;
	    private String Url;
	    

	    public String getMediaId() {
	        return MediaId;
	    }

	    public void setMediaId(String mediaId) {
	        MediaId = mediaId;
	    }
	    public String getTitle() {
	        return Title;
	    }

	    public void setTitle(String Title) {
	    	this.Title = Title;
	    }
	    public String getDescription() {
	        return Description;
	    }

	    public void setDescription(String Description) {
	    	this.Description = Description;
	    }
	    public String getPicUrl() {
	        return PicUrl;
	    }

	    public void setPicUrl(String PicUrl) {
	    	this.PicUrl = PicUrl;
	    }
	    public String getUrl() {
	        return Url;
	    }

	    public void setUrl(String Url) {
	    	this.Url = Url;
	    }
}