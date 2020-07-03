package com.jc.system.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SysRole implements Serializable {
    private int role_id;        //角色id
    private String role_name;   //角色名称
    private String role_desc;   //角色描述
    private int if_vilid;       //是否有效

    private List<SysUser> userList;

    @Override
    public String toString() {
        return "SysRole{" +
                "role_id=" + role_id +
                ", role_name='" + role_name + '\'' +
                ", role_desc='" + role_desc + '\'' +
                ", if_vilid=" + if_vilid +
                ", userList=" + userList +
                '}';
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getRole_desc() {
        return role_desc;
    }

    public void setRole_desc(String role_desc) {
        this.role_desc = role_desc;
    }

    public int getIf_vilid() {
        return if_vilid;
    }

    public void setIf_vilid(int if_vilid) {
        this.if_vilid = if_vilid;
    }

    public List<SysUser> getUserList() {
        return userList;
    }

    public void setUserList(List<SysUser> userList) {
        this.userList = userList;
    }
}
