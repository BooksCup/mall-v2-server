package com.bc.mall.v2.server.entity;

import com.bc.mall.v2.server.utils.CommonUtil;

import java.math.BigDecimal;

/**
 * 订单
 *
 * @author zhou
 */
public class Order {
    private String id;
    private String storeId;
    private String userId;
    private String goodsId;
    private String skuId;
    private String addressId;
    private Integer number;
    private BigDecimal totalAmount;
    private String status;
    private String remark;
    private String createTime;
    private String shopName;
    private String goodsName;

    public Order() {

    }

    public Order(String storeId, String userId, String goodsId, String skuId,
                 String addressId, Integer number, String remark) {
        this.id = CommonUtil.generateId();
        this.storeId = storeId;
        this.userId = userId;
        this.goodsId = goodsId;
        this.skuId = skuId;
        this.addressId = addressId;
        this.number = number;
        this.remark = remark;
    }

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
}
