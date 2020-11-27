package com.bc.mall.v2.server.mapper;

import com.bc.mall.v2.server.entity.Order;

import java.util.List;
import java.util.Map;

public interface OrderMapper {
    List<Order> getOrderListForAdmin(Map<String,Object> paramMap);
}
