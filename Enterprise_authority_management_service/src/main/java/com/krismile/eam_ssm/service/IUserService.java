package com.krismile.eam_ssm.service;

import com.krismile.eam_ssm.domain.Role;
import com.krismile.eam_ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @author krismile
 * @Create 2020-07-25 18:25
 */
public interface IUserService extends UserDetailsService {
    List<UserInfo> findAll() throws Exception;

    void save(UserInfo userInfo) throws Exception;

    UserInfo findById(String id) throws Exception;

    List<Role> findOtherRoles(String uid) throws Exception;

    void addRoleToUser(String userId, String[] roleIds) throws Exception;
}
