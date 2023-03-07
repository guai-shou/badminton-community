package com.cloud.badminton.project.invitation.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.cloud.badminton.framework.common.check.Publish;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/2/27 13:54
 */
@Data
@TableName("comment")
public class Comment implements Comparable<Comment> {
    @TableId(type = IdType.AUTO)
    private Long id;

    @NotNull(message = "评论昵称不能为空", groups = {Publish.class})
    private String nickName;

    @NotBlank(message = "评论内容不能为空", groups = {Publish.class})
    private String content;

    @NotNull(message = "文章ID不能为空", groups = {Publish.class})
    @TableField("invitation_id")
    private Long invitationId;

    @TableField("parent_id")
    private Long parentId;

    @TableField("replay_id")
    private Long replayId;

    private String replyNickName;

    @NotNull(message = "是否为博主评论不能为空", groups = {Publish.class})
    private Integer adminReplay;

    @NotNull(message = "评论用户ID不能为空", groups = {Publish.class})
    @TableField("user_id")
    private Long userId;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(exist = false)
    private List<Comment> childComment;

    @Override
    public int compareTo(Comment o) {
        return this.getCreateTime().compareTo(o.getCreateTime());
    }
}
