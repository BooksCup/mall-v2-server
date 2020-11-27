package com.bc.mall.v2.server.controller;

import com.bc.mall.v2.server.cons.Constant;
import com.bc.mall.v2.server.entity.Goods;
import com.bc.mall.v2.server.entity.GoodsLabel;
import com.bc.mall.v2.server.service.GoodsService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商品
 *
 * @author zhou
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);

    @Resource
    private GoodsService goodsService;

    /**
     * 获取商品详情
     *
     * @param goodsId 商品ID
     * @return ResponseEntity<Goods>
     */
    @ApiOperation(value = "获取商品详情", notes = "获取商品详情")
    @GetMapping(value = "/{goodsId}")
    public ResponseEntity<Goods> getGoodsDetail(
            @PathVariable String goodsId) {
        ResponseEntity<Goods> responseEntity;
        try {
            Map<String, Object> paramMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);
            paramMap.put("goodsId", goodsId);
            Goods goods = goodsService.getGoodsByGoodsId(paramMap);

            List<GoodsLabel> goodsLabelList = goodsService.getGoodsLabelListByGoodsId(paramMap);
            goods.setGoodsLabelList(goodsLabelList);
            responseEntity = new ResponseEntity<>(goods, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("[getGoodsDetail] error: " + e.getMessage());
            responseEntity = new ResponseEntity<>(new Goods(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
