package com.mrkb.dao.modle.weixin.often;

public class QRcodeModel {
	 // 图片路径
		public String imageUrl;
	    // 凭证有效期，单位：秒
	    public int expiresInImageUrl;

	    public String expiresInDataTimeImageUrl;
	    
	    public String openid;//微信ID
	    
	    public String getOpenid() {
			return openid;
		}

		public void setOpenid(String openid) {
			this.openid = openid;
		}

		public String getimageUrl() {
	        return imageUrl;
	    }

	    public void setimageUrl(String imageUrl) {
	        this.imageUrl = imageUrl;
	    }

	    public int getExpiresIn() {
	        return expiresInImageUrl;
	    }

	    public void setexpiresInImageUrl(int expiresInImageUrl) {
	        this.expiresInImageUrl = expiresInImageUrl;
	    }
	  
	    public String getexpiresInDataTimeImageUrl() {
	        return expiresInDataTimeImageUrl;
	    }
	    public void setexpiresInDataTimeImageUrl(String expiresInDataTimeImageUrl) {
	        this.expiresInDataTimeImageUrl = expiresInDataTimeImageUrl;
}}
