package com.bc.mall.v2.server.mapper;

import com.bc.mall.v2.server.entity.Order;


/**
 * 订单
 *
 * @author zhou
 */
public interface OrderMapper {

    /**
     * 新增订单
     *
     * @param order 订单
     */
    void addOrder(Order order);

}
