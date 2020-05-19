package com.mrkb.common.utils.weixinservice;

import java.awt.List;


import com.mrkb.common.utils.paycomme.WeixinOauth2Token;
import com.mrkb.common.utils.weixinutils.CommonUtil;
import com.mrkb.dao.modle.weixin.oauth.SNSUserInfo;
import com.mrkb.dao.modle.weixin.oauth.WeixinUserInfo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;




/**
* 类名: WeixinUserInfoService 
* 描述: 获取微信的用户信息 
* 开发人员： 万祖权 
* 创建时间： 2018-1-1 
 */
public class WeixinUserInfoService {
	
	
/**
 * 获取用户信息
 * @param accessToken 接口访问凭证
 * @param openId 用户标识
 * @return WeixinUserInfo
 */
public static WeixinUserInfo getUserInfo(String accessToken, String openId) {
    WeixinUserInfo weixinUserInfo = null;
    // 拼接请求地址
    String requestUrl = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID";
    requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openId);
    // 获取用户信息
    JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);

    if (null != jsonObject) {
        try {
            weixinUserInfo = new WeixinUserInfo();
            // 用户的标识
            weixinUserInfo.setOpenId(jsonObject.getString("openid"));
            // 关注状态（1是关注，0是未关注），未关注时获取不到其余信息
            weixinUserInfo.setSubscribe(jsonObject.getInt("subscribe"));
            // 用户关注时间
            weixinUserInfo.setSubscribeTime(jsonObject.getString("subscribe_time"));
            // 昵称
            weixinUserInfo.setNickname(jsonObject.getString("nickname"));
            // 用户的性别（1是男性，2是女性，0是未知）
            weixinUserInfo.setSex(jsonObject.getInt("sex"));
            // 用户所在国家
            weixinUserInfo.setCountry(jsonObject.getString("country"));
            // 用户所在省份
            weixinUserInfo.setProvince(jsonObject.getString("province"));
            // 用户所在城市
            weixinUserInfo.setCity(jsonObject.getString("city"));
            // 用户的语言，简体中文为zh_CN
            weixinUserInfo.setLanguage(jsonObject.getString("language"));
            // 用户头像
            weixinUserInfo.setHeadImgUrl(jsonObject.getString("headimgurl"));
        } catch (Exception e) {
            if (0 == weixinUserInfo.getSubscribe()) {
               // Logger.("用户{}已取消关注");
                weixinUserInfo.getOpenId();
            } else {
                int errorCode = jsonObject.getInt("errcode");
                String errorMsg = jsonObject.getString("errmsg");
               // log.error("获取用户信息失败 errcode:{} errmsg:{}", errorCode, errorMsg);
            }
        }
    }
    return weixinUserInfo;
}



/**
 * 获取网页授权凭证     获取到token值
 * 
 * @param appId 公众账号的唯一标识
 * @param appSecret 公众账号的密钥
 * @param code
 * @return WeixinAouth2Token
 */
public static WeixinOauth2Token getOauth2AccessToken(String appId, String appSecret, String code) {
    WeixinOauth2Token wat = null;
    // 拼接请求地址
    String requestUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
    requestUrl = requestUrl.replace("APPID", appId);
    requestUrl = requestUrl.replace("SECRET", appSecret);
    requestUrl = requestUrl.replace("CODE", code);
    // 获取网页授权凭证
    JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);
    if (null != jsonObject) {
        try {
            wat = new WeixinOauth2Token();
            wat.setAccessToken(jsonObject.getString("access_token"));
            wat.setExpiresIn(jsonObject.getInt("expires_in"));
            wat.setRefreshToken(jsonObject.getString("refresh_token"));
            wat.setOpenId(jsonObject.getString("openid"));
            wat.setScope(jsonObject.getString("scope"));
        } catch (Exception e) {
            wat = null;
            int errorCode = jsonObject.getInt("errcode");
            String errorMsg = jsonObject.getString("errmsg");
          //  log.error("获取网页授权凭证失败 errcode:{} errmsg:{}", errorCode, errorMsg);
        }
    }
    return wat;
}

/**
 * 通过网页授权获取用户信息
 * 
 * @param accessToken 网页授权接口调用凭证
 * @param openId 用户标识
 * @return SNSUserInfo
 */

/**获取的json对象，列如
 * {    "openid":" OPENID",
" nickname": NICKNAME,
"sex":"1",
"province":"PROVINCE"
"city":"CITY",
"country":"COUNTRY",
"headimgurl":    "http://wx.qlogo.cn/mmopen/g3MonUZtNHkdmzicIlibx6iaFqAc56vxLSUfpb6n5WKSYVY0ChQKkiaJSgQ1dZuTOgvLLrhJbERQQ4eMsv84eavHiaiceqxibJxCfHe/46",
"privilege":[ "PRIVILEGE1" "PRIVILEGE2"     ],
"unionid": "o6_bmasdasdsad6_2sgVt7hMZOPfL"
}* 
 * **/
@SuppressWarnings( { "deprecation", "unchecked" })
public static SNSUserInfo getSNSUserInfo(String accessToken, String openId) {
    SNSUserInfo snsUserInfo = null;
    // 拼接请求地址
    String requestUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID";
    requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openId);
    // 通过网页授权获取用户信息
    JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);

    if (null != jsonObject) {
        try {
            snsUserInfo = new SNSUserInfo();
            // 用户的标识
            snsUserInfo.setOpenId(jsonObject.getString("openid"));
            // 昵称
            snsUserInfo.setNickname(jsonObject.getString("nickname"));
            // 性别（1是男性，2是女性，0是未知）
            snsUserInfo.setSex(jsonObject.getInt("sex"));
            // 用户所在国家
            snsUserInfo.setCountry(jsonObject.getString("country"));
            // 用户所在省份
            snsUserInfo.setProvince(jsonObject.getString("province"));
            // 用户所在城市
            snsUserInfo.setCity(jsonObject.getString("city"));
            // 用户头像
            snsUserInfo.setHeadImgUrl(jsonObject.getString("headimgurl"));
            // 用户特权信息
            snsUserInfo.setPrivilegeList(JSONArray.toList(jsonObject.getJSONArray("privilege"), List.class));
        } catch (Exception e) {
            snsUserInfo = null;
            int errorCode = jsonObject.getInt("errcode");
            String errorMsg = jsonObject.getString("errmsg");
            //log.error("获取用户信息失败 errcode:{} errmsg:{}", errorCode, errorMsg);
        }
    }
    return snsUserInfo;
}
}