package com.cloud.badminton.project.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.badminton.project.user.entity.User;
import com.cloud.badminton.project.user.entity.vo.UserVo;
import com.cloud.badminton.project.user.mapper.UserMapper;
import com.cloud.badminton.project.user.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return baseMapper.insert(user);
    }

    @Override
    public int deleteUserByIds(List<Long> ids) {
        return baseMapper.deleteBatchIds(ids);
    }

    @Override
    public int updateUser(User user) {
        return baseMapper.updateById(user);
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
    public List<UserVo> getUserList(UserVo userVo) {
        return baseMapper.getUserList(userVo);
    }
}
