package com.cloud.badminton.project.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.badminton.project.user.entity.Like;
import com.cloud.badminton.project.user.mapper.LikeMapper;
import com.cloud.badminton.project.user.service.LikeService;
import org.springframework.stereotype.Service;

import javax.swing.*;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/2/27 14:06
 */
@Service
public class LikeServiceImpl extends ServiceImpl<LikeMapper, Like> implements LikeService {
    @Override
    public int insertLike(Like like) {
        // 收藏文章
        return baseMapper.insertLike(like);
    }

    @Override
    public int deleteLike(Like like) {
        // 取消收藏文章
        return baseMapper.deleteByInvitationId(like);
    }
}
