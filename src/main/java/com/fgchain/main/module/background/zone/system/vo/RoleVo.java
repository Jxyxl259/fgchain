package com.fgchain.main.module.background.zone.system.vo;

import com.fgchain.main.module.background.zone.system.entity.Role;

/**
 * @ClassName RoleVo
 * @Description
 * @Author jiangxy
 * @Date 2018\11\23 0023 11:56
 * @Version 1.0.0
 */
public class RoleVo extends Role {

    private boolean checked;

    public RoleVo() {
    }

    public RoleVo(Integer roleId, String roleName, boolean checked) {
        super(roleId, roleName);
        this.checked = checked;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
