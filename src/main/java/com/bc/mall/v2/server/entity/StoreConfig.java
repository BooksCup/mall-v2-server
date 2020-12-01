package com.bc.mall.v2.server.entity;

/**
 * 店铺配置信息
 *
 * @author zhou
 */
public class StoreConfig {
    private String id;
    private String storeId;
    private String appId;
    private String appSecret;
    private String wxDefaultName;
    private String wxDefaultAvatar;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getWxDefaultName() {
        return wxDefaultName;
    }

    public void setWxDefaultName(String wxDefaultName) {
        this.wxDefaultName = wxDefaultName;
    }

    public String getWxDefaultAvatar() {
        return wxDefaultAvatar;
    }

    public void setWxDefaultAvatar(String wxDefaultAvatar) {
        this.wxDefaultAvatar = wxDefaultAvatar;
    }
}
