package com.fgchain.main.module.background.zone.system.entity;

import java.util.Date;

public class Perm {
    private Integer permId;

    private String permName;

    private String permUrl;

    private Integer permType;

    private Integer menuId;

    private Date permCreateDate;

    private String permCreateBy;

    public Perm(Integer permId, String permName, String permUrl, Integer permType, Integer menuId, Date permCreateDate, String permCreateBy) {
        this.permId = permId;
        this.permName = permName;
        this.permUrl = permUrl;
        this.permType = permType;
        this.menuId = menuId;
        this.permCreateDate = permCreateDate;
        this.permCreateBy = permCreateBy;
    }

    public Perm() {
        super();
    }

    public Integer getPermId() {
        return permId;
    }

    public void setPermId(Integer permId) {
        this.permId = permId;
    }

    public String getPermName() {
        return permName;
    }

    public void setPermName(String permName) {
        this.permName = permName == null ? null : permName.trim();
    }

    public String getPermUrl() {
        return permUrl;
    }

    public void setPermUrl(String permUrl) {
        this.permUrl = permUrl == null ? null : permUrl.trim();
    }

    public Integer getPermType() {
        return permType;
    }

    public void setPermType(Integer permType) {
        this.permType = permType;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Date getPermCreateDate() {
        return permCreateDate;
    }

    public void setPermCreateDate(Date permCreateDate) {
        this.permCreateDate = permCreateDate;
    }

    public String getPermCreateBy() {
        return permCreateBy;
    }

    public void setPermCreateBy(String permCreateBy) {
        this.permCreateBy = permCreateBy == null ? null : permCreateBy.trim();
    }
}