package com.fgchain.main.module.background.zone.system.user.service;

import com.fgchain.main.module.background.zone.system.user.dto.UserDto;
import com.fgchain.main.module.front.login.entity.User;

import java.util.List;

public interface AccountService {

    public List<User> getList(UserDto userDto);

}
