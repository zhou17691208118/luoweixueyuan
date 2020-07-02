package com.jc.system.service.impl;

import com.jc.system.dao.SysUserDao;
import com.jc.system.entity.SysPermission;
import com.jc.system.entity.SysUser;
import com.jc.system.entity.User_Role;
import com.jc.system.service.SysUserService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public boolean addNewSysUser(String loginName, String password, String phonenum) {
        int i = sysUserDao.addNewSysUser(loginName, password, phonenum);
        return i>0?true : false;
    }

    //根据手机号查询用户信息
    @Override
    public SysUser findUserInfoByPhonenum(String phonenum) {
        return sysUserDao.findUserInfoByPhonenum(phonenum);
    }


}
