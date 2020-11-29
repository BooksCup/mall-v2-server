package com.bc.mall.v2.server.entity.pay;

import com.bc.mall.v2.server.entity.BaseResponse;

import java.util.Map;

/**
 * 微信预支付参数
 *
 * @author zhou
 */
public class WechatPrepayParam extends BaseResponse {

    private Map<String, String> prePayMap;

    public WechatPrepayParam() {

    }

    public WechatPrepayParam(String responseCode, String responseMessage) {
        super(responseCode, responseMessage);
    }

    public WechatPrepayParam(String responseCode, String responseMessage, Map<String, String> prePayMap) {
        super(responseCode, responseMessage);
        this.prePayMap = prePayMap;
    }

    public Map<String, String> getPrePayMap() {
        return prePayMap;
    }

    public void setPrePayMap(Map<String, String> prePayMap) {
        this.prePayMap = prePayMap;
    }
}
