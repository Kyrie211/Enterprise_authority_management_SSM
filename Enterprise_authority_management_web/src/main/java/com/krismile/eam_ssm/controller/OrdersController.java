package com.krismile.eam_ssm.controller;

import com.github.pagehelper.PageInfo;
import com.krismile.eam_ssm.domain.Orders;
import com.krismile.eam_ssm.service.IOrdersService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.crypto.interfaces.PBEKey;
import java.util.List;

/**
 * @author krismile
 * @Create 2020-07-24 17:39
 */
@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private IOrdersService ordersService;

    // 查询订单详情
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true) String ordersId) throws Exception {
        Orders orders = ordersService.findById(ordersId);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("orders-show");
        mv.addObject("orders", orders);
        return mv;
    }

    //分页查询
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true)Integer page, @RequestParam(name = "pageSize",required = true) Integer pageSize) throws Exception {
        List<Orders> ordersList = ordersService.findAll(page, pageSize);
        PageInfo pageInfo = new PageInfo(ordersList);
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("orders-list");
        return mv;
    }
}
