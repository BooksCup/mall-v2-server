package com.bc.mall.v2.server.utils;

import com.alibaba.fastjson.JSONObject;
import com.bc.mall.v2.server.entity.User;


/**
 * 微信工具类
 *
 * @author zhou
 */
public class WechatUtil {

    private static final String OPENID = "openid";
    private static final String SESSION_KEY = "session_key";

    /**
     * 获取微信用户(openid和session_key)
     *
     * @param appId     小程序唯一标识(在微信小程序管理后台获取)
     * @param appSecret 小程序的app secret(在微信小程序管理后台获取)
     * @param code      登录凭证
     *                  用户允许登录后，回调内容会带上code(有效期五分钟)，开发者需要将code发送到开发者服务器后台，
     *                  使用api将code换成openid和session_key
     * @return 微信用户(openid和session_key)
     */
    public static User getWechatUserInfo(String appId, String appSecret, String code) {
        // 授权类型(必填)
        String grantType = "authorization_code";
        // url
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appId
                + "&secret=" + appSecret + "&js_code=" + code + "&grant_type=" + grantType;
        // 发送请求
        String result = HttpUtil.doGet(url);
        JSONObject resultJson = JSONObject.parseObject(result);
        if (null != resultJson.get(OPENID) && null != resultJson.get(SESSION_KEY)) {
            User user = new User();
            user.setWxOpenid(resultJson.get(OPENID).toString());
            user.setWxSessionKey(resultJson.get(SESSION_KEY).toString());
            return user;
        }
        return null;
    }
}
