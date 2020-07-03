package com.jc.system.controller;

import com.jc.system.entity.SysUser;
import com.jc.system.entity.User_Role;
import com.jc.system.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class SysUserController {
    @Autowired
    private SysUserService userService;

    //前端登录处理
    @RequestMapping(value = "/qtLogin", method = RequestMethod.POST)
    public String qtLogin (@RequestParam("email") String email,
                         @RequestParam("password") String password,
                         Model model, HttpSession session) {
        if (email != null && email != "" && password != null && password != "" ) {
                Subject subject = SecurityUtils.getSubject();
                UsernamePasswordToken token = new UsernamePasswordToken(email, password);
            /**
             * 使用shiro后，这些步骤统一交给shiro处理
             */
                try {
                    subject.login(token);
                    if (subject.isAuthenticated()) {
                        session.setAttribute("email", email);
                        //根据传入的用户名查询用户的所有信息
                        SysUser user = userService.findUserInfoByEmail(email);
                        System.out.println(user);
                    } else {
                        model.addAttribute("error", "登陆失败，请重新登录");
                        return "redirect:roleLogin";
                    }
                } catch (UnknownAccountException un) {
                    model.addAttribute("error", "邮箱不存在");
                    return "redirect:roleLogin";
                } catch (IncorrectCredentialsException ice) {
                    model.addAttribute("error", "邮箱或密码错误");
                    return "redirect:roleLogin";
                } catch (AuthenticationException ae) {
                    ae.printStackTrace();
                }
        } else {
            model.addAttribute("error", "请输入完整的邮箱和密码");
            return "redirect:roleLogin";
        }
        return "redirect:main1";
    }

    //后台登录
    @RequestMapping(value = "/htLogin", method = RequestMethod.POST)
    public String htLogin(@RequestParam("password") String password, @RequestParam("phonenum") String phonenum,
                           Model model, HttpSession session){
        System.out.println(password);
        System.out.println(phonenum);
        if (password != null && password != "" && phonenum != null && phonenum != ""){
            SysUser user = userService.userTypeByPhonenum(phonenum);
            int State = user.getState();
            System.out.println(State);
            if (State == 1) {
                return "redirect:main1";
            } else if (State == 2) {
                return "roleLogin";
            }
        }else {
            model.addAttribute("error", "请输入完整的用户手机号");
            return "redirect:roleLogin";
        }
        return "redirect:main1";
    }

    //普通用户有权访问的模块
    @RequiresPermissions(value = {"user_forbidden"})
    //@RequestMapping("/memberView")
    public String memberView(Model model){
        return "member";
    }
    // 当用户权限不足时，访问的页面
    @RequestMapping("/unOauth")
    public String showUnOauth(){
        return "unauth";
    }
    //用户登出时
    @RequestMapping("/logout")
    public String logout(){
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.logout();//清空用户在shiro中的驻留信息
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        return "redirect:login";
    }
    //会员用户有权访问的模块11
    //@RequiresPermissions(value = {"user_edit"})
    @RequestMapping("/main")
    public String main(){
        return "main";
    }

    //增加新用户
    @RequestMapping("/reg")
    public String addNewSysUser(String loginName, String password, String phonenum){
        boolean bool = userService.addNewSysUser(loginName, password, phonenum);
        return bool?"redirect:add":"error";
    }

    //查询所有用户
    @RequestMapping("/findSysUserInfo")
    public List<SysUser> findSysUserInfo(){
        List<SysUser> userList = userService.findSysUserInfo();
        return userList;
    }

    //通过email查询单个用户
    @RequestMapping("/findSysUserInfoByEmail")
    public SysUser findSysUserInfoByEmail(String email){
        SysUser userLists = userService.findUserInfoByEmail(email);
        return userLists;
    }

    //根据id删除用户信息
    @RequestMapping("/deleteSysUserById")
    public String deleteSysUserById(int id){
        boolean bool = userService.deleteSysUserById(id);
        return "1";
    }


}
