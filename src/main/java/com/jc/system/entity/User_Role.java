package com.jc.system.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User_Role implements Serializable {
    private Integer user_id;
    private Integer role_id;

    @Override
    public String toString() {
        return "User_Role{" +
                "user_id=" + user_id +
                ", role_id=" + role_id +
                '}';
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }
}
