package com.cloud.badminton.project.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.badminton.project.user.entity.User;
import com.cloud.badminton.project.user.entity.vo.UserPasswordVo;
import com.cloud.badminton.project.user.entity.vo.UserVo;

import java.util.List;

public interface UserService extends IService<User> {
    /*获取全部用户*/
    //List<UserVo> getUserList();
    /*根据用户ID查询信息*/
    UserVo getUserById(Long id);
    /*增加用户*/
    int insertUser(User user);
    /*删除用户*/
    int deleteUserByIds(List<Long> ids);
    /*更新用户*/
    int updateUser(User user);
    /*判断用户名*/
    int getUserName(String name);
    /*更新用户密码*/
    int updateUserPassword(UserPasswordVo userPasswordVo);
    /*获取用户密码*/
    String getUserPassword(String name);
    /*根据前端条件查询用户 参数可加字段*/
    List<UserVo> getUserList(UserVo user);
}
