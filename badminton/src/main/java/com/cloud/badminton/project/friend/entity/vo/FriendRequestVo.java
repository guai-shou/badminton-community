package com.cloud.badminton.project.friend.entity.vo;

import com.cloud.badminton.project.friend.entity.FriendRequest;
import lombok.Data;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/2/28 1:38
 */
@Data
public class FriendRequestVo extends FriendRequest {
    private String sendName;
    private String receiveName;
}
