package com.cloud.badminton.framework.webSocket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/3/1 16:36
 */
/*WebSocket第一种种实现方式, 可以使用原生注解 @OnOpen @OnMessage @OncClose那些*/
@Configuration
public class WebSocketConfig {

    //@Bean
    //public ServerEndpointExporter serverEndpointExporter() {
    //    return new ServerEndpointExporter();
    //}

}
