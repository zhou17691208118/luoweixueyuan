package com.jc.system.service;

import com.jc.system.entity.SysRole;

import java.util.List;

public interface SysRoleService {
    /**
     * 获取所有角色信息
     * @return 所有角色集合
     */
    public List<SysRole> loadRoleAll();

    /**
     * 通过角色信息查询用户角色
     * @return 单个用户角色
     */
    public SysRole findRoleInfoByRoleName(String role_name);

    /**
     * 通过用户名查询用户角色
     * @return 单个用户角色
     */
    public SysRole findRoleInfoByLoginName(String loginName);
}
