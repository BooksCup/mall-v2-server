package com.bc.mall.v2.server.controller.admin;

import com.bc.mall.v2.server.cons.Constant;
import com.bc.mall.v2.server.entity.Order;
import com.bc.mall.v2.server.service.OrderService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 订单
 *
 * @author zhou
 */
@CrossOrigin(exposedHeaders = "responseCode")
@RestController
@RequestMapping("/admin/order")
public class AdminOrderController {

    private static final Logger logger = LoggerFactory.getLogger(AdminOrderController.class);

    @Resource
    private OrderService orderService;

    @ApiOperation(value = "获取订单列表(管理后台)", notes = "获取订单列表(管理后台)")
    @GetMapping(value = "")
    public ResponseEntity<PageInfo<Order>> getOrderPageInfoForAdmin(
            @RequestParam(required = false, defaultValue = "1") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer limit) {
        logger.info("[getOrderListForAdmin] page: " + page + ", limit: " + limit);
        ResponseEntity<PageInfo<Order>> responseEntity;
        try {
            Map<String, Object> paramMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);
            PageInfo<Order> pageInfo = orderService.getOrderPageInfoForAdmin(page, limit, paramMap);
            responseEntity = new ResponseEntity<>(pageInfo, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("[getOrderListForAdmin] error: " + e.getMessage());
            responseEntity = new ResponseEntity<>(new PageInfo<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
