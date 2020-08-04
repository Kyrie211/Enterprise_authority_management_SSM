package com.krismile.eam_ssm.dao;

import com.krismile.eam_ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author krismile
 * @Create 2020-07-25 9:34
 */
public interface ITravellerDao {

    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId = #{ordersId})")
    List<Traveller> findById(String ordersId) throws Exception;
}
