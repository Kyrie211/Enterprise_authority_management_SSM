package com.krismile.eam_ssm.dao;

import com.krismile.eam_ssm.domain.Orders;
import org.apache.ibatis.annotations.*;
import org.aspectj.weaver.ast.Or;

import java.util.List;

/**
 * @author krismile
 * @Create 2020-07-24 17:42
 */
public interface IOrdersDao {

    // 查询所有
    @Select("select * from orders")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "product", column = "productId", one = @One(select = "com.krismile.eam_ssm.dao.IProductDao.findById"))
    })
    List<Orders> findAll() throws Exception;

    @Select("select * from orders where id = #{ordersId}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "product", column = "productId", one = @One(select = "com.krismile.eam_ssm.dao.IProductDao.findById")),
            @Result(property = "member", column = "memberid", one = @One(select = "com.krismile.eam_ssm.dao.IMemberDao.findById")),
            @Result(property = "travellers", column = "id", many = @Many(select = "com.krismile.eam_ssm.dao.ITravellerDao.findById"))
    })
    Orders findById(String ordersId) throws Exception;
}
