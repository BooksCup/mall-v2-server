package com.bc.mall.v2.server.cons;


/**
 * 常量类
 *
 * @author zhou
 */
public class Constant {

    /**
     * 初始化hashmap容量
     */
    public static final int DEFAULT_HASH_MAP_CAPACITY = 16;

    /**
     * 是否默认-"否"
     */
    public static final String IS_DEFAULT_FALSE = "0";

    /**
     * 是否默认-"是"
     */
    public static final String IS_DEFAULT_TRUE = "1";

    /**
     * 未知IP
     */
    public static final String IP_UNKNOWN = "unknown";

    // 符号
    /**
     * 逗号
     */
    public static final String SYMBOL_COMMA = ",";

    /**
     * 点
     */
    public static final String SYMBOL_DOT = ".";

    public static final String SUCCESS = "SUCCESS";

    // 支付类型
    /**
     * 微信小程序支付
     */
    public static final String PAY_TYPE_MINI_WECHAT = "5";

    // 订单状态
    /**
     * 待发货(已付款)
     */
    public static final String ORDER_STATUS_AWAITING_SHIPMENT = "1";

    // 付款状态
    /**
     * 未付款
     */
    public static final String PAY_STATUS_UNPAID = "0";

    /**
     * 已付款
     */
    public static final String PAY_STATUS_PAID = "1";

    /**
     * 删除状态 - “未删除”
     */
    public static final String DELETE_STATUS_NOT = "0";

    /**
     * 第一级父ID
     */
    public static final String FIRST_CLASS_PARENT_ID = "0";

    /**
     * 订单类型-"秒杀"
     */
    public static final String ORDER_TYPE_SECKILL = "MS";

}
