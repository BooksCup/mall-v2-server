package com.bc.mall.v2.server.controller;

import com.bc.mall.v2.server.cons.Constant;
import com.bc.mall.v2.server.entity.Banner;
import com.bc.mall.v2.server.entity.Goods;
import com.bc.mall.v2.server.entity.HomeProfile;
import com.bc.mall.v2.server.service.BannerService;
import com.bc.mall.v2.server.service.GoodsService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

/**
 * 导航
 *
 * @author zhou
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Resource
    private BannerService bannerService;

    @Resource
    private GoodsService goodsService;

    @ApiOperation(value = "获取首页信息", notes = "获取首页信息")
    @GetMapping(value = "/home")
    public ResponseEntity<HomeProfile> getHomeProfile(@RequestParam String storeId) {
        logger.info("[getHomeProfile] storeId: " + storeId);
        ResponseEntity<HomeProfile> responseEntity;
        HomeProfile homeProfile = new HomeProfile();
        try {
            Map<String, Object> paramMap = new HashMap<>(Constant.DEFAULT_HASH_MAP_CAPACITY);
            paramMap.put("storeId", storeId);
            List<Banner> bannerList = bannerService.getBannerList(paramMap);
            homeProfile.setBannerList(bannerList);

            // 猜你喜欢商品
            List<Goods> likeGoodsList = goodsService.getLikeGoodsList(1, 10, paramMap);
            homeProfile.setLikeGoodsList(likeGoodsList);

            responseEntity = new ResponseEntity<>(homeProfile, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("[getHomeProfile] error: " + e.getMessage());
            responseEntity = new ResponseEntity<>(new HomeProfile(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

}
