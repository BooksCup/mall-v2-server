package com.bc.mall.v2.server.mapper;

import com.bc.mall.v2.server.entity.UserAddress;

/**
 * 用户收货地址
 *
 * @author zhou
 */
public interface UserAddressMapper {

    /**
     * 新增用户收货地址
     *
     * @param userAddress 用户收货地址
     */
    void addUserAddress(UserAddress userAddress);
}
