package com.krismile.eam_ssm.controller;

import com.krismile.eam_ssm.domain.Role;
import com.krismile.eam_ssm.domain.UserInfo;
import com.krismile.eam_ssm.service.IUserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author krismile
 * @Create 2020-07-27 16:40
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    // 给用户添加角色
    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId", required = true) String userId, @RequestParam(name = "ids", required = true) String[] roleIds) throws Exception {
        userService.addRoleToUser(userId, roleIds);
        return "redirect:findAll.do";
    }

    // 查询用户 及 其未关联的角色集合
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id",required = true) String uid) throws Exception {
        UserInfo user = userService.findById(uid);
        List<Role> roleList = userService.findOtherRoles(uid);
        ModelAndView mv = new ModelAndView();
        mv.addObject("user", user);
        mv.addObject("roleList", roleList);
        mv.setViewName("user-role-add");
        return mv;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id", required = true) String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userService.findById(id);
        mv.addObject("user", userInfo);
        mv.setViewName("user-show");
        return mv;
    }

    //查询所有用户基本信息
    @RequestMapping("/findAll.do")
    @Secured("ROLE_ADMIN")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<UserInfo> userList = userService.findAll();
        mv.addObject("userList", userList);
        mv.setViewName("user-list");
        return mv;
    }

    // 添加用户
    @RequestMapping("/save.do")
    public String save(UserInfo userInfo) throws Exception {
        userService.save(userInfo);
        return "redirect:findAll.do";
    }
}
