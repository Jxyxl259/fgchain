package com.fgchain.main.module.background.zone.system.service;

import com.fgchain.main.module.background.zone.system.dto.UserDto;
import com.fgchain.main.module.front.login.entity.User;

import java.util.List;

public interface AccountService {

    public List<User> getList(UserDto userDto);

}
