package com.cloud.badminton.project.friend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.badminton.project.friend.entity.FriendMsgRecord;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/2/27 14:17
 */
@Mapper
public interface FriendMsgRecordMapper extends BaseMapper<FriendMsgRecord> {

    @Select("select * from friend_msg_record where (from_uid=#{sendId} and to_uid=#{receiveId}) or (from_uid=#{receiveId} and to_uid=#{sendId}) order by create_time")
    List<FriendMsgRecord> getFriendMsgRecord(Long sendId, Long receiveId);

    @Update("update friend_msg_record set is_undo=1 where from_uid=#{fromUid} and to_uid=#{toUid}")
    int updateFriendMsgRecordUndo(FriendMsgRecord friendMsgRecord);

    @Update("update friend_msg_record set is_read=1 where from_uid=#{fromUid} and to_uid=#{toUid} and date_format(create_time, '%y%m%d %h%i%s') < date_format(#{createTime}, '%y%m%d %h%i%s')")
    int updateFriendMsgRecordRead(FriendMsgRecord friendMsgRecord);

    @Insert("insert into friend_msg_record(from_uid, to_uid, is_read, content, type, is_undo) VALUE (#{fromUid}, #{toUid}, 0, #{content}, #{type}, 0)")
    int insertFriendMsgRecord(FriendMsgRecord friendMsgRecord);
}
