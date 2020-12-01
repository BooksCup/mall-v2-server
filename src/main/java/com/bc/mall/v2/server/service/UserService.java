package com.bc.mall.v2.server.service;


import com.bc.mall.v2.server.entity.User;

import java.util.Map;

/**
 * 用户
 *
 * @author zhou
 */
public interface UserService {

    /**
     * 根据openid获取用户
     *
     * @param paramMap 参数map
     * @return 用户
     */
    User getUserByOpenId(Map<String, String> paramMap);

    /**
     * 微信授权时保存用户
     *
     * @param user 用户
     */
    void addUserByWechatAuth(User user);

    /**
     * 微信授权时修改用户
     *
     * @param user 用户
     */
    void updateUserByWechatAuth(User user);

}
