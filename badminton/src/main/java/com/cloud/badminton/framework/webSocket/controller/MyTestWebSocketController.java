package com.cloud.badminton.framework.webSocket.controller;

import com.cloud.badminton.framework.webSocket.entity.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/3/1 14:40
 */
//@RestController
public class MyTestWebSocketController {


    //@MessageMapping("/chat")
    //@SendTo("/queue/message")  /*类似于广播*/
    //public ChatMessage handlerWebSocketRequest(ChatMessage chatMessage) {
    //
    //    return chatMessage;
    //}

}
