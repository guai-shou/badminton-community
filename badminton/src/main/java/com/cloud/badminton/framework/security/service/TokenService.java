package com.cloud.badminton.framework.security.service;

import cn.hutool.core.util.IdUtil;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTPayload;
import cn.hutool.jwt.JWTUtil;
import cn.hutool.jwt.signers.JWTSignerUtil;
import com.cloud.badminton.framework.common.constant.Constants;
import com.cloud.badminton.framework.common.utils.RedisUtils;
import com.cloud.badminton.framework.security.entity.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/3/6 22:07
 */
@Service
public class TokenService {


    @Autowired
    RedisUtils redisUtils;

    /*令牌自定义标识*/
    @Value("${token.header}")
    private String header;

    /*令牌密钥*/
    @Value("${token.secret}")
    private String secret;

    /*令牌有效期, 默认30分钟*/
    @Value("${token.expireTime}")
    private Integer expireTime;

    private final static Long MILLIS_SECOND = 1000L;

    private final static Long MILLIS_MINUTE = 60 * MILLIS_SECOND;

    private final static Long MILLIS_MINUTE_TEN = 10 * MILLIS_MINUTE;

    /*获取用户信息*/
    public LoginUser getLoginUser(HttpServletRequest request) {
        /*获取请求携带的token*/
        String token = getToken(request);
        if (StringUtils.hasLength(token) && tokenVerify(token)) {
            final JWT jwt = parseToken(token);
            final JWTPayload payload = jwt.getPayload();
            String uuid = (String) payload.getClaim(Constants.LOGIN_USER_KEY);
            String userKey = getTokenKey(uuid);
            return (LoginUser) redisUtils.getValue(userKey);
        }
        return null;
    }

    /*删除用户身份信息*/
    public void delLoginUser(String uuid) {
        if (StringUtils.hasLength(uuid)) {
            String userKey = getTokenKey(uuid);
            redisUtils.delKey(userKey);
        }
    }

    /*创建令牌*/
    public String createToken(LoginUser loginUser) {
        String uuid = IdUtil.fastUUID();
        loginUser.setUuid(uuid);
        refreshToken(loginUser);

        HashMap<String, Object> claim = new HashMap<>();
        claim.put(Constants.LOGIN_USER_KEY, uuid);
        claim.put(JWTPayload.EXPIRES_AT, System.currentTimeMillis() + MILLIS_MINUTE_TEN);
        return createToken(claim);
    }



    private String createToken(HashMap<String, Object> claim) {
        return JWTUtil.createToken(claim, JWTSignerUtil.hs512(secret.getBytes(StandardCharsets.UTF_8)));
    }

    private JWT parseToken(String token) {
        return JWTUtil.parseToken(token);
    }


    /**
     * 获取请求token
     *
     * @param request
     * @return token
     */
    private String getToken(HttpServletRequest request) {
        String token = request.getHeader(header);
        if (StringUtils.hasLength(token) && token.startsWith(Constants.TOKEN_PREFIX)) {
            token = token.replace(Constants.TOKEN_PREFIX, "");
        }
        return token;
    }

    private String getTokenKey(String uuid) {
        return Constants.LOGIN_TOKEN_KEY + uuid;
    }

    private void refreshToken(LoginUser loginUser) {
        loginUser.setLoginTime(System.currentTimeMillis());
        loginUser.setExpireTime(loginUser.getLoginTime() + expireTime * MILLIS_MINUTE);
        // 根据 uuid 将loginUser进行缓存
        final String userKey = getTokenKey(loginUser.getUuid());
        redisUtils.setValueExpire(userKey, loginUser, expireTime);
    }

    /*保证令牌有效期, 相差不足10分钟, 自动刷新缓存*/
    public void verifyToken(LoginUser loginUser) {
        Long expireTime = loginUser.getExpireTime();
        Long currentTime = System.currentTimeMillis();
        if (expireTime - currentTime <= MILLIS_MINUTE_TEN) {
            refreshToken(loginUser);
        }
    }

    private boolean tokenVerify(String token) {
        return JWTUtil.verify(token, JWTSignerUtil.hs512(secret.getBytes(StandardCharsets.UTF_8)));
    }
}
