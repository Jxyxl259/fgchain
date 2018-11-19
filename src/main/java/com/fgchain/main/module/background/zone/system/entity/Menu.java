package com.fgchain.main.module.background.zone.system.entity;

import java.util.Date;

public class Menu {

    private Integer menuId;

    private String menuName;

    private Integer menuLevel;

    private Integer menuParentId;

    private Integer menuOrder;

    private String menuRelativeUrl;

    private String menuAbsoluteUrl;

    private Date menuCreateData;

    private String menuCreateBy;

    public Menu(Integer menuId, String menuName, Integer menuLevel, Integer menuParentId, Integer menuOrder, String menuRelativeUrl, String menuAbsoluteUrl, Date menuCreateData, String menuCreateBy) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.menuLevel = menuLevel;
        this.menuParentId = menuParentId;
        this.menuOrder = menuOrder;
        this.menuRelativeUrl = menuRelativeUrl;
        this.menuAbsoluteUrl = menuAbsoluteUrl;
        this.menuCreateData = menuCreateData;
        this.menuCreateBy = menuCreateBy;
    }

    public Menu() {
        super();
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public Integer getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(Integer menuLevel) {
        this.menuLevel = menuLevel;
    }

    public Integer getMenuParentId() {
        return menuParentId;
    }

    public void setMenuParentId(Integer menuParentId) {
        this.menuParentId = menuParentId;
    }

    public Integer getMenuOrder() {
        return menuOrder;
    }

    public void setMenuOrder(Integer menuOrder) {
        this.menuOrder = menuOrder;
    }

    public String getMenuRelativeUrl() {
        return menuRelativeUrl;
    }

    public void setMenuRelativeUrl(String menuRelativeUrl) {
        this.menuRelativeUrl = menuRelativeUrl == null ? null : menuRelativeUrl.trim();
    }

    public String getMenuAbsoluteUrl() {
        return menuAbsoluteUrl;
    }

    public void setMenuAbsoluteUrl(String menuAbsoluteUrl) {
        this.menuAbsoluteUrl = menuAbsoluteUrl == null ? null : menuAbsoluteUrl.trim();
    }

    public Date getMenuCreateData() {
        return menuCreateData;
    }

    public void setMenuCreateData(Date menuCreateData) {
        this.menuCreateData = menuCreateData;
    }

    public String getMenuCreateBy() {
        return menuCreateBy;
    }

    public void setMenuCreateBy(String menuCreateBy) {
        this.menuCreateBy = menuCreateBy == null ? null : menuCreateBy.trim();
    }
}