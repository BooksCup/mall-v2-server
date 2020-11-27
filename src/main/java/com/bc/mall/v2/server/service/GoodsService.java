package com.bc.mall.v2.server.service;

import com.bc.mall.v2.server.entity.Goods;

import java.util.List;
import java.util.Map;

/**
 * 商品
 *
 * @author zhou
 */
public interface GoodsService {

    /**
     * 通过商品ID获取商品
     *
     * @param paramMap 参数map
     * @return 商品
     */
    Goods getGoodsByGoodsId(Map<String, Object> paramMap);

}
