package com.cloud.badminton.project.user.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.cloud.badminton.framework.common.check.Publish;
import lombok.Data;

import javax.validation.constraints.NotNull;
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

    @NotNull(message = "用户名不能为空", groups = {Publish.class})
    private String name;

    @NotNull(message = "密码不能为空", groups = {Publish.class})
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