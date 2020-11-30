package com.bc.mall.v2.server.entity;

import com.bc.mall.v2.server.utils.CommonUtil;

/**
 * 商品sku
 *
 * @author zhou
 */
public class GoodsSku {
    private String id;
    private String goodsId;
    private String costPrice;
    private String sellPrice;
    private String origPrice;
    private String image;
    private Integer totalStock;
    private Integer remainStock;
    private Integer warnStock;
    private String unit;
    private String attr;

    private String minSellPrice;
    private String maxSellPrice;

    public GoodsSku() {

    }

    public GoodsSku(String goodsId, String costPrice, String sellPrice,
                    String origPrice, String image, Integer totalStock,
                    Integer remainStock, Integer warnStock, String unit, String attr) {
        this.id = CommonUtil.generateId();
        this.goodsId = goodsId;
        this.costPrice = costPrice;
        this.sellPrice = sellPrice;
        this.origPrice = origPrice;
        this.image = image;
        this.totalStock = totalStock;
        this.remainStock = remainStock;
        this.warnStock = warnStock;
        this.unit = unit;
        this.attr = attr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(String costPrice) {
        this.costPrice = costPrice;
    }

    public String getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(String sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getOrigPrice() {
        return origPrice;
    }

    public void setOrigPrice(String origPrice) {
        this.origPrice = origPrice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getTotalStock() {
        return totalStock;
    }

    public void setTotalStock(Integer totalStock) {
        this.totalStock = totalStock;
    }

    public Integer getRemainStock() {
        return remainStock;
    }

    public void setRemainStock(Integer remainStock) {
        this.remainStock = remainStock;
    }

    public Integer getWarnStock() {
        return warnStock;
    }

    public void setWarnStock(Integer warnStock) {
        this.warnStock = warnStock;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    public String getMinSellPrice() {
        return minSellPrice;
    }

    public void setMinSellPrice(String minSellPrice) {
        this.minSellPrice = minSellPrice;
    }

    public String getMaxSellPrice() {
        return maxSellPrice;
    }

    public void setMaxSellPrice(String maxSellPrice) {
        this.maxSellPrice = maxSellPrice;
    }
}
