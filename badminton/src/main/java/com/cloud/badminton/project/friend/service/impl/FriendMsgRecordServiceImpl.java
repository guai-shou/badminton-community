package com.cloud.badminton.project.friend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.badminton.project.friend.entity.FriendMsgRecord;
import com.cloud.badminton.project.friend.mapper.FriendMsgRecordMapper;
import com.cloud.badminton.project.friend.service.FriendMsgRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/2/27 14:19
 */
@Service
public class FriendMsgRecordServiceImpl extends ServiceImpl<FriendMsgRecordMapper, FriendMsgRecord> implements FriendMsgRecordService {
    @Override
    public List<FriendMsgRecord> getFriendMsgRecord(Long sendId, Long receiveId) {
        return baseMapper.getFriendMsgRecord(sendId, receiveId);
    }

    @Override
    public int insertFriendMsgRecord(FriendMsgRecord friendMsgRecord) {
        return baseMapper.insertFriendMsgRecord(friendMsgRecord);
    }

    @Override
    public int updateFriendMsgRecordUndo(FriendMsgRecord friendMsgRecord) {
        return baseMapper.updateFriendMsgRecordUndo(friendMsgRecord);
    }

    @Override
    public int updateFriendMsgRecordRead(FriendMsgRecord friendMsgRecord) {
        return baseMapper.updateFriendMsgRecordRead(friendMsgRecord);
    }
}
