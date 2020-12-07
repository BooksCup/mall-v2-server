package com.bc.mall.v2.server.controller;

import com.bc.mall.v2.server.cons.Constant;
import com.bc.mall.v2.server.entity.*;
import com.bc.mall.v2.server.enums.ResponseMsg;
import com.bc.mall.v2.server.service.GoodsService;
import com.bc.mall.v2.server.service.GoodsSkuService;
import com.bc.mall.v2.server.service.ShopService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
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

    @Resource
    private ShopService shopService;

    /**
     * 获取猜你喜欢商品列表
     *
     * @param storeId 商城ID
     * @param page    当前分页数
     * @param limit   分页大小
     * @return ResponseEntity
     */
    @ApiOperation(value = "获取猜你喜欢商品列表", notes = "获取猜你喜欢商品列表")
    @GetMapping(value = "/like")
    public ResponseEntity<List<Goods>> getLikeGoodsList(
            @RequestParam String storeId,
            @RequestParam(required = false, defaultValue = "1") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer limit) {
        logger.info("[getLikeGoodsList] storeId: " +
                storeId + ", page: " + page + ", limit: " + limit);
        ResponseEntity<List<Goods>> responseEntity;
        try {
            Map<String, Object> paramMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);
            paramMap.put("storeId", storeId);
            List<Goods> likeGoodsList = goodsService.getLikeGoodsList(page, limit, paramMap);
            responseEntity = new ResponseEntity<>(likeGoodsList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("[getLikeGoodsList] error: " + e.getMessage());
            responseEntity = new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

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

            // 默认商品SKU,eg:默认价格,库存,图片etc.
            GoodsSku defGoodsSku = goodsSkuService.getGoodsDefSku(goodsId);
            if (null != defGoodsSku.getMaxSellPrice() &&
                    defGoodsSku.getMaxSellPrice().equals(defGoodsSku.getMinSellPrice())) {
                goods.setSellPrice(defGoodsSku.getMaxSellPrice());
            } else {
                goods.setSellPrice(defGoodsSku.getMinSellPrice() + "-" + defGoodsSku.getMaxSellPrice());
            }

            // 店铺信息
            if (!StringUtils.isEmpty(goods.getShopId())) {
                paramMap.clear();
                paramMap.put("shopId", goods.getShopId());
                Shop shop = shopService.getShopByShopId(paramMap);
                if (null != shop) {
                    goods.setShop(shop);
                }
            }

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
