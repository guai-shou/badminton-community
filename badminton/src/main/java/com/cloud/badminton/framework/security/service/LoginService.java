package com.cloud.badminton.framework.security.service;

import com.cloud.badminton.framework.common.constant.Constants;
import com.cloud.badminton.framework.common.exception.APIException;
import com.cloud.badminton.framework.common.exception.AppCode;
import com.cloud.badminton.framework.common.utils.RedisUtils;
import com.cloud.badminton.framework.security.entity.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/3/6 21:41
 */
@Service
public class LoginService {

    @Autowired
    TokenService tokenService;

    @Resource
    AuthenticationManager authenticationManager;

    @Autowired
    RedisUtils redisUtils;

    /*登录成功后返回token*/
    public String login(String username, String password, String verifyCode, String uuid) {
        String verifyKey = Constants.CAPTCHA_CODE_KEY + uuid;
        String captcha = (String) redisUtils.getValue(verifyKey);
        if (captcha == null) {
            throw new APIException(AppCode.CAPTCHA_ERROR, "验证码已过期");
        }
        if (!verifyCode.equalsIgnoreCase(captcha)) {
            throw new APIException(AppCode.CAPTCHA_ERROR, "验证码错误");
        }
        // 用户验证
        Authentication authentication;
        try {
            authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }catch (Exception e) {
            if (e instanceof BadCredentialsException) {
                throw new APIException(AppCode.USER_ERROR, "用户名或密码不正确");
            }else {
                throw new APIException(AppCode.APP_ERROR, "业务异常");
            }
        }
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        /*生成token*/
        return tokenService.createToken(loginUser);
    }

}
