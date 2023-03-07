package com.cloud.badminton.project.friend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.badminton.project.friend.entity.Friend;
import com.cloud.badminton.project.friend.entity.vo.FriendVo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/2/27 14:16
 */
@Mapper
public interface FriendMapper extends BaseMapper<Friend> {
    @Select("select f.id, u.id uid, u.nick_name, u.avatar from friend f, user u where f.uid=#{uid} and f.friend_id=u.id")
    List<FriendVo> getFriendList(Long uid);

    @Delete("delete from friend where uid=#{uid} and friend_id = #{friendId}")
    int deleteFriend(Friend friend);

    @Select("select f.id, u.id uid, u.nick_name, u.avatar from friend f, user u where f.friend_id=u.id and u.name=#{name}")
    List<FriendVo> getFriendByName(String name);

    @Select("select count(id) from friend where (uid=#{uid} and friend_id=#{friendId}) or (uid=#{friendId} and friend_id=#{uid})")
    int isFriend(Long uid, Long friendId);
}
