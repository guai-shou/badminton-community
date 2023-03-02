package com.cloud.badminton.framework.webSocket.controller;

import com.cloud.badminton.framework.common.utils.RedisUtils;
import com.cloud.badminton.framework.webSocket.constants.ReadStatus;
import com.cloud.badminton.framework.webSocket.constants.RedisKey;
import com.cloud.badminton.framework.webSocket.entity.ChatMessage;
import com.cloud.badminton.framework.webSocket.entity.ReturnReceipt;
import com.cloud.badminton.framework.webSocket.pool.SessionPool;
import com.cloud.badminton.project.friend.entity.FriendMsgRecord;
import com.cloud.badminton.project.friend.service.FriendMsgRecordService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
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

    private final static ConcurrentHashMap<String, Object> cache = new ConcurrentHashMap<>();

    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    @Autowired
    FriendMsgRecordService friendMsgRecordService;

    @Autowired
    RedisUtils redisUtils;

    @OnOpen
    public void onOpen(Session session, @PathParam("userId") Long userId) {
        log.info("WebSocket connection open: {}", session.getId());

        SessionPool.sessions.put(userId, session);

        /* TODO 用户上线, 从缓存或者数据库获取全部已读回执消息  发送HTTP请求即可 */
        //final Map<Object, Object> receiptMap = redisUtils.hashGetAll(RedisKey.RETURN_RECEIPT + userId);
        //if (receiptMap != null) {
        //    /*缓存中有数据, 拿缓存*/
        //    for (Map.Entry<Object, Object> entry : receiptMap.entrySet()) {
        //        final ChatMessage receipt = (ChatMessage) entry.getValue();
        //        SessionPool.sendMessage(session, receipt);
        //    }
        //}else {
        //    /*缓存中没数据, 拿数据库*/
        //    // TODO 从数据库中获取回执消息
        //}


    }

    @OnClose
    public void onClose(Session session, @PathParam("userId") Long userId) throws IOException {
        log.info("WebSocket connection close: {}", session.getId());

        SessionPool.close(userId);
    }

    @OnMessage
    public void onMessage(Session session, String message, @PathParam("userId") Long userId) {
        log.info("服务器收到用户ID为 {}, 发送的消息: {}", session.getId(), message);
        try {
            final ChatMessage chatMessage = objectMapper.readValue(message, ChatMessage.class);
            // 发送者ID
            final Long senderId = chatMessage.getSenderId();
            // 接受者ID
            final Long recipientId = chatMessage.getRecipientId();
            /* 设置消息时间 */
            chatMessage.setCreateTime(format(LocalDateTime.now()));
            if (chatMessage.getIsRead() == ReadStatus.MESSAGE) {
                // TODO 存储消息  使用Redis进行缓存 或者先直接存储数据库

                sendMessage(chatMessage);
            }else if(chatMessage.getIsRead() == ReadStatus.HAS_READ){
                /* 如果是已读回执 前端给一个已读回执时间 */
                //final ReturnReceipt returnReceipt = new ReturnReceipt(senderId, recipientId, format(LocalDateTime.now()));

                // TODO 存储已读回执  使用Redis进行缓存
                //redisUtils.hashPut(RedisKey.RETURN_RECEIPT+redisUtils, senderId, chatMessage);
                // 更新缓存未读消息, 更新数据库未读消息
                // 根据发送的已读信息, 更新数据库记录
                /* 更新数据库已读记录 */
                final FriendMsgRecord friendMsgRecord = new FriendMsgRecord();
                friendMsgRecord.setFromUid(recipientId);
                friendMsgRecord.setToUid(senderId);
                friendMsgRecordService.updateFriendMsgRecordRead(friendMsgRecord, LocalDateTime.now());

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

    /*格式化时间*/
    public String format(LocalDateTime time) {
        return time.format(formatter);
    }

}
