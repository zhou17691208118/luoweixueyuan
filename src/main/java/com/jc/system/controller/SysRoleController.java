package com.jc.system.controller;

import com.jc.system.entity.SysRole;
import com.jc.system.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.management.relation.Role;
import java.util.List;

@RestController
public class SysRoleController {
    @Autowired
    private SysRoleService roleService;

    //获取所有角色信息
    @RequestMapping("/loadRoleAll")
    public List<SysRole> loadRoleAll(){
        List<SysRole> roleList = roleService.loadRoleAll();
        return roleList;
    }

    //通过角色信息查询用户角色
    @RequestMapping("/findRoleInfoByRoleName")
    public SysRole findRoleInfoByRoleName(String role_name){
        SysRole role = roleService.findRoleInfoByRoleName(role_name);
        return role;
    }

    //通过用户名查询用户角色
    @RequestMapping("/findRoleInfoByLoginName")
    public SysRole findRoleInfoByLoginName(String loginName){
        SysRole roleLists = roleService.findRoleInfoByLoginName(loginName);
        return roleLists;
    }

}
