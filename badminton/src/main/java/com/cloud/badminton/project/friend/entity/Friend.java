package com.cloud.badminton.project.friend.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.cloud.badminton.framework.common.check.Publish;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/2/27 14:07
 */
@Data
@TableName("friend")
public class Friend {
    @TableId(type = IdType.AUTO)
    private Long id;

    @NotNull(message = "用户ID不能为空", groups = {Publish.class})
    private Long uid;

    @NotNull(message = "好友ID不能为空", groups = {Publish.class})
    @TableField("friend_id")
    private Long friendId;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDate createTime;
}
