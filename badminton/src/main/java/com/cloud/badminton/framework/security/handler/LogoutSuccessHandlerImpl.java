package com.cloud.badminton.framework.security.handler;

import cn.hutool.core.util.ObjectUtil;
import com.cloud.badminton.framework.common.check.Status;
import com.cloud.badminton.framework.common.result.ResultCode;
import com.cloud.badminton.framework.common.result.ResultVo;
import com.cloud.badminton.framework.security.entity.LoginUser;
import com.cloud.badminton.framework.security.service.TokenService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/3/6 21:10
 */
/*退出登录后执行*/
@Component
public class LogoutSuccessHandlerImpl implements LogoutSuccessHandler {

    @Autowired
    TokenService tokenService;

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        final LoginUser loginUser = tokenService.getLoginUser(request);
        if (ObjectUtil.isNotNull(loginUser)) {
            String username = loginUser.getUsername();
            tokenService.delLoginUser(loginUser.getUuid());
            /*TODO 记录日志*/
        }
        final ResultVo resultVo = new ResultVo(ResultCode.SUCCESS, "注销成功");
        response.setStatus(200);
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(new ObjectMapper().writeValueAsString(resultVo));
    }
}
