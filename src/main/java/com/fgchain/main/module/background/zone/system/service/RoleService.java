package com.fgchain.main.module.background.zone.system.service;

import com.fgchain.main.module.background.zone.system.entity.Menu;
import com.fgchain.main.module.background.zone.system.entity.Perm;
import com.fgchain.main.module.background.zone.system.entity.Role;

import java.util.List;

public interface RoleService {


    List<Role> getList();

    List<Perm> getPermsByRoleId(Integer roleId);

    List<Menu> getMenuPermsByRoleId(Integer roleId);
}
