package com.jc.system.dao;
import com.jc.system.entity.SysPermission;
import com.jc.system.entity.SysUser;
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
    public SysUser findUserInfoByEmail(@Param("email") String email);


    /**
     * 根据用户名查询用户已经拥有的权限
     * @param loginName 登录名(用户名)
     * @return SysPermission对象的集合
     */
    public List<SysPermission> findPermissionsByUserName(String loginName);

    /**
     * 增加管理员用户角色
     * @param loginName,password,phonenum 登录名(用户名)
     * @return 添加成功或者失败
     */
     public int addNewSysUser(@Param("loginName") String loginName, @Param("password") String password,
                               @Param("phonenum") String phonenum);

    /**
     * 后台登录
     * @param password,phonenum 登录名(用户名)
     * @return
     */
    public SysUser userTypeByPhonenum(@Param("phonenum") String phonenum);

    /**
     * 查询所有用户信息
     */
     public List<SysUser> findSysUserInfo();

    /**
     * 根据id删除用户信息
     */
     public int deleteSysUserById(int userId);
    /**
     * 获取当前用户最大id
     */
    public int getMaxUserId();
    /**
     * 通过userId修改用户角色信息
     */
    public int updateUserRoleInfo(SysUser sysUser);

}
