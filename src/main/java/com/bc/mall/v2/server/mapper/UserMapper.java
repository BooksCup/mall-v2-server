package com.bc.mall.v2.server.mapper;

import com.bc.mall.v2.server.entity.User;

import java.util.List;
import java.util.Map;

/**
 * 用户
 *
 * @author zhou
 */
public interface UserMapper {

    /**
     * 根据openid获取用户列表
     *
     * @param paramMap 参数map
     * @return 用户列表
     */
    List<User> getUserListByOpenId(Map<String, String> paramMap);

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
