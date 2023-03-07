package com.cloud.badminton.project.wx.entity;

import lombok.Data;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/3/7 11:55
 */
@Data
public class WxLoginVo {

    private String openid;

    private String rawData;

    private String signature;

    private String encryptedData;

    private String iv;

}
