package com.krismile.eam_ssm.service;

import com.krismile.eam_ssm.domain.Orders;

import java.util.List;

/**
 * @author krismile
 * @Create 2020-07-24 17:41
 */
public interface IOrdersService {
    List<Orders> findAll() throws Exception;

    List<Orders> findAll(int page, int pageSize) throws Exception;

    Orders findById(String ordersId) throws Exception;
}
