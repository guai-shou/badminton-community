package com.cloud.badminton.project.friend.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

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

    private Long uid;

    @TableField("friend_id")
    private Long friendId;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDate createTime;
}
