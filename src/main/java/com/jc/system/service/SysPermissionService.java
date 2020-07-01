package com.jc.system.service;


import com.jc.system.entity.SysPermission;

import java.util.List;

public interface SysPermissionService {
    /**
     * 获取所有权限信息
     * @return  返回值类型为list
     */
    public List<SysPermission> loadPermissionAll();
}
