package com.bc.mall.v2.server.service.impl;

import com.bc.mall.v2.server.entity.Order;
import com.bc.mall.v2.server.mapper.OrderMapper;
import com.bc.mall.v2.server.service.OrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    @Override
    public PageInfo<Order> getOrderPageInfoForAdmin(int pageNum, int pageSize,  Map<String,Object> paramMap){
        PageHelper.startPage(pageNum, pageSize);
        List<Order> orderList = orderMapper.getOrderListForAdmin(paramMap);
        return new PageInfo<>(orderList);
    }
}
