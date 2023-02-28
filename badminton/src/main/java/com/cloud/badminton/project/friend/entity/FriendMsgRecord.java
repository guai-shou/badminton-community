package com.cloud.badminton.project.friend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/2/27 14:08
 */
@Data
@TableName("friend_msg_record")
public class FriendMsgRecord {
    @TableId(type = IdType.AUTO)
    private Long id;
    @TableField("from_uid")
    private Long fromUid;
    @TableField("to_uid")
    private Long toUid;

    private Integer status;

    @TableField("is_read")
    private Integer isRead;

    private String content;

    private Integer type;
    @TableField("is_undo")
    private Integer isUndo;
}
