package com.cloud.badminton.project.friend.controller;

import com.cloud.badminton.framework.common.check.Publish;
import com.cloud.badminton.project.friend.entity.Friend;
import com.cloud.badminton.project.friend.entity.vo.FriendVo;
import com.cloud.badminton.project.friend.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/2/28 12:00
 */
@RequestMapping("/api")
@RestController
public class FriendController {

    @Autowired
    FriendService friendService;

    /*获取指定ID全部好友*/
    @GetMapping("/friendList/{uid}")
    List<FriendVo> getFriendList(@PathVariable Long uid) {
        return friendService.getFriendList(uid);
    }
    /*增加好友*/
    @PostMapping("/friend/add")
    String insertFriend(@Validated(Publish.class) @RequestBody Friend friend) {
        final int i = friendService.insertFriend(friend);
        return "添加成功";
    }
    /*删除好友*/
    @DeleteMapping("/friend/delte")
    String deleteFriend(@Validated(Publish.class) @RequestBody Friend friend) {
        final int i = friendService.deleteFriend(friend);
        return "删除成功";
    }
    /*根据前端信息搜索指定好友*/
    @PostMapping("/friend")
    List<FriendVo> getFriendByName(@RequestBody String name) {
        return friendService.getFriendByName(name);
    }

}
