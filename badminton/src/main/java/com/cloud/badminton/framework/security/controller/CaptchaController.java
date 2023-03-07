package com.cloud.badminton.framework.security.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import cn.hutool.captcha.ICaptcha;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import com.cloud.badminton.framework.common.annotation.NoControllerResponseAdvice;
import com.cloud.badminton.framework.common.constant.Constants;
import com.cloud.badminton.framework.common.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/3/7 15:22
 */
@RestController
public class CaptchaController {

    @Autowired
    RedisUtils redisUtils;

    //@NoControllerResponseAdvice
    @GetMapping("/captchaImage")
    public Map<String, Object> captcha() {
        HashMap<String, Object> result = new HashMap<>();
        /*生成图片*/
        final CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(200, 100, 4, 20);
        final String verifyCode = captcha.getCode();
        /*唯一标识*/
        String uuid = IdUtil.fastUUID();
        String verifyKey = Constants.CAPTCHA_CODE_KEY + uuid;
        redisUtils.setValueExpire(verifyKey, verifyCode, Constants.CAPTCHA_EXPIRATION);
        result.put("captchaCode" ,"<img src=" + captcha.getImageBase64Data() + " ></img>");
        result.put("uuid", uuid);
        return result;
    }

}
