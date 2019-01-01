package com.fgchain.main.module.background.zone.system.service;

import com.fgchain.main.module.background.zone.system.entity.Menu;
import com.fgchain.main.module.background.zone.system.entity.Perm;
import com.fgchain.main.module.background.zone.system.entity.Role;

import java.util.List;

public interface RoleService {


    List<Role> getList();

    List<Perm> getPermsByRoleId(Integer roleId);

    /**
     * 通过角色Id 查询角色所拥有的菜单权限
     * @param roleId 角色Id
     * @return 该角色Id下的所有菜单权限
     */
    List<Menu> getMenuPermsByRoleId(Integer roleId);

    int deleteOldRolePrems(Integer roleId);

    int allocateRolePerms(Integer roleId, List<Integer> permIds);

}
