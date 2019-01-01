package com.fgchain.main.module.background.zone.system.service;

import com.fgchain.main.module.background.zone.system.entity.Menu;

import java.util.List;

public interface PermService {


    /**
     * 查询所有的菜单
     * @return
     */
    public List<Menu> allMenus();

    List<Integer> getPermIdsByMenuIds(Integer[] menuIdArr);
}
