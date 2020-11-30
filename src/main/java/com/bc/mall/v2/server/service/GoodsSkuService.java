package com.bc.mall.v2.server.service;

import com.bc.mall.v2.server.entity.GoodsSku;

import java.util.List;
import java.util.Map;

/**
 * 商品SKU
 *
 * @author zhou
 */
public interface GoodsSkuService {

    /**
     * 新增商品SKU
     *
     * @param goodsSku 商品SKU
     */
    void addGoodsSku(GoodsSku goodsSku);

    /**
     * 获取商品SKU列表
     *
     * @param paramMap 参数map
     * @return 商品SKU列表
     */
    List<GoodsSku> getGoodsSkuListByGoodsId(Map<String, Object> paramMap);
}
