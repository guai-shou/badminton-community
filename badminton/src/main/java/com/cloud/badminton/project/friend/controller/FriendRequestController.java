package com.cloud.badminton.project.friend.controller;

import com.cloud.badminton.framework.common.check.Publish;
import com.cloud.badminton.framework.common.check.Status;
import com.cloud.badminton.framework.common.result.ResultVo;
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
    /*新增好友请求, 使用WebSocket*/
    //@PostMapping("/friendRequest/add")
    //ResultVo insertFriendRequest(@Validated(Publish.class) @RequestBody FriendRequest friendRequest) {
    //    final int i = friendRequestService.insertFriendRequest(friendRequest);
    //    if (i > 0)
    //        return ResultVo.success();
    //    return ResultVo.fail();
    //}
    /*删除已处理的好友请求*/
    @DeleteMapping("/friendRequest/delete")
    ResultVo deleteFriendRequest(@RequestBody List<Long> ids) {
        final int i = friendRequestService.deleteFriendRequest(ids);
        if (i > 0)
            return ResultVo.success();
        return ResultVo.fail();
    }

    /*更新好友请求状态, 使用WebSocket*/
    //@PostMapping("/friendRequest/updateStatus")
    //ResultVo updateFriendRequestStatus(@Validated(Status.class) @RequestBody FriendRequest friendRequest) {
    //    final int i = friendRequestService.updateFriendRequestStatus(friendRequest);
    //    if (i > 0)
    //        return ResultVo.success();
    //    return ResultVo.fail();
    //}
    /*更新读取状态, 使用WebSocket*/
    //@PostMapping("/friendRequest/updateRead")
    //ResultVo updateFriendRequestRead(@Validated(Publish.class) @RequestBody FriendRequest friendRequest) {
    //    final int i = friendRequestService.updateFriendRequestRead(friendRequest);
    //    if (i > 0)
    //        return ResultVo.success();
    //    return ResultVo.fail();
    //}
}
