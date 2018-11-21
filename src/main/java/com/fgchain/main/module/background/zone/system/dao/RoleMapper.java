package com.fgchain.main.module.background.zone.system.dao;


import com.fgchain.main.module.background.zone.system.entity.Menu;
import com.fgchain.main.module.background.zone.system.entity.Perm;
import com.fgchain.main.module.background.zone.system.entity.Role;

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
}