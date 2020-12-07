package com.bc.mall.v2.server.service.impl;

import com.bc.mall.v2.server.entity.GoodsClass;
import com.bc.mall.v2.server.mapper.GoodsClassMapper;
import com.bc.mall.v2.server.service.GoodsClassService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 商品类别
 *
 * @author zhou
 */
@Service("goodsClassService")
public class GoodsClassServiceImpl implements GoodsClassService {

    @Resource
    private GoodsClassMapper goodsClassMapper;

    /**
     * 获取商品类别列表
     *
     * @param paramMap 参数map
     * @return 商品类别列表
     */
    @Override
    public List<GoodsClass> getGoodsClassList(Map<String, Object> paramMap) {
        return goodsClassMapper.getGoodsClassList(paramMap);
    }
}
