package com.cloud.badminton.project.friend.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.cloud.badminton.framework.common.check.Publish;
import com.cloud.badminton.framework.common.check.Status;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/2/27 14:07
 */
@Data
@TableName("friend_request")
public class FriendRequest {
    @TableId(type = IdType.AUTO)
    private Long id;

    @NotNull(message = "用户ID不能为空", groups = {Publish.class, Status.class})
    @TableField("from_uid")
    private Long fromUid;

    @NotNull(message = "好友ID不能为空", groups = {Publish.class, Status.class})
    @TableField("to_uid")
    private Long toUid;

    @NotNull(message = "更新状态不能为空", groups = {Status.class})
    private Integer status;

    @TableField("is_read")
    private Integer isRead;

    private String requestMsg;

}
