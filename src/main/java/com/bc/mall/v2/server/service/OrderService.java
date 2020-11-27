package com.bc.mall.v2.server.service;

import com.bc.mall.v2.server.entity.Order;
import com.github.pagehelper.PageInfo;

import java.util.Map;

/**
 * 订单
 *
 * @author zhou
 */
public interface OrderService {
    PageInfo<Order> getOrderPageInfoForAdmin(int pageNum, int pageSize, Map<String, Object> paramMap);

}
