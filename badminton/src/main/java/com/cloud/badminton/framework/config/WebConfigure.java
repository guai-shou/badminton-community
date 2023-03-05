package com.cloud.badminton.framework.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/3/1 14:46
 */
/*跨域配置*/
@Configuration
public class WebConfigure implements WebMvcConfigurer {

    @Value("${upload.file.path}")
    private String filePath;

    /*解决跨域*/
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .maxAge(3600);
    }

    /*解决静态资源映射*/

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/**").addResourceLocations("file:" + filePath);
    }
}
