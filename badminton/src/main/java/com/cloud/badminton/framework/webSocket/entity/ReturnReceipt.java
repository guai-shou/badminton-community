package com.cloud.badminton.framework.webSocket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/3/2 23:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReturnReceipt {
    /*发送方ID*/
    private Long senderId;
    /*接收方ID*/
    private Long recipientId;
    /*已读回执时间*/
    private String ReadTime;
}
