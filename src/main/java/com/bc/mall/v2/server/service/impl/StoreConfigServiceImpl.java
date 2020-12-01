package com.bc.mall.v2.server.service.impl;

import com.bc.mall.v2.server.entity.StoreConfig;
import com.bc.mall.v2.server.mapper.StoreConfigMapper;
import com.bc.mall.v2.server.service.StoreConfigService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * 店铺配置
 *
 * @author zhou
 */
@Service("storeConfigService")
public class StoreConfigServiceImpl implements StoreConfigService {

    @Resource
    private StoreConfigMapper storeConfigMapper;

    /**
     * 根据店铺ID获取店铺配置
     *
     * @param storeId 店铺ID
     * @return 店铺配置
     */
    @Override
    public StoreConfig getStoreConfigByStoreId(String storeId) {
        List<StoreConfig> storeConfigList = storeConfigMapper.getStoreConfigListByStoreId(storeId);
        if (!CollectionUtils.isEmpty(storeConfigList)) {
            return storeConfigList.get(0);
        }
        return null;
    }
}
