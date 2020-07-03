package com.jc.system.dao;

import com.jc.system.entity.SysRole;
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
     * 通过角色信息查询用户角色
     * @return 单个用户角色
     */
     public SysRole findRoleInfoByRoleName(@Param("role_name") String role_name);

    /**
     * 通过用户名查询用户角色
     * @return 单个用户角色
     */
    public SysRole findRoleInfoByLoginName(@Param("loginName") String loginName);
}
