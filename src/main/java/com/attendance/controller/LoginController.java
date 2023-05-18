package com.attendance.controller;

import com.attendance.entity.domain.Admin;
import com.attendance.entity.domain.Staff;
import com.attendance.entity.vo.LoginVo;
import com.attendance.service.AdminService;
import com.attendance.service.StaffService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @author zhouyihang
 * @version 1.0
 * @description: TODO
 * @date 2023/5/14 14:38
 */
@Controller
public class LoginController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private StaffService staffService;

    @GetMapping({"/","/login"})
    public String toLogin(){
        return "login";
    }

    @PostMapping("/doLogin")
    public ModelAndView doLogin(LoginVo loginVo, ModelAndView modelAndView, HttpSession session){
        if(loginVo.getIdentity() == 0){
            Admin admin = adminService.getOne(new LambdaQueryWrapper<Admin>().eq(Admin::getUsername, loginVo.getUsername()).eq(Admin::getPassword, loginVo.getPassword()));
            if(admin == null){
                modelAndView.addObject("msg","账号或密码错误");
                modelAndView.setViewName("login");
            }else {
                session.setAttribute("user",admin);
                modelAndView.setViewName("detail_admin");
            }
            return modelAndView;
        }else {
            Staff staff = staffService.getOne(new LambdaQueryWrapper<Staff>().eq(Staff::getUsername, loginVo.getUsername()).eq(Staff::getPassword, loginVo.getPassword()));
            if(staff == null){
                modelAndView.addObject("msg","账号或密码错误");
                modelAndView.setViewName("login");
            }else {
                session.setAttribute("user",staff);
                modelAndView.setViewName("detail_user");
            }
            return modelAndView;
        }
    }


    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "login";
    }

}
