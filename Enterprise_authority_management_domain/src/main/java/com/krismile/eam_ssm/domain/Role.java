package com.krismile.eam_ssm.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @author krismile
 * @Create 2020-07-25 18:16
 */
// 角色表
public class Role implements Serializable {
    private String id;
    private String roleName;
    private String roleDesc;
    private List<Permission> permissions; // 角色对应的权限
    private List<UserInfo> users; //角色赋予的用户

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<UserInfo> getUsers() {
        return users;
    }

    public void setUsers(List<UserInfo> users) {
        this.users = users;
    }
}
