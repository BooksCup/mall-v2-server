package com.bc.mall.v2.server.entity;

import com.bc.mall.v2.server.utils.CommonUtil;

/**
 * 用户地址
 *
 * @author zhou
 */
public class UserAddress {
    private String id;
    private String userId;
    private String name;
    private String phone;
    private String province;
    private String city;
    private String district;
    private String address;
    private String isDefault;
    private String createTime;

    public UserAddress() {

    }

    public UserAddress(String userId, String name, String phone, String province,
                       String city, String district, String address, String isDefault) {
        this.id = CommonUtil.generateId();
        this.userId = userId;
        this.name = name;
        this.phone = phone;
        this.province = province;
        this.city = city;
        this.district = district;
        this.address = address;
        this.isDefault = isDefault;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
