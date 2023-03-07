package com.cloud.badminton.framework.webSocket.pool;

import com.cloud.badminton.framework.webSocket.entity.ChatMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.websocket.Session;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/3/1 20:22
 */
/*自定义WebSocket会话数据结构*/
public class SessionPool {

    public static ObjectMapper objectMapper = new ObjectMapper();

    public static Map<Long, Session> sessions = new ConcurrentHashMap<>();

    public static void close(Long userId) throws IOException {
        final Session session = sessions.get(userId);
        if (session != null) {
            sessions.get(userId).close();
        }
    }

    /*对某个用户发送消息*/
    public static void sendMessage(Session session, Object chatMessage) {
        try {
            session.getAsyncRemote().sendText(objectMapper.writeValueAsString(chatMessage));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    /*广播消息*/
    public static void sendMessage(ChatMessage chatMessage) {
        for (Session session : sessions.values()) {
            sendMessage(session, chatMessage);
        }
    }

}
