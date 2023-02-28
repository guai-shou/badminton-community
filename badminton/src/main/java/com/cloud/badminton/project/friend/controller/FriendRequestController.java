package com.cloud.badminton.project.friend.controller;

import com.cloud.badminton.framework.common.check.Publish;
import com.cloud.badminton.framework.common.check.Status;
import com.cloud.badminton.project.friend.entity.FriendRequest;
import com.cloud.badminton.project.friend.entity.vo.FriendRequestVo;
import com.cloud.badminton.project.friend.service.FriendRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/2/28 12:06
 */
@RequestMapping("/api")
@RestController
public class FriendRequestController {

    @Autowired
    FriendRequestService friendRequestService;

    /*根据ID获取发送好友列表*/
    @GetMapping("/sendFriendRequest/{id}")
    List<FriendRequestVo> getSendFriendRequest(@PathVariable Long id) {
        return friendRequestService.getSendFriendRequest(id);
    }
    /*根据ID获取好友请求*/
    @GetMapping("/receiveFriendRequest/{id}")
    List<FriendRequestVo> getReceiveFriendRequest(@PathVariable Long id) {
        return friendRequestService.getReceiveFriendRequest(id);
    }
    /*新增好友请求*/
    @PostMapping("/friendRequest/add")
    String insertFriendRequest(@Validated(Publish.class) @RequestBody FriendRequest friendRequest) {
        final int i = friendRequestService.insertFriendRequest(friendRequest);
        return "插入成功";
    }
    /*删除好友请求*/
    @DeleteMapping("/friendRequest/delete")
    String deleteFriendRequest(@RequestBody List<Long> ids) {
        final int i = friendRequestService.deleteFriendRequest(ids);
        return "删除成功";
    }

    /*更新好友请求状态*/
    @PostMapping("/friendRequest/updateStatus")
    String updateFriendRequestStatus(@Validated(Status.class) @RequestBody FriendRequest friendRequest) {
        final int i = friendRequestService.updateFriendRequestStatus(friendRequest);
        return "更新成功";
    }
    /*更新读取状态*/
    @PostMapping("/friendRequest/updateRead")
    String updateFriendRequestRead(@Validated(Publish.class) @RequestBody FriendRequest friendRequest) {
        final int i = friendRequestService.updateFriendRequestRead(friendRequest);
        return "更新成功";
    }
}
