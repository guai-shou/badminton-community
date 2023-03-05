package com.cloud.badminton.project.friend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.badminton.project.friend.entity.FriendRequest;
import com.cloud.badminton.project.friend.entity.vo.FriendRequestVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface FriendRequestMapper extends BaseMapper<FriendRequest> {
    @Select("select f.*, u.nickName receiveName from friend_request f, user u where f.from_uid=#{sendId} and f.to_uid=u.id")
    List<FriendRequestVo> getSendFriendRequest(Long sendId);

    @Select("select f.*, u.nickName sendName from friend_request f, user u where f.to_uid=#{receiveId} and f.from_uid=u.id")
    List<FriendRequestVo> getReceiveFriendRequest(Long receiveId);

    @Insert("insert into friend_request(from_uid, to_uid, status, is_read, requestMsg) VALUE (#{fromUid}, #{toUid}, 0, 0, #{requestMsg})")
    int insertFriendRequest(FriendRequest friendRequest);

    @Update("update friend_request set status=#{status} where from_uid=#{fromUid} and to_uid=#{toUid}")
    int updateFriendRequestStatus(FriendRequest friendRequest);

    @Update("update friend_request set is_read=1 where from_uid=#{fromUid} and to_uid=#{toUid}")
    int updateFriendRequestRead(FriendRequest friendRequest);
}
