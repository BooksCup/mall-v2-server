package com.bc.mall.v2.server.entity;

/**
 * 首页轮播图
 *
 * @author zhou
 */
public class Banner {
    private String id;
    private String storeId;
    private String storeType;
    private String image;
    private String linkType;
    private String linkRoute;
    private String linkUrl;

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

    public String getStoreType() {
        return storeType;
    }

    public void setStoreType(String storeType) {
        this.storeType = storeType;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLinkType() {
        return linkType;
    }

    public void setLinkType(String linkType) {
        this.linkType = linkType;
    }

    public String getLinkRoute() {
        return linkRoute;
    }

    public void setLinkRoute(String linkRoute) {
        this.linkRoute = linkRoute;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }
}
