package com.jc.system.service.impl;
import com.jc.system.dao.SysRoleDao;
import com.jc.system.entity.SysRole;
import com.jc.system.entity.SysUser;
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

    @Override
    public boolean deleteSysRoleById(int roleId) {
        int i = sysRoleDao.deleteSysRoleById(roleId);
        return i>0?true:false;
    }

    @Override
    public boolean addNewUserRole(int userId) {
        int i = sysRoleDao.addNewUserRole(userId);
        return i>0?true:false;
    }

    @Override
    public boolean deleteSysUserByUserId(int userId) {
        int i = sysRoleDao.deleteSysUserByUserId(userId);
        return i>0?true:false;
    }

    @Override
    public SysUser findUserRoleInfoByUserId(int userId) {
        return sysRoleDao.findUserRoleInfoByUserId(userId);
    }

    @Override
    public List<SysRole> getRoleByRoleName(String Rname) {
        return sysRoleDao.getRoleByRoleName(Rname);
    }


}
