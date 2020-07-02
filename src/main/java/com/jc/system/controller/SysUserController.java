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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class SysUserController {
    @Autowired
    private SysUserService userService;

    //登录处理
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login (@RequestParam("loginName") String loginName,
                         @RequestParam("password") String password,
                         @RequestParam("phonenum") String phonenum,
                         Model model, HttpSession session) {
        if (loginName != null && loginName != "" && password != null && password != "" &&
                phonenum != null && phonenum != "") {

                Subject subject = SecurityUtils.getSubject();
                UsernamePasswordToken token = new UsernamePasswordToken(loginName, password);
            /**
             * 使用shiro后，这些步骤统一交给shiro处理
             */
                try {
                    subject.login(token);
                    if (subject.isAuthenticated()) {
                        session.setAttribute("loginName", loginName);
                        System.out.println(loginName);
                        //根据传入的用户名查询用户的所有信息
                        SysUser user = userService.findUserInfoByLoginName(loginName);
                        System.out.println(user);

                    } else {
                        model.addAttribute("error", "登陆失败，请重新登录");
                        return "redirect:login";
                    }
                } catch (UnknownAccountException un) {
                    model.addAttribute("error", "用户名不存在");
                    return "redirect:login";
                } catch (IncorrectCredentialsException ice) {
                    model.addAttribute("error", "用户名或密码错误");
                    return "redirect:login";
                } catch (AuthenticationException ae) {
                    ae.printStackTrace();
                }
        } else {
            model.addAttribute("error", "请输入完整的用户名密码");
            return "redirect:login";
        }
        return "redirect:login";
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
    @ResponseBody
    @RequestMapping("/reg")
    public String addNewSysUser(String loginName, String password, String phonenum){
        boolean bool = userService.addNewSysUser(loginName, password, phonenum);
        return bool?"redirect:add":"error";
    }

}
