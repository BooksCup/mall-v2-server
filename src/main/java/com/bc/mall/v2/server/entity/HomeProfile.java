package com.bc.mall.v2.server.entity;

import java.util.List;

/**
 * 首页信息
 *
 * @author zhou
 */
public class HomeProfile {

    /**
     * 轮播图
     */
    private List<Banner> bannerList;

    /**
     * 猜你喜欢商品
     */
    private List<Goods> likeGoodsList;

    public void setBannerList(List<Banner> bannerList) {
        this.bannerList = bannerList;
    }

    public List<Banner> getBannerList() {
        return bannerList;
    }

    public List<Goods> getLikeGoodsList() {
        return likeGoodsList;
    }

    public void setLikeGoodsList(List<Goods> likeGoodsList) {
        this.likeGoodsList = likeGoodsList;
    }
}
