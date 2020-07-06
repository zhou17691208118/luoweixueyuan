package com.jc.system.dao;

import com.jc.system.entity.SysRole;
import com.jc.system.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysRoleDao {
    /**
     * 获取所有角色信息
     * @return 所有角色集合
     */
    public List<SysRole> loadRoleAll();



    /**
     * 通过用户id删除用户角色
     */
    public int deleteSysRoleById(@Param("roleId") int roleId);
    /**
     * 将新的用户和角色关系添加到关系表中
     */
    public int addNewUserRole(@Param("user_id") int user_id);
    /**
     * 通过userId删除用户角色信息
     */
    public int deleteSysUserByUserId(int userId);
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
    /**
     * 给新用户角色添加权限
     */
//    public int insertRolePerm();

}
