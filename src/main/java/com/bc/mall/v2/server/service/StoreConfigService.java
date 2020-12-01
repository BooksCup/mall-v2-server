package com.bc.mall.v2.server.service;


import com.bc.mall.v2.server.entity.StoreConfig;

/**
 * 店铺配置
 *
 * @author zhou
 */
public interface StoreConfigService {

    /**
     * 根据店铺ID获取店铺配置
     *
     * @param storeId 店铺ID
     * @return 店铺配置
     */
    StoreConfig getStoreConfigByStoreId(String storeId);

}
