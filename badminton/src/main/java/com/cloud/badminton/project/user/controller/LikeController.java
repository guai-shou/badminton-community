package com.cloud.badminton.project.user.controller;

import com.cloud.badminton.framework.common.check.Publish;
import com.cloud.badminton.framework.common.result.ResultVo;
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
    ResultVo insertLike(@Validated(Publish.class) @RequestBody Like like) {
        final int i = likeService.insertLike(like);
        if (i > 0)
            return ResultVo.success();
        return ResultVo.fail();
    }
    /*取消喜欢*/
    @DeleteMapping("/like/delete")
    ResultVo deleteLike(@Validated(Publish.class) @RequestBody Like like) {
        final int i = likeService.deleteLike(like);
        if (i > 0)
            return ResultVo.success();
        return ResultVo.fail();
    }

}
