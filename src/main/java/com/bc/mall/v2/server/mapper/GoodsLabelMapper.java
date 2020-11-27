package com.bc.mall.v2.server.mapper;

import com.bc.mall.v2.server.entity.GoodsLabel;

import java.util.List;
import java.util.Map;

/**
 * 商品标签
 *
 * @author zhou
 */
public interface GoodsLabelMapper {

    /**
     * 根据商品ID获取商品标签列表
     *
     * @param paramMap 参数map
     * @return 商品标签列表
     */
    List<GoodsLabel> getGoodsLabelListByGoodsId(Map<String, Object> paramMap);
}
