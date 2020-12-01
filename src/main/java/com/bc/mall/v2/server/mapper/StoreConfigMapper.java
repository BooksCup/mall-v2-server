package com.bc.mall.v2.server.mapper;


import com.bc.mall.v2.server.entity.StoreConfig;

import java.util.List;

/**
 * 店铺配置
 *
 * @author zhou
 */
public interface StoreConfigMapper {

    /**
     * 根据店铺ID获取店铺配置列表
     *
     * @param storeId 店铺ID
     * @return 店铺配置列表
     */
    List<StoreConfig> getStoreConfigListByStoreId(String storeId);

}
