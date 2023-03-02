package com.cloud.badminton.project.friend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.badminton.project.friend.entity.FriendMsgRecord;

import java.time.LocalDateTime;
import java.util.List;

public interface FriendMsgRecordService extends IService<FriendMsgRecord> {
    /*获取聊天记录*/
    List<FriendMsgRecord> getFriendMsgRecord(Long sendId, Long receiveId);
    /*增加聊天记录*/
    int insertFriendMsgRecord(FriendMsgRecord friendMsgRecord);
    /*撤销聊天记录*/
    int updateFriendMsgRecordUndo(FriendMsgRecord friendMsgRecord);
    /*更新已读状态*/
    int updateFriendMsgRecordRead(FriendMsgRecord friendMsgRecord, LocalDateTime readTime);
}
