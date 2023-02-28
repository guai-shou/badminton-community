package com.cloud.badminton.project.invitation.entity.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/2/27 18:05
 */
/*前端查询类*/
@Data
public class InvitationVo {
    private String title;
    private LocalDateTime beginTime;
    private LocalDateTime endTime;
}
