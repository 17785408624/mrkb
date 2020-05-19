package com.mrkb.dao.modle.weixin.oauth;


/**
* 类名: UserinfoToken 
* 描述:  授权凭证  
* 开发人员： 万祖权 
* 创建时间：  2018-1-1 
 */
public class UserinfoToken {
    // 接口访问凭证
    private String accessToken;
    // 凭证有效期，单位：秒
    private int expiresIn;

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
}
