package com.jc.system.controller;

import com.jc.system.service.SysRolePermService;
import com.jc.system.service.SysUserPermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SysPermissionController {
    @Autowired
    private SysRolePermService sysRolePermService;
    @Autowired
    private SysUserPermService sysUserPermService;

   /* @Autowired
    private SysPermissionService permissionService;
    //获取所有权限信息
    @ResponseBody
    @RequestMapping("/loadPermissionAll")
    public List<SysPermission> loadPermissionAll(){
        List<SysPermission> list = permissionService.loadPermissionAll();
        return list;
    }*/
    //批量新增角色菜单信息
    @RequestMapping("/insertRolePerm")
    public String insertRolePerm(List<Integer> ids){
        boolean b = sysRolePermService.insertRolePerm(ids);
        return "1";
    }
    //批量删除多个角色菜单信息
    @RequestMapping("/delecrRolePerms")
    public String delecrRolePerms(List<Integer> ids){
        boolean b = sysRolePermService.delecrRolePerms(ids);
        return "1";
    }

    @RequestMapping("/deleteUserPermByUserId")
    public String deleteUserPermByUserId(List<Integer> ids){
        boolean b = sysUserPermService.deleteUserPermByUserId(ids);
        return "1";
    }

}
