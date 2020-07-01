package com.jc.system.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User_Role implements Serializable {
    private Integer user_id;
    private Integer role_id;
}
