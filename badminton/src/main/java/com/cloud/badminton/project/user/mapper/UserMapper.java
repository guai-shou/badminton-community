package com.cloud.badminton.project.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.badminton.project.user.entity.User;
import com.cloud.badminton.project.user.entity.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/2/27 14:05
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("select count(name) from user where name=#{name}")
    int getUserName(String name);

    @Select("select password from user where name=#{name}")
    String getUserPassword(String name);

    @Select("select u.id, u.name, u.nickName, u.avatar, u.create_time, u.space_bg from user u where u.id=#{id}")
    UserVo selectById(Long id);

    List<UserVo> getUserList(UserVo userVo);
}