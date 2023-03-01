package com.cloud.badminton.framework.common.exception;

import com.cloud.badminton.framework.common.result.StatusCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/3/1 12:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIException extends RuntimeException{
    private int code;
    private String msg;

    // 手动设置异常
    public APIException(StatusCode statusCode, String message) {
        // msg用于用户设置抛出错误详情, 例如: 当前价格-5 小于0
        super(message);
        // 状态码
        this.code = statusCode.getCode();
        // 状态码配套的msg
        this.msg = statusCode.getMsg();
    }

    // 默认异常使用APP_ERROR状态码
    public APIException(String message) {
        super(message);
        this.code = AppCode.APP_ERROR.getCode();
        this.msg = AppCode.APP_ERROR.getMsg();
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
