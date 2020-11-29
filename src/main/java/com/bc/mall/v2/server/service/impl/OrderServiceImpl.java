package com.bc.mall.v2.server.service.impl;

import com.bc.mall.v2.server.entity.Order;
import com.bc.mall.v2.server.mapper.OrderMapper;
import com.bc.mall.v2.server.service.OrderService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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

    /**
     * 根据订单ID获取订单
     *
     * @param orderId 订单ID
     * @return 订单
     */
    @Override
    public Order getOrderById(String orderId) {
        return orderMapper.getOrderById(orderId);
    }

    /**
     * 支付后更新订单
     *
     * @param paramMap 参数map
     */
    @Override
    public void updateOrderAfterPay(Map<String, String> paramMap) {
        orderMapper.updateOrderAfterPay(paramMap);
    }

    /**
     * 获取订单列表
     *
     * @param pageNum  当前分页数
     * @param pageSize 分页大小
     * @param paramMap 参数map
     * @return 订单列表
     */
    @Override
    public List<Order> getOrderList(int pageNum, int pageSize, Map<String, Object> paramMap) {
        PageHelper.startPage(pageNum, pageSize);
        return orderMapper.getOrderList(paramMap);
    }
}
