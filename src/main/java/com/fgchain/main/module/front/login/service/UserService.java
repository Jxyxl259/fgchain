package com.fgchain.main.module.front.login.service;

import com.fgchain.main.module.background.zone.system.dto.MenuDto;
import com.fgchain.main.module.front.login.entity.User;

/**
 * 用户接口
 */
public interface UserService {

    /**
     * 根据用户名称查询用户是否存在
     * @param username
     * @return
     */
    User getUserByUsername(String username);

    /**
     * 根据用户名密码查询用户对象
     * 用于登陆验证
     * @param username
     * @param password
     * @return
     */
    User getUserByUsernameAndPassword(String username, String password);


    /**
     * 根据用户id查询用户详细信息
     * @param userId
     * @return
     */
    User getUserInfoByUserId(Long userId);


    /**
     * 获取用户所有的菜单权限
     * @param userId
     * @return
     */
    MenuDto getMenuPermsOfUser(Long userId);
}
