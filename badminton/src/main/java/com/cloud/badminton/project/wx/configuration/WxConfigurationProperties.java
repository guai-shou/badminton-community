package com.cloud.badminton.project.wx.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/3/7 11:03
 */
@Component
@ConfigurationProperties(prefix = "wx.mp")
public class WxConfigurationProperties {
    String appid;

    String secret;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
