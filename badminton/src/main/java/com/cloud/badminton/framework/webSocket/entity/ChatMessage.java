package com.cloud.badminton.framework.webSocket.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/3/1 15:16
 */
@Data
public class ChatMessage {
    /*发送方ID*/
    private Long senderId;
    /*接收方ID*/
    private Long recipientId;
    /*发送内容*/
    private String content;
    /*已读回执标记*/
    private Integer isRead;
    /*发送内容类型*/
    private Integer type;
    /*撤回标记*/
    private Integer isUndo;
    /*消息时间*/
    private String createTime;
}
