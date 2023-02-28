package com.cloud.badminton.project.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

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
    @TableField("u_id")
    private Long uid;
    @TableField("invitation_id")
    private Long invitationId;
}
