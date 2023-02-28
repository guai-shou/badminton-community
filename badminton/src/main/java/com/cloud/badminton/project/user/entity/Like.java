package com.cloud.badminton.project.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cloud.badminton.framework.common.check.Publish;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/2/27 14:01
 */
@Data
@TableName("like")
public class Like {
    @TableId(type = IdType.AUTO)
    private Long id;
    @NotNull(message = "用户ID不能为空", groups = {Publish.class})
    @TableField("u_id")
    private Long uid;
    @NotNull(message = "文章ID不能为空", groups = {Publish.class})
    @TableField("invitation_id")
    private Long invitationId;
}
