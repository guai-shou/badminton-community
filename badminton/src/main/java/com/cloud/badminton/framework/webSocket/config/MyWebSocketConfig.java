package com.cloud.badminton.framework.webSocket.config;

import com.cloud.badminton.framework.webSocket.handler.ChatWebSocketHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.*;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/3/1 14:27
 */
/*第三种实现方式, 不支持订阅*/
//@Configuration
//@EnableWebSocketMessageBroker
public class MyWebSocketConfig implements WebSocketMessageBrokerConfigurer {

    //@Override
    //public void registerStompEndpoints(StompEndpointRegistry registry) {
    //    /*注册 endpoint 连接端点 */
    //    registry.addEndpoint("/endpoint").setAllowedOriginPatterns("*").withSockJS();
    //}
    //
    //@Override
    //public void configureMessageBroker(MessageBrokerRegistry registry) {
    //    /*启用一个队列占存消息, 客户端可以订阅*/
    //    registry.enableSimpleBroker("/queue");
    //    /*整个应用前缀  与 controller路径是chat  一起就是 /ws/chat */
    //    registry.setApplicationDestinationPrefixes("/ws");
    //}


}
