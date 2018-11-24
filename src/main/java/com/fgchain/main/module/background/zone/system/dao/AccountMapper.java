package com.fgchain.main.module.background.zone.system.dao;

import com.fgchain.main.module.background.zone.system.entity.Role;
import com.fgchain.main.module.front.login.entity.User;
import org.apache.ibatis.annotations.Param;

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

    List<Integer> selectRoleByUserId(Long userId);

    int deleteUserRoles(Long userId);

    int insertUserRoleRelation(@Param("userId") Long userId, @Param("roleIds")Integer[] userRoleIdArr);
}
