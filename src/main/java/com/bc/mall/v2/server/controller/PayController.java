package com.bc.mall.v2.server.controller;

import com.bc.mall.v2.server.cons.Constant;
import com.bc.mall.v2.server.entity.Order;
import com.bc.mall.v2.server.entity.StoreConfig;
import com.bc.mall.v2.server.service.OrderService;
import com.bc.mall.v2.server.service.StoreConfigService;
import com.bc.mall.v2.server.utils.BigDecimalUtil;
import com.bc.mall.v2.server.utils.HttpUtil;
import com.bc.mall.v2.server.utils.WxPayUtil;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 支付
 *
 * @author zhou
 */
@RestController
@RequestMapping("/pay")
public class PayController {

    private static final Logger logger = LoggerFactory.getLogger(PayController.class);

    @Resource
    private OrderService orderService;

    @Resource
    private StoreConfigService storeConfigService;

    /**
     * @param request
     * @param
     * @return Map
     * @Description 微信浏览器内微信支付/公众号支付(JSAPI)
     */
    @ApiOperation(value = "微信支付", notes = "微信支付")
    @PostMapping(value = "")
    public ResponseEntity<Map<String, String>> wechatPay(@PathVariable String orderId,
                                                         @RequestParam String storeId,
                                                         HttpServletRequest request) {
        ResponseEntity<Map<String, String>> responseEntity;
        try {

            logger.info("[wechatPay], orderId: " + orderId);
            String openId = request.getHeader("openid");

            if (StringUtils.isEmpty(openId)) {
                logger.info("openid为空");
                return null;
            }

            StoreConfig storeConfig = storeConfigService.getStoreConfigByStoreId(storeId);
            if (null == storeConfig) {
                logger.info("storeConfig有问题");
                return null;
            }

            logger.info("[wechatPay], openId: " + openId);
            // 拼接统一下单地址参数
            Map<String, String> paraMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);
            // 获取请求ip地址
            String ip = request.getHeader("x-forwarded-for");
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unk nown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
            }
            if (ip.indexOf(",") != -1) {
                String[] ips = ip.split(",");
                ip = ips[0].trim();
            }
            logger.info("[wechatPay], ip: " + ip);
            // 通过订单id获取支付金额
            Order order = orderService.getOrderById(orderId);
            String totalFee = BigDecimalUtil.multiply(order.getTotalAmount(), new BigDecimal(100)).toString();
            totalFee = removeZeroAndDot(totalFee);

            String body = order.getShopName() + "-" + order.getGoodsName();
            logger.info("[wechatPay], 支付金额(单位分): " + totalFee);
            logger.info("[wechatPay], 商家名称：" + body);
            // 商家平台ID
            paraMap.put("appid", storeConfig.getAppId());
            // 商家名称-销售商品类目、String(128)
            paraMap.put("body", body);
            // 商户ID
            paraMap.put("mch_id", storeConfig.getMchId());
            // UUID
            paraMap.put("nonce_str", WxPayUtil.generateNonceStr());
            paraMap.put("openid", openId);
            // 订单id,每次都不同
            paraMap.put("out_trade_no", orderId);
            paraMap.put("spbill_create_ip", ip);
            // 支付金额,单位:分
            paraMap.put("total_fee", totalFee);
            // 支付类型
            paraMap.put("trade_type", "JSAPI");
            // 回调地址
            paraMap.put("notify_url", "http://wdwxsc.winddots.com/cloud-mall/pay/notify");
            String sign = WxPayUtil.generateSignature(paraMap, storeConfig.getMchKey());
            paraMap.put("sign", sign);
            // 将所有参数(map)转xml格式
            String xml = WxPayUtil.mapToXml(paraMap);

            // 统一下单URL
            String unifiedOrderUrl = "https://api.mch.weixin.qq.com/pay/unifiedorder";

            logger.info("[wechatPay] xml: " + xml);

            // 发送post请求"统一下单接口"返回预支付id: prepay_id
            String xmlStr = HttpUtil.httpsRequest(unifiedOrderUrl, "POST", xml);
            logger.info("xmlStr为：" + xmlStr);

            // 以下内容是返回前端页面的json数据
            // 预支付id
            String prepayId = "";
            if (xmlStr.indexOf("SUCCESS") != -1) {
                Map<String, String> map = WxPayUtil.xmlToMap(xmlStr);
                prepayId = map.get("prepay_id");
            }

            Map<String, String> payMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);
            payMap.put("appId", storeConfig.getAppId());
            payMap.put("timeStamp", WxPayUtil.getCurrentTimestamp() + "");
            payMap.put("nonceStr", WxPayUtil.generateNonceStr());
            payMap.put("signType", "MD5");
            payMap.put("package", "prepay_id=" + prepayId);
            String paySign = WxPayUtil.generateSignature(payMap, storeConfig.getMchKey());
            payMap.put("paySign", paySign);
            // 参数传给前端
            responseEntity = new ResponseEntity<>(payMap, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(new HashMap<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    /**
     * 去除多余的小数点
     *
     * @param s
     * @return
     */
    private String removeZeroAndDot(String s) {
        if (s.isEmpty()) {
            return null;
        }
        if (s.indexOf(".") > 0) {
            // 去掉多余的0
            s = s.replaceAll("0+?$", "");
            // 如最后一位是.则去掉
            s = s.replaceAll("[.]$", "");
        }
        return s;
    }
}
