package com.cloud.badminton.project.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.badminton.project.user.entity.Like;

public interface LikeService extends IService<Like> {

    /*添加喜欢*/
    int insertLike(Like like);
    /*取消喜欢*/
    int deleteLike(Like like);


}
