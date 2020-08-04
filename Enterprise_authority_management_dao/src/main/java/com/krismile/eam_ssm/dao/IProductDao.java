package com.krismile.eam_ssm.dao;

import com.krismile.eam_ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author krismile
 * @Create 2020-07-23 21:04
 */
public interface IProductDao {

    //通过id查询
    @Select("select * from product where id = #{id}")
    Product findById(String id);

    //查询所有的产品信息
    @Select("select * from product")
    List<Product> findAll() throws Exception;

    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product) throws Exception;
}