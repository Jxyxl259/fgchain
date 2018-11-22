package com.fgchain.main.module.background.zone.system.service;

import com.fgchain.main.module.background.zone.system.entity.Menu;

import java.util.List;

public interface PermService {

    public List<Menu> allMenus();

    List<Integer> getPermIdsByMenuIds(Integer[] menuIdArr);
}
