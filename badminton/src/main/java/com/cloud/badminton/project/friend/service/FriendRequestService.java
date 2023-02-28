package com.cloud.badminton.project.friend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.badminton.project.friend.entity.FriendRequest;
import com.cloud.badminton.project.friend.entity.vo.FriendRequestVo;

import java.util.List;

public interface FriendRequestService extends IService<FriendRequest> {
    /*根据ID获取发送好友列表*/
    List<FriendRequestVo> getSendFriendRequest(Long id);
    /*根据ID获取好友请求*/
    List<FriendRequestVo> getReceiveFriendRequest(Long id);
    /*新增好友请求*/
    int insertFriendRequest(FriendRequest friendRequest);
    /*删除好友请求*/
    int deleteFriendRequest(List<Long> ids);

    /*更新好友请求状态*/
    int updateFriendRequestStatus(FriendRequest friendRequest);
    /*更新读取状态*/
    int updateFriendRequestRead(FriendRequest friendRequest);
}
