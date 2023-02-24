package com.cloud.common.exception;

import com.cloud.common.result.ResultEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * @version 1.0
 */
@Getter
@Setter
public class BlogException extends RuntimeException{
    private Integer code;

    public BlogException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public BlogException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    @Override
    public String toString() {
        return "BlogException{" +
                "code=" + code +
                ", message=" + this.getMessage() +
                '}';
    }
}
