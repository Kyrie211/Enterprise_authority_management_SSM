package com.krismile.eam_ssm.service.impl;

import com.krismile.eam_ssm.dao.IPermissionDao;
import com.krismile.eam_ssm.domain.Permission;
import com.krismile.eam_ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author krismile
 * @Create 2020-07-28 12:17
 */
@Service
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private IPermissionDao permissionDao;

    @Override
    public List<Permission> findAll() throws Exception {
        return permissionDao.findAll();
    }

    @Override
    public void save(Permission permission) throws Exception {
        permissionDao.save(permission);
    }
}
