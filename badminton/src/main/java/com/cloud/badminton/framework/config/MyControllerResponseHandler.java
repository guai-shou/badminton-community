package com.cloud.badminton.framework.config;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cloud.badminton.framework.common.annotation.NoControllerResponseAdvice;
import com.cloud.badminton.framework.common.exception.APIException;
import com.cloud.badminton.framework.common.result.PageResultVo;
import com.cloud.badminton.framework.common.result.ResultCode;
import com.cloud.badminton.framework.common.result.ResultVo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/3/1 12:17
 */
/*统一响应处理*/
@RestControllerAdvice(basePackages = {"com.cloud.badminton.project"})
public class MyControllerResponseHandler implements ResponseBodyAdvice<Object> {

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return !returnType.getGenericParameterType().equals(ResultVo.class) ||
                returnType.hasMethodAnnotation(NoControllerResponseAdvice.class);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (returnType.getGenericParameterType().equals(String.class)) {
            /*如果是String类型转换为JSON对象在写入*/
            try {
                return objectMapper.writeValueAsString(body);
            } catch (JsonProcessingException e) {
                throw new APIException(ResultCode.RESPONSE_PACK_ERROR, e.getMessage());
            }
        }else if(returnType.getGenericParameterType().equals(IPage.class)) {
            /*如果是分页,封装成统一分页结构*/
            IPage iPage = (IPage) body;
            return new PageResultVo(iPage.getRecords(), iPage.getCurrent(), iPage.getSize(), iPage.getTotal());
        }
        return new ResultVo(body);
    }
}
