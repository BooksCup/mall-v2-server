package com.bc.mall.v2.server.utils;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 精确计算工具类
 *
 * @author zhou
 */
public class BigDecimalUtil {

    /**
     * 提供精确的乘法运算。
     *
     * @param v1 被乘数
     * @param v2 乘数
     * @return 两个参数的积
     */
    public static BigDecimal multiply(Object v1, Object v2) {
        BigDecimal b1 = getBigDecimal(v1);
        BigDecimal b2 = getBigDecimal(v2);
        return b1.multiply(b2);
    }

    /**
     * Object转BigDecimal类型
     *
     * @param value 要转的object类型
     * @return 转成的BigDecimal类型数据
     */
    public static BigDecimal getBigDecimal(Object value) {
        BigDecimal ret = null;
        if (value != null) {
            if (value instanceof BigDecimal) {
                ret = (BigDecimal) value;
            } else if (value instanceof String) {
                ret = new BigDecimal((String) value);
            } else if (value instanceof BigInteger) {
                ret = new BigDecimal((BigInteger) value);
            } else if (value instanceof Number) {
                ret = new BigDecimal(((Number) value).doubleValue());
            } else {
                throw new ClassCastException("Not possible to coerce [" + value + "] from class " + value.getClass() + " into a BigDecimal.");
            }
        }
        return ret;
    }

}
