package com.jc.system.controller;

import com.jc.system.entity.SysRole;
import com.jc.system.entity.SysUser;
import com.jc.system.service.SysRoleService;
import com.jc.system.service.SysUserRoleService;
import com.jc.system.service.SysUserService;
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
    @Autowired
    private SysUserService userService;
    @Autowired
    private SysUserRoleService sysUserRoleService;

    //获取所有角色信息
    @RequestMapping("/loadRoleAll")
    public List<SysRole> loadRoleAll(){
        List<SysRole> roleList = roleService.loadRoleAll();
        return roleList;
    }

    //通过用户id删除用户角色
    @RequestMapping("/deleteSysRoleById")
    public String deleteSysRoleById(int roleId){
        boolean bool = roleService.deleteSysRoleById(roleId);
        return "1";
    }
    //增加管理员用户角色
    @RequestMapping("/addNewSysUser")
    public String addNewSysUser(String loginName, String password, String phonenum){
        boolean bool = userService.addNewSysUser(loginName, password, phonenum);
        int maxId = userService.getMaxUserId();
        int userId = maxId;
        boolean bool1 = roleService.addNewUserRole(userId);
        return "1";
    }

    //通过userId删除用户角色信息
    @RequestMapping("/deleteSysUserByUserId")
    public String deleteSysUserByUserId(int userId){
        boolean bool = roleService.deleteSysUserByUserId(userId);
        boolean bool1 = sysUserRoleService.deleteUserRoleByUserId(userId);
        return "1";
    }
    //通过用户Id获取用户角色信息
    @RequestMapping("/findUserRoleInfoByUserId")
    public String findUserRoleInfoByUserId(int userId){
        SysUser sysUser = roleService.findUserRoleInfoByUserId(userId);
//        boolean bool = roleService.updateUserRoleInfo(sysUser);
        return "1";
    }
    //给新用户角色添加权限


    //通过userId修改用户角色信息
    @RequestMapping("/updateUserRoleInfo")
    public String updateUserRoleInfo(SysUser sysUser){
//        int userId = sysUser.getUserId();
//        SysUser bool1 = roleService.findUserRoleInfoByUserId(userId);
        boolean bool = userService.updateUserRoleInfo(sysUser);
        return "1";
    }
    //角色信息的模糊查询
    @RequestMapping("/getRoleByRoleName")
    public List<SysRole> getRoleByRoleName(String Rname){
        List<SysRole> sysRoles = roleService.getRoleByRoleName(Rname);
        return sysRoles;
    }


}
