package com.jc.system.service.impl;

import com.jc.system.dao.SysPernissionDao;
import com.jc.system.entity.SysPermission;
import com.jc.system.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysPermissionServiceImpl implements SysPermissionService {
    @Autowired
    private SysPernissionDao sysPernissionDao;
    //获取所有权限信息
    @Override
    public List<SysPermission> loadPermissionAll() {
        List<SysPermission> list = sysPernissionDao.loadPermissionAll();
        return list;
    }

}
