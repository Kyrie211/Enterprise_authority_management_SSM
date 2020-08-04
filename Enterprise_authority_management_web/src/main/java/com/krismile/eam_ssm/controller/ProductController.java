package com.krismile.eam_ssm.controller;

import com.github.pagehelper.PageInfo;
import com.krismile.eam_ssm.domain.Orders;
import com.krismile.eam_ssm.domain.Product;
import com.krismile.eam_ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author krismile
 * @Create 2020-07-23 21:53
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    // 保存/添加产品信息
    @RequestMapping("/save.do")
    public String save(Product product) throws Exception{
        productService.save(product);
        return "redirect:findAll.do";
    }

    //查询全部产品
//    @RequestMapping("/findAll.do")
//    public ModelAndView findAll() throws Exception {
//        ModelAndView mv = new ModelAndView();
//        List<Product> ps = productService.findAll();
//        mv.addObject("productList", ps);
//        mv.setViewName("product-list");
//        return mv;
//    }

    //分页查询全部产品
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true) Integer page, @RequestParam(name = "pageSize", required = true) Integer pageSize) throws Exception {
        List<Product> productList = productService.findAll(page, pageSize);
        PageInfo pageInfo = new PageInfo(productList);
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("product-list");
        return mv;
    }

}
