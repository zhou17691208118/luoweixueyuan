package com.jc.system.service;

import com.jc.system.entity.SysRole;

import java.util.List;

public interface SysRoleService {
    /**
     * 获取所有角色信息
     * @return 所有角色集合
     */
    public List<SysRole> loadRoleAll();

}
