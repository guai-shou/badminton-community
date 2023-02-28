package com.cloud.badminton.project.friend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.badminton.project.friend.entity.FriendRequest;
import com.cloud.badminton.project.friend.entity.vo.FriendRequestVo;
import com.cloud.badminton.project.friend.mapper.FriendRequestMapper;
import com.cloud.badminton.project.friend.service.FriendRequestService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/2/27 14:19
 */
@Service
public class FriendRequestServiceImpl extends ServiceImpl<FriendRequestMapper, FriendRequest> implements FriendRequestService {

    @Override
    public List<FriendRequestVo> getSendFriendRequest(Long sendId) {
        return baseMapper.getSendFriendRequest(sendId);
    }

    @Override
    public List<FriendRequestVo> getReceiveFriendRequest(Long receiveId) {
        return baseMapper.getReceiveFriendRequest(receiveId);
    }

    @Override
    public int insertFriendRequest(FriendRequest friendRequest) {
        return baseMapper.insertFriendRequest(friendRequest);
    }

    @Override
    public int deleteFriendRequest(List<Long> ids) {
        return baseMapper.deleteBatchIds(ids);
    }

    @Override
    public int updateFriendRequestStatus(FriendRequest friendRequest) {
        return baseMapper.updateFriendRequestStatus(friendRequest);
    }

    @Override
    public int updateFriendRequestRead(FriendRequest friendRequest) {
        return baseMapper.updateFriendRequestRead(friendRequest);
    }
}
