package com.bc.mall.v2.server.service.impl;

import com.bc.mall.v2.server.cons.Constant;
import com.bc.mall.v2.server.entity.UserAddress;
import com.bc.mall.v2.server.mapper.UserAddressMapper;
import com.bc.mall.v2.server.service.UserAddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户收货地址
 *
 * @author zhou
 */
@Service("userAddressService")
public class UserAddressServiceImpl implements UserAddressService {

    @Resource
    private UserAddressMapper userAddressMapper;

    /**
     * 新增用户收货地址
     *
     * @param userAddress 用户收货地址
     */
    @Override
    public void addUserAddress(UserAddress userAddress) {
        userAddressMapper.addUserAddress(userAddress);
    }

    /**
     * 修改用户收货地址
     *
     * @param userAddress 用户收货地址
     */
    @Override
    public void updateUserAddress(UserAddress userAddress) {
        userAddressMapper.updateUserAddress(userAddress);
    }

    /**
     * 获取用户收货地址列表
     *
     * @param userId 用户ID
     * @return 用户收货地址列表
     */
    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        return userAddressMapper.getUserAddressList(userId);
    }

    /**
     * 删除用户收货地址
     *
     * @param addressId 地址ID
     */
    @Override
    public void deleteUserAddress(String addressId) {
        userAddressMapper.deleteUserAddress(addressId);
    }

    /**
     * 重置用户默认收货地址(全置为非默认)
     *
     * @param userId 用户ID
     */
    @Override
    public void resetDefUserAddress(String userId) {
        Map<String, Object> paramMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);
        paramMap.put("userId", userId);
        paramMap.put("isDefault", Constant.IS_DEFAULT_FALSE);
        userAddressMapper.resetDefUserAddress(paramMap);
    }

    /**
     * 根据地址ID获取收货地址
     *
     * @param addressId 地址ID
     * @return 收货地址
     */
    @Override
    public UserAddress getUserAddressById(String addressId) {
        return userAddressMapper.getUserAddressById(addressId);
    }
}
