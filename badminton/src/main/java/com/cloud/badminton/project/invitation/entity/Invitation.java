package com.cloud.badminton.project.invitation.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.cloud.badminton.framework.common.check.Publish;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/2/27 13:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("invitation")
public class Invitation {
    @TableId(type = IdType.AUTO)
    private Long id;


    @NotBlank(message = "标题不能为空", groups = {Publish.class})
    private String title;

    @NotBlank(message = "正文内容不能为空", groups = {Publish.class})
    private String content;

    private String img;

    @NotNull(message = "用户ID不能为空", groups = {Publish.class})
    private Long uid;

    private Long stars;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDate createTime;
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDate updateTime;

    @TableLogic
    private Integer deleted;

    @NotNull(message = "分类ID不能为空", groups = {Publish.class})
    @TableField(exist = false)
    private Long tagId;

    private List<Tag> tag;

    private List<Comment> commentList;
}