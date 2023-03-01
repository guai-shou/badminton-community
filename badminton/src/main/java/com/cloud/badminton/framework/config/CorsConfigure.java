package com.cloud.badminton.framework.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/3/1 14:46
 */
/*跨域配置*/
@Configuration
public class CorsConfigure implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .maxAge(3600);
    }
}
