package com.fgchain.main.module.front.login.service.impl;

import com.alibaba.fastjson.JSON;
import com.fgchain.main.module.background.zone.system.dto.MenuDto;
import com.fgchain.main.module.background.zone.system.entity.Menu;
import com.fgchain.main.module.front.login.dao.UserMapper;
import com.fgchain.main.module.front.login.entity.User;
import com.fgchain.main.module.front.login.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author:
 * @create: 2018-07-08 14:34
 */
@Service
public class UserServiceImpl implements UserService {

    private static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByUsername(String username) {
        log.debug("getUserByUserName param username={}", username);
        User user = userMapper.selectByUsername(username);
        log.debug("getUserByUserName result userEntity={}", JSON.toJSONString(user));
        return user;

    }

    @Override
    public User getUserByUsernameAndPassword(String username, String password) {
        log.debug("getUserByUsernameAndPassword param username={}, psssword={}", username, password);
        User user = userMapper.selectByUsernameAndPassword(username, password);
        log.debug("getUserByUsernameAndPassword result userEntity={}", JSON.toJSONString(user));
        return user;
    }

    @Override
    public User getUserInfoByUserId(Long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }



    @Override
    public MenuDto getMenuPermsOfUser(Long userId) {

        // 先通过用户Id查询出所属该用户的所有menu权限
        List<Menu> menus = userMapper.selectMenuPermsByUserId(userId);
        return null;
    }
}
