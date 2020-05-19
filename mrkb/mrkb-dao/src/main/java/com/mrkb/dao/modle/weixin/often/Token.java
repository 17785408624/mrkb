package com.mrkb.dao.modle.weixin.often;
/**
* 类名: Token 
* 描述: 凭证,操作微信公众号的一把钥匙 
* 开发人员： 万祖权 
* 创建时间：  2017-12-16 
 */
public class Token {
    // 接口访问凭证
	public String accessToken;
    // 凭证有效期，单位：秒
    public int expiresIn;

    public String expiresInDataTime;
    
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }
   // public String setexpiresInDataTime(String expiresInDataTime) {
   // 	return  expiresInDataTime;
    //}
    
    public void setexpiresInDataTime(String expiresInDataTime) {
        this.expiresInDataTime = expiresInDataTime;
    }

}