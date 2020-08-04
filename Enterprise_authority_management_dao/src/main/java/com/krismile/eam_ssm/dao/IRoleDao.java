package com.krismile.eam_ssm.dao;

import com.krismile.eam_ssm.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author krismile
 * @Create 2020-07-25 18:31
 */
public interface IRoleDao {

    @Select("select * from role where id in (select roleId from users_role where userId = #{userId})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            // 使用role表的id值查询权限的相关数据
            @Result(property = "permissions", column = "id", javaType = java.util.List.class, many = @Many(select = "com.krismile.eam_ssm.dao.IPermissionDao.findPermissionByRoleId"))
    })
    List<Role> findRoleByUserId(String userId) throws Exception;

    @Select("select * from role")
    List<Role> findAll() throws Exception;

    @Insert("insert into role(roleName, roleDesc) values(#{roleName}, #{roleDesc})")
    void save(Role role);

    // 角色详情查询
    @Select("select * from role where id = #{rid}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(column = "roleName", property = "roleName"),
            @Result(column = "roleDesc", property = "roleDesc"),
            // 使用role表的id值查询权限的相关数据
            @Result(property = "permissions", column = "id", javaType = java.util.List.class, many = @Many(select = "com.krismile.eam_ssm.dao.IPermissionDao.findPermissionByRoleId"))
    })
    Role findById(String rid) throws Exception;
}

