package com.fgchain.main.module.background.zone.system.entity;

import java.util.Date;

public class Role {
    private Integer roleId;

    private String roleName;

    private Date roleCreateData;

    private String roleCreateBy;

    public Role(Integer roleId, String roleName, Date roleCreateData, String roleCreateBy) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleCreateData = roleCreateData;
        this.roleCreateBy = roleCreateBy;
    }

    public Role() {
        super();
    }

    public Role(Integer roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public Date getRoleCreateData() {
        return roleCreateData;
    }

    public void setRoleCreateData(Date roleCreateData) {
        this.roleCreateData = roleCreateData;
    }

    public String getRoleCreateBy() {
        return roleCreateBy;
    }

    public void setRoleCreateBy(String roleCreateBy) {
        this.roleCreateBy = roleCreateBy == null ? null : roleCreateBy.trim();
    }
}