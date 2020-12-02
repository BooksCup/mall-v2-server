package com.bc.mall.v2.server.entity;

import java.util.List;

/**
 * 店铺
 *
 * @author zhou
 */
public class Shop {
    private String id;
    private String storeId;
    private String name;
    private String isOpen;
    private String logo;
    /**
     * 在售商品数量
     */
    private Integer onSaleGoodsNum;

    /**
     * 总销量
     */
    private Integer totalSalesVolume;

    /**
     * 店铺关注人数
     */
    private Integer followNum;

    private List<Goods> goodsList;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(String isOpen) {
        this.isOpen = isOpen;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Integer getOnSaleGoodsNum() {
        return onSaleGoodsNum;
    }

    public void setOnSaleGoodsNum(Integer onSaleGoodsNum) {
        this.onSaleGoodsNum = onSaleGoodsNum;
    }

    public Integer getTotalSalesVolume() {
        return totalSalesVolume;
    }

    public void setTotalSalesVolume(Integer totalSalesVolume) {
        this.totalSalesVolume = totalSalesVolume;
    }

    public Integer getFollowNum() {
        return followNum;
    }

    public void setFollowNum(Integer followNum) {
        this.followNum = followNum;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

}
