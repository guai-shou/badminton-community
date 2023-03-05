package com.cloud.badminton.framework.webSocket.controller;

import com.cloud.badminton.framework.common.utils.RedisUtils;
import com.cloud.badminton.framework.webSocket.constants.WebSocketConstants;
import com.cloud.badminton.framework.webSocket.entity.RequestMessage;
import com.cloud.badminton.framework.webSocket.pool.SessionPool;
import com.cloud.badminton.project.friend.entity.Friend;
import com.cloud.badminton.project.friend.entity.FriendRequest;
import com.cloud.badminton.project.friend.service.FriendMsgRecordService;
import com.cloud.badminton.project.friend.service.FriendRequestService;
import com.cloud.badminton.project.friend.service.FriendService;
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

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/3/3 16:46
 */
@ServerEndpoint(value = "/imRequestServer/{userId}")
@Component
@Slf4j
public class FriendRequestWebSocketController {

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private static FriendRequestService friendRequestService;

    private static FriendService friendService;

    /*目前没使用Redis缓存记录*/
    private static RedisUtils redisUtils;

    @Autowired
    public void setFriendService(FriendService friendService) {
        FriendRequestWebSocketController.friendService = friendService;
    }

    @Autowired
    public void setFriendMsgRecordService(FriendRequestService friendRequestService) {
        FriendRequestWebSocketController.friendRequestService = friendRequestService;
    }

    @Autowired
    public void setRedisUtils(RedisUtils redisUtils) {
        FriendRequestWebSocketController.redisUtils = redisUtils;
    }

    @OnOpen
    public void onOpen(Session session, @PathParam("userId") Long userId) {
        log.info("WebSocket connection open: {}", session.getId());

        SessionPool.sessions.put(userId, session);

        /*用户上线, 获取好友请求记录 使用HTTP*/

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
            final RequestMessage requestMessage = objectMapper.readValue(message, RequestMessage.class);
            /* 设置消息时间 */
            requestMessage.setCreateTime(format(LocalDateTime.now()));

            /*已读与消息处理*/
            handleMessage(requestMessage);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void handleMessage(RequestMessage requestMessage) {
        // 发送者ID
        final Long senderId = requestMessage.getSenderId();
        // 接受者ID
        final Long recipientId = requestMessage.getRecipientId();

        // TODO 存储消息  使用Redis进行缓存
        /*构造请求消息记录*/
        final FriendRequest friendRequest = new FriendRequest();
        friendRequest.setFromUid(senderId);
        friendRequest.setToUid(recipientId);
        friendRequest.setRequestMsg(requestMessage.getRequestMsg());
        friendRequest.setStatus(requestMessage.getStatus());
        friendRequestService.insertFriendRequest(friendRequest);

        /* 如果好友通过 插入数据库 */
        if (requestMessage.getStatus() == WebSocketConstants.ACCEPT) {
            final Friend friend = new Friend();
            friend.setUid(senderId);
            friend.setFriendId(recipientId);
            friendService.insertFriend(friend);
        }
        sendMessage(requestMessage);
    }

    private void sendMessage(RequestMessage requestMessage) {
        final Session recipientSession = SessionPool.sessions.get(requestMessage.getRecipientId());
        // TODO 存储消息  使用Redis进行缓存 还是直接 数据库
        if (recipientSession != null && recipientSession.isOpen()) {
            /* 接收方在线  发送内容 */
            SessionPool.sendMessage(recipientSession, requestMessage);
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
