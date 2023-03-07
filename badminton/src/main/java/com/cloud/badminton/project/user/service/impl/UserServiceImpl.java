package com.cloud.badminton.project.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.badminton.framework.common.exception.APIException;
import com.cloud.badminton.framework.common.exception.AppCode;
import com.cloud.badminton.project.user.entity.User;
import com.cloud.badminton.project.user.entity.vo.UserPasswordVo;
import com.cloud.badminton.project.user.entity.vo.UserVo;
import com.cloud.badminton.project.user.mapper.UserMapper;
import com.cloud.badminton.project.user.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/2/27 14:06
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public UserVo getUserById(Long id) {
        return baseMapper.selectById(id);
    }

    @Override
    public int insertUser(User user) {
        /*如果用户名存在, 插入失败*/
        if (getUserName(user.getName()) > 0) {
            throw new APIException(AppCode.USER_ERROR, "用户名已存在");
        }
        /*如果不存在昵称, 用户名就是昵称*/
        final boolean present = Optional.ofNullable(user.getNickName()).isPresent();
        if (!present) {
            user.setNickName(user.getName());
        }
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return baseMapper.insert(user);
    }

    @Override
    public int deleteUserByIds(List<Long> ids) {
        return baseMapper.deleteBatchIds(ids);
    }

    /*更新用户基本信息*/
    @Override
    public int updateUser(User user) {
        return baseMapper.updateUserInfo(user);
    }

    @Override
    public int getUserName(String name) {
        return baseMapper.getUserName(name);
    }

    @Override
    public String getUserPassword(String name) {
        return baseMapper.getUserPassword(name);
    }

    @Override
    public int updateUserPassword(UserPasswordVo userPasswordVo) {
        userPasswordVo.setPassword(new BCryptPasswordEncoder().encode(userPasswordVo.getPassword()));
        return baseMapper.updateUserPassword(userPasswordVo);
    }

    @Override
    public List<UserVo> getUserList(UserVo userVo) {
        return baseMapper.getUserList(userVo);
    }

    @Override
    public User getUserByName(String name) {
        return baseMapper.getUserByName(name);
    }
}
