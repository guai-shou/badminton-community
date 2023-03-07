package com.cloud.badminton.framework.security.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/3/7 15:53
 */
/*用于登录的用户*/
@Data
public class LoginRequestUser {
    @NotNull(message = "登录用户不能为空")
    private String username;
    @NotNull(message = "登录密码不能为空")
    private String password;
    @NotNull(message = "验证码不能为空")
    private String captchaCode;
    @NotNull(message = "登录校验不能为空")
    private String uuid;
}
