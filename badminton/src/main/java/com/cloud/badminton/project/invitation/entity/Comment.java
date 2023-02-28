package com.cloud.badminton.project.invitation.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/2/27 13:54
 */
@Data
@TableName("comment")
public class Comment {
    @TableId(type = IdType.AUTO)
    private Long id;

    private String nickName;

    private String content;

    @TableField("invitation_id")
    private Long invitationId;

    @TableField("parent_id")
    private Long parentId;

    @TableField("replay_id")
    private Long replayId;

    private String replyNickName;

    private Integer adminReplay;

    @TableField("user_id")
    private Long userId;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDate createTime;
}
