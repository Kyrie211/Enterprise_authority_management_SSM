package com.krismile.eam_ssm.service.impl;

import com.krismile.eam_ssm.dao.IUserDao;
import com.krismile.eam_ssm.domain.Role;
import com.krismile.eam_ssm.domain.UserInfo;
import com.krismile.eam_ssm.service.IUserService;
import com.krismile.eam_ssm.utils.BCryptPasswordEncoderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author krismile
 * @Create 2020-07-25 18:26
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    // Spring security 方式下的用户登录方法
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try {
             userInfo = userDao.findByUsername(username);
        } catch (Exception e) {
            System.out.println("用户不存在");
            e.printStackTrace();
        }
        if(userInfo==null) throw new RuntimeException("用户不存在");

        List<Role> roles = userInfo.getRoles();
        List<SimpleGrantedAuthority> authority = getAuthority(roles);
        //"{noop}" +
        // 密码已经加密了，解密由spring security自行操作
        User user = new User(userInfo.getUsername(), userInfo.getPassword(), userInfo.getStatus() == 0 ? false : true, true, true, true, authority);

        return user;
    }

    private List<SimpleGrantedAuthority> getAuthority(List<Role> roles){
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for(Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return authorities;
    }

    // 查询所有用户基本信息
    @Override
    public List<UserInfo> findAll() throws Exception {
        return userDao.findAll();
    }

    // 保存用户
    @Override
    public void save(UserInfo userInfo) throws Exception {
        // 密码加密
        userInfo.setPassword(BCryptPasswordEncoderUtils.encode(userInfo.getPassword()));
        // dao
        userDao.save(userInfo);
    }

    // 通过id查询用户详细信息（包含角色以及相关权限）
    @Override
    public UserInfo findById(String id) throws Exception {
        return userDao.findById(id);
    }


    // 查询uid用户 未 关联的角色集合
    @Override
    public List<Role> findOtherRoles(String uid) throws Exception {
        return userDao.findOtherRoles(uid);
    }

    // 给用户添加角色
    @Override
    public void addRoleToUser(String userId, String[] roleIds) throws Exception {
        for(String roleId : roleIds){
            userDao.addRoleToUser(userId, roleId);
        }
    }
}
