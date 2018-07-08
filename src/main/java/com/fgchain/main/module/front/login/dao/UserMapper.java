package com.fgchain.main.module.front.login.dao;

import com.fgchain.main.module.front.login.entity.User;

public interface UserMapper {

    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}