package com.krismile.eam_ssm.dao;

import com.krismile.eam_ssm.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author krismile
 * @Create 2020-07-27 20:58
 */
public interface IPermissionDao {

    @Select("select * from permission where id in (select permissionid from role_permission where roleid=#{roleId})")
    List<Permission> findPermissionByRoleId(String roleId);

    @Select("select * from permission")
    List<Permission> findAll() throws Exception;

    @Insert("insert into permission(permissionName, url) values(#{permissionName}, #{url})")
    void save(Permission permission);
}
