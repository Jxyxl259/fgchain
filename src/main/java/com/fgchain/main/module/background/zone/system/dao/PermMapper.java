package com.fgchain.main.module.background.zone.system.dao;

import com.fgchain.main.module.background.zone.system.entity.Menu;
import com.fgchain.main.module.background.zone.system.entity.Perm;

import java.util.List;

public interface PermMapper {
    int deleteByPrimaryKey(Integer permId);

    int insert(Perm record);

    int insertSelective(Perm record);

    Perm selectByPrimaryKey(Integer permId);

    int updateByPrimaryKeySelective(Perm record);

    int updateByPrimaryKey(Perm record);

    List<Menu> selectAllMenu();
}