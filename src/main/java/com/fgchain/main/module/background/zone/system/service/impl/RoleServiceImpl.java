package com.fgchain.main.module.background.zone.system.service.impl;

import com.fgchain.main.module.background.zone.system.dao.RoleMapper;
import com.fgchain.main.module.background.zone.system.entity.Role;
import com.fgchain.main.module.background.zone.system.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName RoleServiceImpl
 * @Description
 * @Author jiangxy
 * @Date 2018\11\19 0019 16:50
 * @Version 1.0.0
 */
@Service
public class RoleServiceImpl implements RoleService {

    private Logger log = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> getList() {
        return roleMapper.selectAllRoles();
    }
}
