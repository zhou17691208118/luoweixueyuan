package com.jc.system.service.impl;
import com.jc.system.dao.SysRoleDao;
import com.jc.system.entity.SysRole;
import com.jc.system.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleDao sysRoleDao;
    //获取所有角色信息
    @Override
    public List<SysRole> loadRoleAll() {
        List<SysRole> roleList = sysRoleDao.loadRoleAll();
        return roleList;
    }
    //通过角色信息查询用户角色
    @Override
    public SysRole findRoleInfoByRoleName(String role_name) {
        return sysRoleDao.findRoleInfoByRoleName(role_name);
    }

    @Override
    public SysRole findRoleInfoByLoginName(String loginName) {
        return sysRoleDao.findRoleInfoByLoginName(loginName);
    }

}
