package com.fgchain.main.module.background.zone.system.service;

import com.fgchain.main.common.RequestResult;
import com.fgchain.main.module.background.zone.system.dto.UserDto;
import com.fgchain.main.module.background.zone.system.entity.Role;
import com.fgchain.main.module.background.zone.system.vo.RoleVo;
import com.fgchain.main.module.front.login.entity.User;

import java.util.List;
import java.util.Map;

public interface AccountService {

    public List<User> getList(UserDto userDto);

    List<Integer> getUserRoles(Long userId);

    RequestResult<List<RoleVo>> userRoleInfo(Long userId);

    int wipeUserRoles(Long userId);

    RequestResult assignRole(Long userId, Integer[] userRoleIdArr);
}
