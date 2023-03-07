package com.cloud.badminton.framework.security.controller;

import com.cloud.badminton.framework.common.check.Publish;
import com.cloud.badminton.framework.common.exception.APIException;
import com.cloud.badminton.framework.common.result.ResultVo;
import com.cloud.badminton.framework.security.entity.LoginRequestUser;
import com.cloud.badminton.framework.security.entity.LoginUser;
import com.cloud.badminton.framework.security.service.LoginService;
import com.cloud.badminton.framework.security.service.TokenService;
import com.cloud.badminton.project.user.entity.User;
import com.cloud.badminton.project.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/3/7 14:52
 */
@RestController
public class LoginController {
    @Autowired
    LoginService loginService;

    @Autowired
    TokenService tokenService;

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public String login(@Validated @RequestBody LoginRequestUser loginRequestUser) {
        String uuid = loginRequestUser.getUuid();
        String username = loginRequestUser.getUsername();
        String password = loginRequestUser.getPassword();
        String captchaCode = loginRequestUser.getCaptchaCode();
        return loginService.login(username, password, captchaCode, uuid);
    }

    @GetMapping("/getInfo")
    public User getInfo(HttpServletRequest request) {
        final LoginUser loginUser = tokenService.getLoginUser(request);
        if (loginUser != null) {
            return loginUser.getUser();
        }
        return null;
    }

    @PostMapping("/register")
    public ResultVo register(@Validated(Publish.class) @RequestBody User user) {
        final int i = userService.insertUser(user);
        if (i > 0)
            return new ResultVo(user);
        return ResultVo.fail();
    }

}
