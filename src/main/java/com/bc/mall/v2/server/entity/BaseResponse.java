package com.bc.mall.v2.server.entity;

/**
 * 基础entity
 *
 * @author zhou
 */
public class BaseResponse {
    private String responseCode;
    private String responseMessage;

    public BaseResponse(){

    }

    public BaseResponse(String responseCode, String responseMessage) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
    }

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
