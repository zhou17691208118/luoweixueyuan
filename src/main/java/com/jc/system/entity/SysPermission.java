package com.jc.system.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysPermission implements Serializable {
    private long  permission_id;    //权限id
    private String per_name;        //权限名
    private String menu_name;       //菜单名
    private String menu_type;       //菜单分类
    private String menu_url;        //菜单接口url
    private String menu_code;       //菜单编号
    private String parent_code;     //父编号
    private String per_desc;        //权限描述
    private String if_vilid;        //是否有效
    private String checked="false"; //复选框

    @Override
    public String toString() {
        return "SysPermission{" +
                "permission_id=" + permission_id +
                ", per_name='" + per_name + '\'' +
                ", menu_name='" + menu_name + '\'' +
                ", menu_type='" + menu_type + '\'' +
                ", menu_url='" + menu_url + '\'' +
                ", menu_code='" + menu_code + '\'' +
                ", parent_code='" + parent_code + '\'' +
                ", per_desc='" + per_desc + '\'' +
                ", if_vilid='" + if_vilid + '\'' +
                ", checked='" + checked + '\'' +
                '}';
    }

    public long getPermission_id() {
        return permission_id;
    }

    public void setPermission_id(long permission_id) {
        this.permission_id = permission_id;
    }

    public String getPer_name() {
        return per_name;
    }

    public void setPer_name(String per_name) {
        this.per_name = per_name;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public String getMenu_type() {
        return menu_type;
    }

    public void setMenu_type(String menu_type) {
        this.menu_type = menu_type;
    }

    public String getMenu_url() {
        return menu_url;
    }

    public void setMenu_url(String menu_url) {
        this.menu_url = menu_url;
    }

    public String getMenu_code() {
        return menu_code;
    }

    public void setMenu_code(String menu_code) {
        this.menu_code = menu_code;
    }

    public String getParent_code() {
        return parent_code;
    }

    public void setParent_code(String parent_code) {
        this.parent_code = parent_code;
    }

    public String getPer_desc() {
        return per_desc;
    }

    public void setPer_desc(String per_desc) {
        this.per_desc = per_desc;
    }

    public String getIf_vilid() {
        return if_vilid;
    }

    public void setIf_vilid(String if_vilid) {
        this.if_vilid = if_vilid;
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }
}
