package com.krismile.eam_ssm.service;

import com.krismile.eam_ssm.domain.Role;

import java.util.List;

/**
 * @author krismile
 * @Create 2020-07-28 12:05
 */
public interface IRoleService {

    List<Role> findAll() throws Exception;

    void save(Role role);

    Role findById(String rid) throws Exception;
}
