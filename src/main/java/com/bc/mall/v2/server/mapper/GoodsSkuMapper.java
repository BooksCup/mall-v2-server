package com.bc.mall.v2.server.mapper;

import com.bc.mall.v2.server.entity.GoodsSku;

/**
 * 商品sku
 *
 * @author zhou
 */
public interface GoodsSkuMapper {

    /**
     * 新增商品SKU
     *
     * @param goodsSku 商品SKU
     */
    void addGoodsSku(GoodsSku goodsSku);

}
