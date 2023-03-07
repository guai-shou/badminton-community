package com.cloud.badminton.project.wx.configuration;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.config.WxMaConfig;
import cn.binarywang.wx.miniapp.config.impl.WxMaDefaultConfigImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/3/7 12:53
 */
@Configuration
public class WxConfiguration {

    @Autowired
    WxConfigurationProperties properties;

    @Bean
    public WxMaConfig wxMaConfig() {
        final WxMaDefaultConfigImpl config = new WxMaDefaultConfigImpl();
        config.setAppid(properties.getAppid());
        config.setSecret(properties.getSecret());
        config.autoRefreshToken();
        return config;
    }

    @Bean
    public WxMaService wxMaService() {
        WxMaServiceImpl service = new WxMaServiceImpl();
        service.setWxMaConfig(wxMaConfig());
        return service;
    }

}
