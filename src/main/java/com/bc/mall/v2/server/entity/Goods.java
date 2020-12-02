package com.bc.mall.v2.server.entity;

import java.util.List;

/**
 * 商品
 *
 * @author zhou
 */
public class Goods {
    private String id;
    private String storeId;
    private String name;
    private String sellPrice;
    private String content;
    private Integer salesVolume;
    private String shopId;
    private Shop shop;
    private List<GoodsLabel> goodsLabelList;
    private List<GoodsImage> goodsImageList;
    private List<GoodsSku> goodsSkuList;

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

    public String getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(String sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(Integer salesVolume) {
        this.salesVolume = salesVolume;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public List<GoodsLabel> getGoodsLabelList() {
        return goodsLabelList;
    }

    public void setGoodsLabelList(List<GoodsLabel> goodsLabelList) {
        this.goodsLabelList = goodsLabelList;
    }

    public List<GoodsImage> getGoodsImageList() {
        return goodsImageList;
    }

    public void setGoodsImageList(List<GoodsImage> goodsImageList) {
        this.goodsImageList = goodsImageList;
    }

    public List<GoodsSku> getGoodsSkuList() {
        return goodsSkuList;
    }

    public void setGoodsSkuList(List<GoodsSku> goodsSkuList) {
        this.goodsSkuList = goodsSkuList;
    }
}
