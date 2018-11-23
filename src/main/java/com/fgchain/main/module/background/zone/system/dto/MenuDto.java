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
public class MenuDto extends Menu implements Comparable {

    private Boolean checked;

    private Boolean halfCheck;

    private List<MenuDto> childMenu = new ArrayList<MenuDto>();

    public MenuDto() {
    }

    public MenuDto(Menu m) {
        super(m.getMenuId(), m.getPermId(), m.getMenuName(), m.getMenuLevel(), m.getMenuParentId(), m.getMenuOrder(), m.getMenuRelativeUrl(), m.getMenuAbsoluteUrl());
    }

    public MenuDto(Integer menuId, Integer permId, String menuName, Integer menuLevel, Integer menuParentId, Integer menuOrder, String menuRelativeUrl, String menuAbsoluteUrl) {
        super(menuId, permId, menuName, menuLevel, menuParentId, menuOrder, menuRelativeUrl, menuAbsoluteUrl);
    }

    public List<MenuDto> getChildMenu() {
        return childMenu;
    }

    public void setChildMenu(List<MenuDto> childMenu) {
        this.childMenu = childMenu;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public Boolean getHalfCheck() {
        return halfCheck;
    }

    public void setHalfCheck(Boolean halfCheck) {
        this.halfCheck = halfCheck;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
