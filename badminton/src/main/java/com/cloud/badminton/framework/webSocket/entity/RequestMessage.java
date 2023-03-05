package com.cloud.badminton.framework.webSocket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/3/3 16:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RequestMessage {
    /*发送方ID*/
    private Long senderId;
    /*发送方昵称*/
    private String senderName;
    /*接收方ID*/
    private Long recipientId;
    /*接收方昵称*/
    private String recipientName;
    /*状态*/
    private Integer status;
    /*添加好友内容*/
    private String requestMsg;
    /*消息时间*/
    private String createTime;
}
