package com.bc.mall.v2.server.service;


import com.bc.mall.v2.server.entity.GoodsClass;

import java.util.List;
import java.util.Map;

/**
 * 商品类别
 *
 * @author zhou
 */
public interface GoodsClassService {
    /**
     * 获取商品类别列表
     *
     * @param paramMap 参数map
     * @return 商品类别列表
     */
    List<GoodsClass> getGoodsClassList(Map<String, Object> paramMap);
}
