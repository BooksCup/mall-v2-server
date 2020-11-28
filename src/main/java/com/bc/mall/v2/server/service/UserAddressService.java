package com.bc.mall.v2.server.service;

import com.bc.mall.v2.server.entity.UserAddress;

import java.util.List;

/**
 * 用户收货地址
 *
 * @author zhou
 */
public interface UserAddressService {

    /**
     * 新增用户收货地址
     *
     * @param userAddress 用户收货地址
     */
    void addUserAddress(UserAddress userAddress);

    /**
     * 修改用户收货地址
     *
     * @param userAddress 用户收货地址
     */
    void updateUserAddress(UserAddress userAddress);

    /**
     * 获取用户收货地址列表
     *
     * @param userId 用户ID
     * @return 用户收货地址列表
     */
    List<UserAddress> getUserAddressList(String userId);

    /**
     * 删除用户收货地址
     *
     * @param addressId 地址ID
     */
    void deleteUserAddress(String addressId);

    /**
     * 重置用户默认收货地址(全置为非默认)
     *
     * @param userId 用户ID
     */
    void resetDefUserAddress(String userId);

}
