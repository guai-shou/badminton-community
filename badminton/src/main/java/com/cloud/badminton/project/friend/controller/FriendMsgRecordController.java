package com.cloud.badminton.project.friend.controller;

import com.cloud.badminton.framework.common.check.Publish;
import com.cloud.badminton.framework.common.result.ResultVo;
import com.cloud.badminton.project.friend.entity.FriendMsgRecord;
import com.cloud.badminton.project.friend.service.FriendMsgRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/2/28 12:17
 */
@RequestMapping("/api")
@RestController
public class FriendMsgRecordController {

    @Autowired
    FriendMsgRecordService friendMsgRecordService;

    /*获取聊天记录*/
    @GetMapping("/friendMsgRecord/{sendId}/{receiveId}")
    List<FriendMsgRecord> getFriendMsgRecord(@PathVariable Long sendId, @PathVariable Long receiveId) {
        return friendMsgRecordService.getFriendMsgRecord(sendId, receiveId);
    }
    /*增加聊天记录, 使用WebSocket*/
    //@PostMapping("/friendMsgRecord/add")
    //ResultVo insertFriendMsgRecord(@Validated(Publish.class) @RequestBody FriendMsgRecord friendMsgRecord) {
    //    final int i = friendMsgRecordService.insertFriendMsgRecord(friendMsgRecord);
    //    if (i > 0)
    //        return ResultVo.success();
    //    return ResultVo.fail();
    //}
    /*撤销聊天记录, 使用WebSocket*/
    //@PostMapping("/friendMsgRecord/undo")
    //ResultVo updateFriendMsgRecordUndo(@Validated(Publish.class) @RequestBody FriendMsgRecord friendMsgRecord) {
    //    final int i = friendMsgRecordService.updateFriendMsgRecordUndo(friendMsgRecord);
    //    if (i > 0)
    //        return ResultVo.success();
    //    return ResultVo.fail();
    //}
    /*更新已读状态, 使用WebSocket*/
    //@PostMapping("/friendMsgRecord/read")
    //ResultVo updateFriendMsgRecordRead(@Validated(Publish.class) @RequestBody FriendMsgRecord friendMsgRecord) {
    //    final int i = friendMsgRecordService.updateFriendMsgRecordRead(friendMsgRecord);
    //    if (i > 0)
    //        return ResultVo.success();
    //    return ResultVo.fail();
    //}

}
