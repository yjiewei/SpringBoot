package com.yjiewei.entity;

import java.io.Serializable;

/**
 * (TRole)实体类
 *
 * @author makejava
 * @since 2021-10-22 12:46:15
 */
public class TRole implements Serializable {
    private static final long serialVersionUID = -94405690743103133L;
    /**
    * 主键
    */
    private Integer id;
    /**
    * 角色名称
    */
    private String rolename;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

}