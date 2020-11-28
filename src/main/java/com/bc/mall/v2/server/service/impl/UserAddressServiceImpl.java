package com.bc.mall.v2.server.service.impl;

import com.bc.mall.v2.server.entity.UserAddress;
import com.bc.mall.v2.server.mapper.UserAddressMapper;
import com.bc.mall.v2.server.service.UserAddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
}
