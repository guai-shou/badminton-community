package com.cloud.badminton;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTPayload;
import cn.hutool.jwt.JWTUtil;
import cn.hutool.jwt.signers.JWTSignerUtil;
import com.cloud.badminton.framework.common.constant.Constants;
import com.cloud.badminton.framework.common.utils.RedisUtils;
import com.cloud.badminton.framework.security.entity.LoginUser;
import com.cloud.badminton.framework.webSocket.entity.ChatMessage;
import org.bouncycastle.cert.crmf.bc.BcEncryptedValueBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;

@SpringBootTest
public class BadmintonApplicationTests {

    @Autowired
    RedisUtils redisUtils;


    //@Autowired
    //private RedisTemplate<String, Object> redisTemplate;
    //
    //@Test
    //public void contextLoads() {
    //    System.out.println(redisTemplate == null);
    //    redisTemplate.opsForValue().set("ccc", new ChatMessage(1L, 2L, "test content", 1, 0, 1, ""));
    //    final ChatMessage test = (ChatMessage) redisTemplate.opsForValue().get("test");
    //    System.out.println(test);
    //}

    @Test
    public void testToken() {
        //HashMap<String, Object> claim = new HashMap<>();
        //claim.put(Constants.LOGIN_USER_KEY, "12345678");
        //claim.put(JWTPayload.EXPIRES_AT, System.currentTimeMillis() + 10*60*1000L);
        //final String token = JWTUtil.createToken(claim, JWTSignerUtil.hs512("123456".getBytes(StandardCharsets.UTF_8)));
        //System.out.println(token);
        //
        //final JWT jwt = JWTUtil.parseToken(token);
        //final Object claim1 = jwt.getPayload().getClaim(Constants.LOGIN_USER_KEY);
        //System.out.println(claim1);

        String password = "12345678";

        final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.matches(password, "$2a$10$Y7MbFK1Xa0KmpfmFhnodd.UkazqxDwfLUl4r1J6YwUMs49AEL8xoW"));
        System.out.println(passwordEncoder.encode("12345678"));


        final Object value = redisUtils.getValue("login_tokens:6fa48f6e-9eaf-464c-af01-3b4513668bb3");
        System.out.println((LoginUser) value);
    }

}
