package com.cloud.badminton.framework.common.result;

public enum ResultCode implements StatusCode{
    SUCCESS(1000, "请求成功"),
    FAILED(2000, "请求失败"),
    VALIDATE_ERROR(2001, "参数校验失败"),
    RESPONSE_PACK_ERROR(2002, "response返回包装失败");

    private int code;
    private String msg;

    ResultCode(int code, String msg) {
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
