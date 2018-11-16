package com.fgchain.main.module.background.zone.system.user.service.impl;

import com.fgchain.main.module.background.zone.system.user.dao.AccountMapper;
import com.fgchain.main.module.background.zone.system.user.dto.UserDto;
import com.fgchain.main.module.background.zone.system.user.service.AccountService;
import com.fgchain.main.module.front.login.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName AccountServiceImpl
 * @Description
 * @Author jiangxy
 * @Date 2018\11\16 0016 14:52
 * @Version 1.0.0
 */
@Service
public class AccountServiceImpl implements AccountService {

    private Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);


    @Autowired
    private AccountMapper accountMapper;


    public List<User> getList(UserDto userDto){
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        return accountMapper.selectList(user);
    }


}
