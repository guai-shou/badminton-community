package com.cloud.badminton.project.user.controller;

import com.cloud.badminton.framework.common.check.Publish;
import com.cloud.badminton.project.user.entity.Like;
import com.cloud.badminton.project.user.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/2/28 13:25
 */
@RequestMapping("api")
@RestController
public class LikeController {

    @Autowired
    LikeService likeService;

    /*添加喜欢*/
    @PostMapping("/like/add")
    String insertLike(@Validated(Publish.class) @RequestBody Like like) {
        final int i = likeService.insertLike(like);
        return "插入成功";
    }
    /*取消喜欢*/
    @DeleteMapping("/like/delete")
    String deleteLike(@Validated(Publish.class) @RequestBody Like like) {
        final int i = likeService.deleteLike(like);
        return "删除成功";
    }

}
