package com.bc.mall.v2.server.mapper;

import com.bc.mall.v2.server.entity.Order;

import java.util.List;
import java.util.Map;


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

    /**
     * 根据订单ID获取订单
     *
     * @param orderId 订单ID
     * @return 订单
     */
    Order getOrderById(String orderId);

    /**
     * 支付后更新订单
     *
     * @param paramMap 参数map
     */
    void updateOrderAfterPay(Map<String, String> paramMap);

    /**
     * 获取订单列表
     *
     * @param paramMap 参数map
     * @return 订单列表
     */
    List<Order> getOrderList(Map<String, Object> paramMap);

    /**
     * 通过订单号获取订单列表
     *
     * @param orderNo 订单号
     * @return 订单列表
     */
    List<Order> getOrderListByOrderNo(String orderNo);
}
