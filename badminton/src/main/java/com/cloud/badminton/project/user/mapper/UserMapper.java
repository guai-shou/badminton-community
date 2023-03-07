package com.cloud.badminton.project.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.badminton.project.user.entity.User;
import com.cloud.badminton.project.user.entity.vo.UserPasswordVo;
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

    @Select("select u.id, u.name, u.nick_name, u.avatar, u.create_time createTime, u.space_bg spaceBg from user u where u.id=#{id}")
    UserVo selectById(Long id);

    List<UserVo> getUserList(UserVo userVo);

    int updateUserInfo(User user);

    int updateUserPassword(UserPasswordVo userPasswordVo);

    @Select("select * from user where name=#{name}")
    User getUserByName(String name);
}
