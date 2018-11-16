package com.fgchain.main.module.background.zone.system.user.dao;

import com.fgchain.main.module.front.login.entity.User;

import java.util.List;

/**
 * @ClassName AccountMapper
 * @Description
 * @Author jiangxy
 * @Date 2018\11\16 0016 15:04
 * @Version 1.0.0
 */
public interface AccountMapper {


    List<User> selectList(User user);
}
