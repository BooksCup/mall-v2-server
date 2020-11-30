package com.bc.mall.v2.server.controller;

import com.bc.mall.v2.server.cons.Constant;
import com.bc.mall.v2.server.entity.Goods;
import com.bc.mall.v2.server.entity.GoodsImage;
import com.bc.mall.v2.server.entity.GoodsLabel;
import com.bc.mall.v2.server.entity.GoodsSku;
import com.bc.mall.v2.server.enums.ResponseMsg;
import com.bc.mall.v2.server.service.GoodsService;
import com.bc.mall.v2.server.service.GoodsSkuService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @Resource
    private GoodsSkuService goodsSkuService;

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

            // 商品标签
            List<GoodsLabel> goodsLabelList = goodsService.getGoodsLabelListByGoodsId(paramMap);
            goods.setGoodsLabelList(goodsLabelList);

            // 商品图片
            List<GoodsImage> goodsImageList = goodsService.getGoodsImageListByGoodsId(paramMap);
            goods.setGoodsImageList(goodsImageList);

            // 商品SKU
            List<GoodsSku> goodsSkuList = goodsSkuService.getGoodsSkuListByGoodsId(paramMap);
            goods.setGoodsSkuList(goodsSkuList);

            responseEntity = new ResponseEntity<>(goods, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("[getGoodsDetail] error: " + e.getMessage());
            responseEntity = new ResponseEntity<>(new Goods(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    /**
     * 新增商品SKU
     *
     * @param goodsId 商品ID
     * @return ResponseEntity<Goods>
     */
    @ApiOperation(value = "新增商品SKU", notes = "新增商品SKU")
    @PostMapping(value = "/{goodsId}/sku")
    public ResponseEntity<String> addGoodsSku(
            @PathVariable String goodsId,
            @RequestParam String costPrice,
            @RequestParam String sellPrice,
            @RequestParam String origPrice,
            @RequestParam String image,
            @RequestParam Integer totalStock,
            @RequestParam Integer remainStock,
            @RequestParam Integer warnStock,
            @RequestParam String unit,
            @RequestParam String attr) {
        ResponseEntity<String> responseEntity;
        try {
            GoodsSku goodsSku = new GoodsSku(goodsId, costPrice, sellPrice,
                    origPrice, image, totalStock,
                    remainStock, warnStock, unit, attr);
            goodsSkuService.addGoodsSku(goodsSku);
            responseEntity = new ResponseEntity<>(ResponseMsg.ADD_GOODS_SKU_SUCCESS.getResponseCode(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("[addGoodsSku] error: " + e.getMessage());
            responseEntity = new ResponseEntity<>(ResponseMsg.ADD_GOODS_SKU_ERROR.getResponseCode(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
