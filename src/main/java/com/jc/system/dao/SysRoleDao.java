package com.jc.system.dao;

import com.jc.system.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysRoleDao {
    /**
     * 获取所有角色信息
     * @return 所有角色集合
     */
    public List<SysRole> loadRoleAll();

}
