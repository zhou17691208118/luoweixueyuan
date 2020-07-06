package com.jc.system.service;

import com.jc.system.entity.SysRole;
import com.jc.system.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleService {
    /**
     * 获取所有角色信息
     * @return 所有角色集合
     */
    public List<SysRole> loadRoleAll();


    /**
     * 通过用户id删除用户角色
     */
    public boolean deleteSysRoleById(int roleId);
    /**
     * 将新的用户和角色关系添加到关系表中
     */
    public boolean addNewUserRole( int userId);
    /**
     * 根据userId删除用户角色信息
     */
    public boolean deleteSysUserByUserId(int userId);
    /**
     * 通过用户Id获取用户角色信息
     */
    public SysUser findUserRoleInfoByUserId(int userId);
    /**
     * 根据role_name模糊查询
     * @param Rname  角色名字
     * @return  返回SysRole集合
     */
    public List<SysRole> getRoleByRoleName(String Rname);

}
