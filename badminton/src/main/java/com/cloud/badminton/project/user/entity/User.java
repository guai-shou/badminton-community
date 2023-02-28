package com.cloud.badminton.project.user.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/2/27 14:01
 */
@Data
@TableName("user")
public class User {
    @TableId(type = IdType.AUTO)
    private Long id;

    private String nickName;

    private String name;

    private String password;

    private String avatar;

    @TableField("space_bg")
    private String spaceBg;

    private String description;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDate createTime;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDate updateTime;

    @TableLogic
    private Integer deleted;
}
