package com.fgchain.main.module.background.zone.system.service.impl;

import com.fgchain.main.module.background.zone.system.dao.PermMapper;
import com.fgchain.main.module.background.zone.system.entity.Menu;
import com.fgchain.main.module.background.zone.system.service.PermService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @description:
 * @author:
 * @create: 2018-11-22 00:46
 */
@Service
public class PermServiceImpl implements PermService {

    private Logger log = LoggerFactory.getLogger(PermServiceImpl.class);

    @Autowired
    private PermMapper permMapper;

    @Override
    public List<Menu> allMenus(){
        return permMapper.selectAllMenu();
    }

    @Override
    public List<Integer> getPermIdsByMenuIds(Integer[] menuIdArr) {
        return permMapper.selectPermIdsByMenuIds(menuIdArr);
    }

}
