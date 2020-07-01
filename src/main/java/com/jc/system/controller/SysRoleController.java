package com.jc.system.controller;

import com.jc.system.entity.SysRole;
import com.jc.system.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SysRoleController {
    @Autowired
    private SysRoleService roleService;
    //获取所有角色信息
    @RequestMapping("/loadRoleAll")
    public String loadRoleAll(Model model,
                              @RequestParam(defaultValue = "1",value = "page")Integer page){
//        PageHelper.startPage(page,2);
        List<SysRole> roleList = roleService.loadRoleAll();
//        PageInfo<SysRole> pageInfo = new PageInfo<>(roleList);
//        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("roleList",roleList);
        return "role";
    }

}
