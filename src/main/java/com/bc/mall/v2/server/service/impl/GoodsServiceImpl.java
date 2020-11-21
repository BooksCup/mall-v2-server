package com.bc.mall.v2.server.service.impl;

import com.bc.mall.v2.server.entity.Goods;
import com.bc.mall.v2.server.entity.GoodsImage;
import com.bc.mall.v2.server.entity.GoodsLabel;
import com.bc.mall.v2.server.mapper.GoodsLabelMapper;
import com.bc.mall.v2.server.mapper.GoodsMapper;
import com.bc.mall.v2.server.service.GoodsService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 商品
 *
 * @author zhou
 */
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsMapper goodsMapper;

    @Resource
    private GoodsLabelMapper goodsLabelMapper;

    /**
     * 通过商品ID获取商品
     *
     * @param paramMap 参数map
     * @return 商品
     */
    @Override
    public Goods getGoodsByGoodsId(Map<String, Object> paramMap) {
        List<Goods> goodsList = goodsMapper.getGoodsListByGoodsId(paramMap);
        if (!CollectionUtils.isEmpty(goodsList)) {
            return goodsList.get(0);
        }
        return null;
    }

    /**
     * 根据商品ID获取商品标签列表
     *
     * @param paramMap 参数map
     * @return 商品标签列表
     */
    @Override
    public List<GoodsLabel> getGoodsLabelListByGoodsId(Map<String, Object> paramMap) {
        return goodsLabelMapper.getGoodsLabelListByGoodsId(paramMap);
    }

    /**
     * 通过商品ID获取商品图片列表
     *
     * @param paramMap 参数map
     * @return 商品图片列表
     */
    @Override
    public List<GoodsImage> getGoodsImageListByGoodsId(Map<String, Object> paramMap) {
        return goodsMapper.getGoodsImageListByGoodsId(paramMap);
    }
}
