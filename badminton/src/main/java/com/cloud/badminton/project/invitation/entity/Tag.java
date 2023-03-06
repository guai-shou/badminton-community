package com.cloud.badminton.project.invitation.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cloud.badminton.framework.common.check.Publish;
import com.cloud.badminton.framework.common.check.Update;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/2/27 13:52
 */
@Data
@TableName("tag")
public class Tag {
    @NotNull(message = "ID不能为空", groups = {Update.class})
    @TableId(type = IdType.AUTO)
    private Long id;

    @NotNull(message = "标签名不能为空", groups = {Publish.class, Update.class})
    private String name;
}
