package com.bc.mall.v2.server.service.impl;

import com.bc.mall.v2.server.entity.Banner;
import com.bc.mall.v2.server.mapper.BannerMapper;
import com.bc.mall.v2.server.service.BannerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 轮播图
 *
 * @author zhou
 */
@Service("bannerService")
public class BannerServiceImpl implements BannerService {

    @Resource
    private BannerMapper bannerMapper;

    /**
     * 获取轮播图列表
     *
     * @param paramMap 参数map
     * @return 轮播图列表
     */
    @Override
    public List<Banner> getBannerList(Map<String, Object> paramMap){
        return bannerMapper.getBannerList(paramMap);
    }

}
