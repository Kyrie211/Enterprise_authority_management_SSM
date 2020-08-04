package com.krismile.eam_ssm.controller;

import com.krismile.eam_ssm.domain.Role;
import com.krismile.eam_ssm.service.IRoleService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author krismile
 * @Create 2020-07-28 12:03
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;


    // 角色详情查询
    @RequestMapping("/findById.do")
    public ModelAndView findById(String rid) throws Exception {
        Role role = roleService.findById(rid);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("role-show");
        mv.addObject("role", role);
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Role role){
        roleService.save(role);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Role> roleList = roleService.findAll();
        mv.setViewName("role-list");
        mv.addObject("roleList", roleList);
        return mv;
    }
}
