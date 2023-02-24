package com.cloud.framework.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author 怪兽
 * @version 1.0
 * Create by 2022/5/24 9:40
 */
@Configuration
public class MyWebConfig extends WebMvcConfigurationSupport {

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/**").addResourceLocations("file:" + System.getProperty("user.dir")+"\\src\\main\\resources\\static\\image\\");
        super.addResourceHandlers(registry);
    }

}
