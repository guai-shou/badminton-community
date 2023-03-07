package com.cloud.badminton.framework.security.service;

import com.cloud.badminton.framework.security.entity.LoginUser;
import com.cloud.badminton.project.user.entity.User;
import com.cloud.badminton.project.user.entity.vo.UserPasswordVo;
import com.cloud.badminton.project.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/3/6 21:21
 */
@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService, UserDetailsPasswordService {


    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User user = userService.getUserByName(username);
        if(null == user) {
            log.info("登录用户: {} 不存在", username);
        }else if (user.getDeleted() != null && user.getDeleted() == 1) {
            log.info("登录用户: {} 已删除", username);
        }

        return createLoginUser(user);
    }

    public UserDetails createLoginUser(User user) {
        return new LoginUser(user);
    }

    @Override
    public UserDetails updatePassword(UserDetails user, String newPassword) {
        final UserPasswordVo userPasswordVo = new UserPasswordVo();
        userPasswordVo.setName(user.getUsername());
        userPasswordVo.setPassword(newPassword);
        final int i = userService.updateUserPassword(userPasswordVo);
        return user;
    }
}
