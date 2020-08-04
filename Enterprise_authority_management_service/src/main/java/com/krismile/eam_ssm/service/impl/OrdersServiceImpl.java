package com.krismile.eam_ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.krismile.eam_ssm.dao.IOrdersDao;
import com.krismile.eam_ssm.domain.Orders;
import com.krismile.eam_ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author krismile
 * @Create 2020-07-24 17:41
 */
@Service
@Transactional
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    private IOrdersDao ordersDao;

    @Override
    public List<Orders> findAll() throws Exception {
        return ordersDao.findAll();
    }

    // 分页查询
    @Override
    public List<Orders> findAll(int page, int pageSize) throws Exception {
        // 开启分页查询
        PageHelper.startPage(page, pageSize);
        return ordersDao.findAll();
    }

    // 查询订单详情
    @Override
    public Orders findById(String ordersId) throws Exception {
        return ordersDao.findById(ordersId);
    }
}
