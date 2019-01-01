package com.fgchain.main.module.background.zone.system.entity;

import java.util.Date;

public class Menu {

    private Integer menuId;

    private Integer permId;

    private String menuName;

    private String menuIcon;

    private Integer menuLevel;

    private Integer menuParentId;

    private Integer menuOrder;

    private String menuRelativeUrl;

    private String menuAbsoluteUrl;

    private Date menuCreateData;

    private String menuCreateBy;

    public Menu() {
    }

    public Menu(Integer menuId, Integer permId, String menuName, String menuIcon, Integer menuLevel, Integer menuParentId, Integer menuOrder, String menuRelativeUrl, String menuAbsoluteUrl, Date menuCreateData, String menuCreateBy) {
        this.menuId = menuId;
        this.permId = permId;
        this.menuName = menuName;
        this.menuIcon = menuIcon;
        this.menuLevel = menuLevel;
        this.menuParentId = menuParentId;
        this.menuOrder = menuOrder;
        this.menuRelativeUrl = menuRelativeUrl;
        this.menuAbsoluteUrl = menuAbsoluteUrl;
        this.menuCreateData = menuCreateData;
        this.menuCreateBy = menuCreateBy;
    }

    public Menu(Integer menuId, Integer permId, String menuName, String menuIcon, Integer menuLevel, Integer menuParentId, Integer menuOrder, String menuRelativeUrl, String menuAbsoluteUrl) {
        this.menuId = menuId;
        this.permId = permId;
        this.menuName = menuName;
        this.menuIcon = menuIcon;
        this.menuLevel = menuLevel;
        this.menuParentId = menuParentId;
        this.menuOrder = menuOrder;
        this.menuRelativeUrl = menuRelativeUrl;
        this.menuAbsoluteUrl = menuAbsoluteUrl;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getPermId() {
        return permId;
    }

    public void setPermId(Integer permId) {
        this.permId = permId;
    }

    public String getMenuName() {
        return menuName;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
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