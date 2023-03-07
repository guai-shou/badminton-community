package com.cloud.badminton.framework.config;

import com.cloud.badminton.framework.common.exception.APIException;
import com.cloud.badminton.framework.common.result.ResultCode;
import com.cloud.badminton.framework.common.result.ResultVo;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/3/1 11:56
 */
/*统一异常处理*/
@RestControllerAdvice(basePackages = {"com.cloud.badminton"})
public class MyControllerExceptionHandler {

    @ExceptionHandler({BindException.class})
    public ResultVo MethodArgumentNotValidExceptionHandler(BindException e) {
        final String message = e.getAllErrors().get(0).getDefaultMessage();
        return new ResultVo(ResultCode.VALIDATE_ERROR, message);
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public ResultVo MethodArgumentNotValidExceptionHandler(ConstraintViolationException e) {
        return new ResultVo(ResultCode.VALIDATE_ERROR, e.getConstraintViolations().iterator().next().getMessageTemplate());
    }

    @ExceptionHandler({APIException.class})
    public ResultVo APIExceptionHandler(APIException e) {
        // TODO 记录日志
        return new ResultVo(e.getCode(), e.getMsg(), e.getMessage());
    }

}
