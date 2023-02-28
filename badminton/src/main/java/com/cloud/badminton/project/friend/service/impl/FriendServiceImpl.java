package com.cloud.badminton.project.friend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.badminton.project.friend.entity.Friend;
import com.cloud.badminton.project.friend.entity.vo.FriendVo;
import com.cloud.badminton.project.friend.mapper.FriendMapper;
import com.cloud.badminton.project.friend.service.FriendService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/2/27 14:18
 */
@Service
public class FriendServiceImpl extends ServiceImpl<FriendMapper, Friend> implements FriendService {
    @Override
    public List<FriendVo> getFriendList(Long uid) {
        return baseMapper.getFriendList(uid);
    }

    @Override
    public int insertFriend(Friend friend) {
        return baseMapper.insert(friend);
    }

    @Override
    public int deleteFriend(Friend friend) {
        return baseMapper.deleteFriend(friend);
    }

    @Override
    public List<FriendVo> getFriendByName(String name) {
        return baseMapper.getFriendByName(name);
    }

}
