package com.cloud.badminton.project.friend.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.cloud.badminton.framework.common.check.Publish;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/2/27 14:08
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("friend_msg_record")
public class FriendMsgRecord {
    @TableId(type = IdType.AUTO)
    private Long id;

    @NotBlank(message = "用户ID不能为空", groups = {Publish.class})
    @TableField("from_uid")
    private Long fromUid;

    @NotBlank(message = "好友ID不能为空", groups = {Publish.class})
    @TableField("to_uid")
    private Long toUid;

    @TableField("is_read")
    private Integer isRead;

    @NotNull(message = "内容不能为空", groups = {Publish.class})
    private String content;

    @NotNull(message = "类型不能为空", groups = {Publish.class})
    private Integer type;

    @TableField("is_undo")
    private Integer isUndo;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;
}
