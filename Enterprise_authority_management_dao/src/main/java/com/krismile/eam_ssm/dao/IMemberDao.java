package com.krismile.eam_ssm.dao;

import com.krismile.eam_ssm.domain.Member;
import org.apache.ibatis.annotations.Select;

/**
 * @author krismile
 * @Create 2020-07-25 9:33
 */
public interface IMemberDao {

    @Select("select * from member where id = #{id}")
    Member findById(String id) throws Exception;
}
