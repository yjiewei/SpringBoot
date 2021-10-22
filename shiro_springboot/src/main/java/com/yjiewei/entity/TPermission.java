package com.yjiewei.entity;

import java.io.Serializable;

/**
 * (TPermission)实体类
 *
 * @author makejava
 * @since 2021-10-22 12:45:48
 */
public class TPermission implements Serializable {
    private static final long serialVersionUID = -10209958447556552L;
    /**
    * 主键
    */
    private Integer id;
    /**
    * 权限名
    */
    private String permissionname;
    /**
    * 外键关联role
    */
    private Integer roleId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermissionname() {
        return permissionname;
    }

    public void setPermissionname(String permissionname) {
        this.permissionname = permissionname;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

}