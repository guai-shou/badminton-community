package com.cloud.badminton.framework.common.constant;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/3/7 9:16
 */
public class Constants {


    /**
     * captcha redis key
     */
    public static final String CAPTCHA_CODE_KEY = "captcha_codes:";

    /**
     * login user redis key
     */
    public static final String LOGIN_TOKEN_KEY = "login_tokens:";

    /**
     * the prefix of token
     */
    public static final String LOGIN_USER_KEY = "login_user_key";

    /**
     * token
     */
    public static final String TOKEN = "token";

    /**
     * the prefix of token
     */
    public static final String TOKEN_PREFIX = "Cloud ";


    /*验证码过期时间 2分钟*/
    public static final long CAPTCHA_EXPIRATION = 30;
}
