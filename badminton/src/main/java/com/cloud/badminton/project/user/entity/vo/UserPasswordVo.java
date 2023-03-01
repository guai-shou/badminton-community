package com.cloud.badminton.project.user.entity.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/3/1 11:04
 */
@Data
public class UserPasswordVo {
    @NotNull(message = "用户名不能为空")
    private String name;
    @Length(min = 6, max = 18, message = "密码长度在6-18为之间")
    @NotNull(message = "修改密码不能为空")
    private String password;
}
