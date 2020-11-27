package com.bc.mall.v2.server.mapper;

import com.bc.mall.v2.server.entity.Goods;

import java.util.List;
import java.util.Map;

/**
 * 商品
 *
 * @author zhou
 */
public interface GoodsMapper {

    /**
     * 通过商品ID获取商品列表
     *
     * @param paramMap 参数map
     * @return 商品列表
     */
    List<Goods> getGoodsListByGoodsId(Map<String, Object> paramMap);

}
