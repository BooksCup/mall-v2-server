package com.bc.mall.v2.server.controller;

import com.bc.mall.v2.server.entity.Order;
import com.bc.mall.v2.server.enums.ResponseMsg;
import com.bc.mall.v2.server.service.OrderService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
            orderService.addOrder(order);
            responseEntity = new ResponseEntity<>(ResponseMsg.ADD_ORDER_SUCCESS.getResponseCode(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("[addOrder] error: " + e.getMessage());
            responseEntity = new ResponseEntity<>(ResponseMsg.ADD_ORDER_ERROR.getResponseCode(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;

    }
}
