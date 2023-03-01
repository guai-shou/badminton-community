package com.cloud.badminton.framework.webSocket.handler;

import com.cloud.badminton.framework.webSocket.entity.ChatMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/3/1 14:30
 */
/*聊天Socket*/
@Slf4j
@Component
/*WebSocket第二种实现方式 不支持订阅 配合WebSocketConfigurer*/
public class ChatWebSocketHandler extends TextWebSocketHandler {

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final ConcurrentHashMap<String, WebSocketSession> sessions = new ConcurrentHashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.info("WebSocket connection open: {}", session.getId());

        /*成功连接后添加进集合*/
        sessions.put(session.getId(), session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        log.info("received message: {}", message.getPayload());

        /*通信方式为JSON格式 */
        final ChatMessage chatMessage = objectMapper.readValue(message.getPayload(), ChatMessage.class);
        final WebSocketSession recipientSession = sessions.get(chatMessage.getRecipientId());
        if (recipientSession != null && recipientSession.isOpen()) {
            /*接收方在线  发送内容*/
            recipientSession.sendMessage(new TextMessage(objectMapper.writeValueAsString(chatMessage)));
        }else {
            /*否则接收方不在线  存储内容*/
            // TODO 存储消息  问题: 如何获取用户ID,进行数据存储
            session.sendMessage(new TextMessage("Recipient not found or not connected: " + chatMessage.getRecipientId()));
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        log.info("WebSocket connection close: {}", session.getId());
        /*断开连接后移除集合*/
        sessions.remove(session.getId());
    }



}
