package com.fgchain.main.module.front.login.dao;

import com.fgchain.main.module.front.login.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

//@Mapper
public interface UserMapper {

    /**
     * 新增用户信息
     * @param record
     * @return
     */
    int insert(User record);

    /**
     * 新增用户信息
     * @param record
     * @return
     */
    int insertSelective(User record);

    /**
     * 通过用户主键删除用户信息
     * @param userId
     * @return
     */
    int deleteByPrimaryKey(Long userId);

    /**
     * 更新用户信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * 更新用户信息
     * @param record
     * @return
     */
    int updateByPrimaryKey(User record);

    /**
     * 通过主键查询用户信息
     * @param userId
     * @return
     */
    User selectByPrimaryKey(Long userId);

    /**
     * 根据用户名查询用户是否存在
     * @param username
     * @return
     */
    User selectByUsername(@Param("username")String username);

    /**
     * 根据用户名/密码查询用户是否存在,
     * 登陆验证
     * @param username
     * @param password
     * @return
     */
    User selectByUsernameAndPassword(@Param("username")String username,
                                     @Param("password")String password);
}