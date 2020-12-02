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

    /**
     * 获取商品默认规格(用于商品详情页规格模块的加载)
     *
     * @param goodsId 商品ID
     * @return 商品默认规格
     */
    @Override
    public GoodsSku getGoodsDefSku(String goodsId) {
        return goodsSkuMapper.getGoodsDefSku(goodsId);
    }

    /**
     * 根据skuId获取商品sku
     *
     * @param skuId skuId
     * @return 商品sku
     */
    @Override
    public GoodsSku getGoodsSkuBySkuId(String skuId) {
        return goodsSkuMapper.getGoodsSkuBySkuId(skuId);
    }

}
