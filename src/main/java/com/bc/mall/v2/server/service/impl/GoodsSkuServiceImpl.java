package com.bc.mall.v2.server.service.impl;

import com.bc.mall.v2.server.entity.GoodsSku;
import com.bc.mall.v2.server.mapper.GoodsSkuMapper;
import com.bc.mall.v2.server.service.GoodsSkuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 商品SKU
 *
 * @author zhou
 */
@Service("goodsSkuService")
public class GoodsSkuServiceImpl implements GoodsSkuService {

    @Resource
    private GoodsSkuMapper goodsSkuMapper;

    /**
     * 新增商品SKU
     *
     * @param goodsSku 商品SKU
     */
    @Override
    public void addGoodsSku(GoodsSku goodsSku) {
        goodsSkuMapper.addGoodsSku(goodsSku);
    }

    /**
     * 获取商品SKU列表
     *
     * @param paramMap 参数map
     * @return 商品SKU列表
     */
    @Override
    public List<GoodsSku> getGoodsSkuListByGoodsId(Map<String, Object> paramMap) {
        return goodsSkuMapper.getGoodsSkuListByGoodsId(paramMap);
    }

}
