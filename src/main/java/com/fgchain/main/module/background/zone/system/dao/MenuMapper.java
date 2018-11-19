package com.fgchain.main.module.background.zone.system.dao;


import com.fgchain.main.module.background.zone.system.entity.Menu;

public interface MenuMapper {
    int insert(Menu record);

    int insertSelective(Menu record);
}