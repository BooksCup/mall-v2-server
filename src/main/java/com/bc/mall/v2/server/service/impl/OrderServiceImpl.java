package com.bc.mall.v2.server.service.impl;

import com.bc.mall.v2.server.entity.Order;
import com.bc.mall.v2.server.mapper.OrderMapper;
import com.bc.mall.v2.server.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 订单
 *
 * @author zhou
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    /**
     * 新增订单
     *
     * @param order 订单
     */
    @Override
    public void addOrder(Order order) {
        orderMapper.addOrder(order);
    }
}
