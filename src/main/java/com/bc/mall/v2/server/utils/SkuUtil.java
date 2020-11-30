package com.bc.mall.v2.server.utils;

import com.alibaba.fastjson.JSON;
import com.bc.mall.v2.server.cons.Constant;

import java.util.HashMap;
import java.util.Map;

/**
 * sku工具类
 *
 * @author zhou
 */
public class SkuUtil {

    public static void main(String[] args) {
        Map<String, Object> skuMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);
//        skuMap.put("颜色", "黑2+白2+深灰2");
//        skuMap.put("颜色", "白2+深灰2+浅灰2");
//        skuMap.put("颜色", "浅灰3+深灰3");
//        skuMap.put("颜色", "黑3+浅灰3");
        skuMap.put("颜色", "自选6双订单备注颜色");
        skuMap.put("尺码", "均码");
        System.out.println(JSON.toJSONString(skuMap));
    }

}
