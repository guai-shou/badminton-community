package com.cloud.badminton.project.user.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.cloud.badminton.framework.common.check.Publish;
import com.cloud.badminton.framework.common.check.Update;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/2/27 14:01
 */
@Data
@TableName("user")
public class User {
    @NotNull(message = "用户ID不能为空", groups = {Update.class})
    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField("nick_name")
    private String nickName;

    @Null(message = "不能修改用户名", groups = {Update.class})
    @NotNull(message = "用户名不能为空", groups = {Publish.class})
    private String name;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Length(min = 6, max = 18, message = "密码长度在6-18为之间", groups = {Publish.class})
    @Null(message = "不能更新密码", groups = {Update.class})
    @NotNull(message = "密码不能为空", groups = {Publish.class})
    private String password;

    private String avatar;

    @TableField("space_bg")
    private String spaceBg;

    private String description;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @JsonIgnore
    @TableLogic(value = "0", delval = "1")
    @TableField("deleted")
    private Integer deleted;
}
