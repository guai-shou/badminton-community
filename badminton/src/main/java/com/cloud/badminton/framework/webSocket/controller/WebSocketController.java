package com.cloud.badminton.framework.webSocket.controller;

import com.cloud.badminton.framework.webSocket.constants.ReadStatus;
import com.cloud.badminton.framework.webSocket.entity.ChatMessage;
import com.cloud.badminton.framework.webSocket.pool.SessionPool;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.WebSession;
import org.springframework.web.socket.WebSocketSession;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/3/1 16:38
 */
/*配合第一种实现方式*/
@ServerEndpoint(value = "/imServer/{userId}")
@Component
@Slf4j
public class WebSocketController {

    private final ObjectMapper objectMapper = new ObjectMapper();


    private final static ConcurrentHashMap<Long, Session> sessions = new ConcurrentHashMap<>();


    @OnOpen
    public void onOpen(Session session, @PathParam("userId") Long userId) {
        log.info("WebSocket connection open: {}", session.getId());

        /* TODO 用户上线, 从缓存或者数据库获取全部已读回执消息 */


        sessions.put(userId, session);
        SessionPool.sessions.put(userId, session);
    }

    @OnClose
    public void onClose(Session session, @PathParam("userId") Long userId) throws IOException {
        log.info("WebSocket connection close: {}", session.getId());

        sessions.remove(userId);
        SessionPool.close(userId);
    }

    @OnMessage
    public void onMessage(Session session, String message, @PathParam("userId") Long userId) {
        log.info("服务器收到用户ID为 {}, 发送的消息: {}", session.getId(), message);
        try {
            final ChatMessage chatMessage = objectMapper.readValue(message, ChatMessage.class);
            if (chatMessage.getIsRead() == ReadStatus.MESSAGE) {
                // TODO 存储消息  使用Redis进行缓存 还是直接 数据库
                /* 如果当前消息未读, 说明发送消息 设置发送消息时间 */
                chatMessage.setCreateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                sendMessage(chatMessage);
            }else if(chatMessage.getIsRead() == ReadStatus.HAS_READ){
                // TODO 存储已读回执  使用Redis进行缓存 还是直接 数据库
                /* 如果是已读回执 前端给一个已读回执时间 */
                sendMessage(chatMessage);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage(ChatMessage chatMessage) {
        final Session recipientSession = SessionPool.sessions.get(chatMessage.getRecipientId());
        // TODO 存储消息  使用Redis进行缓存 还是直接 数据库
        if (recipientSession != null && recipientSession.isOpen()) {
            /* 接收方在线  发送内容 */
            SessionPool.sendMessage(recipientSession, chatMessage);
        }
    }

    @OnError
    public void onError(Session session, Throwable error) {
        log.error("sessionId为: {}, 发生错误", session.getId());
        error.printStackTrace();
    }

}
