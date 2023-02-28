package com.cloud.badminton.project.invitation.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/2/27 21:32
 */
@Data
@TableName("invitation_con_tag")
public class TagMapping {
    private Long id;
    @TableField("invitation_id")
    private Long invitationId;
    @TableField("tag_id")
    private Long tagId;
}
