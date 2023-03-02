package com.cloud.badminton;

import com.cloud.badminton.framework.webSocket.entity.ChatMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
public class BadmintonApplicationTests {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void contextLoads() {
        System.out.println(redisTemplate == null);
        redisTemplate.opsForValue().set("ccc", new ChatMessage(1L, 2L, "test content", 1, 0, 1, ""));
        final ChatMessage test = (ChatMessage) redisTemplate.opsForValue().get("test");
        System.out.println(test);
    }

}
