package com.cloud.badminton.project.friend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.badminton.project.friend.entity.Friend;
import com.cloud.badminton.project.friend.entity.vo.FriendVo;

import java.util.List;

public interface FriendService extends IService<Friend> {
    /*获取指定ID全部好友*/
    List<FriendVo> getFriendList(Long uid);
    /*增加好友*/
    int insertFriend(Friend friend);
    /*删除好友*/
    int deleteFriend(Friend friend);
    /*搜索指定好友*/
    List<FriendVo> getFriendByName(String name);
    /*更新好友状态*/
    //int updateFriendStatus(Friend friend);
}
