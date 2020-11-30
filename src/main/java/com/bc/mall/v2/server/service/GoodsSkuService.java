package com.bc.mall.v2.server.service;

import com.bc.mall.v2.server.entity.GoodsSku;

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

}
