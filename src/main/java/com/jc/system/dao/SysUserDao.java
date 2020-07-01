package com.jc.system.dao;
import com.jc.system.entity.SysPermission;
import com.jc.system.entity.SysUser;
import com.jc.system.entity.User_Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysUserDao {
    /**
     *@Param注解的作用是给参数命名,参数命名后就能根据名字得到参数值,正确的将参数传入sql语句中（一般通过#{}的方式，${}会有sql注入的问题）。
     * @param loginName 登录名
     * @return  SysUser 用户对象信息
     * 根据登录名查询用户信息
     *
     */
    public SysUser findUserInfoByLoginName(@Param("loginName") String loginName);


    /**
     * 根据用户名查询用户已经拥有的权限
     * @param loginName 登录名(用户名)
     * @return SysPermission对象的集合
     */
    public List<SysPermission> findPermissionsByUserName(String loginName);

    public List<SysUser> findAll();

}
