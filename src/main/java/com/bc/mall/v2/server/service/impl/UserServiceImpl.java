package com.bc.mall.v2.server.service.impl;

import com.bc.mall.v2.server.entity.User;
import com.bc.mall.v2.server.mapper.UserMapper;
import com.bc.mall.v2.server.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 用户
 *
 * @author zhou
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    /**
     * 根据openid获取用户
     *
     * @param paramMap 参数map
     * @return 用户
     */
    @Override
    public User getUserByOpenId(Map<String, String> paramMap) {
        List<User> userList = userMapper.getUserListByOpenId(paramMap);
        if (!CollectionUtils.isEmpty(userList)) {
            return userList.get(0);
        }
        return null;
    }

    /**
     * 微信授权时保存用户
     *
     * @param user 用户
     */
    @Override
    public void addUserByWechatAuth(User user) {
        userMapper.addUserByWechatAuth(user);
    }

    /**
     * 微信授权时修改用户
     *
     * @param user 用户
     */
    @Override
    public void updateUserByWechatAuth(User user) {
        userMapper.updateUserByWechatAuth(user);
    }

}
