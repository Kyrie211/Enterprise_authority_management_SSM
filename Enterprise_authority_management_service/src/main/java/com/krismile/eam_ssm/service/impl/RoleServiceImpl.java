package com.krismile.eam_ssm.service.impl;

import com.krismile.eam_ssm.dao.IRoleDao;
import com.krismile.eam_ssm.domain.Role;
import com.krismile.eam_ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author krismile
 * @Create 2020-07-28 12:05
 */
@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleDao roleDao;

    @Override
    public List<Role> findAll() throws Exception {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    // 角色详情查询
    @Override
    public Role findById(String rid) throws Exception {
        return roleDao.findById(rid);
    }
}
