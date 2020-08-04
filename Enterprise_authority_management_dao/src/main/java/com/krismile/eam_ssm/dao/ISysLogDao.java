package com.krismile.eam_ssm.dao;

import com.krismile.eam_ssm.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author krismile
 * @Create 2020-08-02 16:58
 */
public interface ISysLogDao {
    @Select("select * from syslog")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "visitTime", property = "visitTime"),
            @Result(column = "ip", property = "ip"),
            @Result(column = "url", property = "url"),
            @Result(column = "executionTime", property = "executionTime"),
            @Result(column = "method", property = "method"),
            @Result(column = "username", property = "username")
    })
    List<SysLog> findAll() throws Exception;

    @Insert("insert into syslog(visitTime,username,ip,url,executionTime,method) values(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    void save(SysLog log) throws Exception;
}
