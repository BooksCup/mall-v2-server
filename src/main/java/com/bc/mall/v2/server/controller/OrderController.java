package com.bc.mall.v2.server.controller;

import com.bc.mall.v2.server.entity.GoodsSku;
import com.bc.mall.v2.server.entity.Order;
import com.bc.mall.v2.server.enums.ResponseMsg;
import com.bc.mall.v2.server.service.GoodsSkuService;
import com.bc.mall.v2.server.service.OrderService;
import com.bc.mall.v2.server.utils.BigDecimalUtil;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * 订单
 *
 * @author zhou
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Resource
    private OrderService orderService;

    @Resource
    private GoodsSkuService goodsSkuService;

    @ApiOperation(value = "生成订单", notes = "生成订单")
    @PostMapping(value = "")
    public ResponseEntity<String> addOrder(
            @RequestParam String storeId,
            @RequestParam String userId,
            @RequestParam String goodsId,
            @RequestParam String skuId,
            @RequestParam String addressId,
            @RequestParam Integer number,
            @RequestParam String remark) {
        ResponseEntity<String> responseEntity;
        try {
            Order order = new Order(storeId, userId, goodsId, skuId, addressId, number, remark);

            // 计算总价
            GoodsSku goodsSku = goodsSkuService.getGoodsSkuBySkuId(skuId);
            if (null == goodsSku) {
                return new ResponseEntity<>(ResponseMsg.GOODS_SKU_NOT_EXISTS.getResponseCode(), HttpStatus.BAD_REQUEST);
            } else {
                BigDecimal totalAmount = BigDecimalUtil.multiply(goodsSku.getSellPrice(), number);
                order.setTotalAmount(totalAmount);
            }

            orderService.addOrder(order);
            responseEntity = new ResponseEntity<>(ResponseMsg.ADD_ORDER_SUCCESS.getResponseCode(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("[addOrder] error: " + e.getMessage());
            responseEntity = new ResponseEntity<>(ResponseMsg.ADD_ORDER_ERROR.getResponseCode(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;

    }

    @ApiOperation(value = "根据订单ID获取订单", notes = "根据订单ID获取订单")
    @GetMapping(value = "/{orderId}")
    public ResponseEntity<Order> getOrderById(
            @PathVariable String orderId) {
        logger.info("[getOrderById] orderId: " + orderId);
        ResponseEntity<Order> responseEntity;
        try {
            Order order = orderService.getOrderById(orderId);
            responseEntity = new ResponseEntity<>(order, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("[getOrderById] error: " + e.getMessage());
            responseEntity = new ResponseEntity<>(new Order(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;

    }
}
