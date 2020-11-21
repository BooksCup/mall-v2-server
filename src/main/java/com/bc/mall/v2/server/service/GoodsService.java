package com.bc.mall.v2.server.service;

import com.bc.mall.v2.server.entity.Goods;
import com.bc.mall.v2.server.entity.GoodsImage;
import com.bc.mall.v2.server.entity.GoodsLabel;

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

    /**
     * 根据商品ID获取商品标签列表
     *
     * @param paramMap 参数map
     * @return 商品标签列表
     */
    List<GoodsLabel> getGoodsLabelListByGoodsId(Map<String, Object> paramMap);

    /**
     * 通过商品ID获取商品图片列表
     *
     * @param paramMap 参数map
     * @return 商品图片列表
     */
    List<GoodsImage> getGoodsImageListByGoodsId(Map<String, Object> paramMap);

}
