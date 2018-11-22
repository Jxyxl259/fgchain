package com.fgchain.main.module.background.zone.system.dao;


import com.fgchain.main.module.background.zone.system.entity.Menu;
import com.fgchain.main.module.background.zone.system.entity.Perm;
import com.fgchain.main.module.background.zone.system.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> selectAllRoles();

    List<Perm> selectPermsByRoleId(Integer roleId);

    List<Menu> selectMenuPermsByRoleId(Integer roleId);

    int deleteAllPermsByRoleId(@Param("roleId") Integer roleId);

    int insertRolePerms(@Param("roleId")Integer roleId, @Param("permIds")List<Integer> permIds);
}