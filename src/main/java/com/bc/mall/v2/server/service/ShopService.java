package com.bc.mall.v2.server.service;

import com.bc.mall.v2.server.entity.Shop;

import java.util.List;
import java.util.Map;

/**
 * 店铺
 *
 * @author zhou
 */
public interface ShopService {

    /**
     * 根据店铺ID查询店铺
     *
     * @param paramMap 参数map
     * @return 店铺
     */
    Shop getShopByShopId(Map<String, Object> paramMap);

}
