package com.bc.mall.v2.server.mapper;

import com.bc.mall.v2.server.entity.UserAddress;

import java.util.List;

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

    /**
     * 获取用户收货地址列表
     *
     * @param userId 用户ID
     * @return 用户收货地址列表
     */
    List<UserAddress> getUserAddressList(String userId);
}
