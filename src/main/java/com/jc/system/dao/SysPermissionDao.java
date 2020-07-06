package com.jc.system.dao;

import com.jc.system.entity.SysPermission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysPermissionDao {
    /**
     * 获取所有权限信息
     * @return  返回值类型为list
     */
    public List<SysPermission> loadPermissionAll();

}
