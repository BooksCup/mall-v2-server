package com.bc.mall.v2.server.controller;

import com.bc.mall.v2.server.cons.Constant;
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
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<Order> addOrder(
            @RequestParam String storeId,
            @RequestParam String userId,
            @RequestParam String goodsId,
            @RequestParam String skuId,
            @RequestParam String addressId,
            @RequestParam Integer number,
            @RequestParam String remark) {
        ResponseEntity<Order> responseEntity;
        try {
            Order order = new Order(storeId, userId, goodsId, skuId, addressId, number, remark);

            // 计算总价
            GoodsSku goodsSku = goodsSkuService.getGoodsSkuBySkuId(skuId);
            if (null == goodsSku) {
                return new ResponseEntity<>(new Order(
                        ResponseMsg.GOODS_SKU_NOT_EXISTS.getResponseCode(),
                        ResponseMsg.GOODS_SKU_NOT_EXISTS.getResponseMessage()), HttpStatus.BAD_REQUEST);
            } else {
                BigDecimal totalAmount = BigDecimalUtil.multiply(goodsSku.getSellPrice(), number);
                order.setTotalAmount(totalAmount);
            }
            orderService.addOrder(order);
            order.setResponseCode(ResponseMsg.ADD_ORDER_SUCCESS.getResponseCode());
            order.setResponseMessage(ResponseMsg.ADD_ORDER_SUCCESS.getResponseMessage());
            responseEntity = new ResponseEntity<>(order, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("[addOrder] error: " + e.getMessage());
            responseEntity = new ResponseEntity<>(new Order(
                    ResponseMsg.SERVER_ERROR.getResponseCode(),
                    ResponseMsg.SERVER_ERROR.getResponseMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;

    }

    /**
     * 根据订单ID获取订单详情
     *
     * @param orderId 订单ID
     * @return ResponseEntity
     */
    @ApiOperation(value = "根据订单ID获取订单详情", notes = "根据订单ID获取订单详情")
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

    /**
     * 获取订单列表
     *
     * @param userId 用户ID
     * @param status 订单状态
     * @return ResponseEntity
     */
    @ApiOperation(value = "获取订单列表", notes = "获取订单列表")
    @GetMapping(value = "")
    public ResponseEntity<List<Order>> getOrderList(
            @RequestParam String userId,
            @RequestParam(required = false) String status) {
        logger.info("[getOrderList] userId: " + userId + ", status: " + status);
        ResponseEntity<List<Order>> responseEntity;
        try {
            Map<String, Object> paramMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);
            paramMap.put("userId", userId);
            if (!StringUtils.isEmpty(status)) {
                paramMap.put("status", status);
            }
            List<Order> orderList = orderService.getOrderList(paramMap);
            responseEntity = new ResponseEntity<>(orderList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("[getOrderList] error: " + e.getMessage());
            responseEntity = new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;

    }
}
