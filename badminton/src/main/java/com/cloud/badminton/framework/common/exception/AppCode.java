package com.cloud.badminton.framework.common.exception;

import com.cloud.badminton.framework.common.result.StatusCode;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/3/1 12:07
 */
public enum AppCode implements StatusCode {

    APP_ERROR(3000, "业务异常"),
    CAPTCHA_ERROR(4000, "验证码异常"),
    USER_ERROR(5000, "用户异常");


    private int code;
    private String msg;

    AppCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
