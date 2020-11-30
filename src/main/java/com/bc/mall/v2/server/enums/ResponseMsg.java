package com.bc.mall.v2.server.enums;

/**
 * 返回消息
 *
 * @author zhou
 */
public enum ResponseMsg {

    /**
     * mall-server接口返回信息
     */
    ADD_GOODS_SKU_SUCCESS("ADD_GOODS_SKU_SUCCESS", "新增商品SKU成功!"),
    ADD_GOODS_SKU_ERROR("ADD_GOODS_SKU_ERROR", "新增商品SKU失败!"),
    ;

    ResponseMsg(String responseCode, String responseMessage) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
    }

    private String responseCode;
    private String responseMessage;

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
