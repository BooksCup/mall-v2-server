package com.bc.mall.v2.server.mapper;

import com.bc.mall.v2.server.entity.GoodsSku;

import java.util.List;
import java.util.Map;

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

    /**
     * 获取商品SKU列表
     *
     * @param paramMap 参数map
     * @return 商品SKU列表
     */
    List<GoodsSku> getGoodsSkuListByGoodsId(Map<String, Object> paramMap);

    /**
     * 获取商品默认规格(用于商品详情页规格模块的加载)
     *
     * @param goodsId 商品ID
     * @return 商品默认规格
     */
    GoodsSku getGoodsDefSku(String goodsId);
}
