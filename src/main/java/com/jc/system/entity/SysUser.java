package com.jc.system.entity;

import lombok.Data;

import java.io.Serializable;


@Data
public class SysUser implements Serializable {
    private int userId;  //用户id
    private String loginName;//登陆名
    private String password;//密码（密文）
    private int state;//状态：1表示 用户有效；0表示被禁用户
    private String createTime;//创建时间
    private String phonenum;//用户手机号
    private String email; //邮箱
    private String headportrait; //头像


    @Override
    public String toString() {
        return "SysUser{" +
                "userId=" + userId +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", state=" + state +
                ", createTime='" + createTime + '\'' +
                ", phonenum='" + phonenum + '\'' +
                ", email='" + email + '\'' +
                ", headportrait='" + headportrait + '\'' +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHeadportrait() {
        return headportrait;
    }

    public void setHeadportrait(String headportrait) {
        this.headportrait = headportrait;
    }
}
