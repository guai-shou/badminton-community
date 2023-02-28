package com.cloud.badminton.project.friend.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

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

    @TableField("from_uid")
    private Long fromUid;
    @TableField("to_uid")
    private Long toUid;

    private Integer status;

    @TableField("is_read")
    private Integer isRead;

    private String requestMsg;

}
