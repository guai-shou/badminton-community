package com.cloud.badminton.framework.common.result;

import lombok.Data;

import java.io.Serializable;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/2/27 13:31
 */
@Data
public class ResultVo implements Serializable {

    // 状态码
    private int code;
    //状态信息
    private String msg;
    // 返回对象
    private Object data;

    public ResultVo() {

    }

    // 手动设置返回vo
    public ResultVo(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    // 默认返回成功状态码, 数据对象
    public ResultVo(Object data) {
        this.code = ResultCode.SUCCESS.getCode();
        this.msg = ResultCode.SUCCESS.getMsg();
        this.data = data;
    }

    // 返回指定状态码,数据对象
    public ResultVo(StatusCode statusCode, Object data) {
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
        this.data = data;
    }

    //只返回状态码
    public ResultVo(StatusCode statusCode) {
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
        this.data = null;
    }

    public static ResultVo success() {
        return new ResultVo(ResultCode.SUCCESS, "成功");
    }

    public static ResultVo fail() {
        return new ResultVo(ResultCode.FAILED, "失败");
    }
}
