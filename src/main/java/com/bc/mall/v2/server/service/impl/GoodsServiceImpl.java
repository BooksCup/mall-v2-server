package com.bc.mall.v2.server.service.impl;

import com.bc.mall.v2.server.entity.Goods;
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

    @Override
    public Goods getGoodsByGoodsId(Map<String, Object> paramMap) {
        List<Goods> goodsList =  goodsMapper.getGoodsListByGoodsId(paramMap);
        if(!CollectionUtils.isEmpty(goodsList)){
            return goodsList.get(0);
        }
        return null;
    }
}
