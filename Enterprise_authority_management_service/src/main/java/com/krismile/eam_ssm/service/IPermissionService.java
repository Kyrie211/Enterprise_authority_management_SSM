package com.krismile.eam_ssm.service;

import com.krismile.eam_ssm.domain.Permission;

import java.util.List;

/**
 * @author krismile
 * @Create 2020-07-28 12:17
 */
public interface IPermissionService {

    List<Permission> findAll() throws Exception;

    void save(Permission permission) throws Exception;
}
