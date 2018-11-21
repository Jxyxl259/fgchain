package com.fgchain.main.module.background.zone.system.dto;

import com.fgchain.main.module.background.zone.system.entity.Menu;
import com.fgchain.main.module.background.zone.system.entity.Perm;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName MenuDto
 * @Description
 * @Author jiangxy
 * @Date 2018\11\21 0021 15:16
 * @Version 1.0.0
 */
public class MenuDto extends Menu {

    private List<MenuDto> childMenu = new ArrayList<MenuDto>();

    public MenuDto() {
    }

    public MenuDto(Integer menuId, Integer permId, String menuName, Integer menuLevel, Integer menuParentId, Integer menuOrder, String menuRelativeUrl, String menuAbsoluteUrl) {
        super(menuId, permId, menuName, menuLevel, menuParentId, menuOrder, menuRelativeUrl, menuAbsoluteUrl);
        this.childMenu = childMenu;
    }

    public List<MenuDto> getChildMenu() {
        return childMenu;
    }

    public void setChildMenu(List<MenuDto> childMenu) {
        this.childMenu = childMenu;
    }
}
