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

    ADD_USER_ADDRESS_SUCCESS("ADD_USER_ADDRESS_SUCCESS", "新增收货地址成功!"),
    ADD_USER_ADDRESS_ERROR("ADD_USER_ADDRESS_ERROR", "新增收货地址失败!"),

    UPDATE_USER_ADDRESS_SUCCESS("UPDATE_USER_ADDRESS_SUCCESS", "修改收货地址成功!"),
    UPDATE_USER_ADDRESS_ERROR("UPDATE_USER_ADDRESS_ERROR", "修改收货地址失败!"),

    DELETE_USER_ADDRESS_SUCCESS("DELETE_USER_ADDRESS_SUCCESS", "删除收货地址成功!"),
    DELETE_USER_ADDRESS_ERROR("DELETE_USER_ADDRESS_ERROR", "删除收货地址失败!"),
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
