package com.krismile.eam_ssm.dao;

import com.krismile.eam_ssm.domain.Role;
import com.krismile.eam_ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author krismile
 * @Create 2020-07-25 18:28
 */
public interface IUserDao {

    @Select("select * from users where username = #{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "email", property = "email"),
            @Result(column = "password", property = "password"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(column = "status", property = "status"),
            @Result(column = "id", property = "roles", javaType = List.class, many = @Many(select = "com.krismile.eam_ssm.dao.IRoleDao.findRoleByUserId"))
    })
    UserInfo findByUsername(String username) throws Exception;

    @Select("select * from users")
    List<UserInfo> findAll() throws Exception;

    @Insert("insert into users(email,username,password,phoneNum,status) values(#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo) throws Exception;

    // 查询用户详细信息
    @Select("select * from users where id = #{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "email", property = "email"),
            @Result(column = "password", property = "password"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(column = "status", property = "status"),
            @Result(column = "id", property = "roles", javaType = List.class, many = @Many(select = "com.krismile.eam_ssm.dao.IRoleDao.findRoleByUserId"))
    })
    UserInfo findById(String id);

    // 查询uid用户 未 关联的角色集合
    @Select("select * from role where id not in (select roleId from users_role where userId = #{uid})")
    List<Role> findOtherRoles(String uid) throws Exception;

    // 给用户添加角色
    @Insert("insert into users_role(userId, roleId) values(#{userId}, #{roleId})")
    void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId) throws Exception;
}
