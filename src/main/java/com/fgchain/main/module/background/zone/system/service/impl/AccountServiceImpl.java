package com.fgchain.main.module.background.zone.system.service.impl;

import com.fgchain.main.common.RequestResult;
import com.fgchain.main.common.RequestResultFactory;
import com.fgchain.main.module.background.zone.system.dao.AccountMapper;
import com.fgchain.main.module.background.zone.system.dao.RoleMapper;
import com.fgchain.main.module.background.zone.system.dto.UserDto;
import com.fgchain.main.module.background.zone.system.entity.Role;
import com.fgchain.main.module.background.zone.system.service.AccountService;
import com.fgchain.main.module.background.zone.system.vo.RoleVo;
import com.fgchain.main.module.front.login.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private RoleMapper roleMapper;


    @Override
    public List<User> getList(UserDto userDto){
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        return accountMapper.selectList(user);
    }


    @Override
    public List<Integer> getUserRoles(Long userId) {
        return accountMapper.selectRoleByUserId(userId);
    }


    @Override
    public RequestResult<List<RoleVo>> userRoleInfo(Long userId) {

        List<Integer> userRoleIds = accountMapper.selectRoleByUserId(userId);

        List<Role> allRoleInfo = roleMapper.selectAllRoles();

        List<RoleVo> roleVoList = new ArrayList<>(allRoleInfo.size());

        allRoleInfo.forEach(role -> {
            RoleVo roleVo = new RoleVo();
            BeanUtils.copyProperties(role, roleVo);
            if(!CollectionUtils.isEmpty( userRoleIds) && userRoleIds.contains(role.getRoleId()))
                roleVo.setChecked(true);
            roleVoList.add(roleVo);
        });

        return RequestResultFactory.success(roleVoList);

    }

    @Override
    public int wipeUserRoles(Long userId) {
        return accountMapper.deleteUserRoles(userId);
    }

    @Override
    public RequestResult assignRole(Long userId, Integer[] userRoleIdArr) {

        int affectRows = accountMapper.insertUserRoleRelation(userId, userRoleIdArr);

        return RequestResultFactory.success(affectRows);

    }


}
