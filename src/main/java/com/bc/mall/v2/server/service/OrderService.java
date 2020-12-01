package com.bc.mall.v2.server.service;

import com.bc.mall.v2.server.entity.Order;

/**
 * 订单
 *
 * @author zhou
 */
public interface OrderService {

    /**
     * 新增订单
     *
     * @param order 订单
     */
    void addOrder(Order order);

}
