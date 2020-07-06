package com.jc.system.service.impl;

import com.jc.system.dao.SysRoleDao;
import com.jc.system.dao.SysUserDao;
import com.jc.system.entity.SysPermission;
import com.jc.system.entity.SysRolePermission;
import com.jc.system.entity.SysUser;
import com.jc.system.service.SysUserService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserDao sysUserDao;

    //根据登录名查询用户信息
    @Override
    public SysUser findUserInfoByEmail(String email) {
        SysUser sysUser = sysUserDao.findUserInfoByEmail(email);
        return sysUser;
    }
    //根据登录名查询当前用户权限集合
    @Override
    public List<SysPermission> findPermissionsByLoginName(String loginName) {
        List<SysPermission> permissions = sysUserDao.findPermissionsByUserName(loginName);
        return permissions;
    }
    //增加用户角色菜单信息
    @Override
    public boolean addNewSysUser(String loginName, String password, String phonenum) {
        int i = sysUserDao.addNewSysUser(loginName, password, phonenum);
        return i>0?true : false;
    }

    //根据手机号查询用户信息
    @Override
    public SysUser userTypeByPhonenum(String phonenum) {
        SysUser sysUser = sysUserDao.userTypeByPhonenum(phonenum);
        return sysUser;
    }

    @Override
    public List<SysUser> findSysUserInfo() {
        return sysUserDao.findSysUserInfo();
    }

    @Override
    public boolean deleteSysUserById(int userId) {
        int i = sysUserDao.deleteSysUserById(userId);
        return i>0?true:false;
    }

    @Override
    public int getMaxUserId() {
        int maxUserId = sysUserDao.getMaxUserId();
        return maxUserId;
    }
    @Override
    public boolean updateUserRoleInfo(SysUser sysUser) {
        int i = sysUserDao.updateUserRoleInfo(sysUser);
        return i>0?true:false;
    }


}
